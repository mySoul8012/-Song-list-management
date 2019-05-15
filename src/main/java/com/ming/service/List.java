package com.ming.service;

import com.github.pagehelper.ISelect;
import com.ming.dao.Result;
import com.ming.dao.pojo.FanySing;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static com.github.pagehelper.page.PageMethod.startPage;
import static com.ming.dao.util.SqlSessionFactoryUtil.openSqlSesion;

/**
 * 歌曲列表servlet 进行分页操作
 * @author ming
 */
@Deprecated
public class List extends HttpServlet {
    /**
     * 分页变量
     */
    @Deprecated
    private int page;
    /**
     * 分页大小
     */
    @Deprecated
    private final static int PAGESIZE = 3;
    /**
     * 日志管理
     */
    @Deprecated
    private final static Logger logger = LogManager.getLogger();

    @Deprecated
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Deprecated
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取page
        if(Objects.equals(req.getParameter("page").trim(), null)){
            this.page = 0;
        }else{
            this.page = Integer.parseInt(req.getParameter("page").trim());
        }

        /*
        * 从dao层中获取对象
        * */
        java.util.List<FanySing> fanySingList= null;
        try{
            // 开启一个会话
            SqlSession sqlSession = openSqlSesion();
            // 装载进入接口
            final Result result = sqlSession.getMapper(Result.class);
            // 获取结果
            fanySingList = startPage(page, PAGESIZE).doSelectPage(new ISelect() {
                @Override
                public void doSelect() {
                    result.listSing();
                }
            });
        }catch (Exception e){
            // 写入日志
            logger.error(e);
        }

        // 参数传入jsp页面
        req.setAttribute("fanySingList", fanySingList);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/WEB-INF/classes/view/list.jsp").forward(req, resp);
    }
}
