package com.controller;

import com.model.Customer;
import com.model.DBConnection;
import com.util.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImp implements CustomerDAO {

    final String CREATE = "INSERT INTO customers (cus_dni, cus_name, cus_last_name, cus_phone, cus_email) VALUES (?,?,?,?,?)";
    final String UPDATE = "UPDATE customers SET  cus_name = ?, cus_last_name = ?, cus_phone = ?, cus_email = ?, cus_point = ? WHERE cus_dni = ?";
    final String DELETE = "DELETE FROM customers WHERE cus_dni = ?";
    final String GET_ALL = "SELECT cus_id, cus_dni, cus_name, cus_last_name, cus_phone, cus_email, cus_point FROM customers ";
    final String GET_ONE = "SELECT cus_id, cus_dni, cus_name, cus_last_name, cus_phone, cus_email, cus_point FROM customers WHERE cus_dni = ?";

    private DBConnection connection = DBConnection.getInstance();

    public void create(Customer customer) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.getConnection().prepareStatement(CREATE);
            preparedStatement.setInt(1,customer.getDni());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getLastName());
            preparedStatement.setString(4,customer.getPhoneNumber());
            preparedStatement.setString(5,customer.getEmail());
            if(preparedStatement.executeUpdate() == 0 ){
                System.out.println("Something went wrong");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                connection.closeConnection();
        }
    }

    public Customer findById(Integer dni) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Customer customer = null;
        try {
            preparedStatement = connection.getConnection().prepareStatement(GET_ONE);
            preparedStatement.setInt(1,dni);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                 customer = new Customer(resultSet.getInt("cus_id"),resultSet.getInt("cus_dni"),resultSet.getString("cus_name"),
                          resultSet.getString("cus_last_name"),resultSet.getString("cus_phone"),
                          resultSet.getString("cus_email"),resultSet.getInt("cus_point"));
            }
            return customer;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
        return customer;
    }

    public List<Customer> findAll() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<Customer> customerList = new ArrayList();
        try {
            preparedStatement = connection.getConnection().prepareStatement(GET_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                customerList.add(new Customer(resultSet.getInt("cus_id"),resultSet.getInt("cus_dni"),resultSet.getString("cus_name"),
                        resultSet.getString("cus_last_name"),resultSet.getString("cus_phone"),
                        resultSet.getString("cus_email"), resultSet.getInt("cus_point")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
        return customerList;
    }

    public void update(Integer dni, Customer customer) {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.getConnection().prepareStatement(UPDATE);
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getLastName());
            preparedStatement.setString(3,customer.getPhoneNumber());
            preparedStatement.setString(4,customer.getEmail());
            preparedStatement.setInt(5,customer.getPoints());
            preparedStatement.setInt(6,dni);

            if (preparedStatement.executeUpdate() > 0){
                System.out.println("Customer Updated ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
    }

    public boolean delete(Integer dni) {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.getConnection().prepareStatement(DELETE);
            preparedStatement.setInt(1, dni);

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
