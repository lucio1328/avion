package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entite.Vol;

public class VolDAO {

    //==============================================================================
    public static void insert(Vol vol) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = db.Connection.getConnectionBDD();
            connection.setAutoCommit(false);
            String sql = "INSERT INTO vol (id_avion, date_depart, duree, heure_reservation_avant_vol, heure_annulation_reservation_avant_vol) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, vol.getAvion());
            preparedStatement.setTimestamp(2, vol.getDateDepart());
            preparedStatement.setDouble(3, vol.getDuree());
            preparedStatement.setInt(4, vol.getHeureReservationAvantVol());
            preparedStatement.setInt(5, vol.getHeureAnnulatioReservationAvantVol());

            preparedStatement.executeUpdate();
            connection.commit();
        }
        catch (Exception e) {
            if(connection != null) connection.rollback();
            throw new Exception(e.getMessage());
        }
        finally {
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        }
    }

    //==============================================================================
    public static List<Vol> select() throws Exception {
        List<Vol> vols = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = db.Connection.getConnectionBDD();
            String sql = "SELECT * FROM vol";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer idAvion = resultSet.getInt("id_avion");
                Timestamp dateDepart = resultSet.getTimestamp("date_depart");
                Double duree = resultSet.getDouble("duree");
                Integer heureReservationAvantVol = resultSet.getInt("heure_reservation_avant_vol");
                Integer heureAnnulatioReservationAvantVol = resultSet.getInt("heure_annulation_reservation_avant_vol");

                Vol vol = new Vol(id, idAvion, dateDepart, duree, heureReservationAvantVol, heureAnnulatioReservationAvantVol);

                vols.add(vol);
            }
        }
        catch (Exception e) {
            throw new Exception("La selection a echoue!");
        }
        finally {
            if(resultSet != null) resultSet.close();
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        }
        return vols;
    }

    //==============================================================================
    public static Vol selectParId(Integer idVol) throws Exception {
        Vol vol = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = db.Connection.getConnectionBDD();
            String sql = "SELECT * FROM vol where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idVol);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer idAvion = resultSet.getInt("id_avion");
                Timestamp dateDepart = resultSet.getTimestamp("date_depart");
                Double duree = resultSet.getDouble("duree");
                Integer heureReservationAvantVol = resultSet.getInt("heure_reservation_avant_vol");
                Integer heureAnnulatioReservationAvantVol = resultSet.getInt("heure_annulation_reservation_avant_vol");

                vol = new Vol(id, idAvion, dateDepart, duree, heureReservationAvantVol, heureAnnulatioReservationAvantVol);
            }
        }
        catch (Exception e) {
            throw new Exception("La selection a echoue!");
        }
        finally {
            if(resultSet != null) resultSet.close();
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        }
        return vol;
    }

    //==============================================================================
    public void update(Vol vol, Integer idVol) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = db.Connection.getConnectionBDD();
            String sql = "UPDATE vol SET id_avion = ?, date_depart = ?, duree = ?, heure_reservation_avant_vol = ?, heure_annulation_reservation_avant_vol = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, vol.getAvion());
            preparedStatement.setTimestamp(2, vol.getDateDepart());
            preparedStatement.setDouble(3, vol.getDuree());
            preparedStatement.setInt(4, vol.getHeureReservationAvantVol());
            preparedStatement.setInt(5, vol.getHeureAnnulatioReservationAvantVol());
            preparedStatement.setInt(6, idVol);

            preparedStatement.executeUpdate();
            connection.commit();
        }
        catch (Exception e) {
            if(connection != null) connection.rollback();
            throw new Exception(e.getMessage());
        }
        finally {
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        }
    }

    //==============================================================================
    public static void delete(Integer id) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = db.Connection.getConnectionBDD();
            String sql = "DELETE FROM vol where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            if(connection != null) connection.rollback();
            throw new Exception("La suppression a echoue!");
        }
        finally {
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        }
    }
}
