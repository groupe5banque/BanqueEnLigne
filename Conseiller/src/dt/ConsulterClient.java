package dt;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import da.ClientDAO;
import dt.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class ConsulterClient extends Win1 {
	private JTextField txtIdClient;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ConsulterClient window = new
	 * ConsulterClient(); window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public ConsulterClient() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// JFrame frame = new JFrame();
		// frame.setBounds(100, 100, 574, 395);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.getContentPane().setLayout(null);

		txtIdClient = new JTextField();
		txtIdClient.setText("Id Client");
		txtIdClient.setBounds(320, 99, 66, 21);
		frame.getContentPane().add(txtIdClient);
		txtIdClient.setColumns(10);

		JLabel lblNewLabel = new JLabel("Entrer l'id du client que vous voulez consulter:");
		lblNewLabel.setBounds(40, 99, 270, 21);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Consulter");
		btnNewButton.setBounds(293, 167, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					
					int id = Integer.parseInt(txtIdClient.getText());

					ClientDAO cd = new ClientDAO();
					Client client = cd.getClient(id);
					if (client != null) {
						Main.idChoisi = id;
						switch (Main.typeConsultation) {

						case "C":
							Main.pageAccueil();
							break;
						case "IP":
							Main.infoClient();
							break;
						case "LC":
							Main.listeComClient();
							break;
						case "LH":
							Main.listeHClient();
							break;

						}
						frame.dispose();
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Ce client n'existe pas.");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Vous devez entrer un entier!");

				}

			}
		});
		frame.getContentPane().add(btnNewButton);
	}
}
