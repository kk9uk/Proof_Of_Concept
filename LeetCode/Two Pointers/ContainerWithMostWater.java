public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int curr = Math.min(height[l], height[r]) * (r - l);
            if (curr > res) res = curr;

            if (height[l] > height[r]) r--; else l++;
        }
        return res;
    }
}