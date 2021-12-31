package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bo.*;

public class TableDAO {
	private Connection connexion;
	private String nom;
    //--------------------------------Gestion de la connexion-------------------------------------------------
	public TableDAO(String nom, String database, String user) throws Exception {
		this.connexion = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?user=" + user);
		// this.t=classe.getDeclaredConstructor().newInstance();
		this.nom = nom;
	}

	public Connection getConnexion() {
		return connexion;
	}

	public TableDAO(String nom, String database, String user, String password) throws Exception {
		this.connexion = DriverManager
				.getConnection("jdbc:mysql://localhost/" + database + "?user=" + user + "&password=" + password);
		this.nom = nom;
	}

	public void close() throws SQLException {
		this.connexion.close();
	}
   //--------------------------- SELECT * FROM TABLE -----------------------------------------------------
	public List<Table> selectAll() throws Exception {
		Table table=new Table(this.nom);
		List<Table> resultat = new ArrayList<>();
		PreparedStatement preparedStatement = this.connexion.prepareStatement("SELECT * FROM " + this.nom);
		ResultSet resultSet = preparedStatement.executeQuery(); // select
		
		int nbrColonne = resultSet.getMetaData().getColumnCount(); // pour récuperer le nombre de colonne
		List<String> colonnes = new ArrayList<>();
		for (int i = 1; i <= nbrColonne; i++) {
			colonnes.add(resultSet.getMetaData().getColumnName(i)); // pour recuperer le nom de la colonne i
		}
		table.setColonnes(colonnes);
		
		while (resultSet.next()) {
			List<Object> donnee = new ArrayList<>();
			for (int i = 1; i <= nbrColonne; i++) {
				donnee.add(resultSet.getObject(i));
			}
			table.setDonnee(donnee);
			resultat.add(table.clone());
		}
		preparedStatement.close();
		return resultat;
	}
	 //-----------------------------------------SELECT * FROM TABLE WHERE ID = ----------------------------------------------
	public Table selectById(int id) throws Exception {
		Table table=new Table(this.nom);
		PreparedStatement prepareStatement = this.connexion.prepareStatement("SELECT * FROM " + this.nom + " WHERE id=" + id);
		
		ResultSet resultSet = prepareStatement.executeQuery(); // select
		int nbrColonne = resultSet.getMetaData().getColumnCount();
		if (resultSet.next()) {
			List<String> colonnes = new ArrayList<>();
			List<Object> donnee = new ArrayList<>();
			for (int i = 1; i <= nbrColonne; i++) {
				colonnes.add(resultSet.getMetaData().getColumnName(i));
				donnee.add(resultSet.getObject(i));
			}
			table.setColonnes(colonnes);
			table.setDonnee(donnee);
			prepareStatement.close();
			return table;
		}
		return null;
	}
	
	 //------------------------------------------------------------------------------------------------------------

	public int insert(Table table) {
		Statement st;
		try {
			List<Object> donnee = table.getDonnee();
			String str = "INSERT INTO " + table.getNomTable() + " VALUES (\"" + donnee.get(0);
			for (int i = 1; i < donnee.size(); i++) {
				str += "\",\"" + donnee.get(i);
			}
			str += "\")";
			st = this.connexion.createStatement();
			st.executeUpdate(str);

		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

	// public void udpate
	public int updateRow(String column, String value, String condition) {
		Statement st;

		try {
			st = this.connexion.createStatement();
			st.executeUpdate("UPDATE " + this.nom + " SETable " + column + "=" + value + " WHERE " + condition);

		} catch (Exception e) {
			// System.out.println(e.getMessage());
			return -1;
		}
		return 1;
	}

	// public void delete
	public int deleteRow(String condition) {
		PreparedStatement st;

		try {
			st = this.connexion.prepareStatement("DELETE FROM " + this.nom + " WHERE " + condition);
			st.executeUpdate();

		} catch (Exception e) {
			return -1;
		}
		return 1;
	}
	
	
}
