/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unesc.aplicacao;

import net.unesc.log.LogSistema;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.unesc.log.TipoLog;
import net.unesc.utilidades.Notificacao;
import net.unesc.utilidades.Tela;

/**
 *
 * @author TI
 */
public class TelaMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public TelaMenuPrincipal() {
        initComponents();
        
        addWindowListener(new WindowAdapter() {
          
            public void windowClosing(WindowEvent evt)throws NullPointerException{
                if (JOptionPane.showConfirmDialog(null,"Deseja sair?","Sistema Lembrete",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                    
                    try{
                        if(!Aplicacao.sessao.usuarioLogado.getLogin().trim().isEmpty())
                            LogSistema.inserir(TipoLog.LOGOFF, "Logoff no sistema");
                
                    }catch(NullPointerException e){
                        throw new NullPointerException("Não existe usuário logado!");
                    }finally{
                        System.exit(0);
                    }
                    
                }
            }
        });
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdPane = new javax.swing.JDesktopPane();
        jlLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jmCadUsuario = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jdPane.setBackground(new java.awt.Color(255, 255, 255));
        jdPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jdPane.setOpaque(false);

        jlLogo.setBackground(new java.awt.Color(255, 255, 255));
        jlLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/unesc/resources/logoUnesc.png"))); // NOI18N
        jdPane.add(jlLogo);
        jlLogo.setBounds(350, 80, 570, 440);

        jMenu1.setText("Funções");
        jMenu1.setEnabled(false);

        jMenu3.setText("Cadastros");

        jmCadUsuario.setText("Usuário");
        jmCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadUsuarioActionPerformed(evt);
            }
        });
        jMenu3.add(jmCadUsuario);

        jMenu1.add(jMenu3);

        jMenuItem1.setText("Eventos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

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
    
    Notificacao notificacao   = new Notificacao();
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    public static javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JDesktopPane jdPane;
    public static javax.swing.JLabel jlLogo;
    private javax.swing.JMenuItem jmCadUsuario;
    // End of variables declaration//GEN-END:variables
}
