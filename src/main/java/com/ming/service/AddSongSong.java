package com.ming.service;

import com.ming.dao.Result;
import com.ming.dao.pojo.Songlist;
import com.ming.dao.pojo.Users;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static com.ming.dao.util.SqlSessionFactoryUtil.openSqlSesion;

public class AddSongSong {
    /**
     * 日志管理
     */
    private final static Logger logger = LogManager.getLogger();

    public boolean isAddSongSong(int id, int userId){
        // 传入值做判断
        if(id < 0 || userId < 0){
            return false;
        }

        final SqlSession sqlSession = openSqlSesion();
        boolean flag = false;
        try{
            final Result result = sqlSession.getMapper(Result.class);
            Users users = result.findUsers(userId);
            Songlist songlist = new Songlist(new Random().nextInt(2334), id, userId);
            users.getSonglist().add(songlist);
            if(result.addFanySing(users)){
                flag = true;
            }else{
                flag = false;
            }
            sqlSession.commit();
        }catch (Exception e){
            logger.error(e);
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }

        return flag;
    }
}
