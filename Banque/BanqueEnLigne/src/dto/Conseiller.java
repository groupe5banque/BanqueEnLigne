
public class Conseiller {

	private int idConseiller;
	private String motDePasseConseiler;
	
/**Constructor
 * 
 * @param idConseiller
 * @param motDePasseConseiller
 */
	public Conseiller(int idConseiller, String motDePasseConseiller)
	{
		this.idConseiller = idConseiller;
		this.motDePasseConseiler = motDePasseConseiller;
	}

public int getIdConseiller() {
	return idConseiller;
}

public void setIdConseiller(int idConseiller) {
	this.idConseiller = idConseiller;
}

public String getMotDePasseConseiler() {
	return motDePasseConseiler;
}

public void setMotDePasseConseiler(String motDePasseConseiler) {
	this.motDePasseConseiler = motDePasseConseiler;
}
	
	
}
