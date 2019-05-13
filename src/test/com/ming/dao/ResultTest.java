package com.ming.dao;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.ming.dao.pojo.Fanysing;
import com.ming.dao.pojo.Songlist;
import com.ming.dao.pojo.Users;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static com.ming.dao.util.SqlSessionFactoryUtil.openSqlSesion;
import static java.lang.System.out;

public class ResultTest {
    private SqlSession sqlSession = null;
    private Result result = null;

    @Before
    public void setUp() throws Exception {
        sqlSession = openSqlSesion();
        result = sqlSession.getMapper(Result.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUsers() {
        Users users = null;
        users = result.findUsers(2);
        sqlSession.commit();
        out.println(users.getSex());
    }

    @Test
    public void findSongList() {
        List<Songlist> songlists = null;
        songlists = result.findSongList(2);
        sqlSession.commit();
        Iterator iterator = songlists.iterator();
        while(iterator.hasNext()){
            Songlist songlist = null;
            songlist = (Songlist)iterator.next();
            out.println(songlist.getDescription());
        }
    }

    @Test
    public void findFanySing() {
        Fanysing fanysing = result.findFanySing(3);
        List<Songlist> songlist = fanysing.getSonglist();
        sqlSession.commit();
        Iterator iterator = songlist.iterator();
        while(iterator.hasNext()){
            Songlist songlist1 = null;
            songlist1 = (Songlist)iterator.next();
            out.println(songlist1.getDescription());
        }
    }

    @Test
    public void listSing(){
        List<Fanysing> fanysings = PageHelper.startPage(0, 10).doSelectPage(new ISelect() {
            @Override
            public void doSelect() {
                result.listSing();
            }
        });
        Iterator iterator = fanysings.iterator();
        while(iterator.hasNext()){
            Fanysing fanysing = (Fanysing)iterator.next();
            List<Songlist> songlists = fanysing.getSonglist();
            out.println(songlists.size());
            Iterator iterator1 = songlists.iterator();
            while(iterator1.hasNext()){
                Songlist songlist = (Songlist)iterator1.next();
                out.println(songlist.getName());
            }
        }
    }
}