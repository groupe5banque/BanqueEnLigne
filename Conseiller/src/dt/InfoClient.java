package dt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class InfoClient extends Win1{

	//private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoClient window = new InfoClient();
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
	public InfoClient() {
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
		
		JLabel lblInfosPersonnellesDu = new JLabel("Infos personnelles du client:");
		lblInfosPersonnellesDu.setBounds(21, 44, 205, 26);
		frame.getContentPane().add(lblInfosPersonnellesDu);
	}
}
