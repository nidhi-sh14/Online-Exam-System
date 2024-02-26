package mypack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Test2 extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	Test2(String s)
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
			l.setText("Que1: Who is the father of C language ?");
			jb[0].setText("Steve Jobs");
            jb[1].setText(" James Gosling");
            jb[2].setText(" Dennis Ritchie");
            jb[3].setText(" Rasmus Lerdorf");	
		}
		if(current==1)
		{
			l.setText("Que2: Which of the following is not a valid C variable name?");
			jb[0].setText("int number;");
            jb[1].setText("float rate;");
            jb[2].setText(" int variable_count;");
            jb[3].setText("int $main;");
		}
		if(current==2)
		{
			l.setText("Que3: All keywords in C are in ____________ ?");
			jb[0].setText(" LowerCase letters ");
            jb[1].setText(" UpperCase letters ");
            jb[2].setText("CamelCase letters  ");
            jb[3].setText(" None of the mentioned ");
		}
		if(current==3)
		{
			l.setText("Que4:Which of the following is true for variable names in C?");
			jb[0].setText(" They can contain alphanumeric characters as well as special characters ");
            jb[1].setText(" It is not an error to declare a variable to be one of the keywords(like goto, static)");
            jb[2].setText(" Variable names cannot start with a digit");
            jb[3].setText(" Variable can be of any length ");
		}
		if(current==4)
		{
			l.setText("Que5: Which of the following cannot be a variable name in C? ?");
			jb[0].setText(" volatile");
            jb[1].setText(" true ");
            jb[2].setText(" friend");
            jb[3].setText(" export");
		}
		if(current==5)
		{
			l.setText("Que6: What is short int in C programming?");
			jb[0].setText(" The basic data type of C");
            jb[1].setText(" Qualifier");
            jb[2].setText(" Short is the qualifier and int is the basic data type");
            jb[3].setText(" All of the mentioned ");
		}
		if(current==6)
		{
			l.setText("Que7: Which of the following declaration is not supported by C language?");
			jb[0].setText("String str;");
            jb[1].setText(" char *str;");
            jb[2].setText(" float str = 3e2;");
            jb[3].setText(" Both String str; & float str = 3e2;");
		}
		if(current==7)
		{
			l.setText("Que8: Which keyword is used to prevent any changes in the variable within a C program?");
			jb[0].setText(" immutable");
            jb[1].setText(" mutable");
            jb[2].setText(" const");
            jb[3].setText(" volatile");		
		}
		if(current==8)
		{
			l.setText("Que9: What is an example of iteration in C ?");
			jb[0].setText(" for ");
            jb[1].setText(" while");
            jb[2].setText(" do-while");
            jb[3].setText(" all of the mentioned");
		}
		if(current==9)
		{
			l.setText("Que10: Functions in C Language are always _________ ?");
			jb[0].setText("Internal");
            jb[1].setText("External");
            jb[2].setText("Both Internal and External");
            jb[3].setText("External and Internal are not valid terms for functions");
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
