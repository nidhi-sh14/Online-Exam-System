package mypack;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class MyFrame2 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JLabel l1;
	JButton b1;
	JButton b2;
	public MyFrame2() throws IOException
	{
		super("MyFrame2");
		setLayout(null);
		l1=new JLabel("Conduct Exams");
		l1.setFont(new Font("Fugaz One", Font.BOLD,48));
		l1.setForeground(Color.blue);
		
		b1=new JButton("Login");
		
		b2=new JButton("Register");
		
		b1.setFont(new Font("Arial", Font.BOLD, 20));
		b2.setFont(new Font("Arial", Font.BOLD, 20));
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\nidhi\\Documents\\NetBeansProjects\\mypack\\src\\mypack\\plannn.jpg"));
		//JLabel.setIcon(new ImageIcon(new ImageIcon("img.jpg").getImage().getScaledInstance(20, 20, 50,50)));
		//JLabel2.setIcon(imageIcon);
		add(background);
		/*background.setLayout(new FlowLayout());
		background.add(l1);
		background.add(l2);
	
		background.add(l3);
		background.add(t3);
		background.add(b1);*/
		background.setLayout(null);
		background.add(l1);
		
		background.add(b1);
		background.add(b2);
		l1.setBounds(310,5,800,100);
		b1.setBounds(260,300,200,100);
		b2.setBounds(560,300,200,100);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			try {
				new UserLoginDemo();
				this.dispose();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==b2)
		{
			try {
				JOptionPane.showMessageDialog(this, "register invoked");
				new UserRegister();
				this.dispose();
				System.out.println("register.............");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		
		}
	}
	

