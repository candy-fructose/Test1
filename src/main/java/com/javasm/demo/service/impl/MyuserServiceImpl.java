package com.javasm.demo.service.impl;

import com.javasm.demo.dao.MyuserMapper;
import com.javasm.demo.entity.Myuser;
import com.javasm.demo.service.MyuserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyuserServiceImpl implements MyuserService {

    @Resource
    private MyuserMapper myuserMapper;

    @Resource
    private RedisTemplate<String,Object> rt;

    private final String userKey="myUser:";

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return myuserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Myuser record) {
        return myuserMapper.insert(record);
    }

    @Override
    public int insertSelective(Myuser record) {
        return myuserMapper.insertSelective(record);
    }

    @Override
    public Myuser selectByPrimaryKey(Integer id) {

        ValueOperations<String, Object> oovo = rt.opsForValue();

        Object o = oovo.get(userKey+id.toString());
        if(o!=null){
            System.out.println("缓存查询");
            return (Myuser)o;
        }else {
            System.out.println("数据库查询");
            Myuser mu=myuserMapper.selectByPrimaryKey(id);
            oovo.set(userKey+id.toString(),mu);
            return mu;
        }
    }

    @Override
    public int updateByPrimaryKeySelective(Myuser record) {
        return myuserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Myuser record) {
        return myuserMapper.updateByPrimaryKey(record);
    }

}
