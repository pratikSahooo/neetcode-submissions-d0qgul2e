class Solution {
    public String mergeAlternately(String word1, String word2) {
        int f = 0 ;
        int s = 0 ;
        StringBuilder newString = new StringBuilder() ;
        while(f<word1.length() || s<word2.length() ){
            if(f<word1.length()){
                newString.append(word1.charAt(f));
                f++;
            }
            if(s<word2.length()){
                newString.append(word2.charAt(s));
                s++;
            }
        }
        return newString.toString();
    }
}