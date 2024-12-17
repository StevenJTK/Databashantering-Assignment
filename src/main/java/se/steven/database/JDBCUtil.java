package se.steven.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    public static Connection getConnection() throws SQLException {

        // Creates instance
        Driver hsqlDriver = new org.hsqldb.jdbc.JDBCDriver();

        // Driver registered
        DriverManager.registerDriver(hsqlDriver);

        String dbURL = properties.getProperty("db.URL");

        String userID = properties.getProperty("db.user");

        String password = properties.getProperty("db.password");

        // Allows connection to drivermanager to access database
        Connection conn = DriverManager.getConnection(dbURL, userID, password);

        conn.setAutoCommit(false);

        return conn;
    }


    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement stmt) {
        try {
            if(stmt != null) {
                stmt.close();
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void closeResultSet(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void commit(Connection conn) {
        try {
            if(conn != null) {
                conn.commit();
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void rollback(Connection conn) {
        try {
            if(conn != null) {
                conn.rollback();
            }
        }   catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getDataBaseProductName() throws SQLException {
        Connection conn = null;

        try {
            conn = getConnection();
            DatabaseMetaData metadata = conn.getMetaData();
            System.out.println("Ping");
            return metadata.getDatabaseProductName();


        }   catch (SQLException e) {
            e.printStackTrace();


        } finally {
            closeConnection(conn);
        }
            return null;
    }

    private static Properties properties = new Properties();

    static {
        try(InputStream input = JDBCUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            if(input == null) {
                throw new IOException("Could not find application.properties");
            }
            properties.load(input);
        }   catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Failed to load database properties.");
        }
    }




}