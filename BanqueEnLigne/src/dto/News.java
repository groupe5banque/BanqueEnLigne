package dto;

import java.util.Date;

import java.sql.Timestamp;

import dao.*;

/**
 * Classe NEWS
 * @author Robert
 * @version 1.2
 * */

public class News {
		 /**
	     * Titre
	     */
	    private String titre;
	    /**
		 * Contenu
		 */
		private String contenu;
		/**
		 * Theme
		 */
		private String theme;
		/** 
		 * Timestamp
		 */
		private Timestamp timestamp;
		/** 
		 * idimg 
		 */
		private int idimg;
	
	public News()
	{
		this.titre = null;
		this.contenu = null;
		this.theme = null;
		this.timestamp = null;
		this.idimg = 0;	
	}

	/**
	 * Constructeur
	 * @param titre
	 * @param contenu
	 * @param theme
	 * @param idimg
	 **/

	public News(String titre, String contenu, String theme, Timestamp timestamp, int idimg) {
		this.titre = titre;
		this.contenu = contenu;
		this.theme = theme;
		this.timestamp = timestamp; 
		this.idimg = idimg;
		}
	
	
	public String getTitre() {
		return titre;
		}
	
	public void setTitreNews(String titre) {
		this.titre = titre;
	}
	
	public String getContenu() {
		return contenu;
		}
	
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	public String getTheme() {
		return theme;
		}
	
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public int getidimg() {
		return idimg;
		}
	
	public void setidimg(int idimg) {
		this.idimg = idimg;
	}
	
	public Timestamp gettimestamp() {
		return timestamp;
		}
	
	public void settimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
/*
	public String toString() {
		return " [Titre: " + titreNews  + " , Contenu: " + contenuNews
				+ ", Date:" + timestampNews +  ", Image associee:" + idimgNews + "]";
	}
*/
	
}