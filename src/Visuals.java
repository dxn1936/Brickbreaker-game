import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;
public class Visuals extends JPanel implements KeyListener,ActionListener {
	private int i=1;
	private Boolean play = false;
	private int score = 0;
	private int totalBricks = 21;
	private Timer timer;
	private int delay = 3;
	
	private int playerX = 310;
	private int ballPosX = 120;
	private int ballPosY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	public Visuals()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		g.setColor(Color.red);
		g.fillRect(0, 0, 3, 592);     
		g.fillRect(0, 0, 692, 3);		
		g.fillRect(681, 0, 3, 592);	
		
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(playerX, 550, 100, 8);    
		
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(ballPosX, ballPosY, 20, 20);   
		g.dispose();
	}

	
	public void keyPressed(KeyEvent arg0) {
	
		
	}

	
	public void keyReleased(KeyEvent arg0) {
		
	}


	public void keyTyped(KeyEvent arg0) {
	
		
	}

	public void actionPerformed(ActionEvent arg0) {

		
	}
	

}
