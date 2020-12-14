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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author romanphilip
 */
public class AgencyOfficialDAOImpl implements AgencyOfficialDAO {

    private Connection con1 = null;
    private PreparedStatement insert = null;
    private final DataSource dataSource = new DataSource();

    @Override
    public ArrayList<String> seeJobsTitle() {

        ArrayList<String> listJobs = new ArrayList<>();

        try {   //Import Job from SQL

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
            Logger.getLogger(AgencyOfficialDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    /////Method which returns all the available job in the arraylist
    @Override
    public ArrayList<Job> getAllJobs() {

        int c;
        ArrayList<Job> listJobs = new ArrayList<>();
        try {   //Import Job from SQL

            DataSource dataSource = new DataSource();
            con1 = dataSource.createConnection();

            String query = "SELECT * FROM job";  //query
            insert = con1.prepareStatement(query);  //sending query to server

            ResultSet rs = insert.executeQuery(); //get the query result in rs

            while (rs.next()) //while there is a next row
            {
                ///While there is a next line in the table JobSeekerList, we create a new instance of JobSeeker whith the data took from the dataBase        
                Job job = new Job(rs.getString("JobTitle"),rs.getString("JobDescription"),rs.getString("Company"),rs.getDate("BeginningDate"),rs.getInt("idJob"));
                listJobs.add(job);
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

    @Override
    public void deleteJobById(int idJob) {
        ///we make a query using an inner join to delete the job in the DB and to delete all the applicants which applied for thisjob
        //String query = "DELETE job,jobseekerlist FROM job LEFT JOIN jobseekerlist on jobseekerlist.idJob = job.idJob WHERE job.idJob=?";
        String query = "DELETE job,jobseekerlist FROM job LEFT JOIN jobseekerlist  ON job.idJob = jobseekerlist.idJob WHERE job.idJob=?";
       
        try {
            con1 = dataSource.createConnection();
            insert = con1.prepareStatement(query);
            insert.setInt(1, idJob);
            insert.executeUpdate(); //It updates our dataBase
        } catch (SQLException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgencyOfficialDAOImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
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

}
