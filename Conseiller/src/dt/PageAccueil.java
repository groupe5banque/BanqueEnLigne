package dt;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class PageAccueil extends Win1{

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageAccueil window = new PageAccueil();
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
	public PageAccueil() {
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
		
		JLabel lblNewLabel = new JLabel("Bienvenue dans votre espace Conseiller.");
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 17));
		lblNewLabel.setBounds(106, 123, 370, 79);
		frame.getContentPane().add(lblNewLabel);
	}

}
