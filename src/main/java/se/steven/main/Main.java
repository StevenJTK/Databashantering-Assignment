package se.steven.main;

import java.sql.*;
import se.steven.database.*;


public class Main {
    public static void main(String[] args) throws SQLException {

    JDBCUtil util = new JDBCUtil();

    WorkDAOImpl op = new WorkDAOImpl();

    util.getDataBaseProductName();

    Role role = new Role();

    op.insertRole(role);





    }
}