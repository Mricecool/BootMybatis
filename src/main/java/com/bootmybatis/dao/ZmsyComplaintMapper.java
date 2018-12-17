package com.bootmybatis.dao;

import com.bootmybatis.model.ZmsyComplaint;
import com.bootmybatis.model.ZmsyComplaintWithBLOBs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZmsyComplaintMapper {
    int deleteByPrimaryKey(Integer complaintId);

    int insert(ZmsyComplaintWithBLOBs record);

    int insertSelective(ZmsyComplaintWithBLOBs record);

    ZmsyComplaintWithBLOBs selectByPrimaryKey(Integer complaintId);

    int updateByPrimaryKeySelective(ZmsyComplaintWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ZmsyComplaintWithBLOBs record);

    int updateByPrimaryKey(ZmsyComplaint record);

    List<ZmsyComplaintWithBLOBs> findAll();
}