package com.model;

public class Transaction {

    private Integer transactionId;
    private Integer customerId;
    private Integer productId;

    public Transaction(Integer customerId, Integer productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                '}';
    }
}
