package com.javasm.demo.entity;

import java.io.Serializable;

/**
 * (TbUser)实体类
 *
 * @author makejava
 * @since 2020-06-30 18:17:02
 */
public class TbUser implements Serializable {
    private static final long serialVersionUID = -13327917323490542L;
    
    private String uname;
    
    private Integer uage;
    
    private Integer uid;


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

}