import java.io.*;
import java.util.*;

class Menu implements Serializable {

  private ArrayList<Item> items = new ArrayList<Item>();

  public Menu(){
    try{
      FileInputStream fi = new FileInputStream(new File("menu.data"));
      ObjectInputStream oi = new ObjectInputStream(fi);

      items = ((Menu) oi.readObject()).items;

      oi.close();
      fi.close();
    } catch(FileNotFoundException e){
      System.out.println("No existing data found. Creating default menu.");
      items.add(new Item("Water", 20.0));
    } catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

  }

  public void show_menu(){
    items.forEach((i) -> i.print(items.indexOf(i)+1));
  }

  public void add_item(){
    String item_name;
    double item_price;
    Scanner response = new Scanner(System.in);
    System.out.print("Enter the name of the item:");
    item_name = response.nextLine();
    System.out.print("Enter the price of the item:");
    item_price = response.nextDouble();
    items.add(new Item(item_name, item_price));
  }

  public void remove_item(int index){
    items.remove(index);
  }

  public void save(){
    try{
      FileOutputStream f = new FileOutputStream(new File("menu.data"));
      ObjectOutputStream o = new ObjectOutputStream(f);

      o.writeObject(this);

      o.close();
      f.close();
    } catch (IOException e) {
			System.out.println("Error initializing stream");
		}
  }

  public void modify_item(int index){
    int choice;
    Scanner response = new Scanner(System.in);
    System.out.println("\n");
    items.get(index).print();
    System.out.println("What would you like to do?");
    System.out.println("###################################");
    System.out.println("1. Change name");
    System.out.println("2. Change price");
    System.out.println("Enter your choice");
    choice = response.nextInt();
    response.nextLine();
    switch (choice) {
      case 1:
        System.out.println("Enter the new name");
        String name = response.nextLine();
        items.get(index).modify_name(name);
        break;
      case 2:
        System.out.println("Enter the new price");
        double price = response.nextDouble();
        items.get(index).modify_price(price);
        break;
      case 3:
        break;
      default:
    }
  }
}
