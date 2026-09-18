class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; // no of rows
        int n = matrix[0].length; // no of cols

        int[] helperRows = new int[m]; 
        int[] helperCols = new int[n];

        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(matrix[r][c] == 0){
                    helperRows[r]=1;
                    helperCols[c]=1;
                }
            }
        } 

        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(helperRows[r] == 1 || helperCols[c] == 1){
                    matrix[r][c] = 0;
                }
            }
        } 
    }
}
