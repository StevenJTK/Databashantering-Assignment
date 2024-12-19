package se.steven.database;

import java.sql.SQLException;
import java.util.List;

public interface WorkDAO {

    //anropa metoden med en nu instans av Role // COMPLETED
    public void insertRole(Role role) throws SQLException;


    //se metoden för ändraingar//  COMPLETED
    public List<String> fetchAllRoles() throws SQLException;


    //anropa metoden från main - den här metoden är färdig// COMPLETED
    public Role fetchOneRole(int roleId) throws SQLException;


    //skcika med paramter för roleId, samma som fetchOneROle// COMPLETED
    public void updateRole(int roleId) throws SQLException;


    //skicka med paramter för roleid, samma som ovan// COMPLETED
    public void removeRole(int roleId) throws SQLException;

}
