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
	    private String titreNews;
	    /**
		 * Contenu
		 */
		private String contenuNews;
		/** 
		 * Timestamp
		 */
		private Timestamp timestampNews;
		/** 
		 * idimg 
		 */
		private int idimgNews;

	
	public News()
	{
		this.titreNews = null;
		this.contenuNews = null;
		this.timestampNews=null;
		this.idimgNews = 0;	
	}

	/**
	 * Constructeur
	 * @param id 
	 * @param titreNews
	 * @param contenuNews
	 * @param idimgNews
	 */
	public News(String titreNews, String contenuNews, Timestamp timestampNews, int idimgNews) { //importer pour avoir le type timestamp : "import com.sun.jmx.snmp.Timestamp;"
		this.titreNews = titreNews;
		this.contenuNews = contenuNews;
		this.timestampNews = timestampNews; 
		this.idimgNews = idimgNews;
		}
	
	public void setTitreNews(String titreNews) {
		this.titreNews = titreNews;
	}
	
	public String getTitreNews() {
		return titreNews;
		}
	
	public void setContenuNews(String contenuNews) {
		this.contenuNews = contenuNews;
	}
	
	public String getContenuNews() {
		return titreNews;
		}
	
	
	public int getidimgNews() {
		return idimgNews;
		}
	
	public void setIdimgNews(int idimgNews) {
		this.idimgNews = idimgNews;
	}
	
	public Timestamp gettimestampNews() {
		return timestampNews;//à ajouter timestampNews ici
		}

	public String toString() {
		return " [Titre: " +titreNews  + " , Contenu: " + contenuNews
				+ ", Date:" + timestampNews+  ", Image associee:" + idimgNews+ "]";
	}
}