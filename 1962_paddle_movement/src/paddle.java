import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;
public class paddle extends JPanel implements KeyListener,ActionListener {

	
	private Boolean play = false;
	private int score = 0;
	private int totalBricks = 21;
	private Timer timer;
	private int delay = 3;
	
	private int playerX = 310;
	
	
	public paddle() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay, this);
		timer.start();
	}
	
public void paint(Graphics g) {
		//paddle
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(playerX, 550, 100, 8);   
		g.dispose();

}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 590) {
				playerX = 590;
			}else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX <= 0) {
				playerX = 0;
			}else {
				moveLeft();
			}
		}	
		
	}

	private void moveLeft() {
		// TODO Auto-generated method stub
		play = true;
		playerX-=15;
	}

	private void moveRight() {
		// TODO Auto-generated method stub
		play = true;
		playerX+=15;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(play)
	{
		repaint();
	}
		
	}
	

}
