package com.javasm.demo.dao;

import com.javasm.demo.entity.Myuser;

//@Mapper/*开了包扫描就不用加了*/
public interface MyuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Myuser record);

    int insertSelective(Myuser record);

    Myuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Myuser record);

    int updateByPrimaryKey(Myuser record);
}