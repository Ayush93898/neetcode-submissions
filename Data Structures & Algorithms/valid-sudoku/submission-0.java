class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check all rows
        for (int r = 0; r < 9; r++) {
            HashSet<Character> st = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    if (st.contains(board[r][c]))
                        return false;
                    st.add(board[r][c]);
                }
            }
        }

        // check all columns
        for (int c = 0; c < 9; c++) {
            HashSet<Character> st = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                if (board[r][c] != '.') {
                    if (st.contains(board[r][c]))
                        return false;
                    st.add(board[r][c]);
                }
            }
        }

        // for 9 boxes
        for (int box = 0; box < 9; box++) {
            HashSet<Character> st = new HashSet<>();
            int boxStartingRow = (box / 3) * 3;
            int boxStartingCol = (box % 3) * 3;
            for (int r = boxStartingRow; r < (boxStartingRow + 3); r++) {
                for (int c = boxStartingCol; c < (boxStartingCol + 3); c++) {
                    if (board[r][c] != '.') {
                        if (st.contains(board[r][c]))
                            return false;
                        st.add(board[r][c]);
                    }
                }
            }
        }

        return true;
    }
}
