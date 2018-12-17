package com.bootmybatis.services;

import com.bootmybatis.model.ZmsyComplaint;
import com.bootmybatis.model.ZmsyComplaintWithBLOBs;

import java.io.IOException;

/**
 * Created by mr on 2018/12/17.
 */
public interface DemoService {

    public int addInfo(ZmsyComplaintWithBLOBs zmsyComplaint) throws IOException;

    public int addInfoNormal(ZmsyComplaintWithBLOBs zmsyComplaint);

}
