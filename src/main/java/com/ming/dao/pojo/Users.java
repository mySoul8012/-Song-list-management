package com.ming.dao.pojo;

import com.ming.dao.typeHandler.Sex;

import java.util.List;

/**
 * 用户对象
 * @author ming
 */
public class Users {
    private int id;
    private Sex sex;
    private String address;
    /**
     * 一个用户拥有多个歌单项表
     */
    private List<Songlist> songlist;

    public void setId(int id) {
        this.id = id;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public Sex getSex() {
        return sex;
    }

    public String getAddress() {
        return address;
    }

    public List<Songlist> getSonglist() {
        return songlist;
    }

    public void setSonglist(List<Songlist> songlist) {
        this.songlist = songlist;
    }
}
