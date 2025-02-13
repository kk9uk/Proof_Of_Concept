import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        List<int[]> _intervals = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(a -> a[0]))
                .toList();
        int res = 0, prevEnd = _intervals.get(0)[1];
        for (int i = 1; i < _intervals.size(); i++) {
            if (_intervals.get(i)[0] >= prevEnd)
                prevEnd = _intervals.get(i)[1];
            else {
                prevEnd = Math.min(prevEnd, _intervals.get(i)[1]);
                res++;
            }
        }
        return res;
    }

    /* sort by end
     * public int eraseOverlapIntervals(int[][] intervals) {
     *     if (intervals.length == 0) return 0;
     *     List<int[]> _intervals = Arrays.stream(intervals)
     *             .sorted(Comparator.comparingInt(a -> a[1]))
     *             .toList();
     *     int res = 0, prevEnd = _intervals.get(0)[1];
     *     for (int i = 1; i < _intervals.size(); i++) {
     *         if (_intervals.get(i)[0] < prevEnd)
     *             res++;
     *         else
     *             prevEnd = _intervals.get(i)[1];
     *     }
     *     return res;
     * } */
}
