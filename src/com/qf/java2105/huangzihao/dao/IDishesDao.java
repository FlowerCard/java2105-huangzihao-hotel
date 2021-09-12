package com.qf.java2105.huangzihao.dao;

import com.qf.java2105.huangzihao.pojo.Dishes;

import java.sql.SQLException;

/**
 * 菜品持久层接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public interface IDishesDao {

    /**
     * 通过菜品名称查询
     * @param dishName 菜品名称
     * @return 查询集合
     */
    public Dishes queryByName(String dishName) throws SQLException;
    
}
