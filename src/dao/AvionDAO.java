package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entite.Avion;
import entite.Modele;

public class AvionDAO {

    //==============================================================================
    public static List<Avion> select(Connection connection) throws Exception {
        Boolean estOuvert = false;
        List<Avion> avions = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            String sql = "SELECT * FROM avion";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer idModele = resultSet.getInt("id_modele");
                Date dateFabrication = resultSet.getDate("date_fabrication");

                Modele modele = ModeleDAO.selectParId(connection, idModele);
                Avion avion = new Avion(id, modele, dateFabrication);

                avions.add(avion);
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
        return avions;
    }

    //==============================================================================
    public static Avion selectParId(Connection connection, Integer idAvion) throws Exception {
        Boolean estOuvert = false;
        Avion avion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            String sql = "SELECT * FROM avion where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAvion);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer idModele = resultSet.getInt("id_modele");
                Date dateFabrication = resultSet.getDate("date_fabrication");

                Modele modele = ModeleDAO.selectParId(connection, idModele);
                avion = new Avion(id, modele, dateFabrication);
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
        return avion;
    }
}
