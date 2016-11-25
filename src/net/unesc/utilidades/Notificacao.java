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
import net.unesc.aplicacao.Aplicacao;
import net.unesc.aplicacao.TelaMenuPrincipal;
import net.unesc.log.LogSistema;
import net.unesc.log.TipoLog;

/**
 *
 * @author TI
 */
public class Notificacao {
    public TrayIcon ICON;
    public Notificacao() {
        if (!SystemTray.isSupported())
        {
            return;   
        }
        SystemTray tray = SystemTray.getSystemTray();

        URL url = System.class.getResource("/net/unesc/resources/icon.png");
        Image image = Toolkit.getDefaultToolkit().getImage(url);
            MouseListener mouseListener = new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                //System.out.println("Tray Icon - Mouse clicked!");                 
            }

            public void mouseEntered(MouseEvent e) {
                //System.out.println("Tray Icon - Mouse entered!");                 
            }

            public void mouseExited(MouseEvent e) {
                //System.out.println("Tray Icon - Mouse exited!");                 
            }

            public void mousePressed(MouseEvent e) {
                //System.out.println("Tray Icon - Mouse pressed!");                 
            }

            public void mouseReleased(MouseEvent e) {
                //System.out.println("Tray Icon - Mouse released!");                 
            }
        };

            ActionListener exitListener = new ActionListener() {
            public void actionPerformed(ActionEvent e)throws NullPointerException {
                Aplicacao.sair();
            }
        };

        PopupMenu popup = new PopupMenu();
        MenuItem defaultItem = new MenuItem("Sair");
        defaultItem.addActionListener(exitListener);
        popup.add(defaultItem);

        ICON = new TrayIcon(image, "Lembrete", popup);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Aplicacao.TELA_MENU_PRINCIPAL != null)
                    Aplicacao.TELA_MENU_PRINCIPAL.setVisible(true);
            }
        };

        ICON.setImageAutoSize(true);
        ICON.addActionListener(actionListener);
        ICON.addMouseListener(mouseListener);

        try {
            tray.add(ICON);
        } catch (AWTException e) {
            System.err.println("TrayIcon could not be added.");
        }
    }
    
}
