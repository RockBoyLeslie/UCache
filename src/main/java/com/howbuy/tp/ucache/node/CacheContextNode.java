package com.howbuy.tp.ucache.node;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * The root params node, include all param node and group node
 * 
 * @author LICHAO844
 * 
 */

public class CacheContextNode {

    private static final Logger LOG = LoggerFactory.getLogger(CacheContextNode.class);

    private Map<String, CacheNode> cacheNodes;

    public CacheContextNode() {
        this.cacheNodes = new HashMap<String, CacheNode>();
    }

    public void addCacheNode(CacheNode node) {
        if (cacheNodes.containsKey(node.getName())) {
            LOG.warn("Cache name [{}] already exists, addCacheNode failed", node.getName());
            return;
        }
        cacheNodes.putIfAbsent(node.getName(), node);
    }

    public CacheNode getCacheNode(String cacheName) {
        return cacheNodes.get(cacheName);
    }

    public int size() {
        return cacheNodes.size();
    }
}
