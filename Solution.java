public class Solution {
    public static boolean findPairWithDifference(int[] arr, int K) {
        int i = 0, j = 1; 
        
        while (j < arr.length) {
            int diff = arr[j] - arr[i]; 
            
            if (diff == K && i != j) {
                return true;
            }
            
            if (diff < K) {
                j++;
            } else {
                i++;
            }

            if (i == j) {
                j++;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-3, 0, 1, 3, 6, 8, 11, 14, 21, 25}; 
        int K = 5;       
        
        if (findPairWithDifference(arr, K)) {
            System.out.println("Pair with difference " + K + " exists.");
        } else {
            System.out.println("No such pair exists.");
        }
    }
}
