import java.util.*;

public class recursion {

    public static void main(String[] args) {
        sumOfNNaturalNumbersUsingRecursion(9);
        factorialUsingRecursion(8);
        NthFibbonacciUsingRecursion(10);
        returnSumOfDigitsUsingRecursion(123);
        isPalindromeUsingRecursion("racecar");

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

    public static int returnSumOfDigitsUsingRecursion(int num) {
        if (num == 0) {
            return 0;
        } else {
            int lastDigit = num % 10;
            int remainingNumber = num / 10;
            return lastDigit + returnSumOfDigitsUsingRecursion(remainingNumber);
        }
    }

    public static boolean isPalindromeUsingRecursion(String s) {
        return checkPalindrome(s, 0, s.length() - 1);
    }

    public static boolean checkPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return checkPalindrome(s, start + 1, end - 1);
    }

    public static void TowerOfHanoi(int N, char src, char aux, char dest) {

        if (N == 0) {
            return;
        }

        TowerOfHanoi(N, src, dest, aux);
        System.out.println(src + "to" + dest);
        TowerOfHanoi(N, aux, src, dest);
    }

    // 0, 0, 2
    // 1, 0, 1
    // 0, 2, 1
    // 2, 0, 2
    // 0, 1, 0
    // 1, 1, 2
    // 0, 0, 2

    public int[] grayCode(int A) {
        List<Integer> result = new ArrayList<>();
        grayCodeSolve(A, result);
        int[] pattern = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            pattern[i] = result.get(i);
        }
        return pattern;
    }

    private void grayCodeSolve(int n, List<Integer> result) {
        if (n == 0) {
            result.add(0);
            return;
        }
        grayCodeSolve(n - 1, result);
        int ans = (int) Math.pow(2, n - 1);
        for (int i = result.size() - 1; i >= 0; i--) {
            result.add(result.get(i) + ans);

        }
    }

    














}