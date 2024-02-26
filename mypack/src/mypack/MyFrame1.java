package mypack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyFrame1 extends JFrame implements ActionListener
{
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6;
	public MyFrame1()
	{
		super("MainFrame");
		setLayout(null);
		l1=new JLabel("Online Examination App");
		l1.setFont(new Font("Fugaz One", Font.BOLD,46));
		l1.setForeground(Color.red);
		
		b1=new JButton("Python Test");
		b2=new JButton("C Test");
		b3=new JButton("C++ Test");
		b4=new JButton("Java Test ");
		b5=new JButton("Operating system Test ");
		b6=new JButton("PHP Test");
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\nidhi\\Documents\\NetBeansProjects\\mypack\\src\\mypack\\plan1.jpg"));
		//JLabel.setIcon(new ImageIcon(new ImageIcon("img.jpg").getImage().getScaledInstance(20, 20, 50,50)));D:\\New folder\\ExamApp\\plan1.jpg
		//JLabel2.setIcon(imageIcon);
		add(background);
        background.setLayout(null);
		background.add(b1);
		background.add(b2);
		background.add(b3);
		background.add(b4);
		background.add(b5);
		background.add(b6);
		background.add(l1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		l1.setBounds(310,5,800,100);
		b1.setBounds(100,200,200,100);
		b2.setBounds(200,300,200,100);
		b3.setBounds(300,400,200,100);
		b4.setBounds(400,500,200,100);
	    b5.setBounds(500,600,200,100);
	    b6.setBounds(600,700,200,100);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			new Test1("first test");
		}
		else if(e.getSource()==b2)
		{
			new Test2("second test");
		}
		else if(e.getSource()==b3)
		{
			new Test3("third test");
		}
		else if(e.getSource()==b4)
		{
			new Test4("fourth test");
		}
		else if(e.getSource()==b5)
		{
			new Test5("fifth test");
		}
		else
		{
			new Test6("sixth test");
		}
	}
}
