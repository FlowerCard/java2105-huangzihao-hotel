package com.qf.java2105.huangzihao.dao.impl;

import com.qf.java2105.huangzihao.dao.ICuisineDao;
import com.qf.java2105.huangzihao.pojo.Cuisine;
import com.qf.java2105.huangzihao.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * 菜系持久层实现
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public class CuisineDaoImpl implements ICuisineDao {
    
    private QueryRunner queryRunner = null;
    
    /**
     * 通过菜系名称查询
     *
     * @param cuisineName 菜系名称
     * @return 结果集
     */
    @Override
    public List<Cuisine> queryByName(String cuisineName) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select \n" +
                "t_cuisine_id cuisineId,\n" +
                "t_cuisine_name cuisineName,\n" +
                "t_cuisine_create_time cuisineCreateTime,\n" +
                "t_cuisine_modifie_time cuisineModifieTime,\n" +
                "t_cuisine_modifie_user cuisineModifieUser\n" +
                "from t_cuisine\n" +
                "where t_cuisine_name like ? and t_cuisine_status != 2";
        return queryRunner.query(sql,new BeanListHandler<>(Cuisine.class),cuisineName);
    }

    /**
     * 通过菜系ID查询
     *
     * @param cuisineId 菜系ID
     * @return
     */
    @Override
    public Cuisine queryById(Integer cuisineId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select\n" +
                "    t_cuisine_id cuisineId,\n" +
                "    t_cuisine_name cuisineName,\n" +
                "    t_cuisine_create_time cuisineCreateTime,\n" +
                "    t_cuisine_modifie_time cuisineModifieTime,\n" +
                "    t_cuisine_modifie_user cuisineModifieUser\n" +
                "from t_cuisine\n" +
                "where t_cuisine_id = ? and t_cuisine_status != 2";
        return queryRunner.query(sql,new BeanHandler<>(Cuisine.class),cuisineId);
    }

    /**
     * 通过菜系id更新菜系名称
     *
     * @param cuisineId          菜系ID
     * @param cuisineName 菜系名词
     * @param userId      用户ID
     * @return 受影响行数
     */
    @Override
    public int updateById(Integer cuisineId, String cuisineName, Integer userId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "update t_cuisine set t_cuisine_name = ?,t_cuisine_modifie_time = ?," +
                "t_cuisine_modifie_user = ? where t_cuisine_id = ?";
        return queryRunner.update(
                sql,
                cuisineName,new Date(),userId,cuisineId
        );
    }

    /**
     * 通过菜系ID删除
     *
     * @param cuisineId 菜系ID
     */
    @Override
    public void deleteById(Integer cuisineId) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "update t_cuisine set t_cuisine_status = 2 where t_cuisine_id = ?";
        queryRunner.update(sql,cuisineId);
    }

    /**
     * 新增菜系
     *
     * @param cuisine 菜系对象
     * @throws SQLException
     */
    @Override
    public void save(Cuisine cuisine) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "insert into t_cuisine (t_cuisine_name, t_cuisine_create_time, t_cuisine_modifie_time, t_cuisine_modifie_user) \n" +
                "VALUES (?,?,?,?)";
        queryRunner.update(
                sql,
                cuisine.getCuisineName(),cuisine.getCuisineCreateTime(),cuisine.getCuisineModifieTime(),cuisine.getCuisineModifieUser()
        );
    }
}
