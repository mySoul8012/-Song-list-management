package com.ming.service;

import com.github.pagehelper.PageInfo;
import com.ming.dao.Result;
import com.ming.dao.pojo.FanySing;
import com.ming.dao.pojo.Users;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.ming.dao.util.SqlSessionFactoryUtil.*;
import static com.github.pagehelper.page.PageMethod.startPage;

/**
 * List Service bean
 * @author ming
 */
public class ListService {
    /**
     * 分页大小
     */
    private final static int PAGESIZE = 3;
    /**
     * 日志管理
     */
    private final static Logger logger = LogManager.getLogger();

    private int pages;

    /**
     * 获取列表List
     * @param page 页数
     * @return List<FanySing> | null </> 列表List对象
     */
    public List<FanySing> getList(int page){
        // 对page 处理
        page = page <= 0 ? 1 : page;
        final SqlSession sqlSession = openSqlSesion();
        java.util.List<FanySing> fanySingList= null;
        try {
            final Result result = sqlSession.getMapper(Result.class);
            // 获取结果
            fanySingList = startPage(page, PAGESIZE).doSelectPage(() -> {
                result.listSing();
            });
            pages = new PageInfo<>(fanySingList).getPages();
            return fanySingList;
        }catch (Exception e){
            // 记录错误回滚
            logger.error(e);
            sqlSession.rollback();
        }finally {
            // 对资源关闭
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return null;
    }

    /**
     * 获取到总页数
     * @return
     */
    public int getPages(){
        return this.pages;
    }
}
