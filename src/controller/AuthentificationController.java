package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import dao.RoleDAO;
import entite.Role;
import entite.User;
import framework.Annotation.Controller;
import framework.Annotation.Param;
import framework.Annotation.Post;
import framework.Annotation.Url;
import framework.ModelView;
import framework.Session;
import service.UserService;

@Controller
public class AuthentificationController {
    @Url("/")
    public ModelView index() {
        ModelView modelView = new ModelView("index.jsp");
        return modelView;
    }

    @Url("/connection")
    @Post
    public ModelView connection(@Param("user") User user, @Param("session") Session session) throws SQLException {
        ModelView modelView = new ModelView();

        Connection connection = db.Connection.getConnectionBDD();
        try {
            if (user != null) {
                User user2 = UserService.connection(connection, user);
                if (user2 != null) {
                    Role role = RoleDAO.selectParId(connection, user2.getRole());
                    if (role.getType().equalsIgnoreCase("admin")) {
                        modelView.setUrl("./pages/backoffice/accueil.jsp");
                        session.add("user", user);
                        session.add("auth", "admin");
                    }
                    else {
                        modelView.setUrl("./pages/frontoffice/accueil.jsp");
                        session.add("user", user);
                        session.add("auth", "user");
                    }
                }
                else {
                    modelView.setUrl("index.jsp");
                    modelView.add("error","login ou mot de passe incorrect");
                }
            }
            else {
                modelView.setUrl("index.jsp");
                modelView.add("error","login ou mot de passe incorrect");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            modelView.setUrl("index.jsp");
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

    @Url("/creer_admin")
    public ModelView creerAdmin() throws SQLException {
        ModelView modelView = new ModelView("index.jsp");

        Connection connection = db.Connection.getConnectionBDD();

        User user = new User();
        user.setNom("admin");
        user.setPrenom("admin");
        user.setDateNaissance(Date.valueOf("2000-12-02"));
        user.setLogin("admin");
        user.setMdp("admin");
        user.setRole(1);

        try {
            UserService.inscription(connection, user);
        }
        catch (Exception e) {
            e.printStackTrace();
            modelView.setUrl("index.jsp");
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

    @Url("/creer_utilisateur")
    public ModelView creerUtilisateurForm() {
        ModelView modelView = new ModelView("./pages/user/creer_user.jsp");
        return modelView;
    }

    @Url("/creer_utilisateur")
    @Post
    public ModelView creerUtilisateur(@Param("user") User user) throws SQLException {
        ModelView modelView = new ModelView();

        Connection connection = db.Connection.getConnectionBDD();
        try {
            if (user != null) {
                user.setRole(2);
                UserService.inscription(connection, user);
                modelView.setUrl("./pages/user/creer_user.jsp");
                modelView.add("success","Incsription reussie");
            }
            else {
                modelView.setUrl("./pages/user/creer_user.jsp");
                modelView.add("error","Inscription echouee");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            modelView.setUrl("./pages/user/creer_user.jsp");
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

    @Url("/logout")
    public ModelView logout(@Param("session") Session session) {
        ModelView modelView = new ModelView("index.jsp");

        try {
            session.delete("user");
            session.delete("auth");
        }
        catch (Exception e) {
            modelView.add("error", e.getMessage());
        }

        return modelView;
    }
}