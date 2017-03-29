import java.sql.Date;

public class Client {
 
	private int idClient;
	private String nomClient;
	private Date dateNaissanceClient;
	private String civiliteClient;
	private String motDePasseClient;
	private String EmailClient;

	/**Constructor par default
	 * 
	 */
	public Client()
	{
		this.idClient = (Integer) null;
		this.nomClient = null;
		this.civiliteClient = null;
		this.dateNaissanceClient = null;
		this.EmailClient = null;
		this.motDePasseClient = null;
	}
	/**Constructor
	 * 
	 * @param idClient
	 * @param nomClient
	 * @param dateNaissanceClient
	 * @param civiliteClient
	 * @param motDePasseClient
	 * @param EmailClient
	 */
	public Client(int idClient, String nomClient, Date dateNaissanceClient, String civiliteClient, String motDePasseClient, String EmailClient)
	{
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.dateNaissanceClient = dateNaissanceClient;
		this.civiliteClient = civiliteClient;
		this.motDePasseClient = motDePasseClient;
		this.EmailClient = EmailClient;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Date getDateNaissanceClient() {
		return dateNaissanceClient;
	}
	public void setDateNaissanceClient(Date dateNaissanceClient) {
		this.dateNaissanceClient = dateNaissanceClient;
	}
	public String getCiviliteClient() {
		return civiliteClient;
	}
	public void setCiviliteClient(String civiliteClient) {
		this.civiliteClient = civiliteClient;
	}
	public String getMotDePasseClient() {
		return motDePasseClient;
	}
	public void setMotDePasseClient(String motDePasseClient) {
		this.motDePasseClient = motDePasseClient;
	}
	public String getEmailClient() {
		return EmailClient;
	}
	public void setEmailClient(String emailClient) {
		EmailClient = emailClient;
	}
	
	
	
	
	
	
}
