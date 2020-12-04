package Controler;


import View.GUIWelcome;
import View.GUI2;
import View.GUI;
import com.bulenkov.darcula.DarculaLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public class Demo {
    public static void main(String[] args) {
        
        for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
          try {
              javax.swing.UIManager.setLookAndFeel(new DarculaLaf());
          } catch (UnsupportedLookAndFeelException ex) {
              Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
          }
      }

        
        //Customer customer = new Customer();
      /*
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
        }*/
        
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
