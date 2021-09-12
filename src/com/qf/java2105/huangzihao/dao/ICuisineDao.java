package com.qf.java2105.huangzihao.dao;

import com.qf.java2105.huangzihao.pojo.Cuisine;

import java.sql.SQLException;
import java.util.List;

/**
 * 菜系持久层接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public interface ICuisineDao {

    /**
     * 通过菜系名称查询
     * @param cuisineName 菜系名称
     * @return 结果集
     */
    public List<Cuisine> queryByName(String cuisineName) throws SQLException;

    /**
     * 通过菜系ID查询
     * @param cuisineId 菜系ID
     * @return
     */
    public Cuisine queryById(Integer cuisineId) throws SQLException;

    /**
     * 通过菜系id更新菜系名称
     * @param cuisineId 菜系ID
     * @param cuisineName 菜系名词
     * @param userId 用户ID
     * @return 受影响行数
     */
    public int updateById(Integer cuisineId, String cuisineName, Integer userId) throws SQLException;

    /**
     * 通过菜系ID删除
     * @param cuisineId 菜系ID
     */
    public void deleteById(Integer cuisineId) throws SQLException;

    /**
     * 新增菜系
     * @param cuisine 菜系对象
     * @throws SQLException
     */
    public void save(Cuisine cuisine) throws SQLException;
    
}
