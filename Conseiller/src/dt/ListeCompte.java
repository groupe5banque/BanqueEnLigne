package dt;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ListeCompte extends Win1{

	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeCompte window = new ListeCompte();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ListeCompte() {
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
		
		JLabel lblNewLabel = new JLabel("Liste des comptes:");
		lblNewLabel.setBounds(26, 42, 138, 29);
		frame.getContentPane().add(lblNewLabel);
	}

}
