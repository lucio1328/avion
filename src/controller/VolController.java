package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entite.Vol;
import framework.ModelView;
import framework.Session;
import framework.Annotation.Auth;
import framework.Annotation.Controller;
import framework.Annotation.Param;
import framework.Annotation.Url;
import service.AvionService;
import service.VolService;

@Controller
public class VolController {
    @Url("/insert_vol")
    @Auth("admin")
    public ModelView  insert() throws SQLException {
        ModelView modelView = new ModelView();
        Connection connection = db.Connection.getConnectionBDD();

        try {
            modelView.setUrl("./pages/backoffice/accueil.jsp");
            modelView.add("view", "/pages/vol/insert.jsp");

            modelView.add("avions", AvionService.select(connection));
        }
        catch (Exception e) {
            e.printStackTrace();
            modelView.add("error",e.getMessage());
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

    @Url("/liste_vol")
    public ModelView  liste(@Param("session") Session session) throws SQLException {
        ModelView modelView = new ModelView("./pages/frontoffice/accueil.jsp");
        modelView.setUrl("./pages/backoffice/accueil.jsp");

        if (session.get("auth").equals("admin")) {
            modelView.add("view", "/pages/vol/liste.jsp");
        }
        Connection connection = db.Connection.getConnectionBDD();

        try {
            List<Vol> vols = VolService.select(connection);
            modelView.add("vols", vols);
        }
        catch (Exception e) {
            e.printStackTrace();
            modelView.add("error",e.getMessage());
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

    @Url("/delete_vol")
    @Auth("admin")
    public ModelView delete(@Param("idVol") String idVol, @Param("session") Session session) throws SQLException {
        Connection connection = db.Connection.getConnectionBDD();

        try {
            if (idVol != null && !idVol.isEmpty()) {
                VolService.delete(connection, Integer.parseInt(idVol));
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
        return liste(session);
    }
}
