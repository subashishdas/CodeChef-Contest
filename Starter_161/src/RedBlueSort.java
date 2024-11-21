import java.util.ArrayList;
import java.util.Scanner;

public class RedBlueSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int N = scanner.nextInt();
            ArrayList<Integer> P = new ArrayList<>();

            boolean alreadySorted = true;
            for (int i = 0; i < N; i++) {
                P.add(scanner.nextInt());
                if (P.get(i) != i + 1) {
                    alreadySorted = false;
                }
            }

            if (alreadySorted) {
                System.out.println(N);
                continue;
            }

            boolean hasCorrectPosition = false;
            for (int i = 0; i < N; i++) {
                if (P.get(i) == i + 1) {
                    hasCorrectPosition = true;
                    break;
                }
            }

            if (hasCorrectPosition) {
                System.out.println(N - 1);
            } else {
                System.out.println(N - 2);
            }
        }
    }
}
