package com.bootmybatis.dao;

import com.bootmybatis.model.BatchBean;

public interface BatchBeanMapper {
    int insert(BatchBean record);

    int insertSelective(BatchBean record);
}