package src.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import src.main.model.account.Account;
import src.main.model.account.Personal;

public class AccountTest {
    static Account  acc;
     @Before
    public void main()
    {  
        HashMap<String,Integer> map=new HashMap<String,Integer>();//Creating HashMap    
        map.put("TSLA",5);
        map.put("GOOG",5);
        map.put("FB",5);
        map.put("AAPL",5);
        double funds=3400;
        acc=new Personal(map, funds);
        System.out.println(acc);

        };
   
    @Test
    public void testRound()
    { 
       assertEquals(122.34, acc.round(122.34364));
    }

  

}
