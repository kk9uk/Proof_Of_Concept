import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) return null;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combinationSumHelper(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private static void combinationSumHelper(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int currI) {
        if (target == 0) { res.add(new ArrayList<>(curr)); return; }
        for (int i = currI; i < candidates.length; i++) {
            if (candidates[i] > target) return;
            curr.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], res, curr, i);
            curr.remove(curr.size() - 1);
        }
    }
}
