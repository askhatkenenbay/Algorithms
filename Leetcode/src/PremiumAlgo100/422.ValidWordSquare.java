class Solution {
    public int findLonelyPixel(char[][] picture) {
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];
        for(int i = 0; i < picture.length; i++){
            int count = 0;
            for(int j = 0; j < picture[0].length; j++){
                if(picture[i][j] == 'B')count++;
            }
            row[i] = count;
        }

        for(int j = 0; j < picture[0].length; j++){
            int count = 0;
            for(int i = 0; i < picture.length; i++){
                if(picture[i][j] == 'B')count++;
            }
            col[j] = count;
        }
        int res = 0;
        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[0].length; j++){
                if(picture[i][j] == 'B'){
                    if(row[i] == 1 && col[j] == 1){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}

class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int wordNum = 0; wordNum < words.size(); ++wordNum) {
            for (int charPos = 0; charPos < words.get(wordNum).length(); ++charPos) {
                // charPos (curr 'row' word) is bigger than column word, or
                // wordNum (curr 'column' word) is bigger than row word, or 
                // characters at index (wordNum,charPos) and (charPos,wordNum) are not equal.
                if (charPos >= words.size() || 
                    wordNum >= words.get(charPos).length() || 
                    words.get(wordNum).charAt(charPos) != words.get(charPos).charAt(wordNum)){
                    return false;
                }
            }
        }
        return true;
    }
}