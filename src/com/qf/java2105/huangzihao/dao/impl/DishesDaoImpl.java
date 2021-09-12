package com.qf.java2105.huangzihao.dao.impl;

import com.qf.java2105.huangzihao.dao.IDishesDao;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 菜品持久层实现
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public class DishesDaoImpl implements IDishesDao {

    private QueryRunner queryRunner = null;

    /**
     * 通过菜品名称查询
     *
     * @param dishName 菜品名称
     * @return 查询集合
     */
    @Override
    public List<Map<String, Object>> queryByName(String dishName) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select \n" +
                "    d.t_dishes_id dishesId,\n" +
                "    d.t_cuisine_id cuisineId, \n" +
                "    d.t_dishes_name dishesName, \n" +
                "    d.t_dishes_price dishesPrice, \n" +
                "    d.t_dishes_member_price dishesMemberPrice, \n" +
                "    d.t_dishes_img dishesImg, \n" +
                "    d.t_dishes_introduction dishesIntroduction, \n" +
                "    d.t_dishes_status dishesStatus, \n" +
                "    c.t_cuisine_name cuisineName\n" +
                "from t_dishes d,t_cuisine c \n" +
                "where d.t_cuisine_id = c.t_cuisine_id\n" +
                "and d.t_dishes_status != 3 and d.t_dishes_name like ?";
        return queryRunner.query(sql, new MapListHandler(), dishName);
    }

    /**
     * 新增菜品
     *
     * @param dishes 菜品对象
     * @throws SQLException
     */
    @Override
    public void save(Dishes dishes) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "insert into t_dishes (t_cuisine_id, t_dishes_name, t_dishes_price, t_dishes_member_price," +
                " t_dishes_img, t_dishes_introduction) VALUES (?,?,?,?,?,?)";
        queryRunner.update(
                sql,
                dishes.getCuisineId(), dishes.getDishesName(), dishes.getDishesPrice(), dishes.getDishesMemberPrice(),
                dishes.getDishesImg(), dishes.getDishesIntroduction()
        );
    }

    /**
     * 通过ID查询
     *
     * @param dishesId 菜品id
     * @return 菜品对象
     * @throws SQLException
     */
    @Override
    public Dishes queryById(Integer dishesId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select \n" +
                "t_dishes_id dishesId,\n" +
                "t_cuisine_id cuisineId, \n" +
                "t_dishes_name dishesName, \n" +
                "t_dishes_price dishesPrice,\n" +
                "t_dishes_member_price dishesMemberPrice,\n" +
                "t_dishes_img dishesImg, \n" +
                "t_dishes_introduction dishesIntroduction, \n" +
                "t_dishes_status dishesStatus\n" +
                "from t_dishes\n" +
                "where t_dishes_id = ?";
        return queryRunner.query(sql, new BeanHandler<>(Dishes.class), dishesId);
    }

    /**
     * 更新菜品
     *
     * @param dishes 菜品对象
     * @throws SQLException
     */
    @Override
    public void updateById(Dishes dishes) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "update t_dishes\n" +
                "        set t_cuisine_id = ?,t_dishes_name = ?,t_dishes_price = ?," +
                "t_dishes_member_price = ?,t_dishes_img = ?,t_dishes_introduction = ?\n" +
                "        where t_dishes_id = ?";
        queryRunner.update(
                sql,
                dishes.getCuisineId(),dishes.getDishesName(),dishes.getDishesPrice(),dishes.getDishesMemberPrice(),
                dishes.getDishesImg(),dishes.getDishesIntroduction(),dishes.getDishesId()
        );
    }

    /**
     * 根据id删除
     *
     * @param dishesId 菜品id
     * @throws SQLException
     */
    @Override
    public void deleteById(Integer dishesId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "update t_dishes set t_dishes_status = 3 where t_dishes_id = ?";
        queryRunner.update(sql,dishesId);
    }
}
