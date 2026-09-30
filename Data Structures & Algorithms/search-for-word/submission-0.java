class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        
  
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = 1; 
                    if(solve(i,j,board, word, visited, m, n, 1)) return true;
                    visited[i][j] = 0; 
                }
            }
        }
        return false;
    }
    boolean solve(int i, int j, char[][] board, String word, int[][] visited, int m,
        int n, int idx) {
        if (idx == word.length()) {
            return true;
        }
        // dowm
        if (i + 1 < m && visited[i + 1][j] == 0) {
            if (board[i + 1][j] == word.charAt(idx)) {
                visited[i + 1][j] = 1;
                if (solve(i + 1, j, board, word, visited, m, n, idx + 1)) {
                    return true;
                }
                visited[i + 1][j] = 0;
            }
        }

        // 2. UP
        if (i - 1 >= 0 && visited[i - 1][j] == 0) {
            if (board[i - 1][j] == word.charAt(idx)) {
                visited[i - 1][j] = 1;
                if (solve(i - 1, j, board, word, visited, m, n, idx + 1)) {
                    return true;
                }
                visited[i - 1][j] = 0;
            }
        }

        // 3. LEFT
        if (j - 1 >= 0 && visited[i][j - 1] == 0) {
            if (board[i][j - 1] == word.charAt(idx)) {
                visited[i][j - 1] = 1;
                if (solve(i, j - 1, board,word, visited, m, n, idx + 1)) {
                    return true;
                }
                visited[i][j - 1] = 0;
            }
        }

        // 4. RIGHT
        if (j + 1 < n && visited[i][j + 1] == 0) {
            if (board[i][j + 1] == word.charAt(idx)) {
                visited[i][j + 1] = 1;
                if (solve(i, j + 1, board, word, visited, m, n, idx + 1)) {
                    return true;
                }
                visited[i][j + 1] = 0;
            }
        }

        return false;
    }
}
