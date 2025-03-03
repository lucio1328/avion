package service;

import java.sql.Connection;
import java.util.List;

import dao.AvionDAO;
import entite.Avion;

public class AvionService {
    //==============================================================================
    public static List<Avion> select(Connection connection) throws Exception {
        return AvionDAO.select(connection);
    }

    //==============================================================================
    public static Avion selectParId(Connection connection, Integer idAvion) throws Exception {
        return AvionDAO.selectParId(connection, idAvion);
    }
}
