package dt;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dt.Client;
import dt.Compte;
import dt.Historique;

public class ListeHClient extends Win1{

	//private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeHClient window = new ListeHClient();
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
	public ListeHClient() {
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
		
		JLabel lblNewLabel = new JLabel("Tous les historiques du client choisi:");
		lblNewLabel.setBounds(33, 44, 266, 29);
		frame.getContentPane().add(lblNewLabel);
		
		//Créer une liste
		ArrayList<Historique> ListH = new ArrayList<Historique>();
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
		Date d = sdf.parse("21/12/2012");
		 for(int i=0; i<=10; i++)
		 {
			Historique h = new Historique(1,2,d,"Dépôt",300.3,0);
			ListH.add(h);
		 }
		}catch(Exception e)
		{		
		}*/
		
		if(Main.idChoisi==0)
		{
			try {
				ListH = (ArrayList<Historique>) Client1.client1("ListHis","0");
			} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(null, "Echec récupérer la liste des historiques.");
				e.printStackTrace();
			}
		}
		else{
			try {
				ListH = (ArrayList<Historique>)Client1.client1("ListHisClient", String.valueOf(Main.idChoisi));
				
			} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(null, "Echec récupérer les historiques du client choisi.");
				e.printStackTrace();
			}
			
			
		}
		
DefaultTableModel model = new DefaultTableModel(); 
		
		
		model.addColumn("idClient");
		model.addColumn("idCompte");
		model.addColumn("Date");
		model.addColumn("Nature");
		model.addColumn("Credit");
		model.addColumn("Debit");
		
		for(int s=0; s<ListH.size(); s++)
		{
			//model.addRow(new Object[]{"nom","prenom","civi","mail","dateN","mdp","nation","type",11111111,"adresse",76100,"ville","pays"});
			model.addRow(new Object[]{ListH.get(s).getIdClient_historique(), ListH.get(s).getIdCompte_historique(), ListH.get(s).getDate(), ListH.get(s).getNature(), ListH.get(s).getCredit(), ListH.get(s).getDebit()});
	        //System.out.println(ListH.get(s).getDebit());	
		}
		
		JTable table = new JTable(model); 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportView(table);
		//scrollPane.setPreferredSize(new Dimension(400, 300));
		//scrollPane.setMinimumSize(new Dimension(400,300));
		scrollPane.setBounds(0, 100, 1000, 300);
		
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//table.setFillsViewportHeight(true);
		frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
		
		
	}

}
