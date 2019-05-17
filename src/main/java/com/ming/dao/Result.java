package com.ming.dao;

import com.ming.dao.pojo.FanySing;
import com.ming.dao.pojo.Users;
import com.ming.dao.pojo.Songlist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ming
 */
public interface Result {

    /**
     * 根据id查找Users
     * @param id
     * @return Users
     */
    public Users findUsers(@Param("id") int id);

    /**
     * 根据id得出歌单对象列表
     * @param id
     * @return
     */
    public List<Songlist> findSongList(@Param("id") int id);

    /**
     * 根据歌曲id查找出歌曲FanySing对象
     * @param id
     * @return
     */
    public FanySing findFanySing(@Param("id") int id);

    /**
     * 列出歌曲列表
     * @param
     * @return
     */
    public List<FanySing> listSing();


    /**
     * 修改歌曲信息
     * @param fanySing
     * @return
     */
    public boolean changeFanySing(FanySing fanySing);


    /**
     * 用户添加歌曲
     * @param
     * @return
     */
    public boolean addFanySing(@Param("users")Users users);

}
