package se.steven.database;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkDAOImpl implements WorkDAO {

    @Override
    public void insertRole(Role role) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();


            String sql = "INSERT INTO work_role (title, description, salary, creation_date) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);
            pstmt.setString(1,"Michael");
            pstmt.setString(2,"Jackson");
            pstmt.setDouble(3,500000.00);
            pstmt.setDate(4, Date.valueOf("1985-1-17"));

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
    public List<String> fetchAllRoles() throws SQLException {

        List<String> roles = new ArrayList<String>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM work_role";
            rs = stmt.executeQuery(sql);


            while (rs.next()) {
                roles.add(rs.getString("title"));
                System.out.println(rs.getString("title"));
            }

        }   catch (SQLException e) {
            e.printStackTrace();
            throw e;

        }   finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(stmt);
            JDBCUtil.closeConnection(conn);
        }
            return roles;
    }


    @Override
    public Role fetchOneRole(int roleId) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();


            String sql = "SELECT title FROM work_role WHERE role_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roleId);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                System.out.println(title);
                Role role = new Role(title);
                return role;

            }


        }   catch (SQLException e) {
            e.printStackTrace();
            throw e;

        }   finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(pstmt);
            JDBCUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public void updateRole(int roleId) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();


            String sql = "UPDATE work_role SET title = ?, description = ?, salary = ?, creation_date = ? WHERE role_id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Taylor");
            pstmt.setString(2, "Swift");
            pstmt.setDouble(3, 50000000.00);
            pstmt.setDate(4, Date.valueOf("1995-1-17"));
            pstmt.setInt(5, roleId);

            pstmt.executeUpdate();
            pstmt.close();
            conn.commit();

            String query = "SELECT * FROM work_role WHERE role_id=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, roleId);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                double salary = rs.getDouble("salary");
                Date creationDate = rs.getDate("creation_date");

                System.out.println(title);
                System.out.println(description);
                System.out.println(salary);
                System.out.println(creationDate);
            }

        }   catch (SQLException e) {
            e.printStackTrace();
            throw e;


        }   finally {
            JDBCUtil.closeResultSet(rs);
            JDBCUtil.closeStatement(pstmt);
            JDBCUtil.closeConnection(conn);
        }
    }

    @Override
    public void removeRole(int roleId) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "DELETE FROM work_role WHERE role_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,roleId);
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