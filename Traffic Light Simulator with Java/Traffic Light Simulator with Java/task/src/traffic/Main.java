package traffic;

// Input
// -------
// 1. number of roads
// 2. interval for open/close
// App ends when a user types 0
//

import java.util.Scanner;

public class Main {
  public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      Input input = new Input(scanner);

      Messages.welcome();
      int roads = input.readValue("Input the number of roads: ");
      int interval = input.readValue("Input the interval: ");

      Messages.displayMenu();

      int option = input.readValue("");

      while (option != 0) {
          switch (option) {
              case 1:
                  System.out.println("Road added");
                  Messages.displayMenu();
                  break;
              case 2:
                  System.out.println("Road deleted");
                  Messages.displayMenu();
                  break;
              case 3:
                  System.out.println("System opened");
                  Messages.displayMenu();
                  break;
              default:
                  System.out.println("Invalid");
          }
          option = input.readValue("");
      }
      System.out.print("Bye!");
  }
}
