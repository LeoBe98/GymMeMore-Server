package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/prova_sync_db";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "password";

    public static Connection getDbConnection() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();//Missing JDBC Driver in /lib
            return null;
        }
        //driver registered
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            //connection failed
            e.printStackTrace();
            return null;
        }
        return connection;
    }

}
