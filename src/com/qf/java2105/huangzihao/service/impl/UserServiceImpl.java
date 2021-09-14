package com.qf.java2105.huangzihao.service.impl;

import com.qf.java2105.huangzihao.constant.MessageConstant;
import com.qf.java2105.huangzihao.dao.IUserDao;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.factory.BeanFacotry;
import com.qf.java2105.huangzihao.pojo.User;
import com.qf.java2105.huangzihao.service.IUserService;

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
}
