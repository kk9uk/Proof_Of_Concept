public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;
        for (int i = 0; i < board.length; i++)
            if (board[i] == null || (i > 0 && board[i].length != board[i - 1].length))
                return false;

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (existHelper(board, word, 0, i, j)) return true;
        return false;
    }

    private static boolean existHelper(char[][] board, String word, int wordI, int i, int j) {
        if (wordI == word.length()) return true;
        if (i == -1 || i == board.length ||
                j == -1 || j == board[0].length ||
                board[i][j] != word.charAt(wordI)) return false;
        board[i][j] = '.';
        boolean res = existHelper(board, word, wordI + 1, i + 1, j) ||
                existHelper(board, word, wordI + 1, i - 1, j) ||
                existHelper(board, word, wordI + 1, i, j + 1) ||
                existHelper(board, word, wordI + 1, i, j - 1);
        board[i][j] = word.charAt(wordI);
        return res;
    }
}
