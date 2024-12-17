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
            pstmt.setString(1,"Teacher");
            pstmt.setString(2,"Teaches students");
            pstmt.setDouble(3,50000.0);
            pstmt.setDate(4, Date.valueOf("2000-1-17"));

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
        //skapa tom lista som bara innehåller Role, det ska vara en ArrayList

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

                //skapa ny instans av Role här

                //lägg denna nya instans till listan med Roles
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
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "UPDATE work_role SET title = ?, description = ?, salary = ?, creation_date = ? WHERE role_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(5, 5);
            pstmt.setString(1, "Java Developer");
            pstmt.setString(2, "Programs in Java");
            pstmt.setDouble(3, 90000.0);
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
    public void removeRole(int roleId) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "DELETE FROM work_role WHERE role_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,6);
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