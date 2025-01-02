package se.steven.database;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface WorkDAO {

    public void insertRole(Role role) throws SQLException;

    public List<Role> fetchAllRoles() throws SQLException;

    public Role fetchOneRole(int roleId) throws SQLException;

    public void updateRole(Role role) throws SQLException;

    public void removeRole(int roleId) throws SQLException;

}
