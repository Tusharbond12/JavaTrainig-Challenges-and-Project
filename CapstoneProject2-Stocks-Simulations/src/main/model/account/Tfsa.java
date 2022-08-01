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
    public boolean buy(String stock ,Double price ,int shares )
    {
        double charge= price * shares;
        if(charge>super.getFunds())
        {
            return false;
        }
        else{
            double fee=0.01 * charge;
            super.setFunds(super.getFunds()-charge-fee);
            super.updatePortfolio(shares,"BUY",stock);
            return true;
        }

    }
    public boolean sell(String stock ,Double price ,int shares)
    {
      if(super.getPortfolio().get(stock)<shares)
      {
        return false;
      }
      else
      { 
        double charge=price*shares;
        double fee=0.01 * charge;
        super.setFunds(super.getFunds()+charge-fee);
        super.updatePortfolio(shares,"SELL",stock);
        return true;
      }
    }
}
