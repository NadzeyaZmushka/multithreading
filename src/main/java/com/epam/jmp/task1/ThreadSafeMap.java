package com.epam.jmp.task1;

import java.util.HashMap;
import java.util.Map;

class ThreadSafeMap<K, V> extends HashMap<K, V> {
    private Map<K, V> map;
    public ThreadSafeMap() {
        map = new HashMap<>();
    }
    public synchronized V get(Object key) {
        return map.get(key);
    }
    public synchronized V put(K key, V value) {
        return map.put(key, value);
    }
}
