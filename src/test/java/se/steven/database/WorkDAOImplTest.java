package se.steven.database;

import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;


class WorkDAOImplTest {



   // JDBCUtil util = new JDBCUtil();

    @org.junit.jupiter.api.Test
    public void testInsertWorkRole() throws SQLException {
        WorkDAOImpl dao = new WorkDAOImpl();

        //skapa instans av ROle

        //sätta in deenna instans med metod i DAO

        //hämta all ROles met metod i DAO - en lista returneras

        //använd assertEquals för att verifiera att listans storlek är 1


//
//        //   dao.insertRole();
//        Statement stmt = null;
//        Connection conn = null;
//        ResultSet rs = null;
//
//        try {
//            conn = JDBCUtil.getConnection();
//            stmt = conn.createStatement();
//            stmt.execute("SELECT title FROM work_role WHERE title = 'Fullstack Developer'");
//
//            rs = stmt.getResultSet();
//
//            assertTrue(rs.next());
//
//            assertEquals("Fireman", rs.getString("title"));
//
//        } catch (SQLException e) {
//            throw e;
//        } finally {
//
//            JDBCUtil.closeResultSet(rs);
//            JDBCUtil.closeStatement(stmt);
//            JDBCUtil.closeConnection(conn);
//        }
    }
}