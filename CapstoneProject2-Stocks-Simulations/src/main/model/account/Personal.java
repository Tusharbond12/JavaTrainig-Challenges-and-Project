package src.main.model.account;
import java.util.Map;
public class Personal extends Account {
    
    public Personal(Map<String,Integer> portfolio,Double funds) {
        super(portfolio,funds);
        
    }
    public Personal(Personal source)
    {
        super(source);
    }
    public boolean buy(String stock ,Double price ,int shares )
    {
        double charge= price * shares;
        if(charge>super.getFunds())
        {
            return false;
        }
        else{
            super.setFunds(super.getFunds()-charge);
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
        double fee=0.05 * charge;
        super.setFunds(super.getFunds()+charge-fee);
        super.updatePortfolio(shares,"SELL",stock);
        return true;
      }
    }
    public Personal clone()
    {
        return new Personal(this);
    }
}
