import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null) return true;
        HashMap<Integer, List<Integer>> prereqList = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            prereqList.put(i, new ArrayList<>());
        for (int[] prerequisite : prerequisites)
            prereqList.get(prerequisite[0]).add(prerequisite[1]);
        for (Integer course : prereqList.keySet())
            if (!dfs(course, prereqList, new HashSet<>())) return false;
        return true;
    }

    private static boolean dfs(int curr, HashMap<Integer, List<Integer>> prereqList, HashSet<Integer> visited) {
        if (visited.contains(curr)) return false;
        if (prereqList.get(curr).isEmpty()) return true;
        visited.add(curr);
        for (Integer prereq : prereqList.get(curr))
            if (!dfs(prereq, prereqList, visited)) return false;
        visited.remove(curr);
        // now we know we can take this course, no need recheck prereqs
        prereqList.put(curr, List.of());
        return true;
    }
}
