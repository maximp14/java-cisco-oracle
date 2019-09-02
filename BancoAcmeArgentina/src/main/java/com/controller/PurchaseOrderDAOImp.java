package com.controller;

import com.model.DBConnection;
import com.model.PurchaseOrder;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PurchaseOrderDAOImp implements PurchaseOrderDAO {

    final String CREATE = "INSERT INTO purchases_orders (pro_id) VALUES (?)";
    final String GET_ALL = "SELECT pro_id, pro_code, pro_description, pro_stock, pro_point FROM products ";


    private DBConnection connection = DBConnection.getInstance();

    @Override
    public void create(PurchaseOrder purchaseOrder) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.getConnection().prepareStatement(CREATE);
            preparedStatement.setInt(1,purchaseOrder.getProductId());
            if(preparedStatement.executeUpdate() == 0 ){
                System.out.println("Something went wrong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
    }

    @Override
    public PurchaseOrder findById(Integer integer) {
        return null;
    }

    @Override
    public List<PurchaseOrder> findAll() {
        return null;
    }

    @Override
    public void update(Integer integer, PurchaseOrder purchaseOrder) {

    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
