
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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener, ActionListener{

	private int i=1;
	private Boolean play = true;
	private int score = 0;
	private int totalBricks = 21;
	private Timer timer;
	private int delay;
	
	private int playerX = 310;
	private int ballPosX = 120;
	private int ballPosY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	private int check = 1;
	private int count = 0;
	private int indicator=0;
	public String name;
	private int paddle_speed;
	private String expert="(expert)";
	private String easy="(easy)";
	
	private MapGenerator map = new MapGenerator(3,7);
	public GamePlay(String username,int d,int ps) {
		delay = d;
		paddle_speed = ps;
		name = username;
		addKeyListener(this);
		setFocusable(true);
		//setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		map.draw((Graphics2D)g);
		
		g.setColor(Color.white);
		g.setFont(new Font("Segoe Script",Font.BOLD, 25));
		g.drawString(""+score, 590, 30);
		
		//border
		if(count%2==0) {
			g.setColor(Color.red);
			g.fillRect(0, 0, 3, 592);     //border rectangle
			g.fillRect(0, 0, 692, 3);		//border rectangle
			g.fillRect(681, 0, 3, 592);		//border rectangle
		}
		else if(count%3==0) {
			g.setColor(Color.CYAN);
			g.fillRect(0, 0, 3, 592);     //border rectangle
			g.fillRect(0, 0, 692, 3);		//border rectangle
			g.fillRect(681, 0, 3, 592);		//border rectangle
		}
		else if(count%5==0){
			g.setColor(Color.green);
			g.fillRect(0, 0, 3, 592);     //border rectangle
			g.fillRect(0, 0, 692, 3);		//border rectangle
			g.fillRect(681, 0, 3, 592);		//border rectangle
		}
		else if(count%7==0){
			g.setColor(Color.magenta);
			g.fillRect(0, 0, 3, 592);     //border rectangle
			g.fillRect(0, 0, 692, 3);		//border rectangle
			g.fillRect(681, 0, 3, 592);		//border rectangle
		}
		else if(count%1==0){
			g.setColor(Color.yellow);
			g.fillRect(0, 0, 3, 592);     //border rectangle
			g.fillRect(0, 0, 692, 3);		//border rectangle
			g.fillRect(681, 0, 3, 592);		//border rectangle
		}
		
		//paddle
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(playerX, 550, 100, 8);    
		
		//ball
		g.setColor(Color.white);
		g.fillOval(ballPosX, ballPosY, 20, 20); 
		
		if(totalBricks <= 0) { //all the bricks are over 
			play = false;
			ballPosX = 0;
			ballPosY = 0;
			
			g.setColor(Color.white);
			g.setFont(new Font("Segoe Script",Font.BOLD, 30));
			g.drawString("You Won: ", 230, 300);
			
			g.setFont(new Font("Segoe Script",Font.BOLD, 20));
			g.drawString("Press Enter to Restart, Q to quit", 230, 350);
			timer.stop();
			
			if(delay==-1) {
				ScoreFile sf = new ScoreFile(name,score,expert);
			}
			else if(delay==2){
				ScoreFile sf = new ScoreFile(name,score,easy);
			}
		}
		
		if(ballPosY >  570) { //if we miss the ball
			play = false;
			ballPosX = 0;
			ballPosY = 0;
			
			g.setColor(Color.white);
			g.setFont(new Font("Segoe Script",Font.BOLD, 30));
			g.drawString(" Game Over, score: "+score, 170, 300);
			
			g.setFont(new Font("Segoe Script",Font.BOLD, 20));
			g.drawString("Press Enter to Restart, Q to quit", 180, 350);
			timer.stop();
			
			if(delay==-1) {
				ScoreFile sf = new ScoreFile(name,score,expert);
			}
			else if(delay==2){
				ScoreFile sf = new ScoreFile(name,score,easy);
			}
			
		}
		g.dispose();
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(playerX >= 590) {
				playerX = 590;
			}else {
				moveRight();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(playerX <= 0) {
				playerX = 0;
			}else {
				moveLeft();
			}
		}	
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				//check=1;
				timer.start();
				play = true;
				ballPosX = 120;
				ballPosY = 350;
				ballXdir = -1;
				ballYdir = -2;
				playerX = 310;
				score = 0;
				totalBricks  = 21;
				map = new MapGenerator(3,7);
				
				repaint();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_Q) {
			System.exit(0);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_P) {
			play = false;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_R) {
			play = true;
		}
		
		
	}
	
	public void moveRight() {
		//play = true;
		playerX=playerX+paddle_speed;
	}
	
	public void moveLeft() {
		//play = true;
		playerX=playerX-paddle_speed;
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
			ballYdir = -ballYdir;
		}
		
		if(play) {
			ballPosX += ballXdir;
			ballPosY += ballYdir;
			if(ballPosX < 0) {
				ballXdir = -ballXdir;
				count++;
			}
			if(ballPosY < 0) {				
				ballYdir = -ballYdir;
				count++;
			}
			if(ballPosX > 670) {			
				ballXdir = -ballXdir;
				count++;
			}
			
			repaint();
		}
		
		A: for(i=0;i<map.map.length;i++) {
			for(int j=0;j<map.map[0].length;j++) {
				if(map.map[i][j] > 0) {
					int brickX = j * map.brickWidth + 80;
					int brickY = i * map.brickHeight + 50;
					int brickWidth = map.brickWidth;
					int brickHeight = map.brickHeight;
					
					Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
					Rectangle ballRect = new Rectangle(ballPosX,ballPosY,20,20);
					//Rectangle brickRect = rect;
					
					if(ballRect.intersects(rect)) {
						count++;
						map.setBrickValue(0, i, j);
						totalBricks--;
						score += 5;
						
						if(ballPosX + 19 <= rect.x || ballPosX + 1 >= rect.x + rect.width) {
							ballXdir = -ballXdir;
						}else {
							ballYdir = -ballYdir;
						}
						break A;
					}
				}
			}
		}
		
	}

}
