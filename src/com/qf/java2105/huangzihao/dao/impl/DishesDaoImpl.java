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
                "    d.t_dishes_id,\n" +
                "    d.t_cuisine_id, \n" +
                "    d.t_dishes_name, \n" +
                "    d.t_dishes_price, \n" +
                "    d.t_dishes_member_price, \n" +
                "    d.t_dishes_img, \n" +
                "    d.t_dishes_introduction, \n" +
                "    c.t_cuisine_name\n" +
                "from t_dishes d,t_cuisine c \n" +
                "where d.t_cuisine_id = c.t_cuisine_id\n" +
                "and d.t_dishes_name = ?";
        return queryRunner.query(
                sql,
                new MapListHandler(),
                dishName
        );
    }
}
