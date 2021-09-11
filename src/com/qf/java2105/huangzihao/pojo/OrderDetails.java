package com.qf.java2105.huangzihao.pojo;

import java.math.BigDecimal;

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
    private Long detailsId;
    /**
     * 菜品ID
     */
    private Long dishesId;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单数量小记
     */
    private Long quantityNote;
    /**
     * 小记
     */
    private BigDecimal note;

    public OrderDetails() {
    }

    public OrderDetails(Long detailsId, Long dishesId, Long orderId, Long quantityNote, BigDecimal note) {
        this.detailsId = detailsId;
        this.dishesId = dishesId;
        this.orderId = orderId;
        this.quantityNote = quantityNote;
        this.note = note;
    }

    public Long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Long detailsId) {
        this.detailsId = detailsId;
    }

    public Long getDishesId() {
        return dishesId;
    }

    public void setDishesId(Long dishesId) {
        this.dishesId = dishesId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getQuantityNote() {
        return quantityNote;
    }

    public void setQuantityNote(Long quantityNote) {
        this.quantityNote = quantityNote;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }
}
