package com.bootmybatis.services;

import com.bootmybatis.model.ZmsyComplaint;

import java.io.IOException;

/**
 * Created by mr on 2018/12/17.
 */
public interface DemoService {

    public int addInfo(ZmsyComplaint zmsyComplaint) throws IOException;

    public int addInfoNormal(ZmsyComplaint zmsyComplaint);

}
