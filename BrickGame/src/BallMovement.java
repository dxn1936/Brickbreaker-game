
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JPanel;

public class BallMovement extends JPanel implements KeyListener, ActionListener{
	private int i=1;
	private Boolean play = false;
	private int score = 0;
	private int totalBricks = 21;
	private Timer timer;
	private int delay = 2;
	
	private int playerX = 310;
	private int ballPosX = 120;
	private int ballPosY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	private int check = 1;
	
	public BallMovement() {
		addKeyListener(this);
		setFocusable(true);
		//setFocusTraversalKeysEnabled(true);
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
		g.fillOval(ballPosX, ballPosY, 20, 20); 
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		play=true;
		
		if(play) {
			ballPosX += ballXdir;
			ballPosY += ballYdir;
			if(ballPosX < 0) {				
				ballXdir = -ballXdir;       
			}
			if(ballPosY < 0) {				
				ballYdir = -ballYdir;		
			}
			if(ballPosX > 670) {			
				ballXdir = -ballXdir;		
			}
			
			repaint();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
