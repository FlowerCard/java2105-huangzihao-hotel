package com.qf.java2105.huangzihao.service;

import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.Dishes;

import java.util.List;

/**
 * 菜品业务层接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public interface IDishesService {

    /**
     * 通过名字查询
     * @param dishName 磁盘名字
     * @return
     */
    public ResultVO<List<Dishes>> queryByName(String dishName);
    
}
