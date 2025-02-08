import java.util.ArrayList;
import java.util.List;

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

    public int[] grayCode(int A) {
        List<Integer> result = new ArrayList<>();
        grayCodeSolve(A, result);
        int[] pattern = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            pattern[i] = result.get(i);
        }
        return pattern;
    }

    private void grayCodeSolve(int n, List<Integer> result) {
        if (n == 0) {
            result.add(0);
            return;
        }
        grayCodeSolve(n - 1, result);
        int ans = (int) Math.pow(2, n - 1);
        for (int i = result.size() - 1; i >= 0; i--) {
            result.add(result.get(i) + ans);

        }
    }
}
