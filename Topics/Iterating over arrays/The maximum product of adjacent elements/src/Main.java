import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the number of elements
        int n = scanner.nextInt();

        // Read the first element to start the comparison
        int prevElement = scanner.nextInt();
        int maxProduct = Integer.MIN_VALUE;

        // Iterate through the array starting from the second element
        for (int i = 1; i < n; i++) {
            int currentElement = scanner.nextInt();

            // Calculate the product of the current and previous elements
            int product = prevElement * currentElement;

            // Update the maximum product if the current product is greater
            if (product > maxProduct) maxProduct = product;

            // Update the previous element for the next iteration
            prevElement = currentElement;
        }

        // Output the maximum product
        System.out.println(maxProduct);
    }
}
