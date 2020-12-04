package View;

//test 
import Model.Customer;
import Model.DataSource;
import java.awt.Color;
import java.awt.Container;
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
    
    Connection con1 = null;
    PreparedStatement insert = null;

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
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Type");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Email");

        txtEmail.setToolTipText("ex : name@gmail.com");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jButton2)
                .addContainerGap())
        );

        txtEmail.getAccessibleContext().setAccessibleDescription("");

        Title.setBackground(new java.awt.Color(204, 204, 255));
        Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Connection to your account");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/welcomeImage.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
    
    ///Query to get the first and last name
    private void getFirstAndLastName(String email) {

        try {
            DataSource dataSource = new DataSource();
            con1 = dataSource.createConnection();

            String query = "SELECT FirstName,LastName,idUser FROM user where Email = ?";
            
            PreparedStatement stmt = con1.prepareStatement(query);
            stmt.setString(1, email);//We put the email in the query which is entered in parameters
            
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next())
            {
                customerBuffer.setFirstName(rs.getString("FirstName"));///We get the first name of the member which email is given in parameter
                customerBuffer.setLastName(rs.getString("LastName"));
                customerBuffer.setId(rs.getInt("idUser"));
            }
            con1.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
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
        getFirstAndLastName(customerBuffer.getEmail());
        System.out.println("iduser = " +customerBuffer.getId());
        
        String query = "SELECT * FROM user where Email = ?"; //query
        String query2 = "SELECT * FROM user where Password = ?";
        

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //con1 = DriverManager.getConnection("jdbc:mysql://localhost/gui_sql", "root", "roro94220"); //Connection
            ///We create the link with the Db
            DataSource dataSource = new DataSource();
            con1 = dataSource.createConnection();
          
            PreparedStatement stmt = con1.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); //Find a row with the same email
            stmt.setString(1, customerBuffer.getEmail()); //insert value in the query
            ResultSet result = stmt.executeQuery(); //Get query result in result

            ////////////-------------/////// Test for if the mail is wrong but with a good password
            
            PreparedStatement stmt2 = con1.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS); //Find a row with the same password
            stmt2.setString(1, customerBuffer.getPassword()); //insert value in the query
            ResultSet result2 = stmt2.executeQuery(); //Get query result in result

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
                con1.close();
            } else ///Test if the password is good but not the email
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
                con1.close();
            }
            ////Il reste deux blindages à faire, à savoir si le password et l'email sont faux mais bon type  et si les 3 champs sont faux                 
            dispose();//Dispose the JFrame
        } //Exceptions//
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GUISignUp jPanel2 = new GUISignUp(); //Init the job seeker GUI 
        jPanel2.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JComboBox<String> txtType;
    // End of variables declaration//GEN-END:variables
}
