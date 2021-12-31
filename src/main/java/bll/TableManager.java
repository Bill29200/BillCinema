package bll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bo.Authentification;
import bo.Table;
import dao.TableDAO;

public class TableManager {
	
	public static List<Table> listTable=new ArrayList<>();
	private  final static String user="root";
	private final static String password="root";
	private final static String database="cinema123";
	
	public static void initList(String nomTable) throws Exception {
		TableDAO table=new TableDAO(nomTable,database, user, password);
		listTable=table.selectAll();
	}
	
	public static List<Table> getList(){
		return listTable;
	}
	 //--------------------------------Gestion de l'authentification -------------------------------------------------
	
		public static boolean authentifier(String login, String mdp) throws Exception
		{
			Authentification Auth = new Authentification();
			Connection connexion;
			 
				connexion = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?user=" + user + "&password=" + password);
				
			PreparedStatement preparedStatement = connexion.prepareStatement("select * from authentification where login ='"+login+"' and mdp ='"+mdp+"'");
			//	PreparedStatement preparedStatement = connexion.prepareStatement("select login, mdp from authentification where login ='bill'");
				
				ResultSet resultSet = preparedStatement.executeQuery();
				boolean res =resultSet.next();
				
				preparedStatement.close();
				connexion.close();
				return res;
				
				
		}
}
