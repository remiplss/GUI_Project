/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2020 Sun Microsystems, Inc.
 */
package Model;

import View.GUI;
import View.GUI3See;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author romanphilip
 */
public class EmployerDAOImpl implements EmployerDAO {

        private Connection con1 = null;       
        private PreparedStatement insert = null;

    /*@Override
     public void addEmployer(Employer emp) {
     }*/
    @Override
    public void addJob(String jobTitle, java.sql.Date date, String jobDescription, String company) {
        

        String sql = "insert into job(JobTitle,BeginningDate,JobDescription,Company)values(?,?,?,?)";

        System.out.println("Debg");
        try {
            DataSource dataSource = new DataSource();
            con1 = dataSource.createConnection();
            insert = con1.prepareStatement(sql);

            ///We put the parameters values into the query 
            insert.setString(1, jobTitle);
            insert.setDate(2, date);
            insert.setString(3, jobDescription);
            insert.setString(4, company);
            insert.executeUpdate();
            JOptionPane.showMessageDialog(null, "Job added successfully");

        } catch (SQLException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (insert != null) {
                try {
                    insert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con1 != null) {
                try {
                    con1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public ArrayList<JobSeeker> getApplicantsByJob(String jobTitle) {       
        ArrayList<JobSeeker> applicants = new ArrayList<JobSeeker>();
        try {   //Import Job from SQL

            DataSource dataSource = new DataSource();
            con1 = dataSource.createConnection();
            //Vector v2 = new Vector<JobSeeker>();//Create vector

            String query = "SELECT * FROM jobseekerlist WHERE Job LIKE ?";  //query
            insert = con1.prepareStatement(query);  //sending query to server
            insert.setString(1, jobTitle); //Select jobseeker in the database

            ResultSet rs = insert.executeQuery(); //get the query result in rs

            while (rs.next()) //while there is a next row
            {
                ///While there is a next line in the table JobSeekerList, we create a new instance of JobSeeker whith the data took from the dataBase
                JobSeeker appli = new JobSeeker(rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Phone"), rs.getString("Email"), rs.getString("Status"));
                applicants.add(appli);//We add the 
            }
        } //Exceptions
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmployerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return applicants;
    }
    
    
    @Override
    public ArrayList<String> getAllJobs() {
        
        ArrayList<String> listJobs = new ArrayList<>();

        try {   //Import Job from SQL

            DataSource dataSource = new DataSource();
            con1 = dataSource.createConnection();
            

            String query = "SELECT * FROM job ";  //query
            insert = con1.prepareStatement(query);  //sending query to server
            
            ResultSet rs = insert.executeQuery(); //get the query result in rs

            while (rs.next()) //while there is a next row
            {
                ///While there is a next line in the table Job we add it into the ArrayList 
                listJobs.add(rs.getString("JobTitle"));
            }
        } //Exceptions
        catch (SQLException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JobSeekerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (insert != null) {
                try {
                    insert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con1 != null) {
                try {
                    con1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return listJobs;
    }
            
            
   

}
