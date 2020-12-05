
package Model;
import java.util.ArrayList;

/**
 *
 * @author romanphilip
 */
public interface EmployerDAO 
{
   
    
    ///method which add a job into the JobTable
    public void addJob(String jobTitle,java.sql.Date  date,String jobDescription,String company,int id);
    
    ///Methode which diplay all the applicants according to the job
   public ArrayList<JobSeeker> getApplicantsByJob(String jobTitle);
   
   ///Method wich returns all the jobs from the database
   public ArrayList<String> getAllJobs();
    
}
