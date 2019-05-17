package com.ming.controller;

import com.ming.dao.pojo.FanySing;
import com.ming.service.Update;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 更新update
 * @author ming
 */
public class update extends HttpServlet {
    private final static Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断
        if(req.getParameterValues("id").length > 0){
            // 调用service进行处理
            String[] name = req.getParameterValues("name");
            String[] id = req.getParameterValues("id");
            ArrayList<FanySing> fanySings = new ArrayList<>();
            FanySing fanySing = null;

            try{
                for(int i = 0; i < name.length; i++){
                    fanySing = new FanySing();
                    fanySing.setId(Integer.parseInt(id[i]));
                    fanySing.setName(name[i]);
                    fanySings.add(fanySing);
                }
            }catch (Exception e){
                logger.error(e);
                req.getRequestDispatcher("/WEB-INF/classes/view/404.jsp").forward(req, resp);
            }

            // 调用处理
            Update update = new Update();
            if(update.idUpdate(fanySings)){
                req.getRequestDispatcher("/WEB-INF/classes/view/success.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("/WEB-INF/classes/view/failure.jsp").forward(req, resp);
            }

            return;
        }

        req.getRequestDispatcher("/WEB-INF/classes/view/404.jsp").forward(req, resp);
        return;
    }
}
