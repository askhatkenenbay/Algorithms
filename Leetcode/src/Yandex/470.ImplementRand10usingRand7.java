class Solution extends SolBase {
    public int rand10() {
        int col = 0;
        int row = 0;
        int index = 0;
        do{
            row = rand7();
            col = rand7();
            index = col + (row - 1) * 7;
        }while(index > 40);
        return 1 + (index - 1) % 10;
    }
}