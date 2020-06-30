/**
 * @FileName:
 * @Date:2020/6/11 17:15
 * @Description:
 */
package com.javasm.demo.dao;

      /*  假设这个是你的DAO存储。当然还要这个类让spring管理，当然你不用需要存储，也不需要这个类。*/

import com.javasm.demo.entity.UserExcel;

import java.util.List;

public class DemoDAO {
    public void save(List<UserExcel> list) {
        // TODO: 2020/6/11 持久化操作，将list保存到mysql
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
//        for (UserExcel ue:list){
//            System.out.println(ue);
//        }
    }
}