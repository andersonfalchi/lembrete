package net.unesc.aplicacao;

import net.unesc.log.LogSistema;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
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
    private Usuario usuarioSelecionado;
 
    public void setRetornoSimples(RetornoSimples<Usuario> retornoSimples) {
        this.retornoSimples = retornoSimples;
    }
    
    public TelaListaUsuarios() {
        initComponents();
        atualizarListaUsuarios();
    }
    
    private void atualizarListaUsuarios() {
        try
        {
            List<Usuario> usuarios = usuarioDao.getAll();
            jListUsuarios.setListData(new Vector(usuarios));
        }
        catch(BancoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void telaUsuario(Usuario usuario) {
        TelaUsuario telaUsuario = new TelaUsuario(usuario);

        telaUsuario.setRetornoSimples(new RetornoSimples<Usuario>() {
            @Override
            public void retorno(Usuario t) {
                retornoSimples.retorno(t);
                setVisible(false);
            }
        });
        TelaMenuPrincipal.jdPane.add((JInternalFrame)telaUsuario);
        Tela.centralizar(telaUsuario);
        telaUsuario.show();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        srcContatos = new javax.swing.JScrollPane();
        jListUsuarios = new javax.swing.JList();
        jTxtPesquisar = new javax.swing.JTextField();
        jBtNovo = new javax.swing.JButton();
        jBtSelecionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Regras");

        jListUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListUsuariosValueChanged(evt);
            }
        });
        srcContatos.setViewportView(jListUsuarios);

        jBtNovo.setText("Novo Cadastro");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.setEnabled(false);
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
            }
        });

        jLabel1.setText("Pesquisar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(srcContatos, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtPesquisar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srcContatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtSelecionar)
                    .addComponent(jBtNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListUsuariosValueChanged
        Usuario usuario = (Usuario) jListUsuarios.getSelectedValue();
        if (usuario != null) {
            this.usuarioSelecionado = usuario;
            jBtSelecionar.setEnabled(true);
        }
        else {
            jBtSelecionar.setEnabled(false);
        }
    }//GEN-LAST:event_jListUsuariosValueChanged

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        telaUsuario(null);
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        retornoSimples.retorno(usuarioSelecionado);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jBtSelecionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jListUsuarios;
    private javax.swing.JTextField jTxtPesquisar;
    private javax.swing.JScrollPane srcContatos;
    // End of variables declaration//GEN-END:variables
}
