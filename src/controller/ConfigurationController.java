package controller;

import framework.ModelView;

import java.sql.Connection;
import java.sql.SQLException;

import entite.Vol;
import framework.Annotation.Auth;
import framework.Annotation.Controller;
import framework.Annotation.Param;
import framework.Annotation.Url;
import service.VolService;

@Controller
public class ConfigurationController {
    @Url("/configuration")
    @Auth("admin")
    public ModelView config(@Param("idVol") String idVol) throws SQLException {
        ModelView modelView = new ModelView("./pages/backoffice/accueil.jsp");
        Connection connection = db.Connection.getConnectionBDD();

        try {
            modelView.add("view", "/pages/backoffice/configuration.jsp");
            if (idVol != null && !idVol.isEmpty()) {
                modelView.add("vol", VolService.selectParId(connection, Integer.parseInt(idVol)));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            modelView.add("error", e.getMessage());
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

    @Url("/conf")
    @Auth("admin")
    public ModelView config(@Param("idVol") String idVol, @Param("heureReservationAvantVol") String heureReservationAvantVol,
                            @Param("heureAnnulatioReservationAvantVol") String heureAnnulatioReservationAvantVol) throws SQLException {
        Connection connection = db.Connection.getConnectionBDD();

        System.out.println("Id Vol : " + idVol);
        System.out.println(heureReservationAvantVol);
        System.out.println(heureAnnulatioReservationAvantVol);

        try {
            if (idVol != null && heureReservationAvantVol != null && heureReservationAvantVol != null) {
                Integer idV = Integer.parseInt(idVol);
                Vol vol2 = VolService.selectParId(connection, idV);

                vol2.setHeureReservationAvantVol(Integer.parseInt(heureReservationAvantVol));
                vol2.setHeureAnnulatioReservationAvantVol(Integer.parseInt(heureAnnulatioReservationAvantVol));

                VolService.update(connection, vol2, idV);
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

        return config(idVol);
    }
}
