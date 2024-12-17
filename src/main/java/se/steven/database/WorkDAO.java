package se.steven.database;

import java.sql.SQLException;
import java.util.List;

public interface WorkDAO {

    //anropa metoden med en nu instans av Role
    public void insertRole(Role role) throws SQLException;


    //se metoden för ändraingar
    public List<String> fetchAllRoles() throws SQLException;


    //anropa metoden från main - den här metoden är färdig
    public Role fetchOneRole(int roleId) throws SQLException;


    //skcika med paramter för roleId, samma som fetchOneROle
    public void updateRole(int roleId) throws SQLException;


    //skicka med paramter för roleid, samma som ovan
    public void removeRole(int roleId) throws SQLException;

}
