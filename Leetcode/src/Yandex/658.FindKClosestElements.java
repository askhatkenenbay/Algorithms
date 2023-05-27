class Solution {
    int k;
    int x;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        this.k = k;
        this.x = x;
        int index = Arrays.binarySearch(arr,0, arr.length, x);
        index = index >= 0 ? index : ~index;
        return getClosest(arr, index);
    }

    public List<Integer> getClosest(int[] arr, int index){
        LinkedList<Integer> list = new LinkedList<>();
        int left = index - 1;
        int right = index;
        while(list.size() != k){
            if(left >= 0 && right < arr.length){
                if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                    list.addFirst(arr[left]);
                    left--;
                }else{
                    list.addLast(arr[right]);
                    right++;
                }
            }else{
                if(left < 0){
                    list.addLast(arr[right]);
                    right++;
                }else{
                    list.addFirst(arr[left]);
                    left--;
                }
            }
        }
        return list;
    }
}