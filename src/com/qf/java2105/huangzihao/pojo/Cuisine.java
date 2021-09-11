package com.qf.java2105.huangzihao.pojo;

import java.util.Date;

/**
 * 菜系实体类
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/11.
 */
public class Cuisine {

    /**
     * 菜系ID
     */
    private Long cuisineId;
    /**
     * 菜系名称
     */
    private String cuisineName;
    /**
     * 菜系创建时间
     */
    private Date cuisineCreateTime;
    /**
     * 菜系修改时间
     */
    private Date cuisineModifieTime;

    public Cuisine() {
    }

    public Cuisine(Long cuisineId, String cuisineName, Date cuisineCreateTime, Date cuisineModifieTime, Long cuisineModifieUser) {
        this.cuisineId = cuisineId;
        this.cuisineName = cuisineName;
        this.cuisineCreateTime = cuisineCreateTime;
        this.cuisineModifieTime = cuisineModifieTime;
        this.cuisineModifieUser = cuisineModifieUser;
    }

    public Long getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(Long cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public Date getCuisineCreateTime() {
        return cuisineCreateTime;
    }

    public void setCuisineCreateTime(Date cuisineCreateTime) {
        this.cuisineCreateTime = cuisineCreateTime;
    }

    public Date getCuisineModifieTime() {
        return cuisineModifieTime;
    }

    public void setCuisineModifieTime(Date cuisineModifieTime) {
        this.cuisineModifieTime = cuisineModifieTime;
    }

    public Long getCuisineModifieUser() {
        return cuisineModifieUser;
    }

    public void setCuisineModifieUser(Long cuisineModifieUser) {
        this.cuisineModifieUser = cuisineModifieUser;
    }

    /**
     * 修改菜系的人
     */
    private Long cuisineModifieUser;
    
    

}
