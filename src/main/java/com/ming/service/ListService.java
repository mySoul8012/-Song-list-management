package com.ming.service;

import com.ming.dao.Result;
import com.ming.dao.pojo.FanySing;
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

    /**
     * 获取列表List
     * @param page 页数
     * @return List<FanySing> | null </> 列表List对象
     */
    public List<FanySing> getList(int page){
        // 对page 处理
        page = page < 0 ? 0 : page;
        final SqlSession sqlSession = openSqlSesion();
        java.util.List<FanySing> fanySingList= null;
        try {
            final Result result = sqlSession.getMapper(Result.class);
            // 获取结果
            fanySingList = startPage(page, PAGESIZE).doSelectPage(() -> {
                result.listSing();
            });
            return fanySingList;
        }catch (Exception e){
            logger.error(e);
        }
        return null;
    }
}
