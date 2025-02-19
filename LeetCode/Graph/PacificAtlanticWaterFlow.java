import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) return null;
        final int ROWS = heights.length, COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[ROWS][COLS], atlantic = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i, COLS - 1, atlantic, heights[i][COLS - 1]);
        }
        for (int j = 0; j < COLS; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);
            dfs(heights, ROWS - 1, j, atlantic, heights[ROWS - 1][j]);
        }
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(List.of(i, j));
        return res;
    }

    private static void dfs(int[][] heights, int i, int j, boolean[][] visited, int prevHeight) {
        final int ROWS = heights.length, COLS = heights[0].length;
        if (i < 0 || i >= ROWS ||
                j < 0 || j >= COLS ||
                visited[i][j] || heights[i][j] < prevHeight) return;
        visited[i][j] = true;
        dfs(heights, i + 1, j, visited, heights[i][j]);
        dfs(heights, i - 1, j, visited, heights[i][j]);
        dfs(heights, i, j + 1, visited, heights[i][j]);
        dfs(heights, i, j - 1, visited, heights[i][j]);
    }
}
