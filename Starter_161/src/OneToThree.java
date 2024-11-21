public class OneToThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int size = scanner.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                nums.add(scanner.nextInt());
            }

            for (int i = size - 2; i > 0; i--) {
                if (nums.get(i) == 3 && nums.get(i - 1) + nums.get(i + 1) == 4) {
                    nums.set(i, 1);
                }
            }

            for (int i = 1; i < size - 1; i++) {
                if (nums.get(i) == 3 && nums.get(i - 1) + nums.get(i + 1) == 4) {
                    nums.set(i, 1);
                }
            }
            long total = 0;
            for (int num : nums) {
                total += num;
            }
            System.out.println(total);
        }

    }
}
