/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class HDSD {
    public static void openHDSD() {
        try {
            if((new File(System.getProperty("user.dir") + "\\exportFile\\HDSD\\2017_7_ApplicationDevelopment_UserManual.pdf")).exists()){
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll, FileProtocolHandler " + System.getProperty("user.dir") +"\\exportFile\\HDSD\\2017_7_ApplicationDevelopment_UserManual.pdf" );
            } else {
                JOptionPane.showMessageDialog(null, "File is not Exists");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
