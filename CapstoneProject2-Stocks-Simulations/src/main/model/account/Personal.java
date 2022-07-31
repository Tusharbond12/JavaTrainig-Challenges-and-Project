package src.main.model.account;
import java.util.Map;
public class Personal extends Account {
    
    public Personal(Map<String,Integer> portfolio,Double price ) {
        super(portfolio,price);
        
    }
    public Personal(Personal source)
    {
        super(source);
    }
}
