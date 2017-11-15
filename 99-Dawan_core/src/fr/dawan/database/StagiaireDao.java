/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dawan.database;

import fr.dawan.domain.Stagiaire;
import fr.dawan.domain.enums.Genre;
import fr.dawan.domain.enums.Niveau;
import fr.dawan.domain.enums.PriseEnCharge;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author bmarron
 */
public class StagiaireDao {

    public void create(Stagiaire item) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/formation", "root", "dawan742");
        PreparedStatement stmt = cnx.prepareStatement("INSERT INTO stagiaire "
                + "(nom, prenom, civilite, date_naissance, payeur, niveau) "
                + "VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setString(1, item.getNom());
        stmt.setString(2, item.getPrenom());
        stmt.setString(3, item.getCivilite().toString());
        stmt.setDate(4, new Date(item.getDateNaissance().getTime()));
        stmt.setString(5, item.getPayeur().toString());
        stmt.setString(6, item.getNiveauProgrammation().toString());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            item.setId(rs.getInt(1));
        }

        cnx.close();
    }

    public Stagiaire read(int id) throws ClassNotFoundException, SQLException {
        // SELECT * from stagiaire where id = ??
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/formation", "root", "dawan742");
        //PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM stagiaire "
        //       + "WHERE id = ? ");
        //stmt.setInt(1, id);
        //stmt.executeQuery();
        Statement stmt2 = cnx.createStatement();
        ResultSet rs = stmt2.executeQuery("SELECT * FROM stagiaire WHERE id = " + id);
        if (rs.next()) {
            Stagiaire s = new Stagiaire();
            s.setNom(rs.getString("nom"));
            s.setPrenom(rs.getString("prenom"));
            s.setId(rs.getInt("id"));
            s.setDateNaissance(rs.getDate("date_naissance"));
            s.setCivilite(Genre.valueOf(rs.getString("civilite")));
            s.setNiveauProgrammation(Niveau.valueOf("niveau"));
            s.setPayeur(PriseEnCharge.valueOf(rs.getString("payeur")));
            return s;
        }
        cnx.close();
        return null;
    }

    public ArrayList<Stagiaire> readAll() throws ClassNotFoundException, SQLException {
        ArrayList<Stagiaire> resultat = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/formation", "root", "dawan742");
        Statement stmt = cnx.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM stagiaire");
        // Parcours du resultSet
        while (rs.next()) {
            Stagiaire s = new Stagiaire();
            s.setNom(rs.getString("nom"));
            s.setPrenom(rs.getString("prenom"));
            s.setId(rs.getInt("id"));
            s.setDateNaissance(rs.getDate("date_naissance"));
            s.setCivilite(Genre.valueOf(rs.getString("civilite").toUpperCase()));
            s.setNiveauProgrammation(Niveau.valueOf(rs.getString("niveau")));
            s.setPayeur(PriseEnCharge.valueOf(rs.getString("payeur")));
            resultat.add(s);
        }
        cnx.close();
        return resultat;
    }

    public void update(Stagiaire item) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/formation", "root", "dawan742");
        PreparedStatement stmt = cnx.prepareStatement("UPDATE stagiaire SET "
                + "nom = ?, prenom = ?, civilite = ?, date_naissance = ?, payeur = ?, niveau = ? "
                + "WHERE id = ?");
        stmt.setString(1, item.getNom());
        stmt.setString(2, item.getPrenom());
        stmt.setString(3, item.getCivilite().toString());
        stmt.setDate(4, new Date(item.getDateNaissance().getTime()));
        stmt.setString(5, item.getPayeur().toString());
        stmt.setString(6, item.getNiveauProgrammation().toString());
        stmt.setInt(7, item.getId());
        stmt.executeUpdate();
        cnx.close();
    }

    public void delete(Stagiaire item) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/formation", "root", "dawan742");
        Statement stmt = cnx.createStatement();
        stmt.executeUpdate("DELETE FROM stagiaire WHERE id="+item.getId());
        cnx.close();
    }
}
