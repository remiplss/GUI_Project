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

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author romanphilip
 */
public class UserDAOImpl implements UserDAO {

    private Connection con1 = null;
    private PreparedStatement insert = null;

    @Override
    public void addUser(Customer customer) {

        try {
            DataSource dataSource = new DataSource();
            con1 = dataSource.createConnection();

            ///Query which insert a user into the DB
            String query = "insert into user(Email,Password,Type,FirstName,LastName)values(?,?,?,?,?)";
            insert = con1.prepareStatement(query);
            
            //insert values in the query//
            insert.setString(1, customer.getEmail());
            insert.setString(2, customer.getPassword());
            insert.setString(3, customer.getType());
            insert.setString(4, customer.getFirstName());
            insert.setString(5, customer.getLastName());
            
            ///We execute the query 
            insert.executeUpdate();

            ///We print a JOptionPane message if the account is created
            JOptionPane.showMessageDialog(null, "Wonderful ! \nAccount succesfully created");//Display a message
            
        } catch (ClassNotFoundException | SQLException ex) {
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
    }

}
