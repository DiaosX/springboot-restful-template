package com.mydemo.resttemplate.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author yst
 * @Description 本地缓存
 * @Date 2022/7/18 22:42
 * @Version 1.0
 */
public class LocalCache<K, V> {

    private Cache<K, V> cache;

    public LocalCache(long expire, TimeUnit timeUnit) {
        cache = CacheBuilder.newBuilder()
                .initialCapacity(10)
                .maximumSize(10000)
                .expireAfterWrite(expire, timeUnit)
                .build();
    }

    public V get(K key, Callable<? extends V> loader) {
        try {
            return cache.get(key, loader);
        } catch (ExecutionException e) {
            throw new RuntimeException("本地缓存读取出错");
        }
    }

}