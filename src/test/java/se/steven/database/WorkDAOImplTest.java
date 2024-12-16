package se.steven.database;

import org.junit.Test;

import javax.xml.transform.Result;
import java.sql.*;
import se.steven.database.WorkDAOImpl.*;

import static org.junit.jupiter.api.Assertions.*;


class WorkDAOImplTest {


    WorkDAOImpl dao = new WorkDAOImpl();

    @org.junit.jupiter.api.Test
    public void testInsertWorkRole() throws SQLException {

        dao.insertRole();

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            stmt.execute("SELECT title FROM work_role WHERE title = '3D Artist'");

            rs = stmt.getResultSet();

            if (rs.next()) {

                assertEquals("3D Artist", rs.getString("title"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
        }
    }
}