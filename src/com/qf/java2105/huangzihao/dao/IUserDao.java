package com.qf.java2105.huangzihao.dao;

import com.qf.java2105.huangzihao.pojo.User;

import java.sql.SQLException;

/**
 * 用户持久层
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public interface IUserDao {

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return
     */
    public User queryByUsername(String username) throws SQLException;
    
}