import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************");
        
         Item[][] items = new Item[][] {
             { new Item("Pepsi", 1.99, 3) , new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2) },
           { new Item("Fanta", 1.99, 2) , new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3) },
           { new Item("Crush", 1.99, 2) , new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1) }
        };
        
        Machine machine=new Machine(items);
        // Item test=machine.getItem(2, 1);
        // test.setPrice(2.99);
         //System.out.println(machine.getItem(2, 1));
        // machine.dispense(0, 0);
        // machine.dispense(0, 0);
        
        // System.out.println(machine.getItem(0, 0));
        System.out.println(machine);
        Scanner scan=new Scanner(System.in);
        int row , column;
        int purchase=1;
        System.out.print("\nPick a Row: ");
        row= scan.nextInt();
        System.out.print("Pick a column: ");
        column=scan.nextInt();
        machine.dispense(row, column);
        System.out.print("\n"+machine);
        System.out.print("\nEnjoy the Drink ! Press 1 to purchase another: ");
        purchase=scan.nextInt();
        while(purchase==1)
        {
            System.out.print("\nPick a Row: ");
        row= scan.nextInt();
        System.out.print("Pick a column: ");
        column=scan.nextInt();
        boolean bool=machine.dispense(row, column);
        System.out.print("\n"+machine);
        if(bool)
        {
            System.out.print("\nEnjoy the Drink ! Press 1 to purchase another: ");
        }
        else{
            System.out.print("\nThis Drink not available ! Press 1 to purchase another: ");
        }
        purchase=scan.nextInt();

        }
        scan.close();
    }
    
        
        
}
