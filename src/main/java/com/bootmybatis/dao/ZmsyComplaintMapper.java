package com.bootmybatis.dao;

import com.bootmybatis.model.ZmsyComplaint;

public interface ZmsyComplaintMapper {
    int deleteByPrimaryKey(Long complaintid);

    int insert(ZmsyComplaint record);

    int insertSelective(ZmsyComplaint record);

    ZmsyComplaint selectByPrimaryKey(Long complaintid);

    int updateByPrimaryKeySelective(ZmsyComplaint record);

    int updateByPrimaryKey(ZmsyComplaint record);
}