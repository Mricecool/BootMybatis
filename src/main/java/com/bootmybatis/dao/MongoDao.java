package com.bootmybatis.dao;

import com.bootmybatis.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by mr on 2018/12/25.
 */
public interface MongoDao extends MongoRepository<Person,Integer>{

    Person findByPName(String pName);

}
