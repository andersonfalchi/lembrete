/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unesc.utilidades;

import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class Tela {
    public static void centralizar(JLabel jLabel){
        Dimension dimension = jLabel.getParent().getSize();  
        jLabel.setLocation((dimension.width - jLabel.getSize().width) / 2, (dimension.height - jLabel.getSize().height) / 2);   
    }
    
    public static void centralizar(JInternalFrame fr){  
        Dimension d = fr.getDesktopPane().getSize();  
        fr.setLocation((d.width - fr.getSize().width) / 2, (d.height - fr.getSize().height) / 2);     
    }  
}
