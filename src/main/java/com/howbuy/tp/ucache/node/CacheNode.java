/**
 * CacheNode.java
 * com.howbuy.tp.ucache.node
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年12月14日 		sophia
 *
 * Copyright (c) 2016, Howbuy Rights Reserved.
 */

package com.howbuy.tp.ucache.node;

import java.util.Map;

import com.howbuy.tp.ucache.CacheContextException;

/**
 * ClassName:CacheNode Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 * 
 * @author sophia
 * @version
 * @since Ver 1.1
 * @Date 2016年12月14日 下午2:20:05
 * 
 * @see
 */
public interface CacheNode {

    void refresh();

    Map<String, Object> getCache();

    Object getCache(String keyValue) throws CacheContextException;
    
    String getName();

}
