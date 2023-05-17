class Solution {
    private static HashMap<Character, Integer> hashMap = new HashMap<>();
    static{
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
    }
    public int romanToInt(String s) {
        int res = 0;
        if(s == null || s.isBlank())return res;
        for(int i =0; i< s.length(); i++){
            if(s.charAt(i) == 'I' && i+1 <s.length() && (s.charAt(i+1)=='V' || s.charAt(i+1) == 'X') ){
                res += hashMap.get(s.charAt(i+1)) - 1;
                i++;
                continue;
            }
            if(s.charAt(i) == 'X' && i+1 <s.length() && (s.charAt(i+1)=='L' || s.charAt(i+1) == 'C') ){
                res += hashMap.get(s.charAt(i+1)) - 10;
                i++;
                continue;
            }
            if(s.charAt(i) == 'C' && i+1 <s.length() && (s.charAt(i+1)=='D' || s.charAt(i+1) == 'M') ){
                res += hashMap.get(s.charAt(i+1)) - 100;
                i++;
                continue;
            }
            res += hashMap.get(s.charAt(i));
        }
        return res;
    }
}