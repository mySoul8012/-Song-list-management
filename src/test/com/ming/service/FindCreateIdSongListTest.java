package com.ming.service;

import com.ming.dao.pojo.Songlist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class FindCreateIdSongListTest {
    private FindCreateIdSongList findCreateIdSongList = null;

    @Before
    public void setUp() throws Exception {
        findCreateIdSongList = new FindCreateIdSongList();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSongList() {
        List<Songlist> listSongList = findCreateIdSongList.getSongList(1);
        assert listSongList != null;
        System.out.println(listSongList.size());
        Iterator iterator = listSongList.iterator();
        while(iterator.hasNext()){
            Songlist songlist = (Songlist) iterator.next();
            System.out.println(songlist.getName());
        }
    }
}