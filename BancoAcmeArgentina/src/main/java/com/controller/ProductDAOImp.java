package com.controller;

import com.model.DBConnection;
import com.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAO {

    final String CREATE = "INSERT INTO products (pro_code, pro_description, pro_stock, pro_point) VALUES (?,?,?,?)";
    final String UPDATE = "UPDATE products SET pro_description = ?, pro_stock = ?, pro_point = ? WHERE pro_code = ?";
    final String DELETE = "DELETE FROM products WHERE pro_code = ?";
    final String GET_ALL = "SELECT pro_id, pro_code, pro_description, pro_stock, pro_point FROM products ";
    final String GET_ONE = "SELECT pro_id, pro_code, pro_description, pro_stock, pro_point FROM products WHERE pro_code = ?";

    private DBConnection connection = DBConnection.getInstance();

    public void create(Product product) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.getConnection().prepareStatement(CREATE);
            preparedStatement.setInt(1,product.getCode());
            preparedStatement.setString(2,product.getProductName());
            preparedStatement.setInt(3,product.getProductStock());
            preparedStatement.setInt(4,product.getProductPoints());
            if(preparedStatement.executeUpdate() == 0 ){
                System.out.println("Something went wrong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
    }

    public Product findById(Integer code) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Product product = null;
        try {
            preparedStatement = connection.getConnection().prepareStatement(GET_ONE);
            preparedStatement.setInt(1,code);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                product = new Product(resultSet.getInt("pro_id"),resultSet.getString("pro_description"),
                        resultSet.getInt("pro_point"),resultSet.getInt("pro_stock"),resultSet.getInt("pro_code"));
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
        return product;
    }

    public List<Product> findAll() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<Product> productList = new ArrayList();
        try {
            preparedStatement = connection.getConnection().prepareStatement(GET_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                productList.add(new Product(resultSet.getInt("pro_id"),resultSet.getString("pro_description"),
                        resultSet.getInt("pro_point"),resultSet.getInt("pro_stock"),resultSet.getInt("pro_code")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
        return productList;
    }

    public void update(Integer code, Product product) {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.getConnection().prepareStatement(UPDATE);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2,product.getProductStock());
            preparedStatement.setInt(3,product.getProductPoints());
            preparedStatement.setInt(4,code);
            if (preparedStatement.executeUpdate() > 0){
                System.out.println("Customer Updated ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
    }

    public boolean delete(Integer code) {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.getConnection().prepareStatement(DELETE);
            preparedStatement.setInt(1, code);

            if (preparedStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
        return false;
    }
}
