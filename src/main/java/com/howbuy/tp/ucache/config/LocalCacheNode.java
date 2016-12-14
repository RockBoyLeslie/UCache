/**
 * CacheNode.java
 * com.howbuy.tp.ucache.config
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年12月13日 		sophia
 *
 * Copyright (c) 2016, Howbuy Rights Reserved.
 */

package com.howbuy.tp.ucache.config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import lombok.Setter;

import org.apache.commons.lang.StringUtils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.howbuy.tp.ucache.CacheContextException;
import com.howbuy.tp.ucache.utils.SessionTemplateUtils;

/**
 * ClassName:CacheNode Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 * 
 * @author sophia
 * @version
 * @since Ver 1.1
 * @Date 2016年12月13日 下午3:17:42
 * 
 * @see
 */
public class LocalCacheNode extends DefaultCacheNode {

    private static final char SEPARATOR = ':';

    @Setter
    private String namespace;

    @Setter
    private String sqlName;

    //private String keyName;

    private String[] keys;

    private LoadingCache<String, Object> infos;

    public LocalCacheNode() {
        infos = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build(new CacheLoader<String, Object>() {

            @Override
            public Object load(String keyValue) throws Exception {
                return loadFromDb(keyValue);
            }

        });
    }
    
    public Object getCache(String keyValue) throws ExecutionException {
        return infos.get(keyValue);
    }
    
    public Map<String, Object> getCache() {
        return infos.asMap();
    }

    private Object loadFromDb(String keyValue) throws CacheContextException {
        String[] values = StringUtils.split(keyValue, SEPARATOR);
        if (values.length != keys.length) {
            String error = String.format("invalid keyvalue %s for cache %s", keyValue, getName());
            throw new CacheContextException(error);
        }

        Map<String, Object> condition = new HashMap<String, Object>();
        for (int i = 0; i < keys.length; i++) {
            condition.put(keys[i], values[i]);
        }
        return SessionTemplateUtils.executeQuery(namespace, sqlName, condition);
    }

    @Override
    public void refresh() {
    }

    public void setKeyName(String keyName) {
        //this.keyName = keyName;
        this.keys = StringUtils.split(keyName, SEPARATOR);
    }
}
