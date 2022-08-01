package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.Tfsa;


public class BuyTests {
    
    static Account  acc1;
    static Account acc2;
    @Before
    public void main()
    {  
        HashMap<String,Integer> map=new HashMap<String,Integer>();//Creating HashMap    
        map.put("TSLA",5);
        map.put("GOOG",5);
        map.put("FB",5);
        map.put("AAPL",5);
        double funds=3400;
        acc1=new Personal(map, funds);
        acc2=new Tfsa(map,funds);

     };
     @Test
     public void testBuyPersonal()
     {  boolean bool= acc1.buy("TSLA", 20.00, 20);
        if(bool){
        assertEquals(acc1.getPortfolio().get("TSLA"), 25); 
        //assertEquals(acc.getFunds(), 3400-20*10);
        // assertEquals(acc.getPortfolio().get("TSLA"), 15);}
     }}
     @Test
     public void testBuyTfsa()
     {  boolean bool= acc2.buy("TSLA", 20.00, 30);
        if(bool){
        assertEquals(acc2.getPortfolio().get("TSLA"), 35); 
        assertEquals(acc2.getFunds(), 3400-20*30-0.01*600);
        // assertEquals(acc.getPortfolio().get("TSLA"), 15);}
     }}
     


}
