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

	
	private Boolean play = false;//because  game  shouldnt play by itself
	private Timer timer;
	private int delay = 3; 
	
	private int playerX = 310; //starting position of paddle
	
	
	
	
	public paddle() {
		addKeyListener(this);   //added to work with keylistener 
		setFocusable(true);    //Events are only dispatched to the component that has focus. 
		//So your KeyEvent will only be dispatched to the panel if it is "focusable" and it has focus.
		setFocusTraversalKeysEnabled(true); //allows to switch from one component to next upon pressing the tab key
		timer = new Timer(delay, this); // creating timer object
		timer.start();
	}
	
public void paint(Graphics g) { //graphics for creating diff shapes for bal,paddle and bricks
		
	//background
	g.setColor(Color.black);
	g.fillRect(1, 1, 692, 592);//rectangle for background
	
	//border
	g.setColor(Color.red);
	g.fillRect(0, 0, 3, 592);     //border rectangle
	g.fillRect(0, 0, 692, 3);		//border rectangle
	g.fillRect(681, 0, 3, 592);
	
	//paddle
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(playerX, 550, 100, 8);   
		g.dispose();
	

}
	@Override
	public void keyPressed(KeyEvent e) { //to detect the arrow key for moving paddle
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
		play = true;
		playerX-=15;
	}

	private void moveRight() {
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
		timer.start();
		repaint(); //its a function to recreate paddle
	}
		
	}
	


