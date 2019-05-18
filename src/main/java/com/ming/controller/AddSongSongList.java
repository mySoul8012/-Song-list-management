package com.ming.controller;

import com.ming.service.AddSongSong;
import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 添加用户的歌曲到歌单  这里简化添加到歌单1
 * 传入的参数为 歌曲id， 用户 id
 * @author ming
 */
public class AddSongSongList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {// 判断传入的值
            String id;
            id = req.getParameter("id").trim();
            String userId;
            userId = req.getParameter("userId").trim();
            // 进行判断是否为空
            if (Objects.equals(id, "") || Objects.equals(userId, "") || Objects.equals(id, null)
                    || Objects.equals(userId, "")
            ) {
                req.getRequestDispatcher("/WEB-INF/classes/view/change.jsp").forward(req, resp);
                return;
            }

            // 传入service 进行逻辑处理
            AddSongSong addSongSong = new AddSongSong();
            boolean flag = false;
            try {
                flag = addSongSong.isAddSongSong(Integer.parseInt(id), Integer.parseInt(userId));
            } catch (Exception e) {
                LogManager.getLogger().error(e);
            }

            if(!flag){
                req.getRequestDispatcher("/WEB-INF/classes/view/404.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("/WEB-INF/classes/view/success.jsp").forward(req, resp);
            }
        }catch (Exception e){
            LogManager.getLogger().error(e);
        }

        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
