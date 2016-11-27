package net.unesc.aplicacao;

import java.sql.ResultSet;
import java.sql.SQLException;
import net.unesc.log.LogSistema;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import net.unesc.dao.RegraEventoDao;
import net.unesc.dao.UsuarioDao;
import net.unesc.entidades.Regra;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.BancoException;
import net.unesc.log.TipoLog;
import net.unesc.utilidades.RetornoSimples;
import net.unesc.utilidades.Tela;
import net.unesc.utilidades.TelaPadrao;

public class TelaListaUsuarios extends TelaPadrao {
    private UsuarioDao usuarioDao = new UsuarioDao();
    private RetornoSimples<Usuario> retornoSimples;
    private ArrayList<Usuario> usuarios;
    DefaultTableModel model = new DefaultTableModel();
    
    public void setRetornoSimples(RetornoSimples<Usuario> retornoSimples) {
        this.retornoSimples = retornoSimples;
    }
    
    public TelaListaUsuarios() throws BancoException {
        initComponents();
        montaGrid();
        usuarios = usuarioDao.getAll();
        atualizarListaUsuarios(usuarios);
    }
    
    private void atualizarListaUsuarios(ArrayList<Usuario> usuarios){
        try
        {
            Integer linha=0;
  
            for(Usuario t : usuarios){
                    adicionaLinha();
                    jTableUsuarios.setValueAt(t.getNome(), linha, 0);
                    jTableUsuarios.setValueAt(t.getLogin(), linha, 1);
                    jTableUsuarios.setValueAt(t.getSituacao(), linha, 2);
                    linha++;
            }
    
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void montaGrid(){
        model.addColumn("Nome");
        model.addColumn("Usuário");
        model.addColumn("Situação");
    }
    
    private void adicionaLinha(){
         model.insertRow(jTableUsuarios.getRowCount(), new Object[] {});
    }
    
    private void limpaGrid(){
        while(model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtFiltroLogin = new javax.swing.JTextField();
        jBtSelecionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable(model);
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTxtFiltroNome = new javax.swing.JTextField();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Usuários");

        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jTableUsuarios.setModel(model);
        jScrollPane2.setViewportView(jTableUsuarios);

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFiltroLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtFiltroLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(jTxtFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSelecionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        
        try{
            if(jTableUsuarios.getSelectedRow() <0)
                throw new IllegalArgumentException("Nenhum usuário selecionado!");
            
            Usuario usuario = (Usuario)usuarios.get(jTableUsuarios.getSelectedRow());
            retornoSimples.retorno(usuario);
            setVisible(false);
            dispose();
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, e.getMessage());
        }   
    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String login, nome;
        login = jTxtFiltroLogin.getText();
        nome = jTxtFiltroNome.getText();
        
        limpaGrid();
        
        try {
            usuarios = usuarioDao.getUsuarios(login, nome);
            atualizarListaUsuarios(usuarios);
        } catch (BancoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
                
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTxtFiltroLogin;
    private javax.swing.JTextField jTxtFiltroNome;
    // End of variables declaration//GEN-END:variables
}
