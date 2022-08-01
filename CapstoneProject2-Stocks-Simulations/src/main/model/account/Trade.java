package src.main.model.account;
import src.main.model.account.Account;

public class Trade {
    
    private String stock;
    private String type;
    private int shares;
    private double price;


    public Trade( String stock, String type, int shares, double price) {
       
        this.stock = stock;
        this.type = type;
        this.shares = shares;
        this.price = price;
    }
    public Trade(Trade source)
    {
        // if(acc.getClass().getName()=="Personal")
        // {
        //     this.acc=new Personal(source.acc.getPortfolio(),source.acc.getFunds());
        // }
        // else
        // {
        //     this.acc=new Tfsa(source.acc.getPortfolio(),source.acc.getFunds());
        // }
        this.stock = source.stock;
        this.type = source.type;
        this.shares = source.shares;
        this.price = source.price;
    }

    public String getStock() {
        return this.stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getShares() {
        return this.shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void processTrade(Account acc)
    {
        if(this.type.equals("SELL"))
        {
             acc.sell(this.stock,this.price,this.shares);
        }
        else if(this.type.equals("Buy"))
        {
            acc.buy(this.stock,this.price,this.shares);
        }
        


    }


}
