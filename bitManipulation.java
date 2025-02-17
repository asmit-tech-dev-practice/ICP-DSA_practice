public class bitManipulation {
    public static void main(String[] args) {

        System.out.println(oddOrEven(546));
        System.out.println(powOfTwo(9));
        System.out.println(countSetBits(89));
        swapBits(45, 2, 5);
        System.out.println(reverseBits(78));
        int[] arr = { 1, 2, 3, 2, 1 };
        System.out.println(uniqueElements(arr));

    }

    public static String oddOrEven(int n) {
        if ((n & 1) == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    public static String powOfTwo(int n) {
        if ((n & (n - 1)) == 0) {
            return "Power of 2";
        } else {
            return "Not Power of 2";
        }
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }

    public static void swapBits(int n, int i, int j) {

        int temp = (n >> i) & 1;
        n = n ^ ((1 << i) | (1 << j));
        n = n | ((temp << j) & ((1 << j) - 1));
        n = n & ~(1 << j);
        n = n | ((temp << i) & ((1 << i) - 1));
        n = n & ~(1 << i);
        n = n | ((temp << j) & ((1 << j) - 1));
        System.out.println(n);

    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>= 1;
        }
        return result;
    }

    public static int uniqueElements(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}