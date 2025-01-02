import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) return Integer.MIN_VALUE;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (var num : nums) {
            heap.add(num);
            if (heap.size() > k) heap.remove();
        }
        return heap.element();
    }
}