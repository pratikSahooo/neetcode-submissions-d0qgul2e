class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length-1;
        int c = matrix[0].length-1;
        for(int i = 0 ; i <= r ; i++){
            if(target <= matrix[i][c]){
                int answerRow = i ;
                for(int j = c ; j >=0 ; j--){
                    if (matrix[answerRow][j] == target){
                        return true;
                    }
                }  
            }
        } 
        return false ;
    }
}
