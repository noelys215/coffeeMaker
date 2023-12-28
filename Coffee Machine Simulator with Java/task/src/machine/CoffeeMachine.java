package machine;

import java.util.Scanner;

enum action {buy, fill, take}

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
//        checkInventory();
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
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int cash = 550;

        System.out.println("""
                The coffee machine has:
                400 ml of water
                540 ml of milk
                120 g of coffee beans
                9 disposable cups
                $550 of money
                """);
        System.out.println("Write action (buy, fill, take): ");
        var action = scanner.nextLine();

        switch (action) {
            case "buy" -> {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                var option = scanner.nextInt();
                switch (option) {
                    case 1 -> System.out.printf("""
                                                        
                            The coffee machine has:
                            %s ml of water
                            %s ml of milk
                            %s g of coffee beans
                            %s disposable cups
                            $%s of money""", water - 250, milk, beans - 16, cups - 1, cash + 4);
                    case 2 -> System.out.printf("""
                                                        
                            The coffee machine has:
                            %s ml of water
                            %s ml of milk
                            %s g of coffee beans
                            %s disposable cups
                            $%s of money""", water - 350, milk - 75, beans - 20, cups - 1, cash + 7);
                    case 3 -> System.out.printf("""
                                                        
                            The coffee machine has:
                            %s ml of water
                            %s ml of milk
                            %s g of coffee beans
                            %s disposable cups
                            $%s of money""", water - 200, milk - 100, beans - 12, cups - 1, cash + 6);
                    default -> System.out.println("Invalid Choice");
                }
            }
            case "fill" -> {
                System.out.println("Write how many ml of water you want to add: ");
                int updatedWater = water + scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add: ");
                int updatedMilk = milk + scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add: ");
                int updatedBeans = beans + scanner.nextInt();
                System.out.println("Write how many disposable cups you want to add: ");
                int updatedCups = cups + scanner.nextInt();
                System.out.printf("""
                                                
                        The coffee machine has:
                        %s ml of water
                        %s ml of milk
                        %s g of coffee beans
                        %s disposable cups
                        $%s of money""", updatedWater, updatedMilk, updatedBeans, updatedCups, cash);
            }
            case "take" -> {
                System.out.printf("I gave you $%s\n\n", cash);
                System.out.printf("""
                        The coffee machine has:
                        400 ml of water
                        540 ml of milk
                        120 g of coffee beans
                        9 disposable cups
                        $%s of money""", 0);
            }
            default -> System.out.println("Invalid Choice");
        }


    }
}



















