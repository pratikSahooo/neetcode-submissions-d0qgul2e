class Solution {
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int row = matrix.length;
    //     int col = matrix[0].length; 
    //     int r = 0; int c = col-1;
    //     while(r<row && c>=0){
    //         if(matrix[r][c]>target){
    //             c--;
    //         }
    //         else if(matrix[r][c]<target){
    //             r++;
    //         }
    //         else{
    //             return true ;
    //         }
    //     }
    //     return false ;       
    // }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = row-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[mid][0]>target){
                r = mid-1;
            }else if(matrix[mid][col-1] < target){
                l = mid+1;
            }
            else{
                break;
            }
        }

        if(!(l<=r)){
            return false ;
        }

        int calcRow = (l+r)/2;
        int ll = 0;
        int rl = col-1; 
        while(ll<=rl){
            int colMid = (rl+ll)/2;
            if(matrix[calcRow][colMid] == target){
                return true;
            }
            else if(matrix[calcRow][colMid] < target){
                ll = colMid+1; 
            }
            else if(matrix[calcRow][colMid] > target){
                rl = colMid-1; 
            }
        }
        return false; 
    }
}
