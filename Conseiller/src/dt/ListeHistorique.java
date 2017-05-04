package dt;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ListeHistorique extends Win1{

	//private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeHistorique window = new ListeHistorique();
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
	public ListeHistorique() {
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
		
		JLabel lblNewLabel = new JLabel("Liste des historique:");
		lblNewLabel.setBounds(29, 42, 175, 38);
		frame.getContentPane().add(lblNewLabel);
	}

}
