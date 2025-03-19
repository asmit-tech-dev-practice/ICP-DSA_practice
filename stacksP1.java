import java.util.*;

public class stacksP1 {
    public static String removeConsecutiveDuplicatesUsingRecursion(String str) {
        if (str.length() <= 1) {
            return str;
        }

        if (str.charAt(0) == str.charAt(1)) {
            return removeConsecutiveDuplicatesUsingRecursion(str.substring(1));
        } else {
            return str.charAt(0) + removeConsecutiveDuplicatesUsingRecursion(str.substring(1));
        }
    }

    public static String removeConsecutiveDuplicatesUsingStack(String str) {
        Stack<Character> stack = new Stack<>();

        for (char i : str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == i) {
                continue;
            }
            stack.push(i);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "aabbccddeffggh";
        String resultA = removeConsecutiveDuplicatesUsingRecursion(input);
        System.out.println(resultA);
        String resultB = removeConsecutiveDuplicatesUsingStack(input);
        System.out.println(resultB);
    }
}
