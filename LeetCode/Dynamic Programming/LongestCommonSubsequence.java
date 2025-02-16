public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null ||
                text1.isEmpty() || text2.isEmpty()) return 0;
        int[][] DP = new int[text1.length() + 1][text2.length() + 1];
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j))
                    DP[i][j] = 1 + DP[i + 1][j + 1];
                else
                    DP[i][j] = Math.max(DP[i + 1][j], DP[i][j + 1]);
            }
        }
        return DP[0][0];
    }

    /* [OPT]: O(min(text1.length(), text2.length())) space
     * public int longestCommonSubsequence(String text1, String text2) {
     *     if (text1 == null || text2 == null ||
     *             text1.isEmpty() || text2.isEmpty()) return 0;

     *     if (text2.length() > text1.length()) swap(text1, text2);
     *     int[] prev = new int[text2.length() + 1], curr = null;
     *     for (int i = text1.length() - 1; i >= 0; i--) {
     *         curr = new int[text2.length() + 1];
     *         for (int j = text2.length() - 1; j >= 0; j--) {
     *             if (text1.charAt(i) == text2.charAt(j))
     *                 curr[j] = 1 + prev[j + 1];
     *             else
     *                 curr[j] = Math.max(curr[j + 1], prev[j]);
     *         }
     *         prev = curr;
     *     }
     *     return curr[0];
     * }

     * private static <T> void swap(T a, T b) {
     *     T tmp = a;
     *     a = b;
     *     b = tmp;
     * } */
}