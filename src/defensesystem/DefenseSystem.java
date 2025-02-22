/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package defensesystem;

import defensesystem.view.controller.MainControllerForm;
import javax.swing.UIManager;

/**
 *
 * @author senukab
 */
public class DefenseSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
        }
        catch (Exception e) {
             System.err.println("Failed to initialize FlatLaf.");
        }

        
        
        new MainControllerForm().setVisible(true);
    }
    
}
