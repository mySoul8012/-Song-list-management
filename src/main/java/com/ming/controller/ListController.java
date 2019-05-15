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
        int page = 0;
        try{
            page = Integer.parseInt(req.getParameter("page").trim());
        }catch (NumberFormatException e){
            page = 0;
        }finally {
            page = page <= 0 ? 0 : page;
        }
        // 从service层获取list
        ListService listService = new ListService();
        List<FanySing> fanySingList = listService.getList(page);

        // 传入试图层

    }
}
