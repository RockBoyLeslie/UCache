package com.howbuy.tp.ucache.config;

import java.io.IOException;
import java.io.InputStream;
import lombok.Setter;
import org.apache.commons.digester.Digester;

/**
 * Common Cache server configuration file parser， parse configuration to param
 * node by apache digester rules
 * 
 * @author leslie
 * 
 */

public class CacheConfigParser {

    @Setter
    private String cacheServerConfig;

    public CacheContextNode getConfig() throws Exception {
        return (CacheContextNode) getDigester().parse(getInputStream());
    }

    private InputStream getInputStream() throws IOException {
        return CacheConfigParser.class.getClassLoader().getResourceAsStream(cacheServerConfig);
    }

    private Digester getDigester() {
        Digester digester = new Digester();
        digester.setClassLoader(Thread.currentThread().getContextClassLoader());
        digester.setValidating(false);

        // parse Caches node
        digester.addObjectCreate("Caches", "com.howbuy.tp.ucache.config.CacheContextNode");
        digester.addSetProperties("Caches");

        // loop parse */Cache node
        digester.addFactoryCreate("*/Cache", "com.howbuy.tp.ucache.config.CacheNodeFactory");
        digester.addSetProperties("*/Cache");
        digester.addSetProperty("*/Cache/Arg", "name", "value");
        digester.addSetNext("*/Cache", "addCacheNode");
        return digester;
    }
}
