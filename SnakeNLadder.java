import java.lang.*;
import java.awt.*;
import java.awt.color.*;
import java.awt.image.*;
import java.awt.event.*;
import java.math.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.*;
import java.util.Random;
import java.io.*;

public class SnakeNLadder extends JFrame
{
	int noOfPlayer;
	JFrame frame = new JFrame("Snake and Ladder");
	JLabel board;
	JLabel image[] = new JLabel[101];
	JLabel rollingDice = new JLabel();
	JLabel dice = new JLabel();
	JLabel  playerName[] = new JLabel[4];
	JLabel text = new JLabel();
	JLabel text1 = new JLabel();
	JLabel guti[] = new JLabel[4];
	JButton roll , reset, exit;
	Listener listener = new Listener(this);
	//static int counter = 0;
	
	public SnakeNLadder()
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		noOfPlayer =0;
		
		try
		{
			while(noOfPlayer<2 || noOfPlayer>4)
			{
				String s = JOptionPane.showInputDialog("Enter Number of Player[2-4]");
				noOfPlayer = Integer.parseInt(s);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		
		for(int i=0; i<4; i++)
		{
			playerName[i] = new JLabel();
		}
		
		String s;
		for(int i = 1; i<=noOfPlayer; i++)
		{
			s = null;
			while(s==null)
			{
				s = JOptionPane.showInputDialog("Player " + i);
				playerName[i-1].setText(s);
				playerName[i-1].setFont(new Font("Book Antiqua", Font.BOLD, 36));
			}
			
		}
		
		/*JTextField tf = new JTextField();
		tf.setBounds(1000, 600, 150, 150);
		tf.setText(playerName[j].getName());
		frame.add(tf);*/
		
		playerName[0].setForeground(Color.GREEN);
		playerName[1].setForeground(Color.RED);
		playerName[2].setForeground(Color.YELLOW);
		playerName[3].setForeground(Color.BLUE);
		
		int j =0;
		while(j<noOfPlayer)
		{
			playerName[j].setBounds(965, 70*j, 250, 70);
			//playerName[j].setBackground(Color.GREEN);
			//playerName[j].setForeground(Color.GREEN);
			frame.add(playerName[j]);
			j++;
		}
		
		//rollingDice.setIcon(new ImageIcon(".//Image//dice.gif"));
		rollingDice.setBounds(970, 300, 100, 100);
		frame.add(rollingDice);
		
		dice.setBounds(1070, 300, 100, 100);
		frame.add(dice);
		
		roll = new JButton();
		roll.setText("Roll");
		roll.setBounds(980, 450, 110, 50);
		roll.setFont(new Font("forte",Font.BOLD,30));
		roll.addActionListener(listener);
		frame.add(roll);
		
		text.setText("Roll the dice to start");
		text.setBounds(950, 500, 300, 50);
		text.setFont(new Font("forte",Font.ITALIC,20));
		frame.add(text);
		
		text1.setText("");
		text1.setBounds(950, 530, 300, 50);
		text1.setFont(new Font("forte",Font.ITALIC,20));
		frame.add(text1);
		
		reset = new JButton();
		reset.setText("Reset");
		reset.setBounds(980, 580, 120, 50);
		reset.setFont(new Font("forte",Font.BOLD,30));
		reset.addActionListener(listener);
		frame.add(reset);
		
		exit = new JButton();
		exit.setText("Exit");
		exit.setBounds(980, 650, 120, 50);
		exit.setFont(new Font("forte",Font.BOLD,30));
		exit.setBackground(Color.RED);
		exit.addActionListener(listener);
		/*exit.addActionListener
		(
			new actionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					return;
				}
			}
		);*/
		frame.add(exit);
		
		/*
		guti[0] = new JLabel();
		guti[0].setBounds(0, 634, 100, 80);
		guti[0].setIcon(new ImageIcon(".//Image//green.png"));
		frame.add(guti[0]);
		
		guti[1] = new JLabel();
		guti[1].setBounds(0, 634, 100, 80);
		guti[1].setIcon(new ImageIcon(".//Image//red.png"));
		frame.add(guti[1]);
		
		guti[2] = new JLabel();
		guti[2].setBounds(0, 634, 100, 80);
		guti[2].setIcon(new ImageIcon(".//Image//yellow.png"));
		frame.add(guti[2]);
		
		guti[3] = new JLabel();
		guti[3].setBounds(0, 634, 100, 80);
		guti[3].setIcon(new ImageIcon(".//Image//blue.png"));
		frame.add(guti[3]);*/
		
		for(int i=0; i<noOfPlayer; i++)
		{
			guti[i] = new JLabel();
			guti[i].setBounds(0, 634, 100, 80);
			guti[i].setIcon(new ImageIcon(".//Image//guti"+ i +".png"));
			frame.add(guti[i]);
		}
		
		int k=0;
		for(int i=100; i>90; i--)
		{
			image[i] = new JLabel();
			image[i].setBounds(k*94, 0, 94, 80);
			image[i].setIcon(new ImageIcon(".//Image//"+ i +".jpg"));		
			frame.add(image[i]);
			k++;
		}
		k=0;
		for(int i=81; i<91; i++)
		{
			image[i] = new JLabel();
			image[i].setBounds(k*94, 71, 94, 80);
			image[i].setIcon(new ImageIcon(".//Image//"+ i +".jpg"));		
			frame.add(image[i]);
			k++;
		}
		k=0;
		for(int i=80; i>70; i--)
		{
			image[i] = new JLabel();
			image[i].setBounds(k*94, 142, 94, 80);
			image[i].setIcon(new ImageIcon(".//Image//"+ i +".jpg"));		
			frame.add(image[i]);
			k++;
		}
		k=0;
		for(int i=61; i<=70; i++)
		{
			image[i] = new JLabel();
			image[i].setBounds(k*94, 213, 94, 80);
			image[i].setIcon(new ImageIcon(".//Image//"+ i +".jpg"));		
			frame.add(image[i]);
			k++;
		}
		k=0;
		for(int i=60; i>50; i--)
		{
			image[i] = new JLabel();
			image[i].setBounds(k*94, 284, 94, 80);
			image[i].setIcon(new ImageIcon(".//Image//"+ i +".jpg"));		
			frame.add(image[i]);
			k++;
		}
		k=0;
		for(int i=41; i<=50; i++)
		{
			image[i] = new JLabel();
			image[i].setBounds(k*94, 355, 94, 80);
			image[i].setIcon(new ImageIcon(".//Image//"+ i +".jpg"));		
			frame.add(image[i]);
			k++;
		}
		k=0;
		for(int i=40; i>30; i--)
		{
			image[i] = new JLabel();
			image[i].setBounds(k*94, 426, 94, 80);
			image[i].setIcon(new ImageIcon(".//Image//"+ i +".jpg"));		
			frame.add(image[i]);
			k++;
		}
		k=0;
		for(int i=21; i<=30; i++)
		{
			image[i] = new JLabel();
			image[i].setBounds(k*94, 497, 94, 80);
			image[i].setIcon(new ImageIcon(".//Image//"+ i +".jpg"));		
			frame.add(image[i]);
			k++;
		}
		k=0;
		for(int i=20; i>10; i--)
		{
			image[i] = new JLabel();
			image[i].setBounds(k*94, 568, 94, 80);
			image[i].setIcon(new ImageIcon(".//Image//"+ i +".jpg"));		
			frame.add(image[i]);
			k++;
		}
		k=0;
		for(int i=1; i<=10; i++)
		{
			image[i] = new JLabel();
			image[i].setBounds(k*94, 639, 94, 80);
			image[i].setIcon(new ImageIcon(".//Image//"+ i +".jpg"));		
			frame.add(image[i]);
			k++;
		}
		
		board = new JLabel(new ImageIcon(".//Image//board.jpg"));
		board.setBounds(940, 0, 250, 1000);
		frame.add(board);
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(1200,750);
		frame.setResizable(false);
		
		
	}
	
	

	
}
