package se.steven.database;

import java.sql.*;
import java.util.List;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;


class WorkDAOImplTest {


    @org.junit.jupiter.api.Test
    public void testInsertWorkRole() throws SQLException {

        WorkDAOImpl dao = new WorkDAOImpl();

        Role role = new Role("Dentist", "Description", 4000.00, Date.valueOf("1998-04-02"));

        dao.insertRole(role);

        List<Role> roles = dao.fetchAllRoles();

        assertEquals(1, roles.size());
        assertEquals("Dentist", roles.get(0).getTitle());

    }
}