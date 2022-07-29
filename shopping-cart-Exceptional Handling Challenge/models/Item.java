package models;
import java.lang.IllegalArgumentException;

public class Item {

  private String name;
  private double price;

  public Item(String name, double price)
  { 
    if(name==null || name.isBlank())
    {
        throw new IllegalArgumentException("Name cannot be null or blank");
    }
    if(price<0)
    {
        throw new IllegalArgumentException("Price cannot be less than 0");
    }
    this.name=name;
    this.price=price;
  }
  public Item(Item source)
  {
    this.name=source.name;
    this.price=source.price;
  }
public String getName()
{
return name;
}
public double getprice()
{
    return price;
}
private void setPrice(double price)
{
    if(price<0)
    {
        throw new IllegalArgumentException("Price cannot be less than 0");
    }
this.price=price;
}
private void setName(String name)
{
    if(name==null || name.isBlank())
    {
        throw new IllegalArgumentException("Name cannot be null or blank");
    }
    this.name=name;
}
public String toString()
{
    return name + ": $" + price + " ";
}
}
