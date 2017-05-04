package dt;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dt.Client;
import dt.Compte;

public class ListeComClient extends Win1{

	//private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeComClient window = new ListeComClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListeComClient() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		//frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tous les compte du client choisi:");
		lblNewLabel.setBounds(30, 46, 226, 34);
		frame.getContentPane().add(lblNewLabel);
		//Pour cr¨¦er une liste Compte
		ArrayList<Compte> ListCom = new ArrayList<Compte>();
		
		/*for(int i=0; i<=10; i++)
		{
			Compte c = new Compte(2,40001,"FR384928399385",031,80008,"900.3","compte courant");
			ListCom.add(c);
			
		}*/
		
		if(Main.idChoisi==0)
		{
			try {
				ListCom = (ArrayList<Compte>) Client1.client1("ListCompte","0");
			} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(null, "Echec r¨¦cup¨¦rer la liste compte.");
				e.printStackTrace();
			}
		}
		else{
			try {
				ListCom = (ArrayList<Compte>)Client1.client1("ListCompteClient", String.valueOf(Main.idChoisi));
				
			} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(null, "Echec r¨¦cup¨¦rer les comptes du client choisi.");
				e.printStackTrace();
			}
			
			
		}
		
		DefaultTableModel model = new DefaultTableModel(); 	
		
		model.addColumn("IdClient"); 
		model.addColumn("CodeGuichet");
		model.addColumn("Numero de compte");
		model.addColumn("Cl¨¦ RIB");
		model.addColumn("Code Banque");
		model.addColumn("Solde banque");
		model.addColumn("Type compte");
		
		for(int s=0; s<ListCom.size(); s++)
		{	
			//model.addRow(new Object[]{"nom","prenom","civi","mail","dateN","mdp","nation","type",11111111,"adresse",76100,"ville","pays"});
			model.addRow(new Object[]{ListCom.get(s).getIdClient(), ListCom.get(s).getCodeGuichet(), ListCom.get(s).getNumeroDeCompte(), ListCom.get(s).getClefRIB(), ListCom.get(s).getCodeBanque(), ListCom.get(s).getSoldeBanque(),ListCom.get(s).getTypeCompte()});
		}
		
		JTable table = new JTable(model); 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 100, 800, 300);
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//table.setFillsViewportHeight(true);
		frame.add(scrollPane,BorderLayout.CENTER);
		
	}

}
