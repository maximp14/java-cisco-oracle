package com.controller;

import com.model.Customer;
import com.model.Product;
import com.model.PurchaseOrder;
import com.model.Transaction;

public class Operation {

    private CustomerDAO customerDAO;
    private ProductDAO productDAO;
    private TransactionDAO transactionDAO;
    private PurchaseOrderDAO purchaseOrderDAO;

    public Operation() {
        this.customerDAO = new CustomerDAOImp();
        this.productDAO = new ProductDAOImp();
        this.transactionDAO = new TransactionDAOImp();
        this.purchaseOrderDAO = new PurchaseOrderDAOImp();
    }

    public boolean redeemProduct(Integer dni, Integer code, Integer amount){
        Customer customer;
        Product product;

        customer = this.customerDAO.findById(dni);
        product = this.productDAO.findById(code);

        if (product.getProductStock()<= 0){
            PurchaseOrder purchaseOrder = new PurchaseOrder(product.getProductId());
            this.purchaseOrderDAO.create(purchaseOrder);
        }if (customer.getPoints() > product.getProductPoints() && product.getProductStock() > amount){
            customer.setPoints(customer.getPoints() - product.getProductPoints());
            product.setProductStock(product.getProductStock() - amount);
            this.customerDAO.update(dni,customer);
            this.productDAO.update(code,product);
            Transaction transaction = new Transaction(customer.getCustomerId(),product.getProductId());
            this.transactionDAO.create(transaction);
            return true;
        }

        return false;
    }
}
