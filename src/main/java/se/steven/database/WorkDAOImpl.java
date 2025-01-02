package se.steven.database;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

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

            pstmt.setString(1, role.getTitle());
            pstmt.setString(2, role.getDescription());
            pstmt.setDouble(3, role.getSalary());
            pstmt.setDate(4, role.getCreation_date());

            pstmt.executeUpdate();
            pstmt.close();
            conn.commit();

            System.out.println("New role added!");

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
    public List<Role> fetchAllRoles() throws SQLException {

        List<Role> roles = new ArrayList<Role>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT * FROM work_role";
            rs = stmt.executeQuery(sql);


            while (rs.next()) {
                Role role = new Role(rs.getString("title"));
                roles.add(role);
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
    public Role fetchOneRole(int roleId) throws SQLException { // Only roleId?
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();


            String sql = "SELECT * FROM work_role WHERE role_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, roleId);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                Integer role_id = rs.getInt("role_id");
                String description = rs.getString("description");
                double salary = rs.getDouble("salary");
                Date creation_date = rs.getDate("creation_date");

                System.out.println(title);
                Role role = new Role(role_id, title, description, salary, creation_date);
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


    public void updateRole(Role role) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();


            String sql = "UPDATE work_role SET title = ?, description = ?, salary = ?, creation_date = ? WHERE role_id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, role.getTitle());
            pstmt.setString(2, role.getDescription());
            pstmt.setDouble(3, role.getSalary());
            pstmt.setDate(4, role.getCreation_date());
            pstmt.setInt(5, role.getRole_id());

            pstmt.executeUpdate();
            conn.commit();


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