/**
 * DefaultCacheNode.java
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

import lombok.Getter;
import lombok.Setter;

/**
 * ClassName:DefaultCacheNode
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   sophia
 * @version  
 * @since    Ver 1.1
 * @Date	 2016年12月13日		下午3:55:51
 *
 * @see 	 
 */
public abstract class DefaultCacheNode {
    
    @Setter @Getter
    private String name;
    
    @Setter @Getter
    private long interval;
    
    public abstract void refresh();
    
}

