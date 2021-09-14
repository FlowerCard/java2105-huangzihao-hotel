package com.qf.java2105.huangzihao.service;

import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.User;

/**
 * 用户业务层
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public interface IUserService {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public ResultVO<User> login(String username,String password);
    
}
