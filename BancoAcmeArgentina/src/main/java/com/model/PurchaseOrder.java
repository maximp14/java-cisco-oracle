package com.model;

public class PurchaseOrder {

    private Integer purchaseOrderId;
    private Integer productId;

    public PurchaseOrder(Integer productId) {
        this.productId = productId;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "purchaseOrderId=" + purchaseOrderId +
                ", productId=" + productId +
                '}';
    }
}
