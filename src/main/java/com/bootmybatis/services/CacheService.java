package com.bootmybatis.services;

import com.bootmybatis.model.ZmsyComplaint;
import com.bootmybatis.model.ZmsyComplaintWithBLOBs;

import java.util.List;

public interface CacheService {

    public List<ZmsyComplaintWithBLOBs> getCacheList();

    public int saveBean(ZmsyComplaintWithBLOBs zmsyComplaint);


}
