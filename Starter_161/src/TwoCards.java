import java.util.Scanner;

public class TwoCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            int maxValue = 0;
            int maxIndex = -1;

            // Find the maximum value and its index across both arrays
            for (int i = 0; i < n; i++) {
                int currentMax = Math.max(a[i], b[i]);
                if (currentMax > maxValue) {
                    maxValue = currentMax;
                    maxIndex = i;
                }
            }

            int[] largestPair = new int[] {0, -1}; // {value, index}
            int[] secondLargestPair = new int[] {0, -1};

            // Find the two largest elements in array a and their indices
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] > largestPair[0]) {
                    secondLargestPair[0] = largestPair[0];
                    secondLargestPair[1] = largestPair[1];
                    largestPair[0] = a[i];
                    largestPair[1] = i;
                } else if (a[i] > secondLargestPair[0]) {
                    secondLargestPair[0] = a[i];
                    secondLargestPair[1] = i;
                }
            }

            // Update the largest and second-largest values considering array b
            largestPair[0] = Math.max(a[largestPair[1]], b[largestPair[1]]);
            secondLargestPair[0] = Math.max(a[secondLargestPair[1]], b[secondLargestPair[1]]);

            // Determine the output based on conditions
            if (largestPair[0] == secondLargestPair[0] && maxValue == largestPair[0]) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
