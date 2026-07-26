class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.')
                    continue;
                if (set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
        }
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                HashSet<Character> set = new HashSet<>();

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char value = board[row + i][col + j];

                        if (value == '.') {
                            continue;
                        }

                        if (set.contains(value)) {
                            return false;
                        }

                        set.add(value);
                    }
                }
            }
        }
        return true;
    }
}
