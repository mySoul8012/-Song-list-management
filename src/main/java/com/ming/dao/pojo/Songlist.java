package com.ming.dao.pojo;

/**
 * 歌曲项对象
 * @author ming
 */
public class Songlist {
    private int id;
    private int singId;
    private String name;
    private String description;
    private int creator;

    public Songlist(Integer id, Integer singId, Integer creator){
        this.id = id;
        this.singId = singId;
        this.creator = creator;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSingId(int singId) {
        this.singId = singId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public int getSingId() {
        return singId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCreator() {
        return creator;
    }
}
