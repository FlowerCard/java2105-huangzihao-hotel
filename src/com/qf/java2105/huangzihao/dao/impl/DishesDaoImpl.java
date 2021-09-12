package com.qf.java2105.huangzihao.dao.impl;

import com.qf.java2105.huangzihao.dao.IDishesDao;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 菜品持久层实现
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
    public Dishes queryByName(String dishName) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select\n" +
                "t_dishes_id, t_cuisine_id, t_dishes_name, t_dishes_price, t_dishes_member_price, t_dishes_img, t_dishes_introduction, t_dishes_status\n" +
                "from t_dishes where t_dishes_name like ?";
        return queryRunner.query(
                sql,
                new BeanHandler<>(Dishes.class),
                dishName
        );
    }
}
