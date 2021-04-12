package org.example;

import java.sql.*;

public class DBconn {
    private static DBconn instance;
    private static Connection con = null;
    static {
        String url = "jdbc:mariadb://localhost:3306/test";
        String username = "root";
        String password = "";
        //String driver = "org.mariadb.jdbc";
        try {
            //Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }
        public static Connection getConnection()
        {
            return con;
        }

    public static DBconn getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBconn();
        } else if (instance.getConnection().isClosed()) {
            instance = new DBconn();
        }

        return instance;
    }
}

