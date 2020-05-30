import java.util.*;

class Admin{

  private static Menu menu;
  private static Scanner response;
  public static void main(String[] args) {
    boolean run = true;
    int choice;
    response = new Scanner(System.in);

    System.out.println("Welcome to the ADMIN interface");
    System.out.println("###################################");
    System.out.println("\n");
    System.out.println("Enter Username:");
    String user = response.nextLine();
    System.out.println("Enter Password:");
    String pass = response.nextLine();

    menu = new Menu();

    while(run){
      System.out.println("What would you like to do today?");
      System.out.println("###################################");
      System.out.println("1. View Earnings");
      System.out.println("2. View menu");
      System.out.println("3. Modify menu");
      System.out.println("4. Quit");
      System.out.println("Enter your choice");
      choice = response.nextInt();
      switch (choice) {
        case 2:
          System.out.println("\n");
          menu.show_menu();
          break;
        case 3:
          modify_menu();
          break;
        case 4:
          run = false;
          menu.save();
          break;
      }
    }
  }

  private static void modify_menu(){
    int choice;
    int index;
    System.out.println("\n");
    menu.show_menu();
    System.out.println("What would you like to do?");
    System.out.println("###################################");
    System.out.println("1. Add Item");
    System.out.println("2. Remove Item");
    System.out.println("3. Modify Item");
    System.out.println("Enter your choice");
    choice = response.nextInt();
    switch (choice) {
      case 1:
        menu.add_item();
        break;
      case 2:
        System.out.println("Enter item number:");
        index = response.nextInt() - 1;
        menu.remove_item(index);
        break;
      case 3:
        System.out.println("Enter item number:");
        index = response.nextInt() - 1;
        menu.modify_item(index);
        break;
      default:
    }
  }
}
