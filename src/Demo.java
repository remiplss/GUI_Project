public class Demo {
    public static void main(String[] args) {
        
        //Customer customer = new Customer();
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                GUIWelcome jPanel1 = new GUIWelcome();
                jPanel1.setVisible(true);               
                
            }
        });
    }
    
}
