import java.util.Arrays;
import java.util.HashMap;

public class RankTransformOfAnArray {
    /*
    Given an array of integers arr, replace each element with its rank.

    The rank represents how large the element is. The rank has the following rules:

    Rank is an integer starting from 1.
    The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
    Rank should be as small as possible.

     */
    //nlogn
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int rank = 1;
        for (int aTemp : temp) {
            if (!hashMap.containsKey(aTemp)) {
                hashMap.put(aTemp, rank);
                rank++;
            }
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = hashMap.get(arr[i]);
        }
        return res;
    }


    //n
    public int[] arrayRankTransformBest(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        int[] count = new int[max - min + 1];
        for (int num : arr) {
            count[num - min] = 1;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = count[arr[i] - min];
        }
        return res;
    }
}
