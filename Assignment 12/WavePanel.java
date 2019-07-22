// Assignment #: 12
//         Name: Taylor Collins
//    StudentID: 1213902038
//      Lecture: MWF 8:35-9:25
//  Description: WavePanel.java contains a constructor and methods
//               for creating and displaying a wave
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class WavePanel extends JPanel
{
	private Color color;
	private Timer timer;
	private int delay;
	private int waveWidth;
	private int waveHeight;
	private int time;
	private int step;
	private ArrayList ptList;

	public WavePanel(Color color)//constructor
	{//initializes variables to specified values
		this.color=color;//sets the color of the wave
		setBackground(Color.WHITE);//makes the panel background white
		ptList=new ArrayList();
		waveHeight=72;
		waveWidth=50;
		delay=20;
		step=1;
		time=0;
		timer=new Timer(delay,new WaveListener());//initializes timer
		timer.start();//starts timer
	}

	public void resume()//starts the timer again
	{
		time=0;
		timer.start();

	}
	public void clearPanel()//removes all dots so that there is no longer a wave
	{
		ptList.clear();
		time=0;

	}

	public void changeColor(Color anotherColor)//changes the color of the wave
	{
		this.color=anotherColor;
	}
	public void setWaveWidth(int newWidth)//changes the width of the wave
	{
		waveWidth=newWidth;
	}

	public void setDelay(int delayNum)//changes the value of the delay
	{
		delay=delayNum;
	}

	public void paintComponent(Graphics page)// paints all of the dots in the list
	{
		super.paintComponent(page);
		for(int i=0;i<ptList.size();i++)
		{
			((Dot)ptList.get(i)).draw(page);
		}

	}

	private class WaveListener implements ActionListener//paints a wave based on the delay
	{
		public void actionPerformed(ActionEvent event)
		{
			int x=0,y=0;
			time+=step;//increments time
			x=(waveWidth*time)/50;
			y=(int)(waveHeight*Math.sin((.0174533)*time)+85);//finds y based on the sin function, height and time
			Dot newDot=new Dot(x,y,color);//create new dot
			ptList.add(newDot);//add dot to list
			repaint();//update the interface with the new dot
			if(x==800 ||y==340)//stop timer if it reaches the end of the screen
			{
				timer.stop();
			}

		}
	}

}