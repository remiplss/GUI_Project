
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author remip
 */
public class GUI4 extends javax.swing.JFrame {

    //public Customer customerBuffer = new Customer();
    public AgencyOfficial ao = new AgencyOfficial();
    private final GUI4Delete delete = new GUI4Delete();

    public GUI4() {
        initComponents();       
            
    }

   /* public void setCustomerBuffer(Customer cust) {
        this.customerBuffer = cust;
    }*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        validateChoice = new javax.swing.JButton();
        actionChoice = new javax.swing.JComboBox();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel1.setText("What do you want to do today ? ");

        validateChoice.setText("Validate");
        validateChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateChoiceActionPerformed(evt);
            }
        });

        actionChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Add new job(s)", "Delete old job(s)", "Analyse most popular jobs" }));
        actionChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionChoiceActionPerformed(evt);
            }
        });

        back.setText("Disconnect");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(actionChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(validateChoice))
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actionChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validateChoice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void validateChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateChoiceActionPerformed
        // TODO add your handling code here:
        String itemText = (String) actionChoice.getSelectedItem();
        switch (itemText) {
            case "Add new job(s)":
                GUI3Add nvJob = new GUI3Add();
                //nvJob.setCustomerBuffer(customerBuffer);
                nvJob.setTitle("Interface to add new job(s)");
                nvJob.setVisible(true);

                //dispose();
                break;
            case "Delete old job(s)":          
                delete.displayJobs();
                delete.setVisible(true);
                //dispose();
                ///Mettre à jour la bdd JOB et user  
                break;
            case "Analyse most popular jobs":
                PieChart pie = new PieChart("", "Job's popularity");
                pie.pack();
                pie.setVisible(true);
                break;
    }//GEN-LAST:event_validateChoiceActionPerformed
    }
    private void actionChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionChoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actionChoiceActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == back) {
            GUI nv = new GUI();
            nv.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_backActionPerformed
   
    public void transfert(Customer customerBuffer) //Transfering data from the buffer to the Agency official object
    {
        ao.setFirstName(customerBuffer.getFirstName());
        System.out.println(customerBuffer.getFirstName());
        ao.setLastName(customerBuffer.getLastName());
        System.out.println(customerBuffer.getLastName());
        ao.setEmail(customerBuffer.getEmail());
        System.out.println(customerBuffer.getEmail());
        ao.setPassword(customerBuffer.getPassword());
        System.out.println(customerBuffer.getPassword());
        ao.setType(customerBuffer.getType());
        welcomeLabel.setText("Welcome " +ao.getFirstName()+ " " +ao.getLastName());    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox actionChoice;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton validateChoice;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
