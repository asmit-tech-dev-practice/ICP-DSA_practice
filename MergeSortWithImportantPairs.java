import java.util.*;

public class MergeSortWithImportantPairs {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] num = new int[10];

        for (int i = 0; i < num.length; i++) {
            num[i] = rand.nextInt(100000);
        }

        System.out.println("Before:");
        printArray(num);

        int importantPairs = solve(num);

        System.out.println("\nAfter:");
        printArray(num);
        System.out.println("\nImportant Pairs Count: " + importantPairs);
    }

    public static void mergeSort(int[] inputArr) {
        int inputLength = inputArr.length;
        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;

        int[] leftHalf = Arrays.copyOfRange(inputArr, 0, midIndex);
        int[] rightHalf = Arrays.copyOfRange(inputArr, midIndex, inputLength);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArr, leftHalf, rightHalf);
    }

    public static void merge(int[] inputArr, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length, rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArr[k++] = leftHalf[i++];
            } else {
                inputArr[k++] = rightHalf[j++];
            }
        }

        while (i < leftSize) {
            inputArr[k++] = leftHalf[i++];
        }
        while (j < rightSize) {
            inputArr[k++] = rightHalf[j++];
        }
    }

    public static int solve(int[] A) {
        return mergeSortAndCount(A, 0, A.length - 1);
    }

    private static int mergeSortAndCount(int[] A, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = mergeSortAndCount(A, left, mid) + mergeSortAndCount(A, mid + 1, right);

        count += countImportantPairs(A, left, mid, right);

        mergeForCounting(A, left, mid, right);

        return count;
    }

    private static int countImportantPairs(int[] A, int left, int mid, int right) {
        int count = 0, j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) A[i] > 2L * A[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        return count;
    }

    private static void mergeForCounting(int[] A, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }

        while (i <= mid) temp[k++] = A[i++];
        while (j <= right) temp[k++] = A[j++];

        System.arraycopy(temp, 0, A, left, temp.length);
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
