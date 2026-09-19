class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n==1) return;

        // transpose
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse each row
        for(int i=0; i<n; i++){
            reverse(matrix[i]);
        }
    }
    void reverse(int[] arr){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}
