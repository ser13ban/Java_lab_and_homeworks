package org.example;
import java.sql.Connection;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    Connection conn = Database.getConnection();
}
