class Solution {
    public int maxArea(int[] heights) {
        int left = 0 ;
        int right = heights.length-1;
        int maxarea = 0;
        while(left<right){
            int h = Math.min(heights[right],heights[left]);
            int w = right-left;
            int a = h*w;
            maxarea =Math.max(maxarea,a);
            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxarea ;
    }
}
