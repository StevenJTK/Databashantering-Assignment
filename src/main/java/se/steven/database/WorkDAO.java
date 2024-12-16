package se.steven.database;

import java.sql.SQLException;

public interface WorkDAO {


    public void insertRole() throws SQLException;

    public void fetchAllRoles() throws SQLException;

    public void fetchOneRole() throws SQLException;

    public void updateRole() throws SQLException;

    public void removeRole() throws SQLException;

}
