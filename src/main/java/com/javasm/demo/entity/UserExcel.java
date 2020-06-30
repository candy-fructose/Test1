/**
 * @FileName:
 * @Date:2020/6/11 16:05
 * @Description:
 */
package com.javasm.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/*表格类*/
public class UserExcel {

    @ExcelProperty(value = "user_id")
    private Integer user_id;

    @ExcelProperty(value = "user_name")
    private String user_name;

    @ExcelProperty(value = "user_age")
    private Integer user_age;

    @ExcelProperty(value = "last_loginTime")
    private Date last_loginTime;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getUser_age() {
        return user_age;
    }

    public void setUser_age(Integer user_age) {
        this.user_age = user_age;
    }

    public Date getLast_loginTime() {
        return last_loginTime;
    }

    public void setLast_loginTime(Date last_loginTime) {
        this.last_loginTime = last_loginTime;
    }

    @Override
    public String toString() {
        return "UserExcel{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_age=" + user_age +
                ", last_loginTime=" + last_loginTime +
                '}';
    }
}
