/**
 * SessionTemplateUtils.java
 * com.howbuy.tp.ucache.utils
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2016年12月13日 		sophia
 *
 * Copyright (c) 2016, Howbuy Rights Reserved.
 */

package com.howbuy.tp.ucache.utils;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ClassName:SessionTemplateUtils Function: TODO ADD FUNCTION Reason: TODO ADD
 * REASON
 * 
 * @author sophia
 * @version
 * @since Ver 1.1
 * @Date 2016年12月13日 下午4:30:36
 * 
 * @see
 */
public class SessionTemplateUtils implements ApplicationContextAware {

    private static SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SessionTemplateUtils.sqlSessionTemplate = applicationContext.getBean(SqlSessionTemplate.class);
    }

    public static Object executeQuery(String namespace, String sqlStatement, Map<String, Object> condition) {
        return sqlSessionTemplate.selectOne(namespace + "." + sqlStatement, condition);
    }

}
