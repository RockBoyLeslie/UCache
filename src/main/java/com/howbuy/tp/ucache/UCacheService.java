/**
 * UCacheService.java
 * com.howbuy.tp.ucache
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年12月13日 		sophia
 *
 * Copyright (c) 2016, Howbuy Rights Reserved.
 */

package com.howbuy.tp.ucache;

import com.howbuy.tp.ucache.config.CacheConfigParser;
import com.howbuy.tp.ucache.node.CacheContextNode;
import java.util.Map;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * ClassName:UCacheService Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 * 
 * @author leslie
 * @version
 * @since Ver 1.1
 * @Date 2016年12月13日 下午4:01:32
 * 
 * @see
 */
public class UCacheService implements InitializingBean {

    private static Logger LOG = LoggerFactory.getLogger(UCacheService.class);

    @Setter
    private CacheConfigParser configParser;

    private CacheContextNode cacheContext;

    public Map<String, Object> get(String cacheName) {
        return cacheContext.getCacheNode(cacheName).getCache();
    }

    public Object get(String cacheName, String keyValue) throws CacheContextException {
        return cacheContext.getCacheNode(cacheName).getCache(keyValue);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            cacheContext = configParser.getConfig();
        } catch (Exception e) {
            LOG.error("Failed to parse cache server config");
            throw new RuntimeException(e);
        }
    }

}
