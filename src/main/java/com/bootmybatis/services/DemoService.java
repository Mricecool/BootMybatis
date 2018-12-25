package com.bootmybatis.services;

import com.bootmybatis.model.Person;
import com.bootmybatis.model.ZmsyComplaint;
import com.bootmybatis.model.ZmsyComplaintWithBLOBs;

import java.io.IOException;
import java.util.List;

/**
 * Created by mr on 2018/12/17.
 */
public interface DemoService {

    public int addInfo(ZmsyComplaintWithBLOBs zmsyComplaint) throws IOException;

    public int addInfoNormal(ZmsyComplaintWithBLOBs zmsyComplaint);

    List<Person> getMongoList();

    Person addMongo(Person person);

    Person getPerson(String pName);

}
