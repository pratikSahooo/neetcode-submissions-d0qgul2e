class Solution {
    public int longestConsecutive(int[] nums) {
        int longest =0;
        Set<Integer> set = new HashSet<Integer>();
         for (int num:nums){
            set.add(num) ;
         }
        for(int n:set){
            int curr = n  ;
            // if contains the number once it is already counted then no need to count again for the 2nd
            // time if the previous is not present means its a new sequence start then start counting..
        if(!set.contains(curr-1)){
            int count =1 ;
            while(set.contains(curr+1)){
                count++ ;
                curr++ ;
            }
            longest = Math.max(longest,count) ;
        }

        }
        return longest ;
    }
}
