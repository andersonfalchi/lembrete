package net.unesc.aplicacao;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.unesc.dao.UsuarioDao;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.BancoException;
import net.unesc.log.LogSistema;
import net.unesc.log.TipoLog;
import net.unesc.utilidades.RetornoSimples;
import net.unesc.utilidades.*;

public class TelaUsuario extends TelaPadrao {
    private UsuarioDao usuarioDao = new UsuarioDao();
    private RetornoSimples<Usuario> retornoSimples;
    private Usuario usuario = null;    

    
    public void setRetornoSimples(RetornoSimples<Usuario> retornoSimples) {
        this.retornoSimples = retornoSimples;
    }
    
    public TelaUsuario(Usuario usuario) {
        this();
        //preenche(usuario);
    }
    
    public TelaUsuario() {
        initComponents();
        LogSistema.inserir(TipoLog.FUNCAO, "Abriu a função Cadastro de usuários");
        this.jCBSituacao.setSelected(true);
    }

    public void ativaDesativaCampos(String opcao){
        if(opcao == "A"){
            jTxtNome.setEnabled(true);
            jTxtUsuario.setEnabled(true);
            jTxtSenha.setEnabled(true);
            jCBSituacao.setEnabled(true);
           // jBConsultar.setEnabled(true);
            //jBNovo.setEnabled(true);
            //jbExcluir.setEnabled(true);
            //jbGravar.setEnabled(true);
        }else{
            jTxtNome.setEnabled(false);
            jTxtUsuario.setEnabled(false);
            jTxtSenha.setEnabled(false);
            jCBSituacao.setEnabled(false);
            //jBConsultar.setEnabled(false);
            //jBNovo.setEnabled(false);
            //jbExcluir.setEnabled(false);
            //jbGravar.setEnabled(false);
        }      
    }
    
//    private void preenche(Usuario usuario) {
//        if (usuario != null)
//        {
////        jTxtInicioVigencia.setText(regra.getInicioVigencia());
//        }
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTxtUsuario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTxtSenha = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jCBSituacao = new javax.swing.JCheckBox();
        jbExcluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();
        jBConsultar = new javax.swing.JButton();
        jBNovo = new javax.swing.JButton();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Cadastro de Usuários");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTxtUsuario.setEnabled(false);

        jLabel14.setText("Usuário");

        jLabel12.setText("Senha");

        jTxtSenha.setEnabled(false);

        jLabel15.setText("Nome");

        jTxtNome.setEnabled(false);

        jCBSituacao.setSelected(true);
        jCBSituacao.setText("Ativo");
        jCBSituacao.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCBSituacao))
                            .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBSituacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbGravar.setText("Gravar");
        jbGravar.setEnabled(false);
        jbGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGravarActionPerformed(evt);
            }
        });

        jBConsultar.setText("Consultar");
        jBConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarActionPerformed(evt);
            }
        });

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGravar)
                    .addComponent(jbExcluir)
                    .addComponent(jBConsultar)
                    .addComponent(jBNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
        
        try{
            Usuario usuario = new Usuario();
            usuario.setLogin(this.jTxtUsuario.getText());
            usuario.setSenha(this.jTxtSenha.getText());
            usuario.setNome(this.jTxtNome.getText());
            usuario.setSituacao(this.jCBSituacao.isSelected()? "A" : "I");
            
            if(!jbExcluir.isEnabled()){
                usuarioDao.inserir(usuario);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!",
                        "Cadastro de usuário",JOptionPane.INFORMATION_MESSAGE);
            }else{
                usuarioDao.alteraUsuario(usuario);
                JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!",
                        "Cadastro de usuário",JOptionPane.INFORMATION_MESSAGE);
            }
            
            limpar();
            jbGravar.setEnabled(false);
            jbExcluir.setEnabled(false);
            ativaDesativaCampos("D");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }   
    }//GEN-LAST:event_jbGravarActionPerformed
    
    public void limpar(){
        jTxtNome.setText("");
        jTxtUsuario.setText("");
        jTxtSenha.setText("");
        jCBSituacao.setSelected(true);
        jTxtNome.grabFocus();
        usuario = null;
    }
    
    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try{
            if(JOptionPane.showConfirmDialog( null,"Deseja realmente excluir o registro?\n"+
                    "Usuário: "+usuario.getLogin().toUpperCase(),
                    "Exclusão de registros",JOptionPane.YES_NO_OPTION)==0){
                usuarioDao.excluirUsuario(usuario.getLogin());
                limpar();
                ativaDesativaCampos("D");
            }
        }catch(BancoException e){
            JOptionPane.showMessageDialog(this, e.getMessage());  
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed
          try{
            TelaListaUsuarios telaListaUsuarios = new TelaListaUsuarios();
            TelaMenuPrincipal.jdPane.add((JInternalFrame)telaListaUsuarios);
            Tela.centralizar(telaListaUsuarios);
            telaListaUsuarios.show();
            
            telaListaUsuarios.setRetornoSimples(new RetornoSimples<Usuario>() {
                @Override
                public void retorno(Usuario t) {
                    ativaDesativaCampos("A");
                    usuario = t;
                    jTxtNome.setText(t.getNome());
                    jTxtUsuario.setText(t.getLogin());
                    jTxtSenha.setText(t.getSenha());
                    
                    if(t.getSituacao().equals("A")){
                        jCBSituacao.setSelected(true);
                    }else{
                        jCBSituacao.setSelected(false);
                    }
                    
                    jbExcluir.setEnabled(true);
                    jbGravar.setEnabled(true);
                    
                }
            });
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        

    }//GEN-LAST:event_jBConsultarActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        ativaDesativaCampos("A");
        jbGravar.setEnabled(true);
        jbExcluir.setEnabled(false);
        limpar();
        usuario = new Usuario();
    }//GEN-LAST:event_jBNovoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConsultar;
    private javax.swing.JButton jBNovo;
    private javax.swing.JCheckBox jCBSituacao;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtSenha;
    private javax.swing.JTextField jTxtUsuario;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbGravar;
    // End of variables declaration//GEN-END:variables
}
