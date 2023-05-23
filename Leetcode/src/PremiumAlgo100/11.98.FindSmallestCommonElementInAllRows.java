class Solution {
    public int smallestCommonElement(int[][] mat) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int j = 0; j < mat[0].length; j++){
            for(int i = 0; i < mat.length; i++){
                map.put(mat[i][j], map.getOrDefault(mat[i][j],0)+1);
                if(map.get(mat[i][j]) == mat.length){
                    return mat[i][j];
                }
            }
        }
        return -1;
    }
}


class SolutionBinary {
    public int smallestCommonElement(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for (int j = 0; j < m; ++j) {
            boolean found = true;
            for (int i = 1; i < n && found; ++i) {
                found = Arrays.binarySearch(mat[i], mat[0][j]) >= 0;
            }
            if (found) {
                return mat[0][j];
            }
        }
        return -1;
    }   
}