class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length)return false;

        HashSet<Pair<String,String>> set = new HashSet<>();
        for(List<String> list : similarPairs){
            set.add(new Pair(list.get(0), list.get(1)));
        }
        
        for(int i = 0; i < sentence1.length; i++){
            if(!sentence1[i].equals(sentence2[i])){
                if(!set.contains(new Pair(sentence1[i], sentence2[i])) && 
                !set.contains(new Pair(sentence2[i], sentence1[i]))){
                    return false;
                }
            }
        }
        return true;
    }
}