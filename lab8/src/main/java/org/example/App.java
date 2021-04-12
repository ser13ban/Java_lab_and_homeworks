package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App
{
    public static void main( String[] args )
    {

        try {
            DBconn db = DBconn.getInstance();
            Connection con = db.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
            while(rs.next()) {
                System.out.println(rs.getObject(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
