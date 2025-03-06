import java.util.ArrayList;
import java.util.List;

public class recursionMed {

    public static void main(String[] args) {
        String str = "abc";
        printPatternOne(str, "", 0);
        printPatternTwo(str, 0, str.length() - 1);

        int n = 2, m = 2;
        findPaths(0, 0, n, m, "");

        int[] arr = {10, 20, 15, 5, 25};
        findSubsets(arr, 0, 30, new ArrayList<>());

    }

    public static void printPatternOne(String str, String output, int index) {
        if (index == str.length()) {
            System.out.println(output);
            return;

        }

        printPatternOne(str, output, index + 1);

        printPatternOne(str, output + str.charAt(index), index + 1);
    }

    public static void printPatternTwo (String str, int left, int right){
        if (left == right){
            System.out.println(str);
            return;
        }

        for (int i = left; i <= right; i++){
            str = swap(str, left, i);
            printPatternTwo(str, left + 1, right);
            str = swap(str, left, i);

        }


    }

    private static String swap (String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);

    }


    public static void findPaths (int row, int col, int n, int m, String path){
        if (row == n-1 || col == m-1){
            System.out.println(path);

            return;
        }

        if (row < n-1){
            findPaths(row + 1, col, n, m, path + "D");
        }

        if (col < m-1){
        
            findPaths(row, col + 1, n, m, path + "R");
        
        }


    }

    public static void findSubsets(int[] arr, int index, int sum, List<Integer> subset) {
        if (sum == 0) {
            System.out.println(subset);
            return;
        }
        if (index == arr.length || sum < 0) return;
        
        subset.add(arr[index]);
        findSubsets(arr, index + 1, sum - arr[index], subset);
        subset.remove(subset.size() - 1);
        findSubsets(arr, index + 1, sum, subset);
    }



}
