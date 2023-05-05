package machine;

import java.util.Scanner;


public class CoffeeMachine {

  private static final Scanner scanner = new Scanner(System.in);

  private static int hasWater = 400;
  private static int hasMilk  = 540;
  private static int hasBeans = 120;
  private static int hasCups  = 9;
  private static int hasMoney = 550;

  public static void main(String[] args) {

    while (true) {
      showActionList();
      String action = scanner.nextLine();
      switchAction(action);
    }
  }

  private static void showActionList() {
    System.out.println("Write action (buy, fill, take, remaining, exit):");
  }

  private static void switchAction(String action) {
    switch (action) {
      case "remaining" -> showRemaining();
      case "buy" -> buyCoffee();
      case "fill" -> fillMachine();
      case "take" -> takeMoney();
      case "exit" -> System.exit(0);
    }
  }

  private static void showRemaining() {
    System.out.printf("""
                      %d ml of water
                      %d ml of milk
                      %d g of coffee beans
                      %d disposable cups
                      $%d of money
                      """, hasWater, hasMilk, hasBeans, hasCups, hasMoney);
  }

  private static void buyCoffee() {
    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

    String choseCoffee = scanner.nextLine();

    switch (choseCoffee) {
      case "1":
        makeCoffee(250, 0, 16, 4);
        break;
      case "2":
        makeCoffee(350, 75, 20, 7);
        break;
      case "3":
        makeCoffee(200, 100, 12, 6);
        break;
      case "back":
        break;
    }
  }

  private static void makeCoffee(int coffeeWater, int coffeeMilk, int coffeeBeans, int coffeeMoney) {

    if (hasWater < coffeeWater) {
      System.out.println("Sorry, not enough water!");
    } else if (hasMilk < coffeeMilk) {
      System.out.println("Sorry, not enough milk!");
    } else if (hasBeans < coffeeBeans) {
      System.out.println("Sorry, not enough coffee beans!");
    } else if (hasCups < 1) {
      System.out.println("Sorry, not enough disposable cups!");
    } else {
      System.out.println("I have enough resources, making you a coffee!");

      hasWater -= coffeeWater;
      hasMilk -= coffeeMilk;
      hasBeans -= coffeeBeans;
      hasCups -= 1;
      hasMoney += coffeeMoney;
    }

  }

  private static void fillMachine() {
    System.out.println("Write how many ml of water you want to add:");
    hasWater += Integer.parseInt(scanner.nextLine());
    System.out.println("Write how many ml of milk you want to add: ");
    hasMilk += Integer.parseInt(scanner.nextLine());
    System.out.println("Write how many grams of coffee beans you want to add:");
    hasBeans += Integer.parseInt(scanner.nextLine());
    System.out.println("Write how many disposable cups you want to add:");
    hasCups += Integer.parseInt(scanner.nextLine());
  }

  private static void takeMoney() {
    System.out.println("I gave you $" + hasMoney);
    hasMoney = 0;
  }
}
