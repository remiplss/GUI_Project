package View;

import Model.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author remip
 */
public class GUI3 extends javax.swing.JFrame {

    public Customer customerBuffer = new Customer();
    public Employer emp = new Employer();
    private ArrayList<String> jobLists;
    private Fees empTest = new EmployerDAOImpl();

    public GUI3() {
        initComponents();
        EmployerDAO daoEmp = new EmployerDAOImpl();
        this.jobLists = daoEmp.getAllJobs();
        for (int i = 0; i < jobLists.size(); i++) {
            txtJob.addItem(jobLists.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ButtonAdd = new javax.swing.JButton();
        ButtonSee = new javax.swing.JButton();
        txtJob = new javax.swing.JComboBox<String>();
        back = new javax.swing.JButton();
        jButtonBalance = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonAdd.setText("Add Job");
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        ButtonSee.setText("See Applicants");
        ButtonSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSeeActionPerformed(evt);
            }
        });

        txtJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobActionPerformed(evt);
            }
        });

        back.setText("Disconnect");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jButtonBalance.setText("See my balance");
        jButtonBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBalanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ButtonSee, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButtonBalance))
                    .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSee)
                    .addComponent(back)
                    .addComponent(jButtonBalance))
                .addGap(22, 22, 22))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        ///If the employer wants to disconnect himself from the application
        GUI nv = new GUI();
        this.dispose();
        nv.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void txtJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJobActionPerformed

    private void ButtonSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSeeActionPerformed

        //get value from the GUI in the emp Object//
        emp.setJobTitle(txtJob.getSelectedItem().toString());

        GUI3See jPanel4 = new GUI3See(emp);//Init the See GUI
        jPanel4.setEmp(emp);//Set the new GUI Employer object with emp
        jPanel4.setVisible(true);
    }//GEN-LAST:event_ButtonSeeActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
        GUI3Add jPanel4 = new GUI3Add(emp); //Init the Add GUI
        int count = 0;
        jPanel4.setVisible(true);
        count = countJobAddedAndComputeFees(emp);
        if (count > 5) {
            JOptionPane.showMessageDialog(null, "You are considered as an old employer, you will only pay 2$ per job added");
        } else {
            JOptionPane.showMessageDialog(null, "You are considered as an nem employer, you will pay 5$ per job added");
        }
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void jButtonBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBalanceActionPerformed
        // TODO add your handling code here:
        GUI3Pay gui3pay = new GUI3Pay();
        gui3pay.setVisible(true);
        System.out.println("firstname " +emp.getFirstName());
        System.out.println("lastname " +emp.getLastName());
        System.out.println("id " +emp.getId());
        gui3pay.transfert(emp,emp);        
    }//GEN-LAST:event_jButtonBalanceActionPerformed

    public void transfert(Customer customerBuffer) //Transfering data from the buffer to the Job Seeker object
    {
        int count = 0;

        emp.setFirstName(customerBuffer.getFirstName());
        System.out.println(emp.getFirstName());
        emp.setLastName(customerBuffer.getLastName());
        System.out.println(emp.getLastName());
        emp.setEmail(customerBuffer.getEmail());
        System.out.println(emp.getEmail());
        emp.setPassword(customerBuffer.getPassword());
        System.out.println(emp.getPassword());
        emp.setType(customerBuffer.getType());
        emp.setId(customerBuffer.getId());
        System.out.println("Prenom = " + emp.getFirstName() + "idUser = " + emp.getId());

        ///We call the method wich determines how much jobs the employer added
        count = countJobAddedAndComputeFees(emp);
        setFeesToEmp(count, emp);

        System.out.println(emp.getFirstName() + " total feees GUI 3:" + emp.getTotalFees());

        jLabel1.setText("Employer " + emp.getFirstName() + " " + emp.getLastName());
    }

    private int countJobAddedAndComputeFees(Employer emp) {
        int c;
        ///Instance where we take the number of jobs added by the emp       
        c = empTest.computeTotalFees(emp.getId());
        return c;
    }

    private void setFeesToEmp(int c, Employer emp) {
        empTest.valueFees(c, emp);
    }

    public JComboBox<String> getTxtJob() {
        return txtJob;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonSee;
    private javax.swing.JButton back;
    private javax.swing.JButton jButtonBalance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> txtJob;
    // End of variables declaration//GEN-END:variables
}
