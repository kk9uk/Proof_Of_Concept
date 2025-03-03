import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K, V> {
    private final LinkedHashMap<K, V> linkedHashMap;

    public LRU(int capacity) {
        this.linkedHashMap = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public V get(K key) {
        return this.linkedHashMap.get(key);
    }

    public V put(K key, V val) {
        return this.linkedHashMap.put(key, val);
    }
}

/* public class LRU<K, V> {
 *     private static class Node<K, V> {
 *         private final K key;
 *         private final V val;
 *         private Node<K, V> prev;
 *         private Node<K, V> next;
 *
 *         private Node(K key, V val) {
 *             this.key = key;
 *             this.val = val;
 *         }
 *     }
 *
 *     private final HashMap<K, Node<K, V>> hashMap;
 *     private final int capacity;
 *     private final Node<K, V> head;
 *     private final Node<K, V> tail;
 *
 *     public LRU(int capacity) {
 *         if (capacity < 1) throw new IllegalArgumentException("LRU(): capacity=" + capacity + " should be at least 1");
 *
 *         this.hashMap = new HashMap<>();
 *         this.capacity = capacity;
 *         this.head = new Node<>(null, null);
 *         this.tail = new Node<>(null, null);
 *         this.head.next = this.tail;
 *         this.tail.prev = this.head;
 *     }
 *
 *     public V get(K key) {
 *         if (!this.hashMap.containsKey(key)) return null;
 *
 *         Node<K, V> target = this.hashMap.get(key);
 *         this.removeNode(target);
 *         this.addNodeToHead(target);
 *         return target.val;
 *     }
 *
 *     public void put(K key, V val) {
 *         if (this.hashMap.containsKey(key)) {
 *             this.removeNode(this.hashMap.get(key));
 *         }
 *         Node<K, V> target = new Node<>(key, val);
 *         this.hashMap.put(key, target);
 *         this.addNodeToHead(target);
 *
 *         if (this.hashMap.size() > this.capacity) this.removeLRU();
 *     }
 *
 *     private void addNodeToHead(Node<K, V> target) {
 *         target.next = this.head.next;
 *         this.head.next.prev = target;
 *         this.head.next = target;
 *         target.prev = this.head;
 *     }
 *
 *     private void removeNode(Node<K, V> target) {
 *         target.next.prev = target.prev;
 *         target.prev.next = target.next;
 *     }
 *
 *     private void removeLRU() {
 *         final Node<K, V> LRU = this.tail.prev;
 *         if (!this.hashMap.remove(LRU.key, LRU)) throw new RuntimeException("removeLRU(): LRU.key=" + LRU.key + " & LRU=" + LRU + " mismatches");
 *         this.removeNode(LRU);
 *     }
 * } */
