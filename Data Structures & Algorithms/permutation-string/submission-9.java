class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        for(Character ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int left = 0 ;
        int right = 0;
        int count = 0 ;
        
        while(right<s2.length()){
            if(map.containsKey(s2.charAt(right))){
                if(map.get(s2.charAt(right))>0){
                count++;
            }
                map.put(s2.charAt(right), map.getOrDefault(s2.charAt(right),0)-1);}
                right++;
            if(count ==  s1.length()){
                return true ;
            }
            if(right - left == s1.length()){
                if(map.containsKey(s2.charAt(left))){
                if(map.get(s2.charAt(left))>=0){
                count--;
                }
                map.put(s2.charAt(left), map.getOrDefault(s2.charAt(left),0)+1);
            }
                left++;
            }
        }
        return false ;
    }
}
