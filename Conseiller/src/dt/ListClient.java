package dt;

import java.awt.*;
import javax.swing.*;

public class ListClient  extends JFrame{

    public  ListClient ()
    {
        //frame
        super("Panel");

        //declaration container
        Container c;
        c=getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(Color.white);
        //declaration des panel avec leurs caracteristiques

        JPanel menu =new JPanel(new GridLayout(0,1,3,3));
        JPanel messageList =new JPanel(new FlowLayout());
        JPanel about=new JPanel(new FlowLayout());

        menu.setBackground(Color.blue);
        messageList.setBackground(Color.cyan);
        messageList.add(new JLabel("'messageList' padder"));
        about.setBackground(Color.green);
        about.add(new JLabel("'about' padder"));

        JPanel menuConstrain = new JPanel(new BorderLayout());
        menuConstrain.setBackground(Color.yellow);

        menuConstrain.add(menu,BorderLayout.NORTH);
        c.add(menuConstrain,BorderLayout.WEST);
        c.add(messageList,BorderLayout.EAST);
        c.add(about,BorderLayout.SOUTH);
        //--------Button---------------------
        JButton button1=new JButton("button1");
        JButton button2=new JButton("Button2");

        menu.add(button1);
        menu.add(button2);
        //-----------------------------

        pack();
        setSize(300,150);
        setVisible(true);
    }


    public static void main(String args[])
    {
        ListClient Message=new ListClient();
        Message.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
