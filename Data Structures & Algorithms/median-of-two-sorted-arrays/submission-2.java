class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums2.length>nums1.length){
            return findMedianSortedArrays(nums2,nums1); 
        }

        int N = nums1.length+nums2.length;
        int start = 0;
        int end = N;
        while(start<=end){
            // cut1
            int mid = start+(end-start)/2;
            //cut2
            int cut2 = (N/2)-mid ;
            int l1 = (mid==0)?Integer.MIN_VALUE:nums2[mid-1];
            int r1 = (mid==nums2.length)?Integer.MAX_VALUE:nums2[mid];
            int l2 = (cut2==0)?Integer.MIN_VALUE:nums1[cut2-1];
            int r2 = (cut2==nums1.length)?Integer.MAX_VALUE:nums1[cut2];

            if(l1<=r2 && l2<=r1){
                if(N%2==0){
                    return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                else{
                    return (double) Math.min(r1,r2);
                }
            }
            else if(r1<l2){
                start = mid + 1;
            }
            else{
                end = mid - 1 ;
            }
        }
        return 0.0;
    }
}
