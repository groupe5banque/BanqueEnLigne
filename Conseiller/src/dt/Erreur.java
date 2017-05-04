package dt;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Erreur {

	protected JFrame frame;

	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Erreur window = new Erreur();
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
	public Erreur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100,  574, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vos identifiants sont erronés.");
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 17));
		lblNewLabel.setBounds(106, 80, 370, 79);
		frame.getContentPane().add(lblNewLabel);
		
		
		JButton connexion = new JButton("Connexion");
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==connexion){
					
					frame.setVisible(false);
					ConnexionCFO co = new ConnexionCFO();
				    co.getFrame().setVisible(true);
				    
					}
					
			}
		});
		connexion.setBounds(59, 271, 130, 23);
		frame.getContentPane().add(connexion);
	}

}
