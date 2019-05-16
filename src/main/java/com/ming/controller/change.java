package com.ming.controller;

import com.ming.dao.pojo.FanySing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 修改
 * @author ming
 */
public class change extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String[] id = req.getParameterValues("id");
        req.setAttribute("id", id);
        // 页面跳转
        req.getRequestDispatcher("/WEB-INF/classes/view/change.jsp").forward(req, resp);
    }
}
