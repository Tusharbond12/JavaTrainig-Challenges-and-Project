public class Machine {
    private Item[][] items;
    
    public Machine(Item[][] items)
    {    this.items=new Item[items.length][items[0].length];
        for(int i=0;i<items.length;i++)
        {   
            for(int j=0;j<items[i].length;j++)
            {
                // this.items[i][j].setName(items[i][j].getName());
                // this.items[i][j].setPrice(items[i][j].getPrice());
                // this.items[i][j].setQuantity(items[i][j].getQuantity());
                this.items[i][j]=new Item(items[i][j]);

            }
        }
    }
    public  Item getItem(int row,int spot)
    {  
      return new Item(this.items[row][spot]);
    }
    public void setItem(Item item,int row ,int spot)
    {
                this.items[row][spot].setName(item.getName());
                this.items[row][spot].setPrice(item.getPrice());
                this.items[row][spot].setQuantity(item.getQuantity());
    }

    /**
     * Function name – dispense
     * @param row (int)
     * @param spot (int)
     * @return (boolean)
     * 
     * Inside the function:
     *  1. Checks if the requested item has a quantity bigger than 0.
     *      • if so: decreases its quantity by one and returns true.
     *      • otherwise: returns false.
     */
    public boolean dispense(int row ,int spot)
    {
        if(items[row][spot].getQuantity()>0)
        {
            items[row][spot].setQuantity(items[row][spot].getQuantity()-1);
            return true;
        }
        else
        {
            return false;
        }
    }
    public String toString()
    {
        String temp="";
        for (int i = 0; i < items.length; i++) {
            temp=temp+"\t";
            for (int j = 0; j < items[0].length; j++) {
                temp=temp+items[i][j].getName()+" : "+items[i][j].getPrice()+"("+items[i][j].getQuantity()+") ";
                
            }
            temp=temp+"\n\n";
            
        }
       
        temp += "\t************************************************";
        return temp;
    }
}
