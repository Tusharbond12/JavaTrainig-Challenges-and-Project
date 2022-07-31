package src.main.model.account;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Soundbank;

public abstract class Account {
   private Map<String,Integer> portfolio=new HashMap<>();
   private Double price;
   public Account(Map<String,Integer> portfolio, Double price) {
        this.portfolio = portfolio;
        this.price = price;
    }
    public Account(Account source) {
        this.portfolio = source.getPortfolio();
        this.price = price;
    }

    public Map<String,Integer> getPortfolio() {
        return this.portfolio;
    }

    public void setProftfolio(Map<String,Integer> proftfolio) {
        this.portfolio = proftfolio;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    
    

}
