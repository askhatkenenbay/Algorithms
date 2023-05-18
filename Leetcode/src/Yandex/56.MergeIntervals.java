class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start >= prevStart && start <= prevEnd){
                prevEnd = Math.max(prevEnd, end);
            }else{
                list.add(new int[]{prevStart, prevEnd});
                prevStart = start;
                prevEnd = end;
            }
        }
        list.add(new int[]{prevStart, prevEnd});
        return list.toArray(new int[0][]);
    }
}