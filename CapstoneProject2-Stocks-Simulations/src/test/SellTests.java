package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.Tfsa;
import src.main.model.account.Trade;

public class SellTests {
    
    static Account  acc1;
    static Account acc2;
    static Trade trade ;
    @Before
    public void main()
    {  
        HashMap<String,Integer> map=new HashMap<String,Integer>();//Creating HashMap    
        map.put("TSLA",25);
        map.put("GOOG",5);
        map.put("FB",5);
        map.put("AAPL",5);
        double funds=3400;
        acc1=new Personal(map, funds);
        acc2=new Tfsa(map, funds);

     };
     @Test
     public void testSellPersonal()
     {  boolean bool= acc1.sell("TSLA", 10.00, 10);
        if(bool){
        assertEquals(acc1.getPortfolio().get("TSLA"), 15); 
        assertEquals(acc1.getFunds(), 3495);
        // assertEquals(acc.getPortfolio().get("TSLA"), 15);}
     }}
     @Test
     public void testSellTfsa()
     {  boolean bool= acc2.sell("TSLA", 10.00, 10);
        if(bool){
        assertEquals(acc2.getPortfolio().get("TSLA"), 15); 
        assertEquals(acc2.getFunds(), 3500-0.01*100);
        // assertEquals(acc.getPortfolio().get("TSLA"), 15);}
     }}

     @Test
     public void testProcessTrade()
     {
        trade=new Trade("TSLA", "SELL", 10, 10);
      //   trade.processTrade(acc2);
      //   assertEquals(acc2.getPortfolio().get("TSLA"), 5); 
      //   assertEquals(acc2.getFunds(), 3600-0.01*200);
      trade.processTrade(acc1);
      assertEquals(acc1.getPortfolio().get("TSLA"), 15); 
      assertEquals(acc1.getFunds(), 3495);


     }


}
