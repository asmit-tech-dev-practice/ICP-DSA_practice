import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hashmapLearn {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 5, 1, 2, 5};
        int element = 2;
        
        int frequency = HashFreq(arr, element);
        System.out.println("Frequency of " + element + " is: " + frequency);

        List<Integer> duplicates = findDuplicatePairs(arr);
        System.out.println("Duplicate pairs: " + duplicates);

        int targetSum = 6;
        System.out.println(countPairsWithSum(arr, targetSum));
    }

    public static int HashFreq(int[] arr, int element) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num : arr) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }
        
        if (freqMap.containsKey(element)) {
            return freqMap.get(element);
        } else {
            return 0;
        }
    }
    


    public static List<Integer> findDuplicatePairs(int[] arr) {
        HashMap<Integer, Integer> dupMap = new HashMap<>();
        List<Integer> dups = new ArrayList<>();
        
        for (int num : arr) {
            if (dupMap.containsKey(num)) {
                dupMap.put(num, dupMap.get(num) + 1);
            } else {
                dupMap.put(num, 1);
            }
        }
        
        for (int key : dupMap.keySet()) {
            if (dupMap.get(key) > 1) {
                dups.add(key);
            }
        }
        
        return dups;
    }


    public static int countPairsWithSum(int[] arr, int targetSum) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = targetSum - num;
            if (freqMap.containsKey(complement)) {
                count += freqMap.get(complement);
            }
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
