package dt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.IOException;

//import javax.swing.JFrame;
//import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import javax.swing.JButton;
import java.util.ArrayList;
import dt.Client;
import javax.swing.JPanel;


public class ListeClient extends Win1{
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeClient window = new ListeClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ListeClient() {
		super();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//JFrame frame = new JFrame();
		//frame.setBounds(100, 100,  574, 395);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Liste des clients:");
		lblNewLabel.setBounds(32, 66, 119, 27);
		frame.getContentPane().add(lblNewLabel);
		
		
		/*ArrayList<Client> ListC = new ArrayList<Client>();
		for(int i=0; i<=10; i++)
		{
			Client c = new Client("nom","prenom","civi","mail","dateN","mdp","nation","type",00000000,"adresse",76100,"ville","pays");
			ListC.add(c);
			
		}*/
		ArrayList<Client> ListC = new ArrayList<Client>();
		if(Main.idChoisi==0)
		{
			try {
				ListC = (ArrayList<Client>) Client1.client1("ListClient","0");
			} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(null, "Echec r¨¦cup¨¦rer la liste client.");
				e.printStackTrace();
			}
		}
		else{
			Client client;
			try {
				client = (Client)Client1.client1("UnClient", String.valueOf(Main.idChoisi));
				ListC.add(client);
			} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(null, "Echec r¨¦cup¨¦rer le client choisi.");
				e.printStackTrace();
			}
			
			
		}
		
		
		DefaultTableModel model = new DefaultTableModel(); 
		
		
		model.addColumn("Nom"); 
		model.addColumn("Prenom"); 
		model.addColumn("Civilit¨¦");
		model.addColumn("Email"); 
		model.addColumn("Date de Naissance"); 
		model.addColumn("Mot de passe"); 
		model.addColumn("Nationalit¨¦"); 
		model.addColumn("Type de compte"); 
		model.addColumn("T¨¦l¨¦phone"); 
		model.addColumn("Adresse"); 
		model.addColumn("Code postal"); 
		model.addColumn("Ville"); 
		model.addColumn("Pays"); 
		
		for(int s=0; s<ListC.size(); s++)
		{
			
			//model.addRow(new Object[]{"nom","prenom","civi","mail","dateN","mdp","nation","type",11111111,"adresse",76100,"ville","pays"});
			model.addRow(new Object[]{ListC.get(s).getNomClient(), ListC.get(s).getPrenomClient(), ListC.get(s).getCiviliteClient(), ListC.get(s).getEmailClient(), ListC.get(s).getDateNaissanceClient(), ListC.get(s).getMotDePasseClient(),ListC.get(s).getNationaliteClient(),ListC.get(s).getTypeCompte(), ListC.get(s).getTelephoneClient(),ListC.get(s).getAdresseClient(),ListC.get(s).getCodepostalClient(),ListC.get(s).getVilleClient(),ListC.get(s).getPaysClient()});
		}
		JTable table = new JTable(model); 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 100, 1000, 300);
		scrollPane.setViewportView(table);
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//table.setFillsViewportHeight(true);
		frame.add(scrollPane,BorderLayout.CENTER);
		
		
		
	}
}
