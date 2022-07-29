package models;

public class Store {
Item store[][];
public Store()
{
    this.store=new Item[7][3];
}
public Item getItem(int row , int column)
{
    return new Item(store[row][column]);
}
public void setItem(int row ,int column , Item item)
{
    store[row][column]=new Item(item);
}
public String toString() {

    String temp="";
    for (int i=0;i<store.length;i++) {
        switch (i) {
            case 0: temp += "\tDRINKS:        "; break;
            case 1: temp += "\tCEREAL:        "; break;
            case 2: temp += "\tDAIRY:         "; break; 
            case 3: temp += "\tDELI:          "; break; 
            case 4: temp += "\tGREENS:        "; break; 
            case 5: temp += "\tCLOTHING:      "; break; 
            case 6: temp += "\tELECTRONICS:   "; break; 
        }
        for(int j=0;j<store[0].length ;j++)
        {
            temp+=store[i][j].toString();
        }
        temp+="\n\n";
        
    }
   temp+= "\t************************************************************************\n";
   return temp;
}
}
