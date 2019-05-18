package com.ming.service;

import com.ming.dao.Result;
import com.ming.dao.pojo.Songlist;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.ming.dao.util.SqlSessionFactoryUtil.openSqlSesion;

public class FindCreateIdSongList {
    private final static Logger logger = LogManager.getLogger();

    public java.util.List<Songlist> getSongList(int createId){
        if(createId < 0){
            return null;
        }

        final SqlSession sqlSession = openSqlSesion();

        List<Songlist> ListSongList = null;
        try{
            final Result result = sqlSession.getMapper(Result.class);
            ListSongList = result.findCreateIdSongList(createId);
        }catch (Exception e){
            logger.error(e);
        }

        return ListSongList;
    }
}
