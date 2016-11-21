/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unesc.utilidades;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import net.unesc.aplicacao.TelaMenuPrincipal;

public class Tela {
    public static void centralizar(JLabel jLabel){
        Dimension dimension = jLabel.getParent().getSize();  
        jLabel.setLocation((dimension.width - jLabel.getSize().width) / 2, (dimension.height - jLabel.getSize().height) / 2);   
    }
    
    public static void centralizar(JInternalFrame fr){  
        Dimension d = fr.getDesktopPane().getSize();  
        fr.setLocation((d.width - fr.getSize().width) / 2, (d.height - fr.getSize().height) / 2);     
    }  
    
    public static void centralizar(JFrame fr){  
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        fr.setLocation((d.width - fr.getSize().width) / 2, (d.height - fr.getSize().height) / 2);     
    } 
    
    public static void configuraIcone(JFrame frame) {
        try {
            Image i = ImageIO.read(frame.getClass().getResource("/net/unesc/resources/icon.png"));
            frame.setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(TelaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
