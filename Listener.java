import java.lang.*;
import java.awt.*;
import java.awt.Toolkit;
//import javax.sound.*;
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

public class Listener implements ActionListener
{
 	static int counter = 0;
	SnakeNLadder o;
	int p1Counter = 0;
	int p2Counter = 0;
	int p3Counter = 0;
	int p4Counter = 0;
	int number,x1,y1;
	double x,y;
	Rectangle r = new Rectangle();
	
	public Listener(SnakeNLadder o) 
	{
		this.o = o;
	}
	
	void randomNumber()
	{
		Random rno = new Random();
		number = rno.nextInt(6)+1;
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		o.text1.setText("");
		if(e.getSource() == o.reset)
		{
			o.guti[0].setBounds(0, 634, 100, 80);
			o.guti[1].setBounds(0, 634, 100, 80);
			o.guti[2].setBounds(0, 634, 100, 80);
			o.guti[3].setBounds(0, 634, 100, 80);
			counter =0;
			p1Counter = 0;
			p2Counter = 0;
			p3Counter = 0;
			p4Counter = 0;
		}
		else if(e.getSource() == o.exit)
		{
			System.exit(0);
		}
		else if(e.getSource()== o.roll)
		{
			//Toolkit.getDefaultToolkit().beep();
			//System.out.println("\007");
			//java.awt.Toolkit.getDefaultToolkit().beep();
			
			/*
			char c = 7;
			System.out.println(c);*/

			
			o.rollingDice.setIcon(new ImageIcon(".//Image//dice.gif"));
			
			/*try        
			{
				Thread.sleep(1000);
			} 
			catch(InterruptedException ex) 
			{
				Thread.currentThread().interrupt();
			}*/
			
			randomNumber();
			
			o.dice.setIcon(new ImageIcon(".//Image//dice"+ number +".png"));
			
			int ladder1[] = new int[]{3,8,28,58,75,80,90};
			int ladder2[] = new int[]{21,30,84,77,86,100,91};
			
			int snake1[] = new int[]{17,52,57,62,88,95,97};
			int snake2[] = new int[]{13,29,40,22,18,51,79};
			
			if(counter%(o.noOfPlayer) == 0)
			{
				counter++;
				
				if((p1Counter+number)<101 && p2Counter<100 && p3Counter<100 && p4Counter<100)
				{
					p1Counter = p1Counter+number;
					r = o.image[p1Counter].getBounds();
					x = r.getX();
					y = r.getY();
					x1=(int)Math.round(x);
					y1=(int)Math.round(y);
					
					o.guti[0].setBounds(x1, y1, 100, 80);
					
					for(int i=0; i<7; i++)
					{
						if(p1Counter == ladder1[i])
						{
							o.text1.setText(o.playerName[0].getText() + " got a LADDER");
							System.out.println("\007");
							r = o.image[ladder2[i]].getBounds();
							x = r.getX();
							y = r.getY();
							x1=(int)Math.round(x);
							y1=(int)Math.round(y);
							
							o.guti[0].setBounds(x1, y1, 100, 80);
							
							p1Counter = ladder2[i];
							
						}
					}
					
					for(int i=0; i<7; i++)
					{
						if(p1Counter == snake1[i])
						{
							o.text1.setText(o.playerName[0].getText() + " got a SNAKE");
							System.out.println("\007");
							r = o.image[snake2[i]].getBounds();
							x = r.getX();
							y = r.getY();
							x1=(int)Math.round(x);
							y1=(int)Math.round(y);
							
							o.guti[0].setBounds(x1, y1, 100, 80);
							
							p1Counter = snake2[i];
						}
					}
				}
				
			}
			
			else if(counter%(o.noOfPlayer) == 1)
			{
				counter++;
				if((p2Counter+number)<101 && p1Counter<100 && p3Counter<100 && p4Counter<100)
				{
					p2Counter = p2Counter+number;
					r = o.image[p2Counter].getBounds();
					x = r.getX();
					y = r.getY();
					x1=(int)Math.round(x);
					y1=(int)Math.round(y);
					
					o.guti[1].setBounds(x1, y1, 100, 80);
					
					for(int i=0; i<7; i++)
					{
						
						if(p2Counter == ladder1[i])
						{
							o.text1.setText(o.playerName[1].getText() + " got a LADDER");
							System.out.println("\007");
							r = o.image[ladder2[i]].getBounds();
							x = r.getX();
							y = r.getY();
							x1=(int)Math.round(x);
							y1=(int)Math.round(y);
							
							o.guti[1].setBounds(x1, y1, 100, 80);
							
							p2Counter = ladder2[i];
						}
					}
					
					for(int i=0; i<7; i++)
					{
						
						if(p2Counter == snake1[i])
						{
							o.text1.setText(o.playerName[1].getText() + " got a SNAKE");
							System.out.println("\007");
							r = o.image[snake2[i]].getBounds();
							x = r.getX();
							y = r.getY();
							x1=(int)Math.round(x);
							y1=(int)Math.round(y);
							
							o.guti[1].setBounds(x1, y1, 100, 80);
							
							p2Counter = snake2[i];
						}
					}
				}
			}
			
			else if(counter%(o.noOfPlayer) == 2)
			{
				counter++;
				if((p3Counter+number)<101 && p2Counter<100 && p1Counter<100 && p4Counter<100)
				{
					p3Counter = p3Counter+number;
					r = o.image[p3Counter].getBounds();
					x = r.getX();
					y = r.getY();
					x1=(int)Math.round(x);
					y1=(int)Math.round(y);
					
					o.guti[2].setBounds(x1, y1, 100, 80);
					
					for(int i=0; i<7; i++)
					{
						if(p3Counter == ladder1[i])
						{
							o.text1.setText(o.playerName[2].getText() + " got a LADDER");
							System.out.println("\007");
							r = o.image[ladder2[i]].getBounds();
							x = r.getX();
							y = r.getY();
							x1=(int)Math.round(x);
							y1=(int)Math.round(y);
							
							o.guti[2].setBounds(x1, y1, 100, 80);
							
							p3Counter = ladder2[i];
						}
					}
					
					for(int i=0; i<7; i++)
					{
						if(p3Counter == snake1[i])
						{
							o.text1.setText(o.playerName[2].getText() + " got a SNAKE");
							System.out.println("\007");
							r = o.image[snake2[i]].getBounds();
							x = r.getX();
							y = r.getY();
							x1=(int)Math.round(x);
							y1=(int)Math.round(y);
							
							o.guti[2].setBounds(x1, y1, 100, 80);
							
							p3Counter = snake2[i];
						}
					}
				}
			}
			
			else if(counter%(o.noOfPlayer) == 3)
			{
				counter++;
				if((p4Counter+number)<101 && p2Counter<100 && p3Counter<100 && p1Counter<100)
				{
					p4Counter = p4Counter+number;
					r = o.image[p4Counter].getBounds();
					x = r.getX();
					y = r.getY();
					x1=(int)Math.round(x);
					y1=(int)Math.round(y);
					
					o.guti[3].setBounds((x1-23), (y1-3), 100, 80);
					
					for(int i=0; i<7; i++)
					{
						if(p4Counter == ladder1[i])
						{
							o.text1.setText(o.playerName[3].getText() + " got a LADDER");
							System.out.println("\007");
							r = o.image[ladder2[i]].getBounds();
							x = r.getX();
							y = r.getY();
							x1=(int)Math.round(x);
							y1=(int)Math.round(y);
							
							o.guti[3].setBounds((x1-23), (y1-3), 100, 80);
							
							p4Counter = ladder2[i];
						}
					}
					
					for(int i=0; i<7; i++)
					{
						if(p4Counter == snake1[i])
						{
							o.text1.setText(o.playerName[3].getText() + " got a SNAKE");
							System.out.println("\007");
							r = o.image[snake2[i]].getBounds();
							x = r.getX();
							y = r.getY();
							x1=(int)Math.round(x);
							y1=(int)Math.round(y);
							
							o.guti[3].setBounds((x1-23), (y1-3), 100, 80);
							
							p4Counter = snake2[i];
						}
					}
				}
			}
			
			o.text.setText(o.playerName[counter%o.noOfPlayer].getText() + "'s turn");
			
			if(p1Counter == 100)
			{
				o.text.setText(o.playerName[0].getText() + " has Won!");
			}
			else if(p2Counter == 100)
			{
				o.text.setText(o.playerName[1].getText() + " has Won!");
			}
			else if(p3Counter == 100)
			{
				o.text.setText(o.playerName[2].getText() + " has Won!");
			}
			else if(p4Counter == 100)
			{
				o.text.setText(o.playerName[3].getText() + " has Won!");
			}
		}
		
	}
	
	
}