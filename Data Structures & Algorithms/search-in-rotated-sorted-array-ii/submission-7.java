class Solution {
    public boolean search(int[] nums, int target) {
        int start =0 ;
        int end =nums.length-1;
        int mid = -1 ;
        while(start<=end){
            mid = start +(end-start)/2;
            if(nums[mid] == target){
                return true ;
            }
            // if we have duplicates available, So we cannot determine which side is sorted.
            if(nums[start]==nums[mid] && nums[end]==nums[mid]){
                start++;
                end--;
            }
            // sorted side of array
            else if(nums[start]<=nums[mid]){
                if(nums[start]<=target && nums[mid]>target){
                    end = mid-1;
                }
                else{
                    start =mid+1; 
                }
            }
            // unsorted side of array
            else{
                if(nums[mid]<target && nums[end]>=target){
                    start =mid+1; 
                }
                else{
                    end = mid-1;
                }
            }
        }
        return false ; 
    }
}