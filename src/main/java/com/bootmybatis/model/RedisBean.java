package com.bootmybatis.model;

import java.io.Serializable;

/**
 * Created by mr on 2018/12/26.
 */
public class RedisBean implements Serializable{

    private static final long serialVersionUID = -7638607272334932898L;

    private String beanId;

    private String beanName;

    /**
     * 获取
     *
     * @return
     */
    public String getBeanId() {
        return beanId;
    }

    /**
     * 设置
     *
     * @param beanId
     */
    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * 设置
     *
     * @param beanName
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
