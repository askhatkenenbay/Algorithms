class Solution {
    public int maxDistToClosest(int[] seats) {
        int length = seats.length;
        int left[] = new int[length];
        int right[] = new int[length];
        int prev = -1;
        for(int i = 0; i < length; i++){
            if(seats[i] == 1){
                prev = i;
                left[i] = -1;
            }else{
                if(prev == -1){
                    left[i] = -1;
                }else{
                    left[i] = i - prev;
                }
            }
        }
        int before = -1;
        for(int i = length - 1; i >= 0; i--){
            if(seats[i] == 1){
                before = i;
                right[i] = -1;
            }else{
                if(before == -1){
                    right[i] = -1;
                }else{
                    right[i] = before - i;
                }
            }
        }
        int res = 1;
        for(int i = 0; i < length; i++){
            if(left[i] == -1 && right[i] == -1){
                continue;
            }else if(left[i] == -1){
                res = Math.max(res, right[i]);
            }else if(right[i] == -1){
                res = Math.max(res, left[i]);
            }else{
                res = Math.max(res, Math.min(left[i],right[i]));
            }
        }
        return res;
    }

    //group by zero
    public int maxDistToClosest2(int[] seats) {
        int N = seats.length;
        int K = 0; //current longest group of empty seats
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                K = 0;
            } else {
                K++;
                ans = Math.max(ans, (K + 1) / 2);
            }
        }

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1){
                ans = Math.max(ans, i);
                break;
            }
        }

        for (int i = N-1; i >= 0; --i) {
            if (seats[i] == 1){
                ans = Math.max(ans, N - 1 - i);
                break;
            }
            
        }

        return ans;
    }
}