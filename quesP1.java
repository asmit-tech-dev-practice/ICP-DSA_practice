import java.util.*;

public class quesP1 {

    public static String getNthNumber(int n) {
        if (n <= 0)
            return "";

        Queue<String> queue = new LinkedList<>();

        queue.offer("1");
        queue.offer("2");
        queue.offer("3");

        String nthNumber = "";

        for (int i = 1; i <= n; i++) {
            nthNumber = queue.poll(); 

            queue.offer(nthNumber + "1");
            queue.offer(nthNumber + "2");
            queue.offer(nthNumber + "3");
        }

        return nthNumber; 
    }

    public static void main(String[] args) {
        int n = 10; 
        System.out.println(getNthNumber(n));
    }
}
