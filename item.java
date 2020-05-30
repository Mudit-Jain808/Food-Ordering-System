import java.io.*;

class Item implements Serializable{
  private String name;
  private double price;

  public Item(String n, double p){
    name = n;
    price = p;
  }

  public void print(){
    System.out.println(name + ":\t" + Double.toString(price));
  }
  public void print(int i){
    System.out.println(Integer.toString(i) + ". " + name + ":\t" + Double.toString(price));
  }
  public void modify_name(String n){
    name = n;
  }
  public void modify_price(double p){
    price = p;
  }
}
