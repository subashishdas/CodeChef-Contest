import java.util.Scanner;

public class SellingDonuts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        while (T-- > 0) {
            // Read N and M
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            // Read the array A (available donuts)
            int[] A = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                A[i] = scanner.nextInt();
            }

            // Read the array B (customer requests)
            int[] B = new int[M];
            for (int i = 0; i < M; i++) {
                B[i] = scanner.nextInt();
            }

            // Count sad customers
            int sadCustomers = 0;
            for (int i = 0; i < M; i++) {
                if (A[B[i]] > 0) {
                    A[B[i]]--; // Fulfill the request
                } else {
                    sadCustomers++; // Customer becomes sad
                }
            }

            // Output the result for this test case
            System.out.println(sadCustomers);
        }
    }
}
