package com.qf.java2105.huangzihao.pojo;

/**
 * 订单详情实体
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/11.
 */
public class OrderDetails {

    /**
     * 订单详情ID
     */
    private String detailsId;
    /**
     * 菜品ID
     */
    private String dishesId;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 订单数量小记
     */
    private String quantityNote;
    /**
     * 小记
     */
    private String note;

    public OrderDetails() {
    }

    public OrderDetails(String detailsId, String dishesId, String orderId, String quantityNote, String note) {
        this.detailsId = detailsId;
        this.dishesId = dishesId;
        this.orderId = orderId;
        this.quantityNote = quantityNote;
        this.note = note;
    }

    public String getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }

    public String getDishesId() {
        return dishesId;
    }

    public void setDishesId(String dishesId) {
        this.dishesId = dishesId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getQuantityNote() {
        return quantityNote;
    }

    public void setQuantityNote(String quantityNote) {
        this.quantityNote = quantityNote;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
