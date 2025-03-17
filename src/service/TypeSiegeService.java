package service;

import java.sql.Connection;
import java.util.List;

import dao.TypeSiegeDAO;
import entite.TypeSiege;

public class TypeSiegeService {
    //==============================================================================
    public static TypeSiege selectParId(Connection connection, Integer idTypeSiege) throws Exception {
        return TypeSiegeDAO.selectParId(connection, idTypeSiege);
    }

    //==============================================================================
    public static List<TypeSiege> select(Connection connection) throws Exception {
        return TypeSiegeDAO.select(connection);
    }
}
