class Solution {
    public int maxFrequency(int[] nums, int k) {
        int left =0 ;
        // int right =0;
        int total =0 ;
        int max = 1;
        Arrays.sort(nums);
        for(int right=0;right<nums.length;right++){
            total+=nums[right];
            while(nums[right]*(right-left+1)-total>k){
                total-=nums[left];
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}