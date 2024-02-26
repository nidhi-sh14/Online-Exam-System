package mypack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Test1 extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	Test1(String s)
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
			l.setText("Que1: What is the maximum length of a python identifier?");
			jb[0].setText("32");
            jb[1].setText("16");
            jb[2].setText("128");
            jb[3].setText("No fixed length is specified");	
		}
		if(current==1)
		{
			l.setText("Que2: Which of the following concepts is not a part of Python?");
			jb[0].setText("Pointers");
            jb[1].setText("Loops");
            jb[2].setText("Dynamic Typing");
            jb[3].setText("All of the above");
		}
		if(current==2)
		{
			l.setText("Que3: Which of the following statements are used in Exception Handling in Python?");
			jb[0].setText("try");
            jb[1].setText("except");
            jb[2].setText("finally");
            jb[3].setText("All of the above");
		}
		if(current==3)
		{
			l.setText("Que4: Which of the following types of loops are not supported in Python?");
			jb[0].setText("for");
            jb[1].setText("while");
            jb[2].setText("do-while");
            jb[3].setText("None of the above ");
		}
		if(current==4)
		{
			l.setText("Que5: Which of the following is the proper syntax to check if a particular elements is present in a list?");
			jb[0].setText("if ele in list");
            jb[1].setText("if not ele not in list");
            jb[2].setText("Both A and B");
            jb[3].setText("None of the above");
		}
		if(current==5)
		{
			l.setText("Que6: Which of the following functions converts date to corresponding time in Python?");
			jb[0].setText("strptime()");
            jb[1].setText("strftime()");
            jb[2].setText("Both A and B");
            jb[3].setText("None ofthe above");
		}
		if(current==6)
		{
			l.setText("Que7: As what datatype are the *args stored, when passed into a function?");
			jb[0].setText("List");
            jb[1].setText("Tuple");
            jb[2].setText("Dictionary");
            jb[3].setText("None of the above");
		}
		if(current==7)
		{
			l.setText("Que8: Which of the following blocks will always be executed whether an exception is encountered or not in a program?");
			jb[0].setText("try");
            jb[1].setText("finally");
            jb[2].setText("except");
            jb[3].setText("None of these");		
		}
		if(current==8)
		{
			l.setText("Que9: What keyword is used in Python to raise exceptions?");
			jb[0].setText("raise");
            jb[1].setText("try");
            jb[2].setText("goto");
            jb[3].setText("except");
		}
		if(current==9)
		{
			l.setText("Que10: Which  of the following is not a valid set operation in python?");
			jb[0].setText("Union");
            jb[1].setText("Intersection");
            jb[2].setText("difference");
            jb[3].setText("None of the aboves");
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
