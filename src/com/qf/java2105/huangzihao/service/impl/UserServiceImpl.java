package com.qf.java2105.huangzihao.service.impl;

import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.dao.IUserDao;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.User;
import com.qf.java2105.huangzihao.service.IUserService;
import com.qf.java2105.huangzihao.utils.JdbcUtil;

import java.util.Date;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public class UserServiceImpl implements IUserService {
    
    private IUserDao userDao = (IUserDao) BeanFacotry.getBean("userDao");
    
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public ResultVO<User> login(String username, String password) {
        try {
            User user = userDao.queryByUsername(username);
            if (null != user) {
                //不为空则用户存在
                if (password.equals(user.getPassword())) {
                    //密码正确
                    return ResultVO.ok(MessageConstant.LOGIN_SUCCESS,user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultVO.error(MessageConstant.LOGIN_FAIL);
    }

    /**
     * 注册
     *
     * @param user 用户
     * @return
     */
    @Override
    public ResultVO<String> register(User user) {
        try {
            JdbcUtil.begin();
            user.setUserCreateTime(new Date());
            userDao.inster(user);
            JdbcUtil.commit();
            return ResultVO.ok(MessageConstant.REG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtil.rollback();
            return ResultVO.error(MessageConstant.REG_FAIL);
        }
    }

    /**
     * 用户名是否存在
     *
     * @param username 用户名
     * @return
     */
    @Override
    public ResultVO<String> exitisName(String username) {
        try {
            Integer exitisName = userDao.exitisName(username);
            if (null != exitisName) {
                return ResultVO.error(MessageConstant.EXITIS_NAME);
            } else {
                return ResultVO.ok(MessageConstant.UNEXITIS_NAME);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.error(MessageConstant.EXITIS_NAME);
        }
    }
}
