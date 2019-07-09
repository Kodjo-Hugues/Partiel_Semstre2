package eu.ensaup.gestionrh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesBd {

	public static Connection cn;
	public static Statement st;

	// TODO Connexion à la BD

	public static Connection Connexion() {
		String url = "jdbc:mysql://localhost:3306/gestion_rh";
		String login = "root";
		String passwd = "";

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			System.out.println("Connection reussi!");
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("hello");
			e.printStackTrace();
		}

		return cn;
	}

	// TODO Déconnexion à la BD

	public void seDeconnecter() {
		try {
			cn.close();
			st.close();
			//System.out.println("Déconnecté. \nBye ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}