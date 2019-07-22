import java.io.*;
// Assignment #:8
//         Name:Taylor Collins
//    StudentID:1213902038
//      Lecture:MWF 8:35-9:45
//  Description: The class Project represents a project


public class Project implements Serializable
 {
   private String projTitle;
   private int projNumber;
   private String projLocation;
   private Manager projManager;

   //Constructor to initialize all member variables
   public Project()
    {
      projTitle = "?";
      projNumber = 0;
      projLocation = "?";
      projManager = new Manager();
    }

   //Accessor methods
   public String getProjTitle()
    {
      return projTitle;
    }

   public int getProjNumber()
    {
      return projNumber;
    }

   public String getProjLocation()
    {
	   return projLocation;
	}

   public Manager getProjManager()
    {
      return projManager;
    }

   //Mutator methods
   public void setProjTitle(String aTitle)
    {
     projTitle = aTitle;
    }

   public void setProjNumber(int aNumber)
    {
     projNumber = aNumber;
    }

   public void setProjLocation(String aLocation)
    {
      projLocation = aLocation;
    }

   public void setProjManager(String first, String last, int deptNum)
    {
        projManager.setFirstName(first);
        projManager.setLastName(last);
        projManager.setDeptNum(deptNum);
    }

    public void copy(Project other)//makes a copy of the project information
    {
		this.setProjTitle(other.getProjTitle());
		this.setProjNumber(other.getProjNumber());
		this.setProjLocation(other.getProjLocation());
		this.setProjManager(other.getProjManager().getFirstName(),other.getProjManager().getLastName(),other.getProjManager().getDeptNum());
	}


   //toString() method returns a string containg its title, number, location and manager
   public String toString()
    {
      String result = "\nProject Title:\t\t" + projTitle
                    + "\nProject Number:\t\t" + projNumber
                    + "\nProject Location:\t" + projLocation
                    + "\nProject Manager:\t"
                    + projManager.toString() + "\n\n";
      return result;
     }
  }