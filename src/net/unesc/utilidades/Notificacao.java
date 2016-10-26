/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unesc.utilidades;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

/**
 *
 * @author TI
 */
public class Notificacao {

    public Notificacao() {
        final TrayIcon trayIcon;
        if (SystemTray.isSupported()) {
        SystemTray tray = SystemTray.getSystemTray();
        
        URL url = System.class.getResource("/net/unesc/resources/icon.png");
        Image image = Toolkit.getDefaultToolkit().getImage(url);
            MouseListener mouseListener = new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                System.out.println("Tray Icon - Mouse clicked!");                 
            }

            public void mouseEntered(MouseEvent e) {
                System.out.println("Tray Icon - Mouse entered!");                 
            }

            public void mouseExited(MouseEvent e) {
                System.out.println("Tray Icon - Mouse exited!");                 
            }

            public void mousePressed(MouseEvent e) {
                System.out.println("Tray Icon - Mouse pressed!");                 
            }

            public void mouseReleased(MouseEvent e) {
                System.out.println("Tray Icon - Mouse released!");                 
            }
        };

            ActionListener exitListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting...");
                System.exit(0);
            }
        };

        PopupMenu popup = new PopupMenu();
        MenuItem defaultItem = new MenuItem("Sair");
        defaultItem.addActionListener(exitListener);
        popup.add(defaultItem);

        trayIcon = new TrayIcon(image, "Lembrete", popup);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trayIcon.displayMessage("sei la", 
                    "opaaaa",
                    TrayIcon.MessageType.INFO);
            }
        };

        trayIcon.setImageAutoSize(true);
        trayIcon.addActionListener(actionListener);
        trayIcon.addMouseListener(mouseListener);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.err.println("TrayIcon could not be added.");
        }

    }
        
 }
    
}
