class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // 2d empty board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();

        // as we have to check in 3 direction only to place queen safely
        // left side
        int[] leftSide = new int[n];

        // lower diagonal
        int[] lowerDiagonal = new int[2 * n - 1];

        // upper diagonal
        int[] upperDiagnoal = new int[2 * n - 1];

        solve(0, board, ans, leftSide, lowerDiagonal, upperDiagnoal, n);
        return ans;
    }
    void solve(int col, char[][] board, List<List<String>> ans, int[] leftSide, int[] lowerDiagonal,
        int[] upperDiagnoal, int n) {
            // base cond
            if(col == n){
                ans.add(construct(board));
                return;
            }
        for (int row = 0; row < n; row++) {
            // checking whether pos is valid or not
            if (leftSide[row] == 0 && lowerDiagonal[row + col] == 0
                && upperDiagnoal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                // marking these pos for future queens , so they have no fear of attack
                // or we can say these are ranges of attack
                leftSide[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagnoal[n - 1 + col - row] = 1;

                solve(col + 1, board, ans, leftSide, lowerDiagonal, upperDiagnoal, n);

                board[row][col] = '.';
                leftSide[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagnoal[n - 1 + col - row] = 0;
            }
        }
    }
    List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length; i++){
            res.add(new String(board[i]));
        }
        return res;
    }
}
