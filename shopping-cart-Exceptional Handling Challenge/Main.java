
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Item;
import models.Store;
import models.Cart;

public class Main {
    static Store store=new Store();
    static Cart  cart=new Cart();

    public static void main(String[] args) {
        // Item item1=new Item("Celery",0.99);
        // Item item2=new Item("Spinach",0.99);
        // Item item3=new Item("Coriander",0.99);
        // System.out.print(item1+" ");
        // System.out.print(item2+" ");
        // System.out.print(item3+" ");
        // Cart cart=new Cart();
        // cart.add(new Item("Celery", 0.99));
        // cart.add(new Item("Celery", 0.99));
        // cart.add(new Item("Spinach", 0.99));
        // cart.add(new Item("Corriander", 1.29));
        // System.out.println(cart);
        // Item[][] inventory = new Item[][] { 
        //     { new Item("Pepsi", 1.99), new Item("Crush", 1.99), new Item("Cola", 1.99) },
        //     { new Item("Honey Oats", 3.99), new Item("Fruit Loops", 1.99), new Item("Cheerios", 2.99) },
        //     { new Item("Milk", 4.99), new Item("Eggs", 0.99), new Item("Cheese", 1.89) },
        //     { new Item("Pepperoni", 2.99), new Item("Salami", 4.49), new Item("Mortadella", 4.99) },
        //     { new Item("Celery", 0.99), new Item("Spinach", 0.99), new Item("Coriander", 1.29) },
        //     { new Item("Shirt", 12.99), new Item("Pants", 24.99), new Item("Sweater", 18.99) }, 
        //     { new Item("Phone", 549.99), new Item("Printer", 349.99), new Item("Television", 1099) } 
        // };
        // Store store=new Store();
        // for (int i = 0; i < inventory.length; i++) {
        //     for (int j = 0; j < inventory[0].length; j++) {
        //         store.setItem(i, j, inventory[i][j]);
        //     }
            
            
        // }
        // System.out.println("\n\t******************************JAVA GROCERS******************************\n");
        //     System.out.println(store + "\n");
      try{
        loadItems("products.txt");
      }
      catch(FileNotFoundException e)
      {
        System.out.println(e);
      }
      manageItems();

    }

    /**
     * Name: manageItems
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. Creates an infinite loop:     
     *   •        The user can choose to a) add or b) remove c) checkout.
     *   •          case a: asks for the aisle and item number. Then, adds item to cart.
     *   •          case b: asks for the name. Then, removes item from cart.
     *   •          case c: prints the receipt and closes Scanner.
     *   •        Prints the updated shopping cart.
     */
 
    public static void manageItems()
    {    Scanner scan=new Scanner(System.in);
         String option,removeItem;
         int row,column;
        while(true)
        {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store + "\n\n");
            System.out.println("Options\n\ta) Add to Cart\n\tb) Remove from Cart\n\tc) Checkout");
            option=scan.nextLine();
            switch(option)
            {
                case "a":
                System.out.print("\nChoose an aisle number between: 1 – 7: ");
                row=scan.nextInt();
                System.out.print("Choose an item number between: 1 – 3: ");
                column=scan.nextInt();
                scan.nextLine();
                if(row<1|| row>7 || column<1 || column>3)
                {
                    System.out.println("Entre valid row and cloumn no : ");
                    System.out.println("Enter anything to continue: ");
            scan.nextLine();
                    continue;
                }
                if(cart.equals(new Item(store.getItem(row-1, column-1))))
                {
                    System.out.println(store.getItem(row-1, column-1).getName() + " is already in your shopping cart.");
                }
                else
                {
                     cart.add(new Item(store.getItem(row-1, column-1)));
                     System.out.println(store.getItem(row-1, column-1).getName() + " was added in your shopping cart.");
                    
                }
                break;
                case "b":

                System.out.print("Enter the item you'd like to remove: ");
                
                removeItem=scan.nextLine();

                cart.remove(removeItem);
                 
                break;
                case "c":
                if(cart.isEmpty())
                {
                    System.out.println("Cannot Checkout !! Cart is already empty");
                    continue;
                }
                System.out.print("\n"+cart.checkout());
                System.exit(0);

                break;
                default:
                System.out.println("Please Enter Valid Operation");
                continue;
            }
            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.println("Enter anything to continue: ");
            scan.nextLine();
   

        }
        
    }
     
    /**
     * 
     * Name: loadItems
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   1. loads items from <fileName>.txt.
     *      • while loop runs through every line in <fileName>
     *      • scan.nextLine() picks up the entire line.
     *      • splits each String using the ";" separator.
     *      • splits both fields in each String using the "=" separator.
     *      • Parse each price into a Double.
     *   2. adds all items to the store object's items field.
     */
     
    public static void loadItems (String file) throws FileNotFoundException
    {
        FileInputStream fis=new FileInputStream(file);
        Scanner scan=new Scanner((fis));
        int row=0;
        int column=0;
        while(scan.hasNextLine())
        {
            String [] item;
            String line =scan.nextLine();
            String[] words=line.split(";");
            column=0;
            for (String string : words) {
                item=string.split("=");
                store.setItem(row,column,new Item(item[0],Double.parseDouble(item[1])));
                column++;
            }
            row++;
        }
        scan.close();
    }
   

}
