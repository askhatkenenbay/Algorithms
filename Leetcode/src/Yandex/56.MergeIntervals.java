class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
        List<int[]> list = new ArrayList<>();
        for(int[] p : intervals){
            if(list.isEmpty() || list.get(list.size() - 1)[1] < p[0]){
                list.add(p);
            }else{
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1],p[1]);
            }
        }
        return list.toArray(new int[0][]);
    }
}


class SolutionSort {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            list.add(i);
        }
        list.sort((a,b) -> Math.abs(a - x) - Math.abs(b - x));
        list = list.subList(0,k);
        list.sort((a,b)->a-b);
        return list;
    }
}


class SolutionBinaryLeft {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = left; i < left + k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}