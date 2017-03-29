
public class Manager {

	private int idManager;
	private String motDePasseManager;
 
/**Constructor
 * 
 */
	public Manager(int idManagger,String motDePasseManager)
	{
		this.idManager = idManager;
		this.motDePasseManager = motDePasseManager;
	}

public int getIdManager() {
	return idManager;
}

public void setIdManager(int idManager) {
	this.idManager = idManager;
}

public String getMotDePasseManager() {
	return motDePasseManager;
}

public void setMotDePasseManager(String motDePasseManager) {
	this.motDePasseManager = motDePasseManager;
}
	
	
	
	
}
