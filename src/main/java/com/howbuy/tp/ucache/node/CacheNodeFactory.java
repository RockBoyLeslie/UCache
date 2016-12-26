package com.howbuy.tp.ucache.node;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.Attributes;

/**
 * 
 * Param handler factory using by apache digester
 * 
 * @author leslie
 * 
 */

public class CacheNodeFactory extends AbstractObjectCreationFactory {

    @Override
    public Object createObject(Attributes attributes) throws Exception {
        String className = attributes.getValue("class");
        if (StringUtils.isEmpty(className)) {
            className = "com.howbuy.tp.ucache.config.LocalCacheNode";
        }

        Class<?> clazz = digester.getClassLoader().loadClass(className);
        Object instance = clazz.newInstance();
        return instance;
    }

}
