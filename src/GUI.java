
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author remip
 */
public class GUI extends javax.swing.JFrame {

    public Customer customerBuffer = new Customer();

    Connection con1;
    PreparedStatement insert;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtType = new javax.swing.JComboBox<String>();
        jButton2 = new javax.swing.JButton();
        Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Type");

        jLabel2.setText("Password");

        jLabel3.setText("Email");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Job seeker", "Employer", "Agency", " " }));

        jButton2.setText("Sign in");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(txtEmail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(37, 37, 37)))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        Title.setBackground(new java.awt.Color(204, 204, 255));
        Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Connection to your account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(168, 168, 168))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void userTest() {
        //if you select "Job seeker"//
        if (customerBuffer.getType().equals("Job seeker")) {

            //jPanel1.setVisible(false);
            GUI2 jPanel2 = new GUI2(); //Init the job seeker GUI
            //jPanel2.setCustomerBuffer(customerBuffer); //set the customer buffer in the new GUI
            jPanel2.transfert(customerBuffer);
            //System.out.println(customerBuffer.getEmail());
            jPanel2.setVisible(true);

        }
        //if you select "Employer"//
        if (customerBuffer.getType().equals("Employer")) {

            //jPanel1.setVisible(true);
            GUI3 jPanel3 = new GUI3(); //Init the Employer GUI
            //jPanel3.setCustomerBuffer(customerBuffer); //set the customer buffer in the new GUI
            jPanel3.transfert(customerBuffer);
            jPanel3.setVisible(true);

        }
        //if you select "Agency"//
        if (customerBuffer.getType().equals("Agency")) {

            //jPanel1.setVisible(true);
            GUI4 jPanel4 = new GUI4(); //Init the Agency GUI
            //jPanel4.setCustomerBuffer(customerBuffer);//set the customer buffer in the new GUI
            jPanel4.transfert(customerBuffer);
            jPanel4.setVisible(true);
        }
    }

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    //if the Connect button is pressed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //get value from the GUI in the customer buffer//
        //On doit set le nom et prenom mais jsp si on doit le recuperer depuis la bdd ou utilise la fonction transfert
        customerBuffer.setEmail(txtEmail.getText());
        customerBuffer.setPassword(txtPassword.getText());
        customerBuffer.setType(txtType.getSelectedItem().toString());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/gui_sql", "root", "roro94220"); //Connection

            String query = "SELECT * FROM user where Email = ?"; //query
            PreparedStatement stmt = con1.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); //Find a row with the same email
           
            stmt.setString(1, customerBuffer.getEmail()); //insert value in the query

            ResultSet result = null; //Init result
            result = stmt.executeQuery(); //Get query result in result
            
            ////////////-------------/////// Test for if the mail is wrong but with a good password
            String  query2 = "SELECT * FROM user where Password = ?";
            PreparedStatement stmt2 = con1.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS); //Find a row with the same password
            
            stmt2.setString(1, customerBuffer.getPassword()); //insert value in the query
            
            ResultSet result2 = null; //Init result
            result2 = stmt2.executeQuery(); //Get query result in result

            if (result.isBeforeFirst())//if the acount already exist
            {
                if (result.next()) {
                    if (result.getString(2).equals(customerBuffer.getPassword())
                            && result.getString(3).equals(customerBuffer.getType())) // if it's the good password and the good type
                    {
                        JOptionPane.showMessageDialog(this, "Connecting..."); //Display a message

                        userTest();
                    } else // wrong password
                    {
                        JOptionPane.showMessageDialog(this, "Invalid password or type!"); //Display a message
                        GUI nv = new GUI();
                        nv.setVisible(true);                       
                    }
                }
            }
            else ///Test if the password is good but not the email
            {
                if (result2.isBeforeFirst())//if the acount already exists
            {
                if (result2.next()) {
                    if (result2.getString(1).equals(customerBuffer.getEmail())
                            && result2.getString(3).equals(customerBuffer.getType())) // if it's the good password and the good type
                    {
                        JOptionPane.showMessageDialog(this, "Connecting..."); //Display a message
                        userTest();
                    } else // wrong mail
                    {
                        JOptionPane.showMessageDialog(this, "Invalid mail or type!"); //Display a message
                        GUI nv = new GUI();
                        nv.setVisible(true);
                    }
                }
            }
            }
            ////Il reste deux blindages à faire, à savoir si le password et l'email sont faux mais bon type  et si les 3 champs sont faux => easy à faire 
                    /*
                     else{ //if it's a new acount
                
                     //send GUI value to the database//
                     insert = con1.prepareStatement("insert into user(Email,Password,Type)values(?,?,?)");
                
                     //insert values in the query//
                     insert.setString(1,customerBuffer.getEmail());
                     insert.setString(2,customerBuffer.getPassword());
                     insert.setString(3,customerBuffer.getType());
                     insert.executeUpdate();
                
                     JOptionPane.showMessageDialog(this,"Registered\n Connecting...");//Display a message
                
                     userTest();
                     }    */
                    /*
                     //if you select "Job seeker"//
                     if(customerBuffer.getType().equals("Job seeker")){
                
                     String query ="SELECT * FROM jobseekerlist where Email = ?"; //query
                     PreparedStatement stmt = con1.prepareStatement(query,Statement.RETURN_GENERATED_KEYS); //Find a row with the same email
            
                     stmt.setString(1,customerBuffer.getEmail()); //insert value in the query

                     ResultSet result = null; //Init result
                     result = stmt.executeQuery(); //Get query result in result

                     if(result.isBeforeFirst())//if the acount already exist
                     {
           
                     String query2 ="SELECT * FROM jobseekerlist where Email = ?"; //query
                     PreparedStatement stmt2 = con1.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS); //Find a row with the same password
                     stmt2.setString(1,customerBuffer.getEmail());//insert value in the query
                     ResultSet result2 = null; //Init result2
                     result2 = stmt2.executeQuery();//Get query result in result2

                     if(result2.next())
                     if(result2.getString(2).equals(customerBuffer.getPassword())) // if it's the good password
                     {
                     JOptionPane.showMessageDialog(this,"Connecting..."); //Display a message
                   
                    
                     jPanel1.setVisible(true);
                     GUI2 jPanel2 = new GUI2(); //Init the job seeker GUI
                     jPanel2.setCustomerBuffer(customerBuffer); //set the customer buffer in the new GUI
                     jPanel2.setVisible(true);
                
                    
                     }
                     else // wrong password
                     {
                     JOptionPane.showMessageDialog(this,"Invalid password !"); //Display a message

                     }

                     }

                     else{ //if it's a new acount
                
                     //send GUI value to the database//
                     insert = con1.prepareStatement("insert into jobseekerlist(Email,Password,Type)values(?,?,?)");
                
                     //insert values in the query//
                     insert.setString(1,customerBuffer.getEmail());
                     insert.setString(2,customerBuffer.getPassword());
                     insert.setString(3,customerBuffer.getType());
                     insert.executeUpdate();
                
                
                     JOptionPane.showMessageDialog(this,"Registered\n Connecting...");//Display a message
                
                     jPanel1.setVisible(true);
                     GUI2 jPanel2 = new GUI2();//Init the job seeker GUI
                     jPanel2.setCustomerBuffer(customerBuffer);//set the customer buffer in the new GUI
                     jPanel2.setVisible(true);
                     }
                     }
            
                     //if you select "Employer"//
                     if(customerBuffer.getType().equals("Employer"))
                     {
                     String query ="SELECT * FROM employerlist where Email = ?"; //query
                     PreparedStatement stmt = con1.prepareStatement(query,Statement.RETURN_GENERATED_KEYS); //Find a row with the same email
                     stmt.setString(1,customerBuffer.getEmail());//insert value in the query

                     ResultSet result = null;//Init result
                     result = stmt.executeQuery();//Get query result in result

                     if(result.isBeforeFirst())//if the acount already exist
                     {
                     String query2 ="SELECT * FROM employerlist where Email = ?"; //query
                     PreparedStatement stmt2 = con1.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS); //Find a row with the same password
                     stmt2.setString(1,customerBuffer.getEmail());//insert value in the query

                     ResultSet result2 = null;//Init result2
                     result2 = stmt2.executeQuery();//Get query result in result2

                     if(result2.next())

                     if(result2.getString(2).equals(customerBuffer.getPassword())) // good password
                     {
                     JOptionPane.showMessageDialog(this,"Connecting...");//Display a message
                                      
                
                     jPanel1.setVisible(true);
                     GUI3 jPanel3 = new GUI3();//Init the Employer GUI
                     jPanel3.setCustomerBuffer(customerBuffer);//set the customer buffer in the new GUI
            
                     jPanel3.setVisible(true);
                    
                     }
                     else // wrong password
                     {
                     JOptionPane.showMessageDialog(this,"Invalid password !");//Display a message

                     }

                     }

                     else{ //if it's a new acount
                     insert = con1.prepareStatement("insert into employerlist(Email,Password,Type)values(?,?,?)");
               
                     //insert values in the query//
                     insert.setString(1,customerBuffer.getEmail());
                     insert.setString(2,customerBuffer.getPassword());
                     insert.setString(3,customerBuffer.getType());
                     insert.executeUpdate();
                     JOptionPane.showMessageDialog(this,"Registered\n Connecting...");//Display a message
          
                
               
                     jPanel1.setVisible(true);
                     GUI3 jPanel3 = new GUI3();//Init the Employer GUI
                     jPanel3.setCustomerBuffer(customerBuffer);//set the customer buffer in the new GUI
                     jPanel3.setVisible(true);
                     }
                     }
            
                     //if you select "Agency"//
                     if(customerBuffer.getType().equals("Agency"))
                     {
                     String query ="SELECT * FROM agencylist where Email = ?"; //query
                     PreparedStatement stmt = con1.prepareStatement(query,Statement.RETURN_GENERATED_KEYS); //Find a row with the same email
                     stmt.setString(1,customerBuffer.getEmail());//insert value in the query

                     ResultSet result = null;//Init result
                     result = stmt.executeQuery();//Get query result in result

                     if(result.isBeforeFirst())//if the acount already exist
                     {
                     String query2 ="SELECT * FROM agencylist where Email = ?"; //query
                     PreparedStatement stmt2 = con1.prepareStatement(query2,Statement.RETURN_GENERATED_KEYS); //Find a row with the same password
                     stmt2.setString(1,customerBuffer.getEmail());//insert value in the query

                     ResultSet result2 = null;//Init result2
                     result2 = stmt2.executeQuery();//Get query result in result2

                     if(result2.next())

                     if(result2.getString(2).equals(customerBuffer.getPassword())) // good password
                     {
                     JOptionPane.showMessageDialog(this,"Connecting...");//Display a message
                    
                     jPanel1.setVisible(true);
                     GUI4 jPanel4 = new GUI4();//Init the Agency GUI
                     jPanel4.setCustomerBuffer(customerBuffer);//set the customer buffer in the new GUI
                     jPanel4.setVisible(true);
                    
                     }
                     else // wrong password
                     {
                     JOptionPane.showMessageDialog(this,"Invalid password !");//Display a message

                     }

                     }

                     else{ //if it's a new acount
                     insert = con1.prepareStatement("insert into agencylist(Email,Password,Type)values(?,?,?)");
                     //insert values in the query//
                     insert.setString(1,customerBuffer.getEmail());
                     insert.setString(2,customerBuffer.getPassword());
                     insert.setString(3,customerBuffer.getType());
                     insert.executeUpdate();
                     JOptionPane.showMessageDialog(this,"Registered\n Connecting...");//Display a message
                
                     jPanel1.setVisible(true);
                     GUI4 jPanel4 = new GUI4();//Init the Agency GUI
                     jPanel4.setCustomerBuffer(customerBuffer);//set the customer buffer in the new GUI
                     jPanel4.setVisible(true);
                     }
                     }*/
                     dispose();//Dispose the JFrame
        } //Exceptions//
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JComboBox<String> txtType;
    // End of variables declaration//GEN-END:variables
}
