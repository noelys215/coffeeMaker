package machine;

import java.util.Scanner;


public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int cash = 550;
    private State state;

    public CoffeeMachine() {
        state = State.CHOOSING_ACTION; // Initial state
    }

    public void input(String inputLine) {
        switch (state) {
            case CHOOSING_ACTION:
                handleAction(inputLine);
                break;
            case CHOOSING_COFFEE:
                handleCoffeeSelection(inputLine);
                break;
            case FILLING_WATER:
                water += Integer.parseInt(inputLine);
                state = State.FILLING_MILK;
                break;
            case FILLING_MILK:
                milk += Integer.parseInt(inputLine);
                state = State.FILLING_BEANS;
                break;
            case FILLING_BEANS:
                beans += Integer.parseInt(inputLine);
                state = State.FILLING_CUPS;
                break;
            case FILLING_CUPS:
                cups += Integer.parseInt(inputLine);
                state = State.CHOOSING_ACTION;
                break;
            default:
                break;
        }
    }

    private void handleAction(String action) {
        switch (action) {
            case "buy":
                state = State.CHOOSING_COFFEE;
                break;
            case "fill":
                state = State.FILLING_WATER;
                System.out.println("Write how many ml of water you want to add: ");
                break;
            case "take":
                handleTake();
                break;
            case "remaining":
                printStatus();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }

    private void handleCoffeeSelection(String option) {
        if ("back".equals(option)) {
            state = State.CHOOSING_ACTION;
            return;
        }

        int choice = Integer.parseInt(option);
        switch (choice) {
            case 1:
                makeCoffee(250, 0, 16, 4);
                break;
            case 2:
                makeCoffee(350, 75, 20, 7);
                break;
            case 3:
                makeCoffee(200, 100, 12, 6);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }

        state = State.CHOOSING_ACTION;
    }

    private void makeCoffee(int waterCost, int milkCost, int beansCost, int cashGain) {
        if (water < waterCost) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkCost) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < beansCost) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterCost;
            milk -= milkCost;
            beans -= beansCost;
            cash += cashGain;
            cups--;
        }
    }

    private void handleTake() {
        System.out.println("I gave you $" + cash);
        cash = 0;
    }

    private void printStatus() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + cash + " of money\n");
    }

    enum State {
        CHOOSING_ACTION,
        CHOOSING_COFFEE,
        FILLING_WATER,
        FILLING_MILK,
        FILLING_BEANS,
        FILLING_CUPS
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            coffeeMachine.input(input);
        }

    }
}



















