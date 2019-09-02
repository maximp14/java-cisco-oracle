package com.controller;

import com.model.DBConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


public class CheckCSV {

    final String CREATE = "INSERT INTO temporals (tem_dni, tem_point, tem_store) VALUES (?,?,?)";
    final String QUERY = "SELECT ";
    private DBConnection connection = DBConnection.getInstance();

    public CheckCSV() {
    }

    public void readFile() {
        Path sourceDirectory = Paths.get("./preprocesado");
        Path targetDirectory = Paths.get("./procesado");

        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDirectory, "*.csv");

            for(Path file : directoryStream){
                readFile(file);
                directoryExist(targetDirectory);
                Files.move(file.toAbsolutePath(),targetDirectory.resolve(file.getFileName()),REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void directoryExist(Path directory) throws IOException {
        if(!Files.exists(directory)){
            Files.createDirectory(directory);
        }
    }

    private void readFile(Path file){
        try {
            PreparedStatement preparedStatement;
            BufferedReader reader = Files.newBufferedReader(file.toAbsolutePath());
            String line;
            String[] splitLine;
            while ((line=reader.readLine())!=null) {
                splitLine = line.split(",");
                preparedStatement = connection.getConnection().prepareStatement(CREATE);
                preparedStatement.setInt(1,Integer.parseInt(splitLine[0]));
                preparedStatement.setInt(2,Integer.parseInt(splitLine[1]));
                preparedStatement.setString(3,splitLine[2]);
                if(preparedStatement.executeUpdate() == 0 ){
                   System.out.println("Something went wrong");
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.closeConnection();
        }
    }

}
