// Assignment #: 7
//         Name: Taylor Collins
//    StudentID: 1213902038
//      Lecture: MWF 8:35-9:25
//  Description: This creates a whole panel and adds it to the content pane. and instatiates its size

import javax.swing.*;

public class Assignment7 extends JApplet
{

 public void init()
  {
    // create a WholePanel object and add it to the applet
    WholePanel wholePanel = new WholePanel();
    getContentPane().add(wholePanel);

    //set applet size to 400 X 400
    setSize (400, 400);
  }

}
