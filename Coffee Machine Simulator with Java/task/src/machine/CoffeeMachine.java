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
        makeCoffee();
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

}
