package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entite.VolVille;

public class VolVilleDAO {
    //==============================================================================
    public static void insert(Connection connection, VolVille volVille) throws Exception {
        Boolean estOuvert = false;
        PreparedStatement preparedStatement = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            connection.setAutoCommit(false);
            String sql = "INSERT INTO vol_ville (id_vol, id_ville) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, volVille.getVol());
            preparedStatement.setInt(2, volVille.getVilleDesservie());

            preparedStatement.executeUpdate();
            connection.commit();
        }
        catch (Exception e) {
            if(connection != null) connection.rollback();
            throw new Exception(e.getMessage());
        }
        finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if (connection != null && estOuvert) {
                    connection.close();
                }
            }
            catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
    }

    //==============================================================================
    public static List<VolVille> selectParIdVol(Connection connection, Integer idVol) throws Exception {
        Boolean estOuvert = false;
        List<VolVille> volVilles = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            String sql = "SELECT * FROM vol_ville where id_vol = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idVol);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idVol2 = resultSet.getInt("id_vol");
                Integer idVille = resultSet.getInt("id_ville");

                VolVille volVille = new VolVille(idVol2, idVille);
                volVilles.add(volVille);
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
        return volVilles;
    }
}
