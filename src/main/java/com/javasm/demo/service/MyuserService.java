package com.javasm.demo.service;

import com.javasm.demo.entity.Myuser;

public interface MyuserService{


    int deleteByPrimaryKey(Integer id);

    int insert(Myuser record);

    int insertSelective(Myuser record);

    Myuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Myuser record);

    int updateByPrimaryKey(Myuser record);

}
