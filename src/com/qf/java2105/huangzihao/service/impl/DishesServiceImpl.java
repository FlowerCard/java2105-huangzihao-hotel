package com.qf.java2105.huangzihao.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.qf.java2105.huangzihao.dao.IDishesDao;
import com.qf.java2105.huangzihao.dao.impl.DishesDaoImpl;
import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.Cuisine;
import com.qf.java2105.huangzihao.pojo.Dishes;
import com.qf.java2105.huangzihao.service.IDishesService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 菜品业务层实现
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/12.
 */
public class DishesServiceImpl implements IDishesService {
    
    private IDishesDao dishesDao = new DishesDaoImpl();
    
    /**
     * 通过名字查询
     *
     * @param dishName 磁盘名字
     * @return
     */
    @Override
    public ResultVO<List<Dishes>> queryByName(String dishName) {

        try {
            //判断传入的用户是否为空
            if (StringUtils.isEmpty(dishName)) {
                dishName = "%%";
            } else {
                dishName = "%" + dishName + "%";
            }
            List<Map<String, Object>> dishNameList = dishesDao.queryByName(dishName);
            
            //处理数据
            List<Dishes> dishesList = new ArrayList<>();
            for (Map<String, Object> map : dishNameList) {
                Long dishesId = (Long) map.get("dishesId");
                Long cuisineId = (Long) map.get("cuisineId");
                String dishesName = (String) map.get("dishesName");
                BigDecimal dishesPrice = (BigDecimal) map.get("dishesPrice");
                BigDecimal dishesMemberPrice = (BigDecimal) map.get("dishesMemberPrice");
                String dishesImg = (String) map.get("dishesImg");
                String dishesIntroduction = (String) map.get("dishesIntroduction");
                Integer dishesStatus = (Integer) map.get("dishesStatus"); 
                String cuisineName = (String) map.get("cuisineName");

                Cuisine cuisine = new Cuisine();
                cuisine.setCuisineId(cuisineId);
                cuisine.setCuisineName(cuisineName);
                
                Dishes dishes = new Dishes(
                        dishesId,cuisineId,dishesName,dishesPrice,dishesMemberPrice,dishesImg,dishesIntroduction,dishesStatus
                );
                dishes.setCuisine(cuisine);
                dishesList.add(dishes);
            }
            
            return ResultVO.ok("查询成功",dishesList);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResultVO.error("查询失败");
        }
    }
}
