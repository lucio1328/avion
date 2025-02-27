package service;

import java.sql.Connection;

import dao.VolDAO;
import dao.VolVilleDAO;
import entite.Vol;
import entite.VolVille;

public class VolService {
    //==============================================================================
    public Boolean ajouterVol(Connection connection ,Vol vol) throws Exception {
        Boolean estMety = false;
        if (vol != null) {
            estMety = true;
            VolDAO.insert(connection, vol);
            if (vol.getVolVilles().size() != 0) {
                for (VolVille volVille : vol.getVolVilles()) {
                    VolVilleDAO.insert(connection, volVille);
                }
            }
        }

        return estMety;
    }
}
