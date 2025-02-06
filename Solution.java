public class Solution {
    public static int[] mergedArr(int[] firstArr, int[] secondArr) {
        int i = 0; 
        int j = 0; 
        int k = 0; 
        
        int[] merged = new int[firstArr.length + secondArr.length];

        while (i < firstArr.length && j < secondArr.length) {
            if (firstArr[i] < secondArr[j]) {
                merged[k] = firstArr[i]; 
                i++;
            } else {
                merged[k] = secondArr[j]; 
                j++;
            }
            k++; 
        }
        
        while (i < firstArr.length) {
            merged[k] = firstArr[i]; 
            i++;
            k++;
        }

        while (j < secondArr.length) {
            merged[k] = secondArr[j]; 
            j++;
            k++;
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        int[] result = mergedArr(arr1, arr2);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}