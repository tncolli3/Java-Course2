// Assignment #: 6
//         title: Taylor Collins
//    StudentID: 1213902038
//      Lecture: MWF 8:35-9:25
//  Description: Sets up and creates the create project panel and handles button event

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CreatePanel extends JPanel
 {
   private Vector projectList;
   private JButton button1;
   private SelectPanel sPanel;
   private JPanel subPanel,subPanel1,subPanel2,leftPanel,rightPanel;
   private JLabel projectMessage;
   private JTextArea projList;
   private JTextField titleField,numberField,locationField;
   private JScrollPane scrollPane;

 //Constructor initializes components and organize them using certain layouts
 public CreatePanel(Vector projectList, SelectPanel sPanel)
  {
    this.projectList = projectList;
    this.sPanel = sPanel;
    subPanel=new JPanel(new GridLayout(3,2));
    subPanel1=new JPanel();
    subPanel2=new JPanel();
    leftPanel=new JPanel(new GridLayout(3,1));
    rightPanel=new JPanel(new GridLayout(1,1));

	JLabel Title=new JLabel("Project Title"); //initialize the labels
	JLabel projNumber= new JLabel("Project Number");
	JLabel projLocation=new JLabel("Project Location");
	titleField=new JTextField();//initialize textfields to take in user input
	numberField=new JTextField();
	locationField=new JTextField();
	projList=new JTextArea("No Project");//initialize to have a message
	 scrollPane=new JScrollPane(projList);//add scroll bar to text area
      // orgranize components here
      // here is an example
	projectMessage=new JLabel();//create a label that displays a message
      button1 = new JButton("Create a project");//initialize button
	  button1.addActionListener(new ButtonListener());//add listener object
      setLayout(new GridLayout(1,1));
      subPanel.add(Title);//add components to the different subpanels
      subPanel.add(titleField);
      subPanel.add(projNumber);
      subPanel.add(numberField);
      subPanel.add(projLocation);
      subPanel.add(locationField);
      subPanel1.add(button1);
      subPanel2.add(projectMessage);

      leftPanel.add(subPanel2);//add the sub panels to the left and right panels
      leftPanel.add(subPanel);
      leftPanel.add(subPanel1);
      rightPanel.add(scrollPane);
      projList.setEditable(false);//not allow editing in the project list

      add(leftPanel,BorderLayout.WEST);//add the subpanels to the main panel
      add(rightPanel,BorderLayout.EAST);
  }


  //ButtonListener is a listener class that listens to
  //see if the buttont "Create a project" is pushed.
  //When the event occurs, it add the project information
  //in the text fields to the text area
  //and the list of project information,
  //and it also does error checking.
  private class ButtonListener implements ActionListener
   {
    public void actionPerformed(ActionEvent event)
     {
	  	Project information=new Project();//create project object
	  	projectMessage.setForeground(Color.red);//set the color of the message to red
	  	information.setProjTitle(titleField.getText());//take information from the textfields
	  	information.setProjLocation(locationField.getText());
		try//catch the NumberFormatException
		{
	  		information.setProjNumber(Integer.parseInt(numberField.getText()));
       	 	if((information.getProjTitle().isEmpty())||(information.getProjLocation().isEmpty())||numberField.getText().isEmpty())
       		{
				projectMessage.setText("Please enter all fields");
			}

			else
			{
				projectMessage.setText("Project added.");
				projectList.add(information);
				if(projList.getText().equals("No Project"))
				{
					projList.setText(information.toString());
				}
				else{
					projList.setText(projList.getText()+information.toString());
				}
				sPanel.updateProjectList();
			}
		}
		catch(NumberFormatException empty)
		{
			projectMessage.setText("Please enter an integer for the project number");
		}
		// if there is no error, add a project to project list
         // otherwise, show an error message
     } //end of actionPerformed method
  } //end of ButtonListener class

} //end of CreatePanel class