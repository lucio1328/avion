package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entite.Role;

public class RoleDAO {

    //==============================================================================
    public static Role selectParId(Connection connection, Integer idRole) throws Exception {
        Boolean estOuvert = false;
        Role role = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            String sql = "SELECT * FROM role where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idRole);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String libelle = resultSet.getString("type");

                role = new Role(id, libelle);
            }
        }
        catch (Exception e) {
            throw new Exception("La selection a echoue!");
        }
        finally {
            try {
                if(resultSet != null) resultSet.close();
                if(preparedStatement != null) preparedStatement.close();
                if (connection != null && estOuvert) {
                    connection.close();
                }
            }
            catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        return role;
    }
}
