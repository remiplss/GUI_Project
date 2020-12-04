
package Model;

import java.sql.*;
import java.sql.*;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;

import java.util.Vector;

/**
 *
 * @author romanphilip
 */
public interface EmployerDAO 
{
   
      
    ///method which add a job into the JobTable
    public void addJob(String jobTitle,java.sql.Date  date,String jobDescription,String company);
    
    ///Methode which diplay all the applicants according to the job
   public ArrayList<JobSeeker> getApplicantsByJob(String jobTitle);
   
   ///Method wich returns all the jobs from the database
   public ArrayList<String> getAllJobs();
    
}
