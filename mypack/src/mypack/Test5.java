package mypack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Test5 extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	Test5(String s)
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
			l.setText("Que1:  Which of the following is not an operating system?");
			jb[0].setText("Windows");
            jb[1].setText("Linux");
            jb[2].setText("Oracle");
            jb[3].setText("DOS");	
		}
		if(current==1)
		{
			l.setText("Que2: What is the maximum length of the filename in DOS? ");
			jb[0].setText("4");
            jb[1].setText("5");
            jb[2].setText("8");
            jb[3].setText("12");
		}
		if(current==2)
		{
			l.setText("Que3: When was the first operating system developed?");
			jb[0].setText("1948");
            jb[1].setText("1949");
            jb[2].setText("1950");
            jb[3].setText("1951");
		}
		if(current==3)
		{
			l.setText("Que4:Which of the following is the extension of Notepad? ");
			jb[0].setText(".txt");
            jb[1].setText(".xls");
            jb[2].setText(".ppt");
            jb[3].setText(".bmp");
		}
		if(current==4)
		{
			l.setText("Que5: What else is a command interpreter called?");
			jb[0].setText("prompt");
            jb[1].setText("kernal");
            jb[2].setText("shell");
            jb[3].setText("command");
		}
		if(current==5)
		{
			l.setText("Que6:  What is the full name of FAT?");
			jb[0].setText("File attribute table");
            jb[1].setText("File allocation table");
            jb[2].setText("Font attribute table");
            jb[3].setText("Format allocation table");
		}
		if(current==6)
		{
			l.setText("Que7:What is the mean of the Booting in the operating system? ");
			jb[0].setText("Restarting computer");
            jb[1].setText("Install the program");
            jb[2].setText("To scan");
            jb[3].setText("To turn of");
		}
		if(current==7)
		{
			l.setText("Que8: Banker's algorithm is used?");
			jb[0].setText("To prevent deadlock");
            jb[1].setText("To deadlock recovery");
            jb[2].setText("To solve the deadlock");
            jb[3].setText("None of these");		
		}
		if(current==8)
		{
			l.setText("Que9: When you delete a file in your computer, where does it go?");
			jb[0].setText("Recycle bin");
            jb[1].setText("Hard disk");
            jb[2].setText("Taskbar");
            jb[3].setText("None of these");
		}
		if(current==9)
		{
			l.setText("Que10: Which is the Linux operating system?");
			jb[0].setText("Private operating system");
            jb[1].setText("Windows operating system");
            jb[2].setText("Open-source operating system");
            jb[3].setText("None of these");
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
