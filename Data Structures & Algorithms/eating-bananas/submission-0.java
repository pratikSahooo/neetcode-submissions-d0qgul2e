class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int end = Integer.MIN_VALUE;
        int start = 1;
        int len = piles.length;
         for(int i: piles){
            end = Math.max(end,i);
         }
          int res =-1 ;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(canBeEaten(piles,mid,h)){
                res = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return res;
    }

        boolean canBeEaten(int[]pil,int eatingspeed, int h){
            int sumofhours = 0 ;
            for(int i = 0;i<pil.length;i++){
                sumofhours += (pil[i]/eatingspeed) ;
                if(pil[i]%eatingspeed !=0){
                    sumofhours +=1;
                }
                if(sumofhours > h){
                    return false;
                }
            }
            return true;
        }
}
