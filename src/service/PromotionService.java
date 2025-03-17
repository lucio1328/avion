package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.PromotionDAO;
import entite.PromotionVol;

public class PromotionService {
    //==============================================================================
    public static List<PromotionVol> selectParIdVol(Connection connection, Integer idVol) throws Exception {
        List<PromotionVol> promotionVols = new ArrayList<>();

        promotionVols = PromotionDAO.selectParIdVol(connection, idVol);
        if (promotionVols == null) {
            promotionVols = new ArrayList<>();
        }
        return promotionVols;
    }

    //==============================================================================
    public static void ajouterPromotion(Connection connection, PromotionVol promotionVol) throws Exception {
        if (promotionVol != null) {
            PromotionDAO.insert(connection, promotionVol);
        }
    }
}
