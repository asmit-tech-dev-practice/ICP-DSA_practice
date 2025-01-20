public class recursion {

    public static void main(String[] args) {
        sumOfNNaturalNumbersUsingRecursion(9);
        factorialUsingRecursion(8);
        NthFibbonacciUsingRecursion(10);
        returnSumOfDigitsUsingRecursion(123);

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
        } 
        else {
            int lastDigit = num % 10;
            int remainingNumber = num / 10;
            return lastDigit + returnSumOfDigitsUsingRecursion(remainingNumber);
        }
    }

    
    

}
