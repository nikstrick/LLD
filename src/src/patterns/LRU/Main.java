package patterns.LRU;


public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(5);

        cache.put(1, "1");
        cache.put(2, "2");
        cache.put(3, "3");
        cache.put(4, "4");
        cache.put(5, "5");
        cache.put(6, "6");
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
    }
}
