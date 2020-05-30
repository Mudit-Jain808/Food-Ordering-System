import java.util.*;

class User {
  private static Menu menu;
  private static Scanner response;
  public static void main(String[] args) {
    boolean run = true;
    int choice;
    response = new Scanner(System.in);
    menu = new Menu();

    while(run){
      System.out.println("What would you like to do today?");
      System.out.println("###################################");
      System.out.println("1. Order Food");
      System.out.println("2. Quit");
      System.out.println("Enter your choice");
      choice = response.nextInt();
      switch (choice) {
        case 1:
          System.out.println("\n");
          menu.show_menu();
          break;
        case 2:
          run = false;
          break;
      }
    }
  }

  private void order_food(){
    menu.show_menu();
  }
}
