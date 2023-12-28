package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
     /*   String[] options = {
                "Starting to make a coffee",
                "Grinding coffee beans",
                "Boiling water",
                "Mixing boiled water with crushed coffee beans",
                "Pouring coffee into the cup",
                "Pouring some milk into the cup",
                "Coffee is ready!"
        };

        for (var option : options) System.out.println(option);
      */
//        makeCoffee();
        checkInventory();

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
}