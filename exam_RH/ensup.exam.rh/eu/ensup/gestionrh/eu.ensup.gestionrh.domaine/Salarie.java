package eu.ensup.gestionrh.domaine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Salarie {
	
	private String nom;
	private String Prenom;
	private String Email;
	private String Adresse;
	private String Fonction;
	private Date DateEmbauche;
	private String login;
	private String password;
	
	public Salarie() {
		
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}
	
	public void setEmail(String email) {
		this.Email = email;
	}
	
	public void setAdresse(String adresse) {
		this.Adresse = adresse;
	}
	
	public void setFonction(String fonction) {
		this.Fonction = fonction;
	}
	
	public void setDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.DateEmbauche = sdf.parse(date);
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password ) {
		this.password = password;
	}
	
	
}
