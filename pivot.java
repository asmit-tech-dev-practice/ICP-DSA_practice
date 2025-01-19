
public class pivot {

    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 2, 3, 4, 5};
        int pivotIndex = PivotJasleen(arr);
        System.out.println(pivotIndex);
        System.out.println(arr[pivotIndex]);
    }

    public static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid - 1]) {
                return mid;
            }

            if (arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }

            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;

    }

    public static int PivotJasleen(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int pivot = -1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[start]) {
                start = mid + 1;

            } else {
                pivot = arr[mid];

                end = mid - 1;
            }

        }

        return pivot;

    }

    public int PivotJasleenScaler(final int[] A, int B) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == B) {
                return mid;
            }

            if (A[start] <= A[mid]) {
                if (A[start] <= B && B < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                if (A[mid] < B && B <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

}
