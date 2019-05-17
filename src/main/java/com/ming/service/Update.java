package com.ming.service;

import com.ming.dao.Result;
import com.ming.dao.pojo.FanySing;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;

import static com.ming.dao.util.SqlSessionFactoryUtil.openSqlSesion;

public class Update {
    private final static Logger logger = LogManager.getLogger();

    /**
     * 更新
     * @param
     * @return
     */
    public boolean idUpdate(java.util.ArrayList<FanySing> list){
        if(list == null){
            return false;
        }

        final SqlSession sqlSession = openSqlSesion();
        try{
            final Result result = sqlSession.getMapper(Result.class);
            Iterator iterator = list.iterator();
            while(iterator.hasNext()){
                if(!result.changeFanySing((FanySing) iterator.next())){
                    return false;
                }
            }
            sqlSession.commit();
        }catch (Exception e){
            // 记录错误回滚
            logger.error(e);
            sqlSession.rollback();
            return false;
        }finally {
            // 对资源关闭
            if(sqlSession != null){
                sqlSession.close();
            }
            return true;
        }
    }
}
