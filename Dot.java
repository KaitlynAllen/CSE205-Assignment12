// Assignment #: 12
//         Name: Kaitlyn Allen
//    StudentID:
//      Lecture: TTH 4:30-5:45
//  Description: The Dot class creates a dot/circle that makes up
//               shape of the wave.
import java.awt.Color;
import java.awt.Graphics;

public class Dot {
	private Color color;
	private int x, y, RADIUS = 3;
	
	public Dot(int x1, int y1, Color color1){
		color = color1;
		x= x1;
		y = y1;
	}
	
	public void draw(Graphics page){
		page.fillOval(x,y,RADIUS, RADIUS);
	}
}
