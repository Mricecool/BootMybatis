package com.bootmybatis.dao;

import com.bootmybatis.model.ZmsyCenter;
import com.bootmybatis.model.ZmsyCenterWithBLOBs;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ZmsyCenterMapper {
    int deleteByPrimaryKey(Integer centerId);

    int insert(ZmsyCenterWithBLOBs record);

    int insertSelective(ZmsyCenterWithBLOBs record);

    ZmsyCenterWithBLOBs selectByPrimaryKey(Integer centerId);

    int updateByPrimaryKeySelective(ZmsyCenterWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ZmsyCenterWithBLOBs record);

    int updateByPrimaryKey(ZmsyCenter record);

    List<ZmsyCenter> findAll();

    List<ZmsyCenter> selectByParentId(Integer parentId);
}