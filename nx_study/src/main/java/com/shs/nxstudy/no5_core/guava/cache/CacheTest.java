package com.shs.nxstudy.no5_core.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author 奈学-肖秋平老师 Eric
 **/
public class CacheTest {
    public static void main(String[] args) {
        cacheTest();
    }
    public static void cacheTest() {
        //缓存
        Cache<Integer, String> cache = CacheBuilder.newBuilder().maximumSize(2).build();
        cache.put(1, "first");
        cache.put(2, "second");
        cache.put(3, "third"); //1. give up the 3 element  , 2.根据key值得到的index， replace

        String cacheValue = cache.getIfPresent(1);
        System.out.println(cacheValue);
        System.out.println(cache.asMap());
    }
}
