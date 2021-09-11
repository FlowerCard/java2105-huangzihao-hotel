package com.qf.java2105.huangzihao.pojo;

import java.math.BigDecimal;

/**
 * 菜品实体类
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/11.
 */
public class Dishes {

    /**
     * 菜品ID
     */
    private Long dishesId;
    /**
     * 菜系ID
     */
    private Long cuisineId;
    /**
     * 菜品名称
     */
    private String dishesName;
    /**
     * 菜品普通价格
     */
    private BigDecimal dishesPrice;
    /**
     * 菜品会员价格
     */
    private BigDecimal dishesMemberPrice;
    /**
     * 菜品图片地址
     */
    private String dishesImg;
    /**
     * 菜品描述
     */
    private String dishesIntroduction;
    /**
     * 菜品状态
     */
    private Integer dishesStatus;

    /**
     * 关联菜系
     * 多个菜品对应一个菜系
     */
    private Cuisine cuisine;

    public Dishes() {
    }

    public Dishes(Long dishesId, Long cuisineId, String dishesName, BigDecimal dishesPrice, BigDecimal dishesMemberPrice, String dishesImg, String dishesIntroduction, Integer dishesStatus) {
        this.dishesId = dishesId;
        this.cuisineId = cuisineId;
        this.dishesName = dishesName;
        this.dishesPrice = dishesPrice;
        this.dishesMemberPrice = dishesMemberPrice;
        this.dishesImg = dishesImg;
        this.dishesIntroduction = dishesIntroduction;
        this.dishesStatus = dishesStatus;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Long getDishesId() {
        return dishesId;
    }

    public void setDishesId(Long dishesId) {
        this.dishesId = dishesId;
    }

    public Long getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Long cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public BigDecimal getDishesPrice() {
        return dishesPrice;
    }

    public void setDishesPrice(BigDecimal dishesPrice) {
        this.dishesPrice = dishesPrice;
    }

    public BigDecimal getDishesMemberPrice() {
        return dishesMemberPrice;
    }

    public void setDishesMemberPrice(BigDecimal dishesMemberPrice) {
        this.dishesMemberPrice = dishesMemberPrice;
    }

    public String getDishesImg() {
        return dishesImg;
    }

    public void setDishesImg(String dishesImg) {
        this.dishesImg = dishesImg;
    }

    public String getDishesIntroduction() {
        return dishesIntroduction;
    }

    public void setDishesIntroduction(String dishesIntroduction) {
        this.dishesIntroduction = dishesIntroduction;
    }

    public Integer getDishesStatus() {
        return dishesStatus;
    }

    public void setDishesStatus(Integer dishesStatus) {
        this.dishesStatus = dishesStatus;
    }
}
