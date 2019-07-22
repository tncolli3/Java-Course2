// Assignment #: 6
//         Name: Taylor Collins
//    StudentID: 1213902038
//      Lecture: MWF 8:35-9:25
//  Description: SelectPanel.java sets up the select a project page and handles events with buttons and JLists

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class SelectPanel extends JPanel
 {
   private Vector projectList, selectedList;
	private JList projects,selection;
	private JButton addProj,removeProj;
	private JLabel proj,selectedProj,numSelected;
	private int totalSelected;

   //Constructor initialize each component and arrange them using
   //certain layouts
   public SelectPanel(Vector projectList)
   {
      this.projectList = projectList;
      selectedList=new Vector();//initialize selectedList vector
      totalSelected=0;
      setLayout(new GridLayout(3,1));//set layout
      projects= new JList(projectList);//initialize JLists
      selection=new JList(selectedList);
      JScrollPane sp1=new JScrollPane(projects);//initialize Scrollpanes
      JScrollPane sp2=new JScrollPane(selection);

      proj=new JLabel("Available project(s)");//initialize JLabels
      selectedProj=new JLabel("Selected project(s)");
      numSelected=new JLabel("Total number of selected projects: "+totalSelected);

      JPanel top=new JPanel(new GridLayout(2,1));//initialize the subpanels and set layouts
      JPanel middle=new JPanel(new GridLayout(1,2));
      JPanel bottom=new JPanel(new GridLayout(3,1));

      addProj=new JButton("Add");//intialize buttons
      removeProj=new JButton("Remove");
      addProj.addActionListener(new ButtonListener());//add listener
      removeProj.addActionListener(new ButtonListener());
      projects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//set selection mode to single

      top.add(proj);//add the components to the different subpanels
      top.add(sp1);
      middle.add(addProj);
      middle.add(removeProj);
      bottom.add(selectedProj);
      bottom.add(sp2);
      bottom.add(numSelected);
      add(top);
      add(middle);
      add(bottom);




       // organize components for the select panel
  }

 //This method updates refresh the JList of projects with
 //updated vector information
 public void updateProjectList()
  {

    projects.updateUI();// call updateUI() for the JList
  }

 //ButtonListener class listens to see if any of
 //buttons is pushed, and perform their corresponding action.
 private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
        {
			if(event.getSource()==addProj)//determines if the add button is selected
			{
				selectedList.add(projects.getSelectedValue());//add to the list the selected value
				totalSelected++;//increase amount selected
				numSelected.setText("The total number of selected projects: "+totalSelected);//set text
				selection.updateUI();//update JList

			}
			else if(event.getSource()==removeProj)//determines if the remove button is selected
			{
				selectedList.remove(selection.getSelectedValue());//removes it from the list
				totalSelected--;
				numSelected.setText("The total number of selected projects: "+totalSelected);//sets text of the label
				selection.updateUI();//update the JList
			}

          //TO BE COMPLETED
        }
  } //end of ButtonListener class

} //end of SelectPanel class