package se.steven.database;


import java.sql.*;

public class WorkDAOImpl implements WorkDAO {

    @Override
    public void insertRole() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();


            String sql = "INSERT INTO work_role (title, description, salary, creation_date) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);
            pstmt.setString(1,"3D Artist");
            pstmt.setString(2,"Creates 3D imagery");
            pstmt.setDouble(3,100000.0);
            pstmt.setDate(4, Date.valueOf("2001-04-02"));

            pstmt.executeUpdate();
            pstmt.close();
            conn.commit();

            String query = "SELECT * FROM work_role";
            rs = stmt.executeQuery(query);
            System.out.println("New role added.");

        }   catch (SQLException e) {
            e.printStackTrace();
            throw e;

        }   finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
        }
    }

    @Override
    public void fetchAllRoles() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM work_role";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Role ID: " + rs.getInt("role_id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Creation date: " + rs.getDate("creation_date"));
            }

        }   catch (SQLException e) {
            e.printStackTrace();
            throw e;

        }   finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
        }
    }


    @Override
    public void fetchOneRole() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT title FROM work_role WHERE role_id=31";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Title: " + rs.getString("title"));

            }


        }   catch (SQLException e) {
            e.printStackTrace();
            throw e;

        }   finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
        }
    }

    @Override
    public void updateRole() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "UPDATE work_role SET title = ?, description = ?, salary = ?, creation_date = ? WHERE role_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(5, 8);
            pstmt.setString(1, "System Architect");
            pstmt.setString(2, "Designs and creates complex data systems.");
            pstmt.setDouble(3, 60000.0);
            pstmt.setDate(4, Date.valueOf("2000-04-02"));
            pstmt.executeUpdate();
            pstmt.close();
            conn.commit();

            String query = "SELECT * FROM work_role";

            rs = stmt.executeQuery(query);

            while(rs.next()) {
                System.out.println("Role ID:" + rs.getInt("role_id"));
                System.out.println("Title: + " + rs.getString("title"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Creation date: " + rs.getDate("creation_date"));
            }

        }   catch (SQLException e) {
            e.printStackTrace();
            throw e;


        }   finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
        }
    }

    @Override
    public void removeRole() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "DELETE FROM work_role WHERE role_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,8);
            pstmt.executeUpdate();
            pstmt.close();

            conn.commit();

            String query = "SELECT * FROM work_role";
            rs = stmt.executeQuery(query);
            System.out.println("Role removed.");


        }   catch (SQLException e) {
            e.printStackTrace();
            throw e;

        }   finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
        }
    }
}