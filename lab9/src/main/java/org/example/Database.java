package org.example;

//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.sql.*;

public class Database {

    private static Connection conn;
    int batchSize = 20;
    {
         String url = "jdbc:mysql://localhost:3306";
         String user = "root";
         String password = "123";

         try {
             Class.forName("org.mariadb.jdbc.Driver");
             conn = DriverManager.getConnection(url, user, password);
             System.out.println("Connection was successful");
             //addMovies();
             //addActors();

         } catch (ClassNotFoundException | SQLException e) {
             e.printStackTrace();
         }
    }

    public static Connection getConnection(){

        return conn;
    }
    /*
    public void addMovies() throws IOException, SQLException {
        String moviesFilePath = "resources/IMDb-movies.csv";
        String query = "INSERT INTO movies(title, release_date, duration, score) VALUES (?, ?, ?, ?)";

        int count = 0;
        Reader in = new FileReader(moviesFilePath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            PreparedStatement statement = conn.prepareStatement(query);
            String title = record.get(1);
            String release_date = record.get(4);
            String duration = record.get(6);
            String score = record.get(14);
            statement.setString(1, title);
            statement.setString(2, release_date);
            statement.setString(3, duration);
            statement.setString(4, score);
            statement.executeUpdate("use bd;");
            statement.addBatch();
            if (count % batchSize == 0) {
                statement.executeBatch();
            }
            statement.executeBatch();
        }
    }

    public void addActors() throws IOException, SQLException {
        String actorsFilePath = "resources/IMDb-names.csv";
        String query = "INSERT INTO actors(actor_name, country, date_of_birth) VALUES (?, ?, ?)";

        int count = 0;
        Reader in = new FileReader(actorsFilePath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            PreparedStatement statement = conn.prepareStatement(query);
            String actor_name = record.get(1);
            String country = record.get(7);
            String date_of_birth = record.get(6);
            statement.setString(1, actor_name);
            statement.setString(2, country);
            statement.setString(3, date_of_birth);
            statement.executeUpdate("use bd;");
            statement.addBatch();
            if (count % batchSize == 0) {
                statement.executeBatch();
            }
            statement.executeBatch();

        }
    }
     */
}
