package com.ming.dao.util;

import com.ming.dao.Result;
import com.ming.dao.pojo.Users;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static java.lang.System.out;

public class SqlSessionFactoryUtilTest {

    @Test
    public void initSqlSessionFactory() {
        SqlSessionFactoryUtil.initSqlSessionFactory();
    }

    @Test
    public void openSqlSesion() {
            Result result;
            Users users = null;
            SqlSession sqlSession = null;
            try {
                sqlSession = SqlSessionFactoryUtil.openSqlSesion();
                result = sqlSession.getMapper(Result.class);
                users = new Users();
                users = result.findUsers(0);
                sqlSession.commit();
            } catch (Exception e) {
                if (sqlSession != null) {
                    sqlSession.rollback();
                }
            } finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
            }
            out.println(users.getAddress());
    }
}