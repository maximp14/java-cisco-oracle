package com.model;

public class Product {

    private Integer productId;
    private String productName;
    private Integer productPoints;
    private Integer productStock;
    private Integer code;

    public Product(Integer productId, String productName, Integer productPoints, Integer productStock, Integer code) {
        this.productId = productId;
        this.productName = productName;
        this.productPoints = productPoints;
        this.productStock = productStock;
        this.code = code;
    }

    public Product(Integer code, String productName, Integer productPoints, Integer productStock) {
        this.code = code;
        this.productName = productName;
        this.productPoints = productPoints;
        this.productStock = productStock;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPoints() {
        return productPoints;
    }

    public void setProductPoints(Integer productPoints) {
        this.productPoints = productPoints;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }



    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPoints=" + productPoints +
                ", productStock=" + productStock +
                ", code=" + code +
                '}';
    }
}
