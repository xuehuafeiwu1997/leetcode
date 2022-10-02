package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xmy
 * @date 2022/6/25 9:14 上午
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCache(int capacity) {
        //调用父类中的构造方法创建一个linkedHashMap，设置其容量为capacity， loadFactor为0.75,并开启accessOrder为true
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        //若key存在，返回对应value的值；若key不存在，返回-1
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        //若返回的结果为true，则执行removeEntryForKey方法删除eldEst entry
        return size() > capacity;
    }
}
