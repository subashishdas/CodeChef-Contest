# Question 1

**URL**: [https://www.codechef.com/problems/NUGGET](#)

---

## Approach

This program calculates the total money earned based on the quantities of two items, where:
- Each unit of the first item contributes 5000 to the total.
- Each unit of the second item contributes 9800 to the total.

### Steps:
1. Take two integers as input, representing the quantities of the two items (`x` and `y`).
2. Calculate the total money using the formula:  
   **Total Money = (5000 * x) + (9800 * y)**
3. Print the total money.

---

## Code

```java
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
```
# Question 2

**URL**: [https://www.codechef.com/problems/DONUTSELL](#)

---

## Approach

This program simulates a donut-selling system where customers request specific types of donuts, and the shop tries to fulfill their requests. The goal is to count how many customers leave unsatisfied (sad).  

### Steps:
1. Take the number of test cases `T` as input.
2. For each test case:
   - Read `N` (number of available donut types) and `M` (number of customer requests).
   - Read the array `A` of size `N`, where `A[i]` represents the count of donuts available for type `i`.
   - Read the array `B` of size `M`, where each element represents the type of donut a customer requests.
3. For each customer request in `B`:
   - If the requested type of donut is available (`A[B[i]] > 0`), reduce its count in `A` by 1.
   - Otherwise, increment the sad customer counter.
4. Output the total number of sad customers for each test case.

---

## Code

```java
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
```
# Question 3

**URL**: [https://www.codechef.com/problems/TMPTMP](#)

---

## Approach

This program calculates the minimum possible "unsavoriness" in a sequence of steps by allowing up to a certain number of changes (`K`). The unsavoriness is defined as the maximum deviation from the desired temperature range for each step.

### Steps:
1. **Input Details:**
    - Read the number of test cases `T`.
    - For each test case, read `N` (number of steps), `K` (maximum allowed changes), and the array `A` (temperatures at each step).
2. **Binary Search on Unsavoriness:**
    - Calculate the possible range of unsavoriness from `0` to `max(A) - min(A)`.
    - Use binary search to find the minimum possible unsavoriness.
3. **Feasibility Check:**
    - For a given unsavoriness (`U`), verify if it's feasible to adjust the sequence using at most `K` changes.
    - Iterate through the steps and adjust the allowed range of temperatures. If a step falls outside the range, make a change and count it.
    - If the total changes exceed `K`, the unsavoriness is infeasible.
4. **Output:**
    - For each test case, output the minimum feasible unsavoriness.

---

## Code

```java
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
```
# Question 4

**URL**: [https://www.codechef.com/problems/TWOCARD](#)

---

## Approach

This program processes multiple test cases to determine if it's possible to form a valid arrangement with two arrays of numbers (`a` and `b`) for a specific problem statement.

### Steps:
1. **Input Details:**
    - Read the number of test cases `t`.
    - For each test case, read:
        - An integer `n` (size of the arrays).
        - Array `a` and array `b`, both of size `n`.
2. **Find Maximum Values:**
    - Traverse both arrays to find the maximum value across both arrays and its index.
    - Simultaneously, identify the two largest elements from `a` and their indices.
3. **Reassign Values Considering Both Arrays:**
    - Replace the largest and second-largest values from `a` with the corresponding maximum values from both arrays (`a` and `b`).
4. **Determine Output:**
    - Compare the largest and second-largest values and decide the output:
        - If both are equal and match the maximum value found, print "No".
        - Otherwise, print "Yes".

---

## Code

```java
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
```
# Question 5

**URL**: [https://www.codechef.com/problems/ONETOTHREE](#)

---

## Approach

The problem involves modifying an array based on specific conditions and calculating the sum of its elements. The modification rules are applied iteratively to ensure the array reaches a stable state.

### Steps:
1. **Input Details:**
    - Read the number of test cases.
    - For each test case, read the size of the array and the array elements.
2. **Array Modification Rules:**
    - Traverse the array from the second last element to the second element:
        - If the current element is `3` and the sum of its immediate neighbors equals `4`, set the current element to `1`.
    - Repeat the traversal from the second element to the second last element for consistency.
3. **Calculate the Total:**
    - Sum all elements in the modified array.
4. **Output:**
    - Print the total sum for each test case.

---

## Code

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main (String[] args) throws java.lang.Exception {
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
```
# Question 6

**URL**: [https://www.codechef.com/problems/RBGM](#)

---

## Approach

The task is to determine the maximum value for a sequence based on the array's state (sorted or unsorted) and specific conditions about the elements' positions.

### Steps:
1. **Input Details:**
    - Read the number of test cases `T`.
    - For each test case:
        - Read the size of the array `N`.
        - Read the elements of the array `P`.
2. **Check if Already Sorted:**
    - Traverse the array to check if all elements are in their correct positions (`P[i] == i + 1` for all `i`).
    - If already sorted, print `N` and proceed to the next test case.
3. **Check for Correctly Positioned Elements:**
    - If the array is not sorted, traverse it again to check if any element is in its correct position (`P[i] == i + 1` for at least one `i`).
    - If found, print `N - 1`.
    - Otherwise, print `N - 2`.
4. **Output the Result:**
    - For each test case, print the result based on the checks above.

---

## Code

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static void main (String[] args) throws java.lang.Exception {
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
```
