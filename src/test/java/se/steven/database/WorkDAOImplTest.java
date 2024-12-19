package se.steven.database;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class WorkDAOImplTest {


    @org.junit.jupiter.api.Test
    public void testInsertWorkRole() throws SQLException {
        WorkDAOImpl dao = new WorkDAOImpl();

        Role role = new Role();

        dao.insertRole(role);

        List<String> roles = dao.fetchAllRoles();

        assertEquals(1, roles.size());

    }
}