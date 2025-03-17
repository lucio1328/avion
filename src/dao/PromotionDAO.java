package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entite.PromotionVol;
import entite.TypeSiege;
import entite.Vol;
import service.TypeSiegeService;
import service.VolService;

public class PromotionDAO {
    //==============================================================================
    public static void insert(Connection connection, PromotionVol promotion) throws Exception {
        Boolean estOuvert = false;
        PreparedStatement preparedStatement = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            connection.setAutoCommit(false);
            String sql = "INSERT INTO promotion_vol (id_vol, id_type_siege, nombre_place, pourcentage, date_promotion) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, promotion.getVol().getId());
            preparedStatement.setInt(2, promotion.getTypeSiege().getId());
            preparedStatement.setInt(3, promotion.getNombrePlace());
            preparedStatement.setDouble(4, promotion.getPourcentage());
            preparedStatement.setTimestamp(5, promotion.getDatePromotion());

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
    public static List<PromotionVol> selectParIdVol(Connection connection, Integer idVol) throws Exception {
        Boolean estOuvert = false;
        List<PromotionVol> promotions = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            String sql = "SELECT * FROM promotion_vol where id_vol = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idVol);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer idVol2 = resultSet.getInt("id_vol");
                Integer idTypeSiege = resultSet.getInt("id_type_siege");
                Integer nombrePlace = resultSet.getInt("nombre_place");
                Double pourcentage = resultSet.getDouble("pourcentage");
                Timestamp datePromotion = resultSet.getTimestamp("date_promotion");

                Vol vol = VolService.selectParId(connection, idVol2);
                TypeSiege typeSiege = TypeSiegeService.selectParId(connection, idTypeSiege);

                PromotionVol promotionVol = new PromotionVol(vol, typeSiege, nombrePlace, pourcentage, datePromotion);
                promotions.add(promotionVol);
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
        return promotions;
    }
}
