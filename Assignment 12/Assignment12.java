// Assignment #: 12
//         Name: Taylor Collins
//    StudentID: 1213902038
//      Lecture: MWF 8:35-9:25
//  Description: The Assignment 12 class creates a controlpanel and
//               adds it as its Applet content and also sets its size.

import javax.swing.*;

public class Assignment12 extends JApplet
 {
  private final int WIDTH = 800;
  private final int HEIGHT = 340;

  public void init()
   {
       ControlPanel panel = new ControlPanel(WIDTH,HEIGHT);
       getContentPane().add(panel);
       setSize(WIDTH,HEIGHT);
   }
 }