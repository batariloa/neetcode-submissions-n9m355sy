class Solution {
    public boolean isValidSudoku(char[][] board) {

        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') continue;

                int num = board[r][c] - '0';
                int mask = 1 << num;

                int boxIndex = (r / 3) * 3 + (c / 3);

                if ((rows[r] & mask) != 0) return false;
                if (((cols[c] & mask) != 0)) return false;
                if ((((boxes[boxIndex] & mask) != 0))) return false;

                rows[r] = rows[r] | mask;
                cols[c] |= mask;
                boxes[boxIndex] |= mask;

            }

        }
        return true;
    }
}
