/**
 * // This is mountainArr's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface mountainArr {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target,MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length()-1;
        int posmid = -1;
        while(start<=end){
            posmid = start+(end-start)/2;
            int mid = mountainArr.get(posmid);
            if(posmid!=0 && posmid!=end && mid>mountainArr.get(posmid-1) && mid>mountainArr.get(posmid+1)){
                // return posmid;
                if(mid ==  target){
                    return posmid ;
                }
                break ; 
            }
            else if(posmid!=end && mid <= mountainArr.get(posmid+1)){
                start = posmid+1;
            }
            else{
                end = posmid-1;
            }
        }
             start = 0;
             end = posmid; 
            while(start<=end){
                posmid = start+(end-start)/2; 
                int mid = mountainArr.get(posmid);
                if(mid == target){
                    return posmid;
                }
                else if(mid<target){
                    start = posmid+1 ;
                }
                else{
                    end = posmid-1;
                }
            }
             start = posmid+1 ;
             end = mountainArr.length()-1 ;
            while(start<=end){
                posmid = start+(end-start)/2; 
                int mid = mountainArr.get(posmid);
                if(mid == target){
                    return posmid;
                }
                else if(mid>target){
                    start = posmid+1 ;
                }
                else{
                    end = posmid-1;
                }
            }
        return -1 ;
    }   
}