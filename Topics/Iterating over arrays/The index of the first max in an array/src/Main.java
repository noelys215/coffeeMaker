import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements
        int n = scanner.nextInt();

        // Initialize variables for storing the maximum value and its index
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        // Read the array elements
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();

            // Update max and maxIndex if a new maximum is found
            if (element > max) {
                max = element;
                maxIndex = i;
            }
        }

        // Output the index of the first maximum
        System.out.println(maxIndex);
    }
}