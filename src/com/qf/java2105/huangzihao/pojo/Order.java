package com.qf.java2105.huangzihao.pojo;

/**
 * 订单实体类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/11.
 */
public class Order {

    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 桌子ID
     */
    private String tableId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 菜总数量
     */
    private String dishsNumber;
    /**
     * 下单总金额
     */
    private String totalAmount;
    /**
     * 下单时间
     */
    private String orderTime;
    /**
     * 订单状态
     */
    private String orderStatus;

    public Order() {
    }

    public Order(String orderId, String tableId, String userId, String dishsNumber, String totalAmount, String orderTime, String orderStatus) {
        this.orderId = orderId;
        this.tableId = tableId;
        this.userId = userId;
        this.dishsNumber = dishsNumber;
        this.totalAmount = totalAmount;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDishsNumber() {
        return dishsNumber;
    }

    public void setDishsNumber(String dishsNumber) {
        this.dishsNumber = dishsNumber;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
