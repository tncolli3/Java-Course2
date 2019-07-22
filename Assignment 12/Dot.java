// Assignment #: 12
//         Name: Taylor Collins
//    StudentID: 1213902038
//      Lecture: MWF 8:35-9:25
//  Description: Dot.java contains a constructor and a draw method
//               to create dots that are used to draw a wave
import java.awt.*;
public class Dot
{
	private Color color;
	private int x;
	private int y;
	private int RADIUS=3;

	public Dot(int x1,int y1,Color color1)//constructor
	{//initializes variables
		x=x1;
		y=y1;
		color=color1;
	}

	public void draw(Graphics page)//draws the dots in a certain color
	{
		page.setColor(color);//sets the dot color
		page.fillOval(x,y,2*RADIUS,2*RADIUS);//draws a dot with those specific characteristics
	}
}