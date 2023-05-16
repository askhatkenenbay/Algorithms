/**
Given n points on a 2D plane, find if there is such a line parallel to the y-axis that reflects the given points symmetrically.

In other words, answer whether or not if there exists a line that after reflecting all points over the given line, the original points' set is the same as the reflected ones.

Note that there can be repeated points.
 */
class Solution {
    public boolean isReflected(int[][] points) {
        int maxLeft = Integer.MAX_VALUE;
        int maxRight = Integer.MIN_VALUE;
        for(int[] arr : points){
            int x = arr[0];
            maxLeft = Math.min(maxLeft, x);
            maxRight = Math.max(maxRight, x);
        }
        int length = maxLeft + maxRight;
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        for(int[] arr : points){
            set.add(new Pair(arr[0],arr[1]));
        }
        for(int[] arr : points){
            int x = arr[0];
            int y = arr[1];
            if(!set.contains(new Pair(length - x, y))){
                return false;
            }
        }
        return true;
    }
}