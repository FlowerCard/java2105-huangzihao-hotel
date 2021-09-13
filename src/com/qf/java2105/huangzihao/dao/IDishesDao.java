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

    /**
     * 查看菜品名字是否存在
     * @param dishesName 菜品名称
     * @return
     */
    public Integer existsDishesName(String dishesName) throws SQLException;

    /**
     * 更新菜品是否被删除
     * 配合菜品名称是否存在使用
     * 如果存在，但是被打上了删除状态，就把状态复原到可用
     * @param dishesId 菜品ID
     */
    public void updateDishesStatus(Integer dishesId) throws SQLException;

    /**
     * 查询被打上删除标记的菜品
     * @param cuisineName 菜品名称
     * @throws SQLException
     * @return
     */
    public Integer queryDeleteStatus(String cuisineName) throws SQLException;
    
}
