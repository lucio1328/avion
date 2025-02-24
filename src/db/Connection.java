package db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors du chargement du driver PostgreSQL.", e);
        }
    }

    public static java.sql.Connection getConnectionBDD(String url, String user, String mdp) throws SQLException {
        java.sql.Connection connection = DriverManager.getConnection(url, user, mdp);
        System.out.println("Connexion etablie avec postgresql!");
        return connection;
    }

    public static java.sql.Connection getConnectionBDD() throws SQLException {
        new Connection();
        java.sql.Connection connection = Connection.getConnectionBDD("jdbc:postgresql://localhost:5432/avion", "lucio", "Lucio1328");
        System.out.println("Connexion etablie avec postgresql!");
        connection.setAutoCommit(true);
        return connection;
    }
}
