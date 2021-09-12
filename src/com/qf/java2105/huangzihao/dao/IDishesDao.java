package com.qf.java2105.huangzihao.dao;

import com.qf.java2105.huangzihao.pojo.Dishes;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
    public List<Map<String ,Object>> queryByName(String dishName) throws SQLException;

    /**
     * 新增菜品
     * @param dishes 菜品对象
     * @throws SQLException
     */
    public void save(Dishes dishes) throws SQLException;

    /**
     * 通过ID查询
     * @param dishesId 菜品id
     * @return 菜品对象
     * @throws SQLException
     */
    public Dishes queryById(Integer dishesId) throws SQLException;

    /**
     * 更新菜品
     * @param dishes 菜品对象
     * @throws SQLException
     */
    public void updateById(Dishes dishes) throws SQLException;

    /**
     * 根据id删除
     * @param dishesId 菜品id
     * @throws SQLException
     */
    public void deleteById(Integer dishesId) throws SQLException;
    
}
