class ATM {
    long denoms[] = {20,50,100,200,500};
    long count[] = new long[5];
    public ATM() {
        
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < 5; i++){
            count[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        long res[] = new long[5];
        int index = 4;
        while(amount > 0 && index >= 0){
            long took  = Math.min(amount / denoms[index], count[index]);
            res[index] = took;
            amount -= took * denoms[index];
            index--;
        }
        if(amount != 0){
            return new int[]{-1};
        }else{
            for(int i = 0; i < 5; i++){
                count[i] -= res[i];
            }
            return Arrays.stream(res).mapToInt(i -> (int) i).toArray();
        }
    }
}