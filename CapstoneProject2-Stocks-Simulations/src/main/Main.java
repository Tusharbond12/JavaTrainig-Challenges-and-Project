package src.main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


import src.main.model.account.Account;
import src.main.utils.Color;
import src.main.model.account.Personal;
import src.main.model.account.Tfsa;
import src.main.model.account.Trade;
public class Main {

    static Account account; 
    static final double INITIAL_DEPOSIT = 4000;
    static Scanner scanner = new Scanner(System.in);
  
    public static void main(String[] args) {    
      explainApp();
      createObject(accountChoice());
      initialBalance();
      startTrading();
    
     
    }
    public static void startTrading()
    {   Trade trade;
        for(int day=1;day<=2160;day++)
        {  
           displayPrices(day);
           String stock= chooseStock();
           String choice=buyOrSell();
           int shares=numShares(choice);
           double price=Double.parseDouble(getPrice(stock, day));
           trade=new Trade(stock, choice.toUpperCase(), shares, price);
           tradeStatus(trade.processTrade(account)?"successful":"unsuccessful");
        }
    }
    public static void createObject( String choice)
    {
        HashMap<String,Integer> map=new HashMap<String,Integer>();//Creating HashMap    
        map.put("TSLA",0);
        map.put("GOOG",0);
        map.put("FB",0);
        map.put("AAPL",0);
        double funds=INITIAL_DEPOSIT;
        if(choice.equals("a"))
        {
           account=new Personal(map,funds);
        }
        else{
            account=new Tfsa(map,funds);
        }
    }

    public static void explainApp() {
        System.out.print(Color.BLUE + "\n - PERSONAL: ");
        System.out.println(Color.YELLOW + "Every sale made in a personal account is charged a 5% fee.");
        System.out.print(Color.BLUE + "\n - TFSA: ");
        System.out.println(Color.YELLOW + "Every trade (buy/sell) made from a TFSA is charged a 1% fee.\n");
        System.out.println(Color.BLUE + " - Neither account has a limit on the amount of trades that can be made." + Color.RESET);
    }
    
    public static void initialBalance() {
        System.out.print("\n\n  You created a " + Color.YELLOW + account.getClass().getSimpleName() + Color.RESET + " account.");
        System.out.println(" Your account balance is " + Color.GREEN + "$" + account.getFunds() + Color.RESET);
        System.out.print("\n  Enter anything to start trading: ");
        scanner.nextLine();
    }


    public static String accountChoice() {
        System.out.print("\n  Respectively, type 'a' or 'b' to create a Personal account or TFSA: ");
        String choice = scanner.nextLine();
        while (!choice.equals("a") && !choice.equals("b")) {
            System.out.print("  Respectively, type 'a' or 'b' to create a Personal account or TFSA: ");
            choice = scanner.nextLine();
        }
        return choice;
    }
    
    
    public static String buyOrSell() {
        System.out.print("\n\n  Would you like to 'buy' or 'sell': ");
        String choice = scanner.nextLine();
        while (!choice.equals("buy") && !choice.equals("sell")) {
            System.out.print("  Would you like to 'buy' or 'sell': ");
            choice = scanner.nextLine();
        }
        return choice;
    }

    public static String chooseStock() {
        System.out.print("  Choose a stock: ");
        String stock = scanner.nextLine(); 
        while (!stock.equals("AAPL") && !stock.equals("FB") && !stock.equals("GOOG") && !stock.equals("TSLA") ) {
            System.out.print("  Choose a stock: ");
            stock = scanner.nextLine();
        }
        return stock;
    }

    public static int numShares(String choice) {
        System.out.print("  Enter the number of shares you'd like to " + choice + ": ");
        int shares = scanner.nextInt(); 
        scanner.nextLine(); //throwaway nextLine
        while (shares <= 0) {
            System.out.print("  Enter the number of shares you'd like to " + choice + ": ");
            shares = scanner.nextInt();
            scanner.nextLine(); //throwaway nextLine

        }
        return shares;
    }
    
  
    public static void displayPrices(int day) {
        System.out.println("\n\n\t  DAY " + day + " PRICES\n");

        System.out.println("  " + Color.BLUE + "AAPL" + "\t\t" + Color.GREEN + getPrice("AAPL", day));
        System.out.println("  " + Color.BLUE + "FB" + "\t\t" + Color.GREEN + getPrice("FB", day));
        System.out.println("  " + Color.BLUE + "GOOG" + "\t\t" + Color.GREEN + getPrice("GOOG", day));
        System.out.println("  " + Color.BLUE + "TSLA" + "\t\t" + Color.GREEN + getPrice("TSLA", day) + Color.RESET+"\n");

    }
    
    public static void tradeStatus(String result) {
        System.out.println("\n  The trade was " + (result.equals("successful") ? Color.GREEN : Color.RED) + result + Color.RESET + ". Here is your portfolio:");
        System.out.println(account);
        System.out.print("\n  Press anything to continue");
        scanner.nextLine();
    }
    
    
    
    public static String getPrice(String stock, int day) {
        Path path=getPath(stock);
        try{
        return Files.lines(path).skip(1)
        .map((value)->value.split(","))
        .filter((value)->Double.parseDouble(value[0])==day)
        .map((value)->value[1])
        .findFirst()
        .orElse(null);
    }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return " ";
        }

    }


    public static Path getPath(String stock) {
        try{
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource("src/main/data/"+stock+".csv").toURI());
            return path;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        }  
    


}
