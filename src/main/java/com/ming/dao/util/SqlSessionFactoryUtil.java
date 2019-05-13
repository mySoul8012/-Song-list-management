package com.ming.dao.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ming
 */
public class SqlSessionFactoryUtil {
    /**
     * SqlSessionFactory对象
     */
    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 类线程锁
     */
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    /**
     * 日志管理类
     */
    private static final Logger logger = LogManager.getLogger();
    /**
     * 单例
     */
    private SqlSessionFactoryUtil(){

    }

    /**
     * @return SqlSessionFactory
     * 初始化SqlSessionFactory对象
     */
    public static SqlSessionFactory initSqlSessionFactory(){
        // 配置文件
        String resource = "dao/mybatis-config.xml";
        // 输出流
        InputStream inputStream = null;
        try{
            // 获得配置文件输入流
            inputStream = Resources.getResourceAsStream(resource);
        }catch (IOException e){
            // 错误写入配置文件中
            logger.error(e);
        }

        // 即类锁 采用最小同步快的方式
        if(sqlSessionFactory == null) {
            // 此处排队
            synchronized (CLASS_LOCK) {
                // 多线程情况下唯一的获取工厂对象
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 打开SqlSession
     * @return SqlSession
     */
    public static SqlSession openSqlSesion(){
        // 判空处理
        if(sqlSessionFactory == null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
