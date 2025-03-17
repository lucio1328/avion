package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entite.VilleDesservie;

public class VilleDesservieDAO {
    //==============================================================================
    public static List<VilleDesservie> select(Connection connection) throws Exception {
        Boolean estOuvert = false;
        List<VilleDesservie> villeDesservies = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            String sql = "SELECT * FROM ville_desservie";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String pays = resultSet.getString("pays");

                VilleDesservie villeDesservie = new VilleDesservie(id, nom, pays);
                villeDesservies.add(villeDesservie);
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
        return villeDesservies;
    }
}
