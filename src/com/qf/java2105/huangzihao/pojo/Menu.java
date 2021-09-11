package com.qf.java2105.huangzihao.pojo;

/**
 * 菜单实体类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/11.
 */
public class Menu {

    /**
     * 菜单ID
     */
    private String menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单地址
     */
    private String menuUrl;

    public Menu() {
    }

    public Menu(String menuId, String menuName, String menuUrl) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
