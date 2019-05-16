package com.ming.controller;

import com.ming.dao.pojo.FanySing;
import com.ming.service.ListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ming
 */
public class ListController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到page
        int page = 1;
        try{
            page = Integer.parseInt(req.getParameter("page").trim());
        }catch (Exception e){
            page = 1;
        }

        // 从service层获取list
        ListService listService = new ListService();
        List<FanySing> fanySingList = listService.getList(page);

        // 总页
        int pages;
        pages = listService.getPages();

        // 判断page 越界
        if(page > pages || page <= 0){
            req.getRequestDispatcher("/WEB-INF/classes/view/404.jsp").forward(req, resp);
            return;
        }

        // 参数传入jsp页面
        req.setAttribute("fanySingList", fanySingList);
        req.setAttribute("page", page);
        req.setAttribute("pages", pages);
        // 传入视图层
        req.getRequestDispatcher("/WEB-INF/classes/view/list.jsp").forward(req, resp);
    }
}
