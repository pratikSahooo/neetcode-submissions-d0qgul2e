class NumMatrix {
    int [][] prefix ;

    // overlapping concept so prefix concept
    public NumMatrix(int[][] matrix) {
        prefix = new int [matrix.length][matrix[0].length] ; 
        // we do it by prefix sum so we do it by adding all the number and then eleminating the override or intersection one 
        for (int i =0 ; i < matrix.length;i++){
            for (int j =0 ; j < matrix[0].length;j++){
            int top = i>0 ? prefix[i-1][j] : 0 ;
            int left = j>0 ? prefix[i][j-1] : 0 ;
            int topleft = (i>0 && j>0) ? prefix[i-1][j-1] : 0 ;
            // AuB = curent value + A + B - AnB(intersection)
            prefix[i][j] = matrix[i][j] + top + left - topleft ; 
        }
        }
    }
    
    // and then do reverse while calculating the actual range sum , take the lastrange(col2) index's prefix sum and deduct the left top and add topleft;
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top = row1>0 ? prefix[row1-1][col2] : 0 ;
        int left = col1>0 ? prefix[row2][col1-1] : 0 ;
        int topleft = (row1>0 && col1>0) ? prefix[row1-1][col1-1] : 0 ;
        //AuB(preffix calculated current value) - top - left + topleft(intersection)
        return prefix[row2][col2] - top -left + topleft ;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */