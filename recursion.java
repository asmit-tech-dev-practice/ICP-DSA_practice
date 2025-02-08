import java.util.*;

public class recursion {

    public static void main(String[] args) {
        // sumOfNNaturalNumbersUsingRecursion(9);
        // factorialUsingRecursion(8);
        // NthFibbonacciUsingRecursion(10);
        // returnSumOfDigitsUsingRecursion(123);
        // isPalindromeUsingRecursion("racecar");

        TowerOfHanoi(5, 'A', 'B', 'C');
        int[] rods = { 5, 0, 0 };
        solveHanoi(5, 'A', 'C', 'B', rods);

        int n = 3;
        ArrayList<Integer> rodA = new ArrayList<>();
        ArrayList<Integer> rodB = new ArrayList<>();
        ArrayList<Integer> rodC = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            rodA.add(i);
        }

        solveHanoi2(n, 'A', 'C', 'B', rodA, rodB, rodC);

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

        if (N == 1) {
            return;
        }

        TowerOfHanoi(N - 1, src, dest, aux);
        System.out.println(src + "to" + dest);
        TowerOfHanoi(N - 1, aux, src, dest);
    }

    // 0, 0, 2
    // 1, 0, 1
    // 0, 2, 1
    // 2, 0, 2
    // 0, 1, 0
    // 1, 1, 2
    // 0, 0, 2

    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod, int[] rods) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);

            if (fromRod == 'A') {
                rods[0]--;
            } else if (fromRod == 'B') {
                rods[1]--;
            } else if (fromRod == 'C') {
                rods[2]--;
            }

            if (toRod == 'A') {
                rods[0]++;
            } else if (toRod == 'B') {
                rods[1]++;
            } else if (toRod == 'C') {
                rods[2]++;
            }

            printRodSizes(rods);
            return;
        }

        solveHanoi(n - 1, fromRod, auxRod, toRod, rods);

        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);

        if (fromRod == 'A') {
            rods[0]--;
        } else if (fromRod == 'B') {
            rods[1]--;
        } else if (fromRod == 'C') {
            rods[2]--;
        }

        if (toRod == 'A') {
            rods[0]++;
        } else if (toRod == 'B') {
            rods[1]++;
        } else if (toRod == 'C') {
            rods[2]++;
        }

        printRodSizes(rods);

        solveHanoi(n - 1, auxRod, toRod, fromRod, rods);
    }

    public static void printRodSizes(int[] rods) {
        System.out.println("Rod Sizes: A=" + rods[0] + ", B=" + rods[1] + ", C=" + rods[2]);
    }




    public static void solveHanoi2(int n, char fromRod, char toRod, char auxRod, ArrayList<Integer> rodA, ArrayList<Integer> rodB, ArrayList<Integer> rodC) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);
            moveBlock(fromRod, toRod, rodA, rodB, rodC);
            printRodState(rodA, rodB, rodC);
            return;
        }
        solveHanoi2(n - 1, fromRod, auxRod, toRod, rodA, rodB, rodC);

        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);
        moveBlock(fromRod, toRod, rodA, rodB, rodC);
        printRodState(rodA, rodB, rodC);
        solveHanoi2(n - 1, auxRod, toRod, fromRod, rodA, rodB, rodC);
    }

    public static void moveBlock(char fromRod, char toRod, ArrayList<Integer> rodA, ArrayList<Integer> rodB, ArrayList<Integer> rodC) {
        if (fromRod == 'A' && toRod == 'B') {
            rodB.add(rodA.remove(rodA.size() - 1));
        } else if (fromRod == 'A' && toRod == 'C') {
            rodC.add(rodA.remove(rodA.size() - 1));
        } else if (fromRod == 'B' && toRod == 'A') {
            rodA.add(rodB.remove(rodB.size() - 1));
        } else if (fromRod == 'B' && toRod == 'C') {
            rodC.add(rodB.remove(rodB.size() - 1));
        } else if (fromRod == 'C' && toRod == 'A') {
            rodA.add(rodC.remove(rodC.size() - 1));
        } else if (fromRod == 'C' && toRod == 'B') {
            rodB.add(rodC.remove(rodC.size() - 1));
        }
    }

    public static void printRodState(ArrayList<Integer> rodA, ArrayList<Integer> rodB, ArrayList<Integer> rodC) {
        System.out.println("Rod A: " + rodA);
        System.out.println("Rod B: " + rodB);
        System.out.println("Rod C: " + rodC);
    }

}