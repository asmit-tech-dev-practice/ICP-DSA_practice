
public class Solution {

    public int solve(String A) {
        return palindromeOrNot(A, 0, A.length() - 1);
    }

    public static int palindromeOrNot(String A, int first, int end) {
        

        if (A.charAt(first) != A.charAt(end)) {
            return 0;
        } 
        else {
            return palindromeOrNot(A, first + 1, end - 1);
        }
    }
}
