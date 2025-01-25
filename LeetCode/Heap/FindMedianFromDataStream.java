import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStream() {
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        this.maxHeap.add(num); this.minHeap.add(this.maxHeap.remove());
        if (this.minHeap.size() > this.maxHeap.size()) this.maxHeap.add(this.minHeap.remove());
    }

    public double findMedian() {
        if (this.maxHeap.size() > this.minHeap.size()) return this.maxHeap.element();
        else return this.maxHeap.element() / 2.0 + this.minHeap.element() / 2.0;
    }
}

/* [OPT]: Track parity
 * public class FindMedianFromDataStream {
 *     private boolean isOdd;
 *
 *     private final PriorityQueue<Integer> maxHeap;
 *     private final PriorityQueue<Integer> minHeap;
 *
 *     public FindMedianFromDataStream() {
 *         this.isOdd = false;
 *         this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
 *         this.minHeap = new PriorityQueue<>();
 *     }
 *
 *     public void addNum(int num) {
 *         isOdd = !isOdd;
 *         if (this.isOdd) {
 *             this.minHeap.add(num); this.maxHeap.add(this.minHeap.remove());
 *         } else {
 *             this.maxHeap.add(num); this.minHeap.add(this.maxHeap.remove());
 *         }
 *     }
 *
 *     public double findMedian() {
 *         if (this.isOdd) return this.maxHeap.element();
 *         else return this.maxHeap.element() / 2.0 + this.minHeap.element() / 2.0;
 *     }
 * } */