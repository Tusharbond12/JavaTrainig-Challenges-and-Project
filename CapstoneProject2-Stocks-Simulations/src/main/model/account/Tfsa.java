package src.main.model.account;

import java.util.Map;

public class Tfsa extends Account{
    
    public Tfsa(Map<String,Integer> portfolio, Double price)
    {
       super(portfolio,price);
    }
    public Tfsa(Account Source)
    {
        super(Source);
    }
}
