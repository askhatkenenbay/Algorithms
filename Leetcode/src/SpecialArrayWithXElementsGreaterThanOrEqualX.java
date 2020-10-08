import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    //time complexity O(N^2), space complexity O(1)
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    if ((nums.length - j) == i) {
                        return i;
                    }
                    break;
                }
            }
        }
        return -1;
    }

    //time complexity O(N), space complexity O(N)
    public int specialArrayBest(int[] nums) {
        int x = nums.length;
        int[] counts = new int[x + 1];
        for (int elem : nums)
            if (elem >= x) {
                counts[x]++;
            } else {
                counts[elem]++;
            }
        int res = 0;
        for (int i = counts.length - 1; i > 0; i--) {
            res += counts[i];
            if (res == i) {
                return i;
            }
        }
        return -1;
    }
}
