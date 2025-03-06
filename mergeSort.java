
import java.util.*;

public class mergeSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] num = new int[10];

        for (int i = 0; i < num.length; i++) {
            num[i] = rand.nextInt(100000);

        }

        System.out.println("Before:");
        printArray(num);

        mergeSortfunc(num);

        System.out.println("\n After:");
        printArray(num);
    }

    public static void mergeSortfunc(int[] inputArr) {
        int inputLength = inputArr.length;
        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;

        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArr[i];

        }

        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArr[i];

        }

        mergeSortfunc(leftHalf);
        mergeSortfunc(rightHalf);

        merge(inputArr, leftHalf, rightHalf);

    }

    public static void merge(int[] inputArr, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length, rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArr[k] = leftHalf[i];
                i++;
            }

            else {
                inputArr[k] = rightHalf[j];
                j++;
            }
            k++;

        }

        while (i<leftSize){
            inputArr[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j<rightSize){
            inputArr[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}



