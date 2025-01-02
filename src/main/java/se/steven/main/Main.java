package se.steven.main;

import java.sql.*;
import java.time.LocalDate;

import se.steven.database.*;


public class Main {
    public static void main(String[] args) throws SQLException {

        JDBCUtil util = new JDBCUtil();

        WorkDAOImpl op = new WorkDAOImpl();

        util.getDataBaseProductName();

        // Role role = new Role(1, "Steven", "Student", 4000.00, LocalDate.of(1998, 04, 02));

        Role role = new Role("Teacher", "Teaches students", 40000.00, Date.valueOf("2024-03-03"));

        Role role2 = op.fetchOneRole(56);
        role2.setTitle("Dentist");
        op.updateRole(role2);

        System.out.println(role2.getTitle());


    }
}