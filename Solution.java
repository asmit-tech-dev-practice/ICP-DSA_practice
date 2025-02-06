public class Solution {
    public int countInversions(int[] A) {
         int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;

    }

    public int ReversePairs(int[] A) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > 2 * A[j]) { 
                    count++; 
                }
            }
        }
        return count;
    }
}
