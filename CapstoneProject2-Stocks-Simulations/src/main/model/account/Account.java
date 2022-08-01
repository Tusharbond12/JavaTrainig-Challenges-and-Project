package src.main.model.account;


import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Soundbank;

public abstract class Account {
   private Map<String,Integer> portfolio=new HashMap<>();
   private Double funds;
   public Account(Map<String,Integer> portfolio, Double funds) {
        this.portfolio = new HashMap(portfolio);
        this.funds = funds;
    }
    public Account(Account source) {
        this.portfolio = new HashMap(source.getPortfolio());
        this.funds = source.funds;
    }

    public Map<String,Integer> getPortfolio() {
        return new HashMap(this.portfolio);
    }

    public void setProftfolio(Map<String,Integer> proftfolio) {
        this.portfolio = proftfolio;
    }

    public Double getFunds() {
        return this.funds;
    }

    public void setFunds(Double funds) {
        this.funds = funds;
    }
    public String toString()
    {
        return "\nStock\t"  + src.main.utils.Color.RESET + "Shares" +
        "\n\n" + displayPortfolio() + src.main.utils.Color.RESET +
        "\nFunds Left\t" + src.main.utils.Color.GREEN + "$" + round(this.getFunds()) + src.main.utils.Color.RESET;
    }
    public String displayPortfolio()
    {
        String str="";
        for (String name: this.portfolio.keySet()) 
        {
            str+=src.main.utils.Color.BLUE+name+"\t"+src.main.utils.Color.GREEN+Integer.toString(this.portfolio.get(name))+"\n";
        }
        return str;
    }
   public double round(double funds)
   {
    double roundOff = Math.round(funds * 100.0) / 100.0;
    return roundOff;
   }
   public void updatePortfolio(int shares,String choice,String stock)
   {
     switch(choice)
     {
        case "BUY":
        this.portfolio.put(stock,this.portfolio.get(stock)+shares);
        return;
        case "SELL":
        this.portfolio.put(stock,this.portfolio.get(stock)-shares);
        return;
     }
   }
   public abstract boolean buy(String stock ,Double price ,int shares);
   public abstract boolean sell(String stock ,Double price ,int shares);


    }


    
    


