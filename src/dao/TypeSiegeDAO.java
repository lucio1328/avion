package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entite.TypeSiege;

public class TypeSiegeDAO {
    //==============================================================================
    public static TypeSiege selectParId(Connection connection, Integer idTypeSiege) throws Exception {
        Boolean estOuvert = false;
        TypeSiege typeSiege = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            String sql = "SELECT * FROM type_siege where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idTypeSiege);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String libelle = resultSet.getString("libelle");

                typeSiege = new TypeSiege(id, libelle);
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
        return typeSiege;
    }

    //==============================================================================
    public static List<TypeSiege> select(Connection connection) throws Exception {
        Boolean estOuvert = false;
        List<TypeSiege> typeSieges = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            if (connection == null) {
                estOuvert = true;
                connection = db.Connection.getConnectionBDD();
            }
            String sql = "SELECT * FROM type_siege";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String libelle = resultSet.getString("libelle");

                TypeSiege typeSiege = new TypeSiege(id, libelle);
                typeSieges.add(typeSiege);
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
        return typeSieges;
    }
}
