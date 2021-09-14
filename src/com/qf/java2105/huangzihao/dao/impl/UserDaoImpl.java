package com.qf.java2105.huangzihao.dao.impl;

import com.qf.java2105.huangzihao.dao.IUserDao;
import com.qf.java2105.huangzihao.pojo.User;
import com.qf.java2105.huangzihao.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public class UserDaoImpl implements IUserDao {
    
    private QueryRunner queryRunner;


    /**
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return
     */
    @Override
    public User queryByUsername(String username) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select \n" +
                "t_create_time userCreateTime, \n" +
                "t_modifie_time userModifieTime, \n" +
                "t_user_id userId, \n" +
                "t_username username, \n" +
                "t_password password, \n" +
                "t_nickname nickname, \n" +
                "t_admin admin, \n" +
                "t_phone phone, \n" +
                "t_gender gender, \n" +
                "t_status status, \n" +
                "t_deleted deleted, \n" +
                "t_member member, \n" +
                "t_balance balance \n" +
                "from t_user \n" +
                "where t_username = ? and t_status !=2;";
        return queryRunner.query(sql,new BeanHandler<>(User.class),username);
    }

    /**
     * 新增用户
     *
     * @param user 用户对象
     */
    @Override
    public void inster(User user) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "insert into t_user (t_username,t_password,t_nickname,t_create_time) values (?,?,?,?)";
        queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getNickname(),user.getUserCreateTime());
    }

    /**
     * 用户名是否存在
     *
     * @param username 用户名
     * @return
     */
    @Override
    public Integer exitisName(String username) throws SQLException {
        queryRunner = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select t_user_id from t_user where t_username = ?";
        return queryRunner.query(sql,new ScalarHandler<>(),username);
    }
}
