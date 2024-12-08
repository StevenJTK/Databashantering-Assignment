package se.steven.database;
import java.sql.*;

    public class Operations {





        // Completed but may need tweaks
        public void insertRole() throws SQLException {

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                conn = JDBCUtil.getConnection();
                stmt = conn.createStatement();


            String sql = "INSERT INTO work_role (title, description, salary, creation_date) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"Software Engineer");
            pstmt.setString(2,"Creates, manages & releases software.");
            pstmt.setDouble(3,40000.0);
            pstmt.setDate(4, Date.valueOf("1998-04-02"));

            pstmt.executeUpdate();
            pstmt.close();
            // add printout
            conn.commit();

            }   catch (SQLException e) {
                e.printStackTrace();
                throw e;

            }   finally {
                JDBCUtil.closeResultSet(rs);
                JDBCUtil.closeStatement(stmt);
                JDBCUtil.closeConnection(conn);
            }

        }

    // Completed
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

    // Completed
    public void fetchOneRole() throws SQLException{
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();

            String sql = "SELECT role_id, title, description, salary, creation_date FROM work_role";

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

    // Fix title not getting privilege
    public void updateRole() throws SQLException {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                conn = JDBCUtil.getConnection();
                stmt = conn.createStatement();

                String sql = "UPDATE title, description, salary, creation_date FROM work_role";
                rs = stmt.executeQuery(sql);

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

    public void removeRole() {

    }





    }