import java.util.Scanner;

public class MoneyMaking {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        int totalMoney = (5000 * x) + (9800 * y);
        System.out.println(totalMoney);
    }
}
