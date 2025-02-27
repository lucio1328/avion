package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entite.User;
import util.PasswordUtil;

public class UserDAO {

    //==============================================================================
    public static void insert(Connection connection, User user) throws Exception {
        Boolean estOuvert = false;
        PreparedStatement preparedStatement = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            connection.setAutoCommit(false);
            String sql = "INSERT INTO users (nom, prenom, date_naissance, login, mdp, id_role) VALUES (?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setDate(3, user.getDateNaissance());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, PasswordUtil.encryptPassword(user.getMdp()));
            preparedStatement.setInt(6, user.getRole());

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
    public static User selectParEmailMdp(Connection connection, User user) throws Exception {
        Boolean estOuvert = false;
        User userValiny = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String login2 = null;
        String mdp2 = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            if (user.getLogin() != null) {
                login2 = user.getLogin();
            }
            if (user.getMdp() != null) {
                mdp2 = PasswordUtil.encryptPassword(user.getMdp());
            }

            String sql = "SELECT * FROM users where login = ? and mdp = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login2);
            preparedStatement.setString(2, mdp2);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                Date dateNaissance = resultSet.getDate("date_naissance");
                String login = resultSet.getString("login");
                String mdp = resultSet.getString("mdp");
                Integer idRole = resultSet.getInt("id_role");

                userValiny = new User(id, nom, prenom, dateNaissance, login, mdp, idRole);
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
        return userValiny;
    }
}
