
import java.util.*;

class binarySearch1 {

    public static void main(String[] args) {
        int[] arr = {3, 4, 9, 0, 2, 1};
        Arrays.sort(arr);
        int[] arr2 = {1, 2, 3, 4, 3, 2, 9, 3, 0};
        Arrays.sort(arr2);

        // System.out.println(binarySearchIterative(arr, 2));
        // System.out.println(binarySearchRecursiveAns(arr, 3));
        // System.out.println(binaryFloor(arr, -2));
        // System.out.println(binaryCeil(arr, 7));
        // System.out.println(binaryFreq(arr2, 3));
    }

    public static int binarySearchIterative(int[] sorted, int key) {
        int first = 0;
        int end = sorted.length - 1;
        while (first <= end) {
            int mid = first + (end - first) / 2;
            if (key < sorted[mid]) {
                end = mid - 1;
            } else if (key > sorted[mid]) {
                first = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecursiveAns(int[] sorted, int key) {
        return binarySearchRecursive(sorted, 0, sorted.length - 1, key);
    }

    public static int binarySearchRecursive(int[] sorted, int first, int end, int key) {

        if (end >= first) {
            int mid = first + (end - first) / 2;
            if (sorted[mid] == key) {
                return mid;
            }
            if (sorted[mid] > key) {
                return binarySearchRecursive(sorted, first, mid - 1, key);
            }
            return binarySearchRecursive(sorted, mid + 1, end, key);
        }
        return -1;
    }

    public static int binaryFloor(int[] sorted, int key) {

        int first = 0;
        int end = sorted.length - 1;
        int floor = -1;
        while (first <= end) {
            int mid = first + (end - first) / 2;
            if (key == sorted[mid]) {
                return sorted[mid];
            } else if (key > sorted[mid]) {
                floor = sorted[mid];
                first = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return floor;
    }

    public static int binaryCeil(int[] sorted, int key) {

        int first = 0;
        int end = sorted.length - 1;
        int ceil = -1;
        while (first <= end) {
            int mid = first + (end - first) / 2;
            if (key == sorted[mid]) {
                return sorted[mid];
            } else if (key > sorted[mid]) {
                first = mid + 1;
            } else {
                ceil = sorted[mid];
                end = mid - 1;
            }
        }
        return ceil;
    }

    public static int firstOccurence(int[] sorted, int key) {
        int first = 0;
        int end = sorted.length - 1;
        int firstIndex = -1;
        while (first <= end) {
            int mid = first + (end - first) / 2;

            if (key < sorted[mid]) {
                end = mid - 1;
            } else if (key > sorted[mid]) {
                first = mid + 1;
            } else {
                firstIndex = mid;
                end = mid - 1;
            }
        }
        return firstIndex;

    }

    public static int lastOccurence(int[] sorted, int key) {
        int first = 0;
        int end = sorted.length - 1;
        int lastIndex = -1;
        while (first <= end) {
            int mid = first + (end - first) / 2;

            if (key < sorted[mid]) {
                end = mid - 1;
            } else if (key > sorted[mid]) {
                first = mid + 1;
            } else {
                lastIndex = mid;
                first = mid + 1;
            }
        }
        return lastIndex;

    }

    public static int binaryFreq(int[] sorted, int key) {

        int first = firstOccurence(sorted, key);
        int last = lastOccurence(sorted, key);

        return last - first + 1;
    }

}
