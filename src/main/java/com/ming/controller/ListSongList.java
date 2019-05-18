package com.ming.controller;

import com.ming.dao.pojo.Songlist;
import com.ming.service.FindCreateIdSongList;
import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListSongList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String createId = req.getParameter("createId");
            FindCreateIdSongList findCreateIdSongList = new FindCreateIdSongList();
            List<Songlist> songListList = null;
            try{
                songListList = findCreateIdSongList.getSongList(Integer.parseInt(createId));
            }catch (Exception e){
                LogManager.getLogger().error(e);
            }

            if(songListList != null){
                req.setAttribute("ListSongList", songListList);
                req.getRequestDispatcher("/WEB-INF/classes/view/songListList.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("/WEB-INF/classes/view/404.jsp").forward(req, resp);
            }
        }catch (Exception e){
            LogManager.getLogger().error(e);
        }

        return;
    }
}
