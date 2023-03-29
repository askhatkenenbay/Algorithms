/*
Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

A string s is said to be one distance apart from a string t if you can:

    Insert exactly one character into s to get t.
    Delete exactly one character from s to get t.
    Replace exactly one character of s with a different character to get t.

 */


class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t))return false;
        int a = 0;
        int b = 0;
        int sSize = s.length();
        int tSize = t.length();
        if(Math.abs(sSize - tSize) > 1)return false;
        int val = sSize - tSize;
        boolean update = false;
        while(a < sSize && b < tSize){
            char x = s.charAt(a);
            char y = t.charAt(b);
            if(x == y){
                a++;
                b++;
                continue;
            }
            if(update)return false;
            update = true;
            if(val == 0){
                a++;
                b++;
            }else if(val > 0){
                a++;
            }else if(val < 0){
                b++;
            }
        }
        return true;
    }
}