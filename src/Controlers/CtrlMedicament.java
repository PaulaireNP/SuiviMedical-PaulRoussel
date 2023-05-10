package Controlers;

import Entities.Consultation;
import Entities.Medicament;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedicament
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedicament() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Medicament> getAllMedicaments()
    {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();

        // A vous de jouer

        try {
            ps = cnx.prepareStatement("select , idMedoc, nomMedoc, prixMedoc from medicament");
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicament medicament = new Medicament(rs.getInt("idMedoc"), rs.getString("nomMedoc"),rs.getDouble("prixMedoc"));
                lesMedicaments.add(medicament);
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lesMedicaments;
    }
}
