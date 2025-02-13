import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        List<int[]> _intervals = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(a -> a[0]))
                .toList();
        LinkedList<int[]> res = new LinkedList<>();
        res.add(_intervals.get(0));
        for (int i = 1; i < _intervals.size(); i++) {
            if (_intervals.get(i)[0] > res.getLast()[1])
                res.add(_intervals.get(i));
            else
                res.getLast()[1] = Math.max(res.getLast()[1], _intervals.get(i)[1]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
