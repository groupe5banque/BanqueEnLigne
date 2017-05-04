package dt;

import java.awt.EventQueue;
import dt.PageAccueil;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import dt.Main;
public class ConnexionCFO {


	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionCFO window = new ConnexionCFO();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnexionCFO() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setForeground(new Color(0, 128, 0));
		getFrame().getContentPane().setFont(new Font("Agency FB", Font.BOLD, 14));
		getFrame().setBounds(100, 100, 574, 395);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblVotreIdentifiant = new JLabel("Email");
		lblVotreIdentifiant.setFont(new Font("Arial Black", Font.ITALIC, 11));
		lblVotreIdentifiant.setBounds(90, 132, 130, 22);
		getFrame().getContentPane().add(lblVotreIdentifiant);
		
		textField = new JTextField();
		textField.setBounds(263, 133, 156, 20);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblVotreMotDe = new JLabel("Mot de passe");
		lblVotreMotDe.setFont(new Font("Arial Black", Font.ITALIC, 11));
		lblVotreMotDe.setBounds(90, 199, 130, 14);
		getFrame().getContentPane().add(lblVotreMotDe);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(263, 196, 156, 20);
		getFrame().getContentPane().add(passwordField);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnQuitter){
					getFrame().setVisible(false);
					}
					
			}
		});
		btnQuitter.setBounds(63, 271, 89, 23);
		getFrame().getContentPane().add(btnQuitter);
		
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.getText();
				passwordField.getText();
				ArrayList <String> con= new ArrayList <String> ();
				con.add(textField.getText());
				con.add(passwordField.getText());
				
				final String rs = null;
				Socket socket;
				String host = "localhost";
				 final BufferedReader in ;
				 final PrintWriter out;
				 final PrintWriter out1;
				 final Scanner sc = new Scanner (System.in);// Pour lire à partir du clavier
				 
				 
				 try {
					 /*
					  * Contenant les informations du serveur (port et adresse IP ou nom d'hote)
					  * 127.0.0.1 address local
					  */
					
					
					 socket = new Socket(host, 5000);
					 
	
					 
					 // Flux pour envoyer 
					 out = new PrintWriter(socket.getOutputStream());
					 out1 = new PrintWriter(socket.getOutputStream());
					 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					 ObjectOutputStream ou = new ObjectOutputStream(socket.getOutputStream());
					 ObjectInputStream OUT = new ObjectInputStream(socket.getInputStream());
					 

					 /*
					  * Il faut creer deux processus (threads) parce que l'envoi et la reception se font simultanemant cela nous permet d'envoyer 
					  * et de recevoir des messages em meme temps
					  */
				Thread envoyer = new Thread (new Runnable(){
					
					 Object obj;
					  List s;
					  
					@Override
					public void run() {
						// TODO Auto-generated method stub
						String str = null;
						
						try {
							ou.writeObject(con);
							ou.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						// receive data from server
						
						try {
							
							while((str = in.readLine()) != null) {
								
								System.out.println(str);
								
								if (str.equals("Identifiants corrects")) {
									getFrame().setVisible(false);
									PageAccueil pa = new PageAccueil();
								    pa.frame.setVisible(true);
						
								}
								
								if (str.equals("Identifiants erronés")) {
									getFrame().setVisible(false);
									Erreur er = new Erreur();
								    er.frame.setVisible(true);
						
								}
								
							}
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							
							
							try {
								socket.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
					}
					
				});

				envoyer.start();
				
			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
							
			}
		});
		
		btnConnexion.setBounds(359, 271, 130, 23);
		getFrame().getContentPane().add(btnConnexion);
		
		JLabel label = new JLabel("");
		Image img= new ImageIcon (this.getClass().getResource("/utilisateur.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(230, 11, 169, 99);
		getFrame().getContentPane().add(label);
		
		JLabel lblBienvenueSurVotre = new JLabel("Bienvenue dans votre espace");
		lblBienvenueSurVotre.setForeground(new Color(128, 0, 0));
		lblBienvenueSurVotre.setBackground(SystemColor.activeCaption);
		lblBienvenueSurVotre.setFont(new Font("Agency FB", Font.BOLD, 14));
		lblBienvenueSurVotre.setBounds(31, 50, 176, 14);
		getFrame().getContentPane().add(lblBienvenueSurVotre);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
