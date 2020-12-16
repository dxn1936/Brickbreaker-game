import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics2D;
public class MapGenerator {
	public int map[][]; //
	public int brickWidth;
	public int brickHeight;
	
	
	public MapGenerator(int row, int col) { 
		map = new int[row][col];
		for(int i=0;i<map.length;i++) {
			for(int j=0; j<map[0].length;j++) {
				map[i][j] = 1; //initializes all matrice cell to 1
			}
		}
		
		brickWidth = 540/col;
		brickHeight = 150/row;
	}
	
	public void draw(Graphics2D g) { //draw matrix blocks
		for(int i=0;i<map.length;i++) {
			for(int j=0; j<map[0].length;j++) {
				if(map[i][j] > 0) {
					g.setColor(Color.lightGray);
					g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);
					           //x position         //where brick will be   individual bricks  1 brick
					g.setStroke(new BasicStroke(3)); //stroke to each bricks  3 rows and 7 col
					g.setColor(Color.black);
					g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight); //where that stroke will come
				}
			}
		}
	}
	
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value; //when ball intersect with bricks
	}
}
