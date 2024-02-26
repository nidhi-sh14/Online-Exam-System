package mypack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Test3 extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	Test3(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: Identify the correct extension of the user-defined header file in C++. ");
			jb[0].setText(".cpp");
            jb[1].setText(".hg");
            jb[2].setText(".h");
            jb[3].setText(".hf");	
		}
		if(current==1)
		{
			l.setText("Que2: Identify the incorrect constructor type.");
			jb[0].setText("Friend constructor");
            jb[1].setText("Default constructor");
            jb[2].setText("Parameterized constructor");
            jb[3].setText("Copy constructor");
		}
		if(current==2)
		{
			l.setText("Que3: C++ uses which approach?");
			jb[0].setText("Right-Left");
            jb[1].setText("Top-down");
            jb[2].setText("Left-Right");
            jb[3].setText(" Bottom-Up");
		}
		if(current==3)
		{
			l.setText("Que4: Which of the following data type is supported in C++ but not in C?");
			jb[0].setText("int");
            jb[1].setText("bool");
            jb[2].setText("double");
            jb[3].setText("float");
		}
		if(current==4)
		{
			l.setText("Que5: Identify the correct syntax for declaring arrays in C++. ");
			jb[0].setText("array arr[10]");
            jb[1].setText("array{10}");
            jb[2].setText("int arr[10]");
            jb[3].setText("int arr");
		}
		if(current==5)
		{
			l.setText("Que6: Which of the following is â€œaddress of operatorâ€�?");
			jb[0].setText(" * ");
            jb[1].setText(" & ");
            jb[2].setText(" [] ");
            jb[3].setText(" && ");
		}
		if(current==6)
		{
			l.setText("Que7: Which of the following loops is best when we know the number of iterations?");
			jb[0].setText(" While loop ");
            jb[1].setText(" Do while ");
            jb[2].setText(" For loop ");
            jb[3].setText(" All of the above ");
		}
		if(current==7)
		{
			l.setText("Que8: Identify the correct definition of â€˜*â€™ operator in pointer. ");
			jb[0].setText("Address of operator ");
            jb[1].setText("Value of address operator ");
            jb[2].setText("Multiplication operator");
            jb[3].setText("All of the above");		
		}
		if(current==8)
		{
			l.setText("Que9: By which of the following can the if-else statement be replaced?");
			jb[0].setText("Bitwise operator");
            jb[1].setText("Logical operator");
            jb[2].setText("Conditional operator");
            jb[3].setText("Arithmetic operator");
		}
		if(current==9)
		{
			l.setText("Que10: Choose the correct default return value of function.");
			jb[0].setText("int");
            jb[1].setText("void");
            jb[2].setText("char");
            jb[3].setText("float");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}

}
