package com.ming.dao.pojo;

import java.util.Date;
import java.util.List;

/**
 * 歌曲对象
 * @author ming
 */
public class FanySing {
    private int id;
    private String name;
    private String singer;
    private String category;
    private String writer;
    private String language;
    private Date issudate;
    private List<Songlist> songlist;

    public void setSonglist(List<Songlist> songlist) {
        this.songlist = songlist;
    }

    public List<Songlist> getSonglist() {
        return songlist;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setIssudate(Date issudate) {
        this.issudate = issudate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    public String getCategory() {
        return category;
    }

    public String getWriter() {
        return writer;
    }

    public String getLanguage() {
        return language;
    }

    public Date getIssudate() {
        return issudate;
    }
}
