
import java.util.HashSet;

public class setImplementation {

    public static void main(String[] args) {
        SetImplementation();

        int[] arr = {2, 3, 7, 6, 11, 15};
        int target = 9;

        int[] result = TargetSum(arr, target);
        if (result.length > 0) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        }
    }

    public static void SetImplementation() {
        HashSet<Integer> set = new HashSet<>();

        System.out.println(set.add(10));
        System.out.println(set.add(20));
        System.out.println(set.add(30));
        System.out.println(set.add(10));

        int[] arr = {60, 70, 90, 100, 30, 50};

        for (int i = 0; i < 5; i++) {
            set.add(arr[i]);
        }

        System.out.println(set.contains(20)); 
        System.out.println(set.contains(40));

        System.out.println(set.size());

        System.out.println(set);
    }

    public static int[] TargetSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                return new int[]{complement, num};
            }
            set.add(num);
        }

        return new int[0];
    }

}
