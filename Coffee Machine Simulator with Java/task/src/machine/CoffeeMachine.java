package machine;

import java.util.Scanner;


public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int cash = 550;

    public static void main(String[] args) {
        coffeeMaker();
    }

    public static void makeCoffee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need: ");
        int cups = scanner.nextInt();

        int waterPerCup = 200;
        int milkPerCup = 50;
        int coffeeBeansPerCup = 15;

        int totalWater = cups * waterPerCup;
        int totalMilk = cups * milkPerCup;
        int totalCoffeeBeans = cups * coffeeBeansPerCup;

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(totalWater + " ml of water");
        System.out.println(totalMilk + " ml of milk");
        System.out.println(totalCoffeeBeans + " g of coffee beans");

        scanner.close();
    }

    public static void checkInventory() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterSupply = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkSupply = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeansSupply = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cupsNeeded = scanner.nextInt();

        int waterPerCup = 200;
        int milkPerCup = 50;
        int coffeeBeansPerCup = 15;
        // Calculating the maximum number of cups the machine can make
        int maxCups = Math.min(waterSupply / waterPerCup,
                Math.min(milkSupply / milkPerCup, coffeeBeansSupply / coffeeBeansPerCup));

        // Checking if the machine can make the exact number of cups requested
        if (cupsNeeded > maxCups) {
            // Not enough resources to make the desired number of cups
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        } else if (cupsNeeded < maxCups) {
            // More resources available than needed for the desired number of cups
            System.out.println("Yes, I can make that amount of coffee (and even "
                    + (maxCups - cupsNeeded) + " more than that)");
        } else {
            // Exact amount of resources for the desired number of cups
            System.out.println("Yes, I can make that amount of coffee");
        }
        scanner.close();
    }

    public static void coffeeMaker() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();
            switch (action) {
                case "buy" -> handleBuy(scanner);
                case "fill" -> handleFill(scanner);
                case "take" -> handleTake();
                case "remaining" -> printStatus();
                case "exit" -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private static void handleBuy(Scanner scanner) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String option = scanner.next();
        scanner.nextLine(); // Consume the rest of the line including newline

        if ("back".equals(option)) {
            return; // Go back to the main menu
        }
        int choice = Integer.parseInt(option);
        switch (choice) {
            case 1 -> makeCoffee(250, 0, 16, 4);
            case 2 -> makeCoffee(350, 75, 20, 7);
            case 3 -> makeCoffee(200, 100, 12, 6);
            default -> System.out.println("Invalid Choice");
        }
    }

    private static void makeCoffee(int waterCost, int milkCost, int beansCost, int cashGain) {
        // Check for each resource individually
        if (water < waterCost) {
            System.out.println("\nSorry, not enough water!\n");
        } else if (milk < milkCost) {
            System.out.println("\nSorry, not enough milk!\n");
        } else if (beans < beansCost) {
            System.out.println("\nSorry, not enough coffee beans!\n");
        } else if (cups < 1) {
            System.out.println("\nSorry, not enough disposable cups!\n");
        } else {
            // If all resources are sufficient, make the coffee
            System.out.println("I have enough resources, making you a coffee!\n");
            water -= waterCost;
            milk -= milkCost;
            beans -= beansCost;
            cash += cashGain;
            cups--;
        }
    }

    private static void handleFill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        water += scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line including newline

        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line including newline

        System.out.println("Write how many grams of coffee beans you want to add: ");
        beans += scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line including newline

        System.out.println("Write how many disposable cups you want to add: ");
        cups += scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line including newline
    }

    private static void handleTake() {
        System.out.printf("I gave you $%d\n\n", cash);
        cash = 0;
    }

    private static void printStatus() {
        System.out.printf("""
                                
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                                
                """, water, milk, beans, cups, cash);
    }
}



















