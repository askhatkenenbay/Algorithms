class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
}

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            dfs(i, n, list);
        }
        return list;
    }

    public void dfs(int curr, int n, List<Integer> list){
        if(curr > n){
            return;
        }
        list.add(curr);
        for(int i = 0; i < 10; i++){
            if(curr * 10 + i > n){
                return;
            }
            dfs(curr * 10 + i, n, list);
        }
    }
}