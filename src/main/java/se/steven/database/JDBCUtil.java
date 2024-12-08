package se.steven.database;

import java.sql.*;

public class JDBCUtil {

    public static Connection getConnection() throws SQLException {

        // Creates instance
        Driver hsqlDriver = new org.hsqldb.jdbc.JDBCDriver();

        // Driver registered
        DriverManager.registerDriver(hsqlDriver);

        String dbURL = "jdbc:hsqldb:hsql://localhost/jdbclab";

        String userID = "sa";

        String password = "";

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
}