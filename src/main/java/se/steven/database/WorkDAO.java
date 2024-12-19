package se.steven.database;

import java.sql.SQLException;
import java.util.List;

public interface WorkDAO {

    public void insertRole(Role role) throws SQLException;

    public List<String> fetchAllRoles() throws SQLException;

    public Role fetchOneRole(int roleId) throws SQLException;

    public void updateRole(int roleId) throws SQLException;

    public void removeRole(int roleId) throws SQLException;

}
