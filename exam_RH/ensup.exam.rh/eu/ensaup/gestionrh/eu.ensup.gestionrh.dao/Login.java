package eu.ensaup.gestionrh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import eu.ensup.gestionrh.domaine.*;


public class Login {

	public static List<Salarie> login(String login,String pwd){

		List<Salarie>listSalarie = new ArrayList<>();

		try{  
			Connection con= AccesBd.Connexion();  
			PreparedStatement ps=con.prepareStatement("select * from Salarie where login=? and password=?");  
			ps.setString(1,login);  
			ps.setString(2,pwd);
			ResultSet rs =ps.executeQuery();  
			if(rs.next()){  				
				Salarie salarie = new Salarie();
				salarie.setNom(rs.getString("Nom"));
				salarie.setPrenom(rs.getString("Prenom"));
				salarie.setEmail(rs.getString("email"));
				salarie.setAdresse(rs.getString("Adresse"));
				salarie.setFonction(rs.getString("Fonction"));
				salarie.setDate(rs.getString("DateEmbauche"));
				salarie.setLogin(rs.getString("login"));
				salarie.setPassword(rs.getString("password"));
				listSalarie.add(salarie);
			} 
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return listSalarie;

	}
}