package dt;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;


import java.awt.event.ActionEvent;

public class Win1 {

	protected JFrame frame;
   
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win1 window = new Win1();
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
	public Win1() {
		initializeW();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initializeW() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 1100, 32);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPageDaccueil = new JMenuItem("Page d'accueil");
		mnNewMenu.add(mntmPageDaccueil);
		mntmPageDaccueil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            frame.dispose();
    		Main.pageAccueil(); 
            }
        });
		
		
		JMenu mnNewMenu_1 = new JMenu("Consulter un client");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Choisir un client", new ImageIcon("Image/choose.png"));
		mnNewMenu_1.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Main.idChoisi=0;
            Main.typeConsultation="C";
            Main.consulterClient();          
            }
        });
		
		
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Info personelle", new ImageIcon("Image/Client.png"));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	            Main.consulterClient(); 
	            if(Main.idChoisi==0)
	            {
	            	Main.consulterClient();
	            	Main.typeConsultation = "IP";
	            }
	            else{
	            Main.listeClient();
	            }
	            }
	        });
		
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Liste des comptes",new ImageIcon("Image/liste compte.png"));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            frame.dispose();
            if(Main.idChoisi==0)
            {
            	Main.consulterClient();
            	Main.typeConsultation = "LC";
            }
            else{
            Main.listeComClient();
            }
    		
            }
        });
		
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Consulter historiques",new ImageIcon("Image/historique.png"));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            frame.dispose();
            
            if(Main.idChoisi==0)
            {
            	Main.consulterClient();
            	Main.typeConsultation = "LH";
            }
            else{
            	Main.listeHClient();
            }
            
            }
        });
		
		
		JMenu mnSurTousLes = new JMenu("Sur tous les clients");
		mnNewMenu.add(mnSurTousLes);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Liste des clients",new ImageIcon("Image/listeClient.png"));
		mnSurTousLes.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Main.idChoisi=0;
            Main.typeConsultation="C";
            Main.listeClient();
    		
            }
        });
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Liste des comptes",new ImageIcon("Image/liste compte.png"));
		mnSurTousLes.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Main.idChoisi=0;
            Main.typeConsultation="C";
            Main.listeComClient();
    		
            }
        });
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Liste des historiques",new ImageIcon("Image/historique.png"));
		mnSurTousLes.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Main.idChoisi=0;
            Main.typeConsultation="C";
            Main.listeHClient();
    		
            }
        });
	}
}
