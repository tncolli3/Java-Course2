// Assignment #: 7
//         Name: Taylor Collins
//    StudentID: 1213902038
//      Lecture: MWF 8:35-9:25
//  Description: WholePanel.java sets up a series of buttons and creates a rectangle based on user selection of color and fill

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // to use listener interfaces

public class WholePanel extends JPanel
{
   private Color currentColor;
   private int currentWidth, currentHeight;
   private CanvasPanel canvas;
   private JPanel menuPanel;
   private JCheckBox fillCheck;
   private JRadioButton Blue,Red,White,Green,Orange;
   private ButtonGroup colorGroup;
   private int x1, y1;

   public WholePanel()
   {
     //white is the default color
     currentColor = Color.WHITE;

     //default x-y cooridnate, width, and height of a rectangle
     currentWidth = currentHeight = 100;
     x1 = 100; y1 = 100;

     fillCheck = new JCheckBox("Filled");
     White=new JRadioButton("white");//add buttons for each color
     Red=new JRadioButton("red");
     Blue=new JRadioButton("blue");
     Green=new JRadioButton("green");
     Orange=new JRadioButton("orange");
     colorGroup=new ButtonGroup();//instantiate a button group for the colors

     fillCheck.addItemListener(new FillListener());//add a listener object for the fill checkbox
     White.addActionListener(new ColorListener());//add listener objects for the buttons
     Red.addActionListener(new ColorListener());
     Blue.addActionListener(new ColorListener());
     Green.addActionListener(new ColorListener());
     Orange.addActionListener(new ColorListener());

     colorGroup.add(White);//add the color buttons to the button group
	 colorGroup.add(Red);
	 colorGroup.add(Blue);
	 colorGroup.add(Green);
     colorGroup.add(Orange);

     menuPanel = new JPanel();
     menuPanel.add(fillCheck);//add the buttons to the menu panel
     menuPanel.add(White);
	 menuPanel.add(Red);
	 menuPanel.add(Blue);
	 menuPanel.add(Green);
     menuPanel.add(Orange);


     canvas = new CanvasPanel();





     JSplitPane sPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuPanel, canvas);

     setLayout(new BorderLayout());
     add(sPane, BorderLayout.CENTER);


     //to be completed

    }


 //insert ColorListener and FillListener classes
 private class FillListener implements ItemListener
 {
	 public void itemStateChanged(ItemEvent event)
	{
		if(fillCheck.isSelected())//fill the rectangle if the checkbox is selected
		{
			repaint();
		}
		else{
			repaint();
		}
	 }
 }

 private class ColorListener implements ActionListener
 {
	 public void actionPerformed(ActionEvent event)
	 {
		 if(event.getSource()==White)//change the color of the rectangle depending on what button is selected
		 {
			 currentColor=Color.white;
		 }
		 else if(event.getSource()==Red)
		 {
			 currentColor=Color.red;
		 }
		 else if(event.getSource()==Blue)
		 {
			 currentColor=Color.blue;
		 }
		 else if(event.getSource()==Green)
		 {
			 currentColor=Color.green;
		 }
		 else if(event.getSource()==Orange)
		 {
			 currentColor=Color.orange;
		 }
		 repaint();//change the color
	 }
 }


 //CanvasPanel is the panel where pressed keys will be drawn
 private class CanvasPanel extends JPanel
  {
     //Constructor to initialize the canvas panel
     public CanvasPanel( )
      {
        // make this canvas panel listen to mouse
        addMouseListener(new PointListener());
        addMouseMotionListener(new PointListener());

        setBackground(Color.BLACK);
      }


     //this method draws all characters pressed by a user so far
     public void paintComponent(Graphics page)
      {
       super.paintComponent(page);

       //set color, then draw a rectangle
       page.setColor(currentColor);

       if(fillCheck.isSelected())//fill the rectangle
       {
		   page.fillRect(x1,y1,currentWidth,currentHeight);
	   }

       page.drawRect(x1, y1, currentWidth, currentHeight);
      }

    // listener class that listens to the mouse
    public class PointListener implements MouseListener,MouseMotionListener
    {
         //in case that a user presses using a mouse,
         //record the point where it was pressed.
         public void mousePressed (MouseEvent event) {}
         public void mouseClicked (MouseEvent event) {}
         public void mouseReleased (MouseEvent event) {}
         public void mouseEntered (MouseEvent event) {}
         public void mouseExited (MouseEvent event) {}
         public void mouseMoved(MouseEvent event) {}
         public void mouseDragged(MouseEvent event)
         {
			if(event.getY()<=(y1+5)&&event.getY()>=(y1-5))//change the height of the rectangle, based on where the mouse drag starts and ends
			{
				if((currentHeight+(y1-event.getY())>=10))//makes sure the height will not be smaller than ten pixels
				{
					currentHeight+=(y1-event.getY());
					y1=event.getY();
					repaint();
				}
			}

			if(event.getY()<=(currentHeight+5)&&event.getY()>=(currentHeight-5)&&(event.getY()!=y1))
			{
				if((currentHeight+(event.getY()-currentHeight)>=10))
				{
					currentHeight=event.getY();
					repaint();
				}
			}

			if(event.getX()<=(x1+5)&&event.getX()>=(x1-5))//change the width of the rectangle,based on where the drag starts and ends
			{
				if((currentWidth+(x1-event.getX())>=10))//make sure width will be greater than 10 pixels
				{
					currentWidth+=(x1-event.getX());
					x1=event.getX();
					repaint();
				}
			}
			if(event.getX()<=(currentWidth+5)&&event.getX()>=(currentWidth-5)&&(event.getX()!=x1))
			{
				if((currentWidth+(event.getX()-currentWidth)>=10))
				{
					currentWidth=event.getX();
					repaint();
				}
			}

          }

    } // end of PointListener

  } // end of Canvas Panel Class

} // end of Whole Panel Class