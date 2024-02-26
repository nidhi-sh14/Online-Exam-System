package mypack;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("unused")
public class UserRegister extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	JPasswordField t5;
	JButton b1; 
	public UserRegister() throws IOException
	{
		super("RegisterFrame");
		setLayout(null);
		b1=new JButton("Login");
		b1.setFont(new Font("Arial", Font.BOLD, 20));
		setSize(300,300);
		setVisible(true);

		l1=new JLabel("Welcome to Register Page");
		l1.setFont(new Font("Fugaz One", Font.BOLD,46));
		l1.setForeground(Color.red);
		
		l2=new JLabel("First Name");
		l2.setFont(new Font("Arial", Font.BOLD,24));
		l2.setForeground(Color.BLUE);
	
		l3=new JLabel("Last Name");
		l3.setFont(new Font("Arial", Font.BOLD,24));
		l3.setForeground(Color.BLUE);
	
		l4=new JLabel("E-Mail");
		l4.setFont(new Font("Arial", Font.BOLD,24));
		l4.setForeground(Color.BLUE);
	

		l5=new JLabel("Password");
		l5.setFont(new Font("Arial", Font.BOLD,24));
		l5.setForeground(Color.BLUE);
	
		
		t1=new JTextField(10);
		t1.setFont(new Font("Arial", Font.BOLD,24));


		t2=new JTextField(10);
		t2.setFont(new Font("Arial", Font.BOLD,24));
	

		t3=new JTextField(10);
		t3.setFont(new Font("Arial", Font.BOLD,24));
	

		t4=new JPasswordField(10);
		t4.setFont(new Font("Arial", Font.BOLD,24));
	
	
		b1=new JButton("Register");
		b1.setFont(new Font("Arial", Font.BOLD, 20));
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\nidhi\\Documents\\NetBeansProjects\\mypack\\src\\mypack\\plan.jpg"));
	
		add(background);
		background.setLayout(null);
		background.add(l1);
		background.add(l2);
		background.add(t1);
		background.add(l3);
		background.add(t2);

		background.add(l4);
		background.add(t3);

		background.add(l5);
		background.add(t4);
		background.add(b1);
		l1.setBounds(310,5,800,100);
		l2.setBounds(260,200,400,40);
		t1.setBounds(400,200,400,40);
		l3.setBounds(260,300,400,40);
		t2.setBounds(400,300,400,40);
		l4.setBounds(260,400,400,40);
		t3.setBounds(400,400,400,40);
		l5.setBounds(260,500,400,40);
		t4.setBounds(400,500,400,40);
		b1.setBounds(460,600,200,60);
		b1.addActionListener(this);
	

		
	}
	public void actionPerformed(ActionEvent e)
	{

		String s1=t1.getText();
		String s2=t2.getText();
		String s3=t3.getText();
		String s4=t4.getText();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test");
				PreparedStatement psmt=con.prepareStatement("insert into user(firstname,lastname,email,password) values(?,?,?,?)");
				String  FirstName=t1.getText();
				String LastName=t2.getText();
				String EMail=t3.getText();
				String Password=t4.getText();
				psmt.setString(1,FirstName);
				psmt.setString(2,LastName);
				psmt.setString(3,EMail);
				psmt.setString(4, Password);
				int a=psmt.executeUpdate();
				if(a>0)
				{
					JOptionPane.showMessageDialog(this, "Registerd Successfully");
					new UserLoginDemo(); 
					this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Registeration failed");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				}
				con.close();
			}
				catch(Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	}

}

