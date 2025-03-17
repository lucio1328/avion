package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entite.PromotionVol;
import entite.TypeSiege;
import framework.Annotation.Auth;
import framework.Annotation.Controller;
import framework.Annotation.Param;
import framework.Annotation.Post;
import framework.Annotation.Url;
import framework.ModelView;
import service.PromotionService;
import service.TypeSiegeService;
import service.VolService;

@Controller
public class PromotionController {
    @Url("/ajouter_promotion")
    @Auth("admin")
    public ModelView ajouterPromotion(@Param("idVol") String idVol) throws SQLException {
        ModelView modelView = new ModelView("./pages/backoffice/accueil.jsp");
        Connection connection = db.Connection.getConnectionBDD();

        try {
            if (idVol != null) {
                int volId = Integer.parseInt(idVol);
                List<PromotionVol> promotionVols = PromotionService.selectParIdVol(connection, volId);
                List<TypeSiege> typeSieges = TypeSiegeService.select(connection);

                Map<Integer, PromotionVol> promotionsMap = new HashMap<>();
                for (PromotionVol promo : promotionVols) {
                    if (promo.getTypeSiege() != null) {
                        promotionsMap.put(promo.getTypeSiege().getId(), promo);
                    }
                }

                modelView.add("view", "/pages/backoffice/promotion.jsp");
                modelView.add("promotions", promotionsMap);
                modelView.add("idVol", volId);
                modelView.add("typeSieges", typeSieges);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return modelView;
    }

    @Url("/insert_promotion")
    @Auth("admin")
    @Post
    public ModelView insererPromotion(
        @Param("idVol") String idVol,
        @Param("datePromotion") String datePromotion,
        @Param("promotionVols") PromotionVol[] promotionVols) throws SQLException {

        ModelView modelView = new ModelView("./pages/backoffice/accueil.jsp");
        Connection connection = db.Connection.getConnectionBDD();

        try {
            if (idVol != null && promotionVols != null) {
                int volId = Integer.parseInt(idVol);

                for (PromotionVol promo : promotionVols) {
                    if (promo.getTypeSiege() != null && promo.getVol() != null) {
                        if (datePromotion != null) {
                            promo.setVol(VolService.selectParId(connection, volId));
                            promo.setDatePromotion(Timestamp.valueOf(datePromotion));
                        }

                        PromotionService.ajouterPromotion(connection, promo);
                    }
                }

                modelView.add("view", "/pages/backoffice/promotion.jsp");
                modelView.add("message", "Promotions enregistrées avec succès !");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            modelView.add("error", "Erreur lors de l'enregistrement.");
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return modelView;
    }
}
