package models;


import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;
    public Cart()
    {
      items=new ArrayList<Item>();

    }
    public Item getItem(int index)
    {
       return new Item(items.get(index));
    }
    public void setItem(int index,Item item)
    {
        this.items.add(index, new Item(item));
    }
    


   /**
    * Name: add
    * @param item
    * @return boolean
    *
    * Inside the function:
    *   1. Adds an item to the cart if it wasn't already added.
    */
   public boolean add(Item item)
   {
    // if(isEmpty())
    // {
    //     throw new IllegalStateException("The cart is empty ");
    // }
    if(equals(item))
    {
return false;
    }
    this.items.add(new Item(item));
    return true;
   }
 
 
  
   /**
    * Name: remove
    * @param name
    *
    * Inside the function:
    *   1. Removes the item that matches the name passed in.
    */

 public void remove(String name)
 {
    for (int i = 0; i < this.items.size(); i++) {
        if(this.items.get(i).getName().equals(name))
        {
            this.items.remove(this.items.get(i));
            break;
        }
    }
 }

 
  
   /**
    *  Name: checkout
    *  @return (String)
    *
    *  Inside the function:
    *   1. Calculates the subtotal (price before tax).
    *   2. Calculates the tax (assume tax is 13%).
    *   3. Calculates total: subtotal + tax
    *   4. Returns a String that resembles a receipt. See below.
    */
    
    public String checkout()
    {   
        if(isEmpty())
        {
            throw new IllegalStateException("The cart is empty ");
        }
        double subtotal=0;
        for (int i = 0; i < items.size(); i++) {
            subtotal+=items.get(i).getprice();
        }
        double tax= 0.13 * subtotal;
        double total= tax+ subtotal;
        return "\tRECEIPT\n\n" +
        "\tSubtotal: $" + subtotal + "\n" +
        "\tTax: $" + tax + "\n" +
        "\tTotal: $" + total + "\n";

    }
    public String toString()
    {
        String temp="";
        for (Item item : items) {
            temp+=item.toString()+"\n";
            
        }
        return temp;
    }
     public boolean equals(Item source)
    {   
        if(source==null){
        return false;}
        for (Item item : items) {

            if(source.getName().equals(item.getName()) && source.getprice()==item.getprice() )
            {
                return true;
            }

        }
        return false;
    }
    public boolean isEmpty()
    {
        if(items.size()==0)
        {
            return true;
        }
        return false;
    }
    
}
