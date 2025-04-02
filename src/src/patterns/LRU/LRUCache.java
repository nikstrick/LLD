package patterns.LRU;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K,V> {
    private final Integer capacity;
    private final Deque<K> deque;
    private final Map<K, V> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.deque = new LinkedList<>();
        this.map = new HashMap<>(capacity);
    }

    public V get(K key) {
        if(!map.containsKey(key)){
            return null;
        }
        deque.remove(key);
        deque.addFirst(key);
        return map.get(key);
    }
    public void put(K key, V value) {
        if(!map.containsKey(key)){
            if(map.size() == capacity){
                map.remove(deque.getLast());
                deque.removeLast();
            }
            map.put(key, value);
            deque.addFirst(key);
        }else{
            map.put(key, value);
            deque.remove(key);
            deque.addFirst(key);
        }
    }
}
