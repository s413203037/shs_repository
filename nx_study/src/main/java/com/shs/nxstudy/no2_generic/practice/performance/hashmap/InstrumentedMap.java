package com.shs.nxstudy.no2_generic.practice.performance.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A performance tuning inherited HashMap.
 *
 * @author 奈学-秋平老师 Eric
 **/
public class InstrumentedMap<K,V> implements Map<K,V> {

    private final Map<K,V> map = new HashMap<K,V>();

    private int addCount = 0;

    public InstrumentedMap(Map<K,V> map) {
        map = map;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V put(K key, V value) {
        addCount++;
        return map.put(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        addCount += map.size();
        map.putAll(m);
    }



    public int getAddCount(){
        return addCount;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return map.remove(key);
    }


    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    @Override
    public String toString() {
        return "InstrumentedMap{" +
                "map=" + map +
                ", addCount=" + addCount +
                '}';
    }

    public static void main(String[] args) {

        InstrumentedMap instrumentedMap = new InstrumentedMap(new HashMap(16, 0.75f));

        instrumentedMap.put("key1", "value1");
        instrumentedMap.put("key2", "value2");
        instrumentedMap.put("key3", "value3");

        instrumentedMap.putAll(instrumentedMap);

        System.out.println(instrumentedMap.toString());

        System.out.println(" getAddCount: "+ instrumentedMap.getAddCount());

    }
}
