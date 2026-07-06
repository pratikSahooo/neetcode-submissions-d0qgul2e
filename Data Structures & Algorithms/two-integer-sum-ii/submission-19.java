class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i =0 ;
        int j=i+1;
        while(i<numbers.length-1){
            if(numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }
            if(j<numbers.length-1 && numbers[i]+numbers[j]!=target){
                j++ ;
            }
            else{
                i++ ;
                j =i+1 ;
            }
        }return new int[]{0,0};
    }
}
