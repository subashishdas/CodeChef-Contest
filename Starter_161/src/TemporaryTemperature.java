
import java.util.Scanner;

public class TemporaryTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            int N = scanner.nextInt(); // Number of steps
            int K = scanner.nextInt(); // Maximum allowed changes
            int[] A = new int[N];
            int minA = Integer.MAX_VALUE, maxA = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
                minA = Math.min(minA, A[i]);
                maxA = Math.max(maxA, A[i]);
            }

            // Binary search for the minimum possible unsavoriness
            int left = 0, right = maxA - minA;
            int answer = right;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (isFeasible(A, N, K, mid)) {
                    answer = mid;
                    right = mid - 1; // Try for smaller unsavoriness
                } else {
                    left = mid + 1; // Increase unsavoriness
                }
            }

            result.append(answer).append("\n");
        }

        System.out.print(result);
        scanner.close();
    }

    private static boolean isFeasible(int[] A, int N, int K, int U) {
        int changes = 0;
        int lower = A[0] - U, upper = A[0] + U; // Initial range for B[1]

        for (int i = 1; i < N; i++) {
            int newLower = A[i] - U, newUpper = A[i] + U;

            // If current step doesn't fit in the range, make a change
            if (newUpper < lower || newLower > upper) {
                changes++;
                lower = newLower;
                upper = newUpper;
            } else {
                // Update the overlapping range
                lower = Math.max(lower, newLower);
                upper = Math.min(upper, newUpper);
            }

            // If changes exceed K, return false
            if (changes > K) {
                return false;
            }
        }

        return true;
    }
}
