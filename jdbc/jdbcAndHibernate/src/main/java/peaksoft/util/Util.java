package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection getConnection() {
        Connection connection=null;
        try {
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "12345");
            System.out.println("Connected to database");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
