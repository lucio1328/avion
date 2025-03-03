package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entite.Modele;

public class ModeleDAO {
    //==============================================================================
    public static Modele selectParId(Connection connection, Integer idModele) throws Exception {
        Boolean estOuvert = false;
        Modele modele = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            String sql = "SELECT * FROM modele where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idModele);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String libelle = resultSet.getString("libelle");

                modele = new Modele(id, libelle);
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
        return modele;
    }
}
