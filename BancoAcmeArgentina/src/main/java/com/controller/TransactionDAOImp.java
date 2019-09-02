package com.controller;

import com.model.DBConnection;
import com.model.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImp implements TransactionDAO {

    final String CREATE = "INSERT INTO transactions (cus_id, pro_id) VALUES (?,?)";
    final String GET_ALL = "SELECT cus_id, pro_id FROM transactions ";
    final String GET_ONE = "SELECT cus_id, pro_id FROM transactions WHERE cus_id = ?";

    private DBConnection connection = DBConnection.getInstance();
    @Override
    public void create(Transaction transaction) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.getConnection().prepareStatement(CREATE);
            preparedStatement.setInt(1,transaction.getCustomerId());
            preparedStatement.setInt(2,transaction.getProductId());
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
    public Transaction findById(Integer cusId) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Transaction transaction = null;
        try {
            preparedStatement = connection.getConnection().prepareStatement(GET_ONE);
            preparedStatement.setInt(1,cusId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                transaction = new Transaction(resultSet.getInt(1),resultSet.getInt(2));
            }
            return transaction;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
        return transaction;
    }

    @Override
    public List<Transaction> findAll() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<Transaction> transactionList = new ArrayList();
        try {
            preparedStatement = connection.getConnection().prepareStatement(GET_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                transactionList.add(new Transaction(resultSet.getInt(1),resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
        return transactionList;
    }

    @Override
    public void update(Integer integer, Transaction transaction) {

    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
