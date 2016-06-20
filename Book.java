import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.ArrayList;
import javax.swing.*;

public class Book extends JApplet implements ActionListener
{
	JLabel display = new JLabel();
	
	Button choiceOne = new Button("Choice 1");
	Button choiceTwo = new Button("Choice 2");
	Button home = new Button("Home");
	Button next = new Button("Next Page");

	int r = 0;
	int c = 0;
	
	String background[][] = { {"temp00.jpg"},
				{"temp10.jpg", "temp12.jpg"), 
				{"temp20.jpg", "temp21.jpg", "temp22.jpg", "temp23.jpg"}, 
				{"temp30.jpg", "temp31.jpg", "temp32.jpg", "temp33.jpg"}};
	

	public void init()
	{
		JPanel buttons = new JPanel(new FlowLayout());

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("Center", display);
		getContentPane().add("South", buttons);

		buttons.add(home);
		home.addActionListener(this);

		if (background[].length == 4)
		{
			buttons.add(next);
			next.addActionListener(this);
		}
		
		if (background[].length != 4)
		{
			buttons.add(choiceOne);
			choiceOne.addActionListener(this);
			
			buttons.add(choiceTwo);
			choiceTwo.addActionListener(this);
		}
	}
	public void showCurrentPage()
	{
		display.setIcon(new ImageIcon(background[r][c]));
	}

	public void showNextPage()
	{
		if (r+1 <= background.length)
			display.setIcon(new ImageIcon(background[r++]));
		else
		{
			r = 0;
			c = 0;
		}
	}

	public void showBackPage()
	{
		if (r-1 > -1)
			display.setIcon(new ImageIcon(background[r--]));
		else
			r = 0;
	}

	public void showHomePage()
	{
		display.setIcon(new ImageIcon(background[0]));
	}

	//Method to choose option 1
	{
		
	}
	//Method to choose option 2
	
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == choiceOne)
			showChoiceOne();
		if (evt.getSource() == choiceTwo)
			showChoiceTwo();	
		if (evt.getSource() == next)
			showNextPage();
		if (evt.getSource() == back)
			showBackPage();
		if (evt.getSource() == home)
			showHomePage();
	}
}
