package mypack;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

//@SuppressWarnings("unused")
public class LoginDemo extends JFrame implements ActionListener    //1
{
	
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1; 
	public LoginDemo() throws IOException
	{
		super("LoginFrame");
		setLayout(null);
		b1=new JButton("Login");
		b1.setFont(new Font("Arial", Font.BOLD, 20));
		setSize(300,300);
		setVisible(true);

		l1=new JLabel("Welcome to Login Page");
		l1.setFont(new Font("Fugaz One", Font.BOLD,46));
		l1.setForeground(Color.red);
		
		l2=new JLabel("UserName");
		l2.setFont(new Font("Arial", Font.BOLD,24));
		l2.setForeground(Color.BLUE);
		//l2.setBounds(10,20,250,50);
		
		l3=new JLabel("Password");
		l3.setFont(new Font("Arial", Font.BOLD,24));
		l3.setForeground(Color.BLUE);
		//l3.setBounds(100,100,120,50);
		//add(l2);add(l3);
		t1=new JTextField(10);
		t1.setFont(new Font("Arial", Font.BOLD,24));
		//t1.setBounds(200,200,300,50);
		t2=new JPasswordField(10);
		t2.setFont(new Font("Arial", Font.BOLD,24));
		
		//t2.setBounds(200,250,300,100);
		b1=new JButton("Login");
		b1.setFont(new Font("Arial", Font.BOLD, 20));
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\nidhi\\Documents\\NetBeansProjects\\mypack\\src\\mypack\\plan.jpg"));
		//JLabel.setIcon(new ImageIcon(new ImageIcon("img.jpg").getImage().getScaledInstance(20, 20, 50,50)));
		//JLabel2.setIcon(imageIcon);
		add(background);
		/*background.setLayout(new FlowLayout());
		background.add(l1);
		background.add(l2);
		background.add(t2);
		background.add(l3);
		background.add(t3);
		background.add(b1);*/
		background.setLayout(null);
		background.add(l1);
		background.add(l2);
		background.add(t1);
		background.add(l3);
		background.add(t2);
		background.add(b1);
		l1.setBounds(310,5,800,100);
		l2.setBounds(260,150,400,40);
		t1.setBounds(400,150,400,40);
		l3.setBounds(260,200,400,40);
		t2.setBounds(400,200,400,40);
		b1.setBounds(460,300,200,60);
		b1.addActionListener(this);
	

		
	}
	public void actionPerformed(ActionEvent e)
	{
		String a=t1.getText();
		String b=t2.getText();
		if(a.equalsIgnoreCase("itm") && b.equalsIgnoreCase("aligarh"))
		{
			JOptionPane.showMessageDialog(this, "login done");
			try {
				new MyFrame2();
				this.dispose();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, " "+e1);
				e1.printStackTrace();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "login failed");
		}
	}

}
