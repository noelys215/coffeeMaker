package machine;

public class CoffeeMachine {
    // Enum representing different states of the coffee machine
    enum State {
        CHOOSING_ACTION,
        CHOOSING_COFFEE,
        FILLING_WATER,
        FILLING_MILK,
        FILLING_BEANS,
        FILLING_CUPS
    }

    // Fields representing the resources of the coffee machine
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int cash = 550;

    // The current state of the coffee machine
    private State state;

    // Constructor initializes the coffee machine to the starting state
    public CoffeeMachine() {
        state = State.CHOOSING_ACTION;
    }

    // Method to handle all input based on the current state
    public void input(String inputLine) {
        switch (state) {
            case CHOOSING_ACTION -> handleAction(inputLine);
            case CHOOSING_COFFEE -> handleCoffeeSelection(inputLine);
            case FILLING_WATER -> {
                water += Integer.parseInt(inputLine);
                state = State.FILLING_MILK; // Next, we expect milk to be filled
            }
            case FILLING_MILK -> {
                milk += Integer.parseInt(inputLine);
                state = State.FILLING_BEANS; // Next, we expect beans to be filled
            }
            case FILLING_BEANS -> {
                beans += Integer.parseInt(inputLine);
                state = State.FILLING_CUPS; // Next, we expect cups to be filled
            }
            case FILLING_CUPS -> {
                cups += Integer.parseInt(inputLine);
                state = State.CHOOSING_ACTION; // Go back to choosing action
            }
            default -> throw new IllegalStateException("Unexpected value: " + state);
        }
    }

    // Method to handle the main actions of the coffee machine
    private void handleAction(String action) {
        switch (action) {
            case "buy" -> state = State.CHOOSING_COFFEE; // Switch to coffee selection state
            case "fill" -> state = State.FILLING_WATER; // Switch to water filling state
            case "take" -> handleTake(); // Handle taking the cash
            case "remaining" -> printStatus(); // Print the current status
            case "exit" -> System.exit(0); // Exit the program
            default -> System.out.println("Invalid Choice");
        }
    }

    // Method to handle coffee selection and making coffee
    private void handleCoffeeSelection(String option) {
        if ("back".equals(option)) {
            state = State.CHOOSING_ACTION; // Go back to choosing action
            return;
        }
        int choice = Integer.parseInt(option);
        switch (choice) {
            case 1 -> makeCoffee(250, 0, 16, 4); // Make espresso
            case 2 -> makeCoffee(350, 75, 20, 7); // Make latte
            case 3 -> makeCoffee(200, 100, 12, 6); // Make cappuccino
            default -> System.out.println("Invalid Choice");
        }
        state = State.CHOOSING_ACTION; // After making coffee, go back to choosing action
    }

    // Method to make a coffee and update resources
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

    // Method to handle taking the cash from the machine
    private void handleTake() {
        System.out.printf("I gave you $%d%n", cash);
        cash = 0;
    }

    // Method to print the current status of the coffee machine
    private void printStatus() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money%n""", water, milk, beans, cups, cash);
    }
}
