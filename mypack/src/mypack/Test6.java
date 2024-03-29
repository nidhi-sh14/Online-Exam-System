package mypack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Test6 extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	Test6(String s)
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
			l.setText("Que1: Who is known as the father of PHP? ");
			jb[0].setText("Drek Kolkevi ");
            jb[1].setText("List Barely");
            jb[2].setText("Rasmus Lerdrof");
            jb[3].setText("None of the above");	
		}
		if(current==1)
		{
			l.setText("Que2:  PHP stands for - ");
			jb[0].setText("Hypertext Preprocessor");
            jb[1].setText("Pretext Hypertext Preprocessor");
            jb[2].setText("Personal Home Processor");
            jb[3].setText("None of the above");
		}
		if(current==2)
		{
			l.setText("Que3: Variable name in PHP starts with -");
			jb[0].setText("! (Exclamation)");
            jb[1].setText("$ (Dollar)");
            jb[2].setText("& (Ampersand)");
            jb[3].setText("# (Hash)");
		}
		if(current==3)
		{
			l.setText("Que4:Which of the following is the default file extension of PHP?");
			jb[0].setText(".php");
            jb[1].setText(".hphp");
            jb[2].setText(".xml");
            jb[3].setText(".html");
		}
		if(current==4)
		{
			l.setText("Que5: Which of the following is not a variable scope in PHP?");
			jb[0].setText("Extern");
            jb[1].setText("Local");
            jb[2].setText("Static");
            jb[3].setText("Global");
		}
		if(current==5)
		{
			l.setText("Que6: Which of the following is correct to add a comment in php?");
			jb[0].setText("& …… &");
            jb[1].setText("// ……");
            jb[2].setText("/* …… */");
            jb[3].setText("Both (b) and (c)");
		}
		if(current==6)
		{
			l.setText("Que7:  Which of the following is used to display the output in PHP?");
			jb[0].setText("echo");
            jb[1].setText("write");
            jb[2].setText("print");
            jb[3].setText("Both (a) and (c)");
		}
		if(current==7)
		{
			l.setText("Que8:Which of the following is the use of strlen() function in PHP? ");
			jb[0].setText("The strlen() function returns the type of string");
            jb[1].setText("The strlen() function returns the length of string");
            jb[2].setText("The strlen() function returns the value of string");
            jb[3].setText("The strlen() function returns both value and type of string");		
		}
		if(current==8)
		{
			l.setText("Que9:Which of the following is used for concatenation in PHP? ");
			jb[0].setText("+ (plus)");
            jb[1].setText("* (Asterisk)");
            jb[2].setText(". (dot)");
            jb[3].setText("append()");
		}
		if(current==9)
		{
			l.setText("Que10:Which of the following starts with __ (double underscore) in PHP?");
			jb[0].setText("Inbuilt constants");
            jb[1].setText("User-defined constants");
            jb[2].setText("Magic constants");
            jb[3].setText("Default constants");
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
