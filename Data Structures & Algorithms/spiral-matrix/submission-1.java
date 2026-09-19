class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m =  matrix.length; // row
        int n = matrix[0].length; // col
 
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = m-1;

        while(left <= right && top <= bottom){
            for(int i=left; i<=right; i++) ans.add(matrix[top][i]);
            if(top <= bottom) top++;
            
            for(int i=top; i<=bottom; i++) ans.add(matrix[i][right]);
            if(right >= left) right--;

            if(top <= bottom){
            for(int i=right; i>=left; i--) ans.add(matrix[bottom][i]);
            if(bottom >= top) bottom--;
            }

            if(left <= right){
            for(int i=bottom; i>=top; i--) ans.add(matrix[i][left]);
            if(left <= right) left++;
            }
        }
        return ans;
    }
}
