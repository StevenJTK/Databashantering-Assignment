package se.steven.main;

import java.sql.*;
import se.steven.database.*;


public class Main {
    public static void main(String[] args) throws SQLException {

    JDBCUtil util = new JDBCUtil();
    Operations op = new Operations();

    util.getDataBaseProductName();

    op.updateRole();





    }
}