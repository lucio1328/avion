package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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

    //==============================================================================
    public static List<Vol> select(Connection connection) throws Exception {
        List<Vol> vols = new ArrayList<>();

        vols = VolDAO.select(connection);
        for (Vol vol : vols) {
            List<VolVille> volVilles = VolVilleDAO.selectParIdVol(connection, vol.getId());
            vol.setVolVilles(volVilles);
        }

        return vols;
    }

    //==============================================================================
    public static Vol selectParId(Connection connection, Integer idVol) throws Exception {
        Vol vol = null;
        if (idVol != null) {
            vol = VolDAO.selectParId(connection, idVol);
        }

        return vol;
    }

    //==============================================================================
    public static void update(Connection connection, Vol vol, Integer idVol) throws Exception {
        if (vol != null && idVol != null) {
            VolDAO.update(connection, vol, idVol);
        }
    }

    //==============================================================================
    public static void delete(Connection connection, Integer idVol) throws Exception {
        VolDAO.delete(connection, idVol);
    }
}
