package dt;
import java.awt.EventQueue;

public class Main {
	
	public static int idChoisi=0;
	public static String typeConsultation = null;
	public static String etat = null;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//PageAccueil pa = new PageAccueil();
					ConnexionCFO cf = new ConnexionCFO();
					cf.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public static void setChoisi(int id)
	{
		idChoisi=id;
	}
	
	public static void pageAccueil(){
		PageAccueil pa=new PageAccueil();
		pa.frame.setVisible(true);
	}
	
	public static void consulterClient(){
		ConsulterClient cc=new ConsulterClient();
		cc.frame.setVisible(true);
	}
	
	public static void infoClient()
	{
		InfoClient ic = new InfoClient();
		ic.frame.setVisible(true);
	}
	
	public static void listeClient()
	{
		ListeClient lc = new ListeClient();
		lc.frame.setVisible(true);
	}
	
	public static void listeHClient()
	{
		ListeHClient lhc = new ListeHClient();
		lhc.frame.setVisible(true);
	}
	
	public static void listeComClient()
	{
		ListeComClient lcc = new ListeComClient();
		lcc.frame.setVisible(true);
	}
	
	
	
	public static void listeCompte(){
		ListeCompte lcom = new ListeCompte();
		lcom.frame.setVisible(true);
	}
	
	public static void listeHistorique(){
		ListeHistorique lh = new ListeHistorique();
		lh.frame.setVisible(true);
	}

	
}
