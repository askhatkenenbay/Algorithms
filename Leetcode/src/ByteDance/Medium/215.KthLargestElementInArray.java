class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i : nums){
            q.add(i);
            if(q.size() > k){
                q.poll();
            }
        }
        return q.peek();
    }
}


class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : nums){
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        int[] count = new int[max - min + 1];
        for(int i : nums){
            count[i - min]++;
        }
        int[] sorted = new int[nums.length];
        int index = 0;
        for(int i = 0; i < count.length; i++){
            if(count[i] != 0){
                for(int j = 0; j < count[i]; j++){
                    sorted[index++] = i+min;
                }
            }
        }

        return sorted[sorted.length - k];
    }
}