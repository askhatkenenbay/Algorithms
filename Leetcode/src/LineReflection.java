/*
Given n points on a 2D plane, find if there is such a line parallel to the y-axis that reflects the given points symmetrically.

In other words, answer whether or not if there exists a line that after reflecting all points over the given line, the original points' set is the same as the reflected ones.

Note that there can be repeated points.
 */

 class Solution {
    public boolean isReflected(int[][] points) {
        Arrays.sort(points, (a,b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
        int min = points[0][0];
        int max = points[points.length - 1][0];
        int sum = max + min;
        for(int[] p : points){
            int target = sum - p[0];
            if(!binary(points, target, p[1])){
                return false;
            }
        }
        return true;
    }

    public boolean binary(int[][] points, int x, int y){
        int left = 0;
        int right = points.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(points[mid][0] == x && points[mid][1] == y)return true;
            if(points[mid][0] == x){
                if(points[mid][1] > y){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(points[mid][0] > x){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }

        }
        return false;
    }
}