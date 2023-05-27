class SolutionSimple {
    public int trap(int[] height) {
        int res = 0;
        for(int i = 0; i < height.length; i++){
            int leftMax= 0;
            int rightMax  = 0;
            for(int j = i; j >= 0; j--){
                leftMax = Math.max(leftMax, height[j]);
            }
            for(int j = i; j < height.length; j++){
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }
}


class SolutionDP {
    public int trap(int[] height) {
        int res = 0;
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int curr = -1;
        for(int i = 0; i < length; i++){
            curr = Math.max(curr, height[i]);
            leftMax[i] = curr;
        }
        curr = -1;
        for(int i = length - 1; i >= 0 ; i--){
            curr = Math.max(curr, height[i]);
            rightMax[i] = curr;
        }

        for(int i = 0; i < length; i++){
            res += Math.min(leftMax[i],rightMax[i]) - height[i];
        }

        return res;
    }
}



class SolutionBest {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    res += leftMax - height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}