package com.ming.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 歌曲列表servlet 进行分页操作
 * @author ming
 */
public class list extends HttpServlet {
    private int page;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("page") == null){

            this.page = 0;
        }else{
            this.page = Integer.parseInt(req.getParameter("page"));
        }
        req.setAttribute("page", page);
        req.getRequestDispatcher("/WEB-INF/classes/view/list.jsp").forward(req, resp);
    }
}
