/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unesc.aplicacao;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import net.unesc.log.LogSistema;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.unesc.log.TipoLog;
import net.unesc.utilidades.Notificacao;
import net.unesc.utilidades.Server;
import net.unesc.utilidades.Tela;

public class TelaMenuPrincipal extends javax.swing.JFrame {
    public static final Notificacao NOTIFICACAO = new Notificacao();
    /**
     * Creates new form Menu
     */
    public TelaMenuPrincipal() {
        initComponents();
        Tela.configuraIcone(this);
        Tela.centralizar(jlLogo);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt)throws NullPointerException{
                setVisible(false);
                NOTIFICACAO.ICON.displayMessage("Aplicação rodando em segundo plano", 
                    "Para sair clique com o botão direito nesse ícone e clique em 'Sair'",
                    TrayIcon.MessageType.INFO);
            }
        });
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdPane = new javax.swing.JDesktopPane();
        jlLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmCadUsuario = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jdPane.setBackground(new java.awt.Color(255, 255, 255));
        jdPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jdPane.setOpaque(false);

        jlLogo.setBackground(new java.awt.Color(255, 255, 255));
        jlLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/unesc/resources/background.png"))); // NOI18N
        jdPane.add(jlLogo);
        jlLogo.setBounds(50, 110, 230, 160);

        jMenu1.setText("Menu");

        jmCadUsuario.setText("Usuário");
        jmCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(jmCadUsuario);

        jMenuItem1.setText("Eventos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Regras");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdPane, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdPane, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jmCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadUsuarioActionPerformed
        JInternalFrame jfCadUsuario = new TelaUsuario();
        this.jdPane.add(jfCadUsuario);
        Tela.centralizar(jfCadUsuario);
        jfCadUsuario.show();
    }//GEN-LAST:event_jmCadUsuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JInternalFrame jfEvento = new TelaEvento();
        JInternalFrame jfRegra = new TelaRegra();
        this.jdPane.add(jfEvento);
        this.jdPane.add(jfRegra);
        Tela.centralizar(jfEvento);
        Tela.centralizar(jfRegra);
        jfEvento.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        JInternalFrame jfRegra = new TelaRegra();
        this.jdPane.add(jfRegra);
        Tela.centralizar(jfRegra);
        jfRegra.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    public static javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JDesktopPane jdPane;
    public static javax.swing.JLabel jlLogo;
    private javax.swing.JMenuItem jmCadUsuario;
    // End of variables declaration//GEN-END:variables
}
