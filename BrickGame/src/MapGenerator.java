package brickBreaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics2D;
public class MapGenerator {
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	
	public MapGenerator(int row, int col) {                   
		map = new int[row][col];							
		for(int i=0;i<map.length;i++) {									//initializes all matrix cells to 1
			for(int j=0; j<map[0].length;j++) {
				map[i][j] = 1;
			}
		}
		
		brickWidth = 540/col;
		brickHeight = 150/row;
	}
	
	public void draw(Graphics2D g) {
		for(int i=0;i<map.length;i++) {
			for(int j=0; j<map[0].length;j++) {								//draw matrix blocks
				if(map[i][j] > 0) {
					g.setColor(Color.lightGray);
					g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
				}
			}
		}
	}
	
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value;
	}
}
