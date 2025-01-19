
import java.util.*;

public class qNa {

    public static void main(String[] args) {

        subarrayDivisibleByK();
        subarrayDivisibleByKUsingHashMap();
        subarrayDivisibleByArrayLengthUsingHashMap();
        sumOfNNaturalNumbersUsingRecursion(9);
        factorialUsingRecursion(8);
        NthFibbonacciUsingRecursion(10);

    }

    public static void subarrayDivisibleByK() {
        int[] arr = {4, 5, 0, 9, 1, 3, 2};
        int k = 3;
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    public static void subarrayDivisibleByKUsingHashMap() {
        int[] arr = {4, 5, 0, 9, 1, 3, 2};
        int k = 3;
        int n = arr.length;

        HashMap<Integer, Integer> ans = new HashMap<>();
        ans.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            int possibleAns = prefixSum % k;

            if (ans.containsKey(possibleAns)) {

                count += ans.get(possibleAns);

                ans.put(possibleAns, ans.get(possibleAns) + 1);
            } else {
                ans.put(possibleAns, 1);
            }

        }

        System.out.println(count);
    }

    public static void subarrayDivisibleByArrayLengthUsingHashMap() {
        int[] arr = {4, 5, 0, 9, 1, 2, 3};
        int n = arr.length;
        HashMap<Integer, Integer> ans = new HashMap<>();
        ans.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            int possibleAns = prefixSum % n;
            if (ans.containsKey(possibleAns)) {
                count += ans.get(possibleAns);
                ans.put(possibleAns, ans.get(possibleAns) + 1);
            } else {
                ans.put(possibleAns, 1);
            }
        }
        System.out.println(count);

    }

    public static int sumOfNNaturalNumbersUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumOfNNaturalNumbersUsingRecursion(n - 1);
        }
    }

    public static int factorialUsingRecursion(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorialUsingRecursion(n - 1);
        }

    }

    public static int NthFibbonacciUsingRecursion(int n) {
        if (n <= 2) {
            return 1;

        } else {
            return NthFibbonacciUsingRecursion(n - 1) + NthFibbonacciUsingRecursion(n - 2);
        }
    }

}
