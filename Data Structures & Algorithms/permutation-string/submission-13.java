class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch= s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left = 0;
        int right = left;
        int uniqueCount = 0;
        while(right<s2.length()){
            char check = s2.charAt(right);
            if(map.containsKey(check)){
                if(map.get(check)>0){
                    uniqueCount++;
                }
                map.put(check,map.get(check)-1);
            }
            if(uniqueCount == s1.length()){
                return true;
            }
            while(right-left == s1.length()-1){
                char check2 = s2.charAt(left);
                    if(map.containsKey(check2)){
                        map.put(check2,map.get(check2)+1);
                        if(map.get(check2)>0){
                            uniqueCount--;
                        }  
                    }
                left++;
            }   
            right++;
        }
        return false;
    }
}
