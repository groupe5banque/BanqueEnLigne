package dt;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.Icon;
import javax.swing.JButton;



import javax.swing.*;

// Create a simple GUI window



	
	public class window1 extends JFrame {
	    JMenuBar menubar;
	    JMenu menu, subMenu;
	    JMenuItem item1, item2;
	    JButton b;
	    JPanel p;

	    public window1() {
	    }

	    public window1(String s, int x, int y, int w, int h) {
	        init(s);
	        setLocation(x, y);
	        setSize(w, h);
	        setVisible(true);
	        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	        
	        
	    }

	    void init(String s) {
	    	 p = new JPanel(new BorderLayout());
	         b = new JButton();
	         ImageIcon img = new ImageIcon("client.png");
	         b.setIcon(img);
	         setDefaultCloseOperation(EXIT_ON_CLOSE);
	         setSize(100, 100);
	         p.add(b);
	         add(p);
	         validate();
	         
	        setTitle(s);
	        menubar = new JMenuBar();
	        menu = new JMenu("Menu"); // JMnud��ʵ������һ���˵�

	        /**
	         * һ���˵���
	         */
	       
	        item1 = new JMenuItem("Client",new ImageIcon("client.png")); // �����˵���
	        //Ϊ�˵�������ͼ��
	        ImageIcon icon = new ImageIcon("client.png");
	        item1.setIcon(icon);

	        //ʹ��JMenuItem�Ĺ��췽������ͼ��
	        item2 = new JMenuItem("Compte", new ImageIcon("Compte.png"));
	        item1.setAccelerator(KeyStroke.getKeyStroke('C'));
	        item2.setAccelerator(KeyStroke.getKeyStroke('D'));
	        
	        JButton button = new JButton(new ImageIcon("Compte.png"));
	       
	        
	        
	        menu.add(item1);
	        menu.addSeparator();
	        menu.add(item2);
	       
	       
	        menubar.add(menu); // �˵����м���˵�
	        setJMenuBar(menubar); // ���һ���˵���

	    }
	    
	   
	}

