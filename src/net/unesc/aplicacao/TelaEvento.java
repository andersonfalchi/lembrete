/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unesc.aplicacao;
 
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.unesc.entidades.Evento;
import net.unesc.entidades.FormaAlerta;
import net.unesc.exceptions.LoginException;
import net.unesc.utilidades.CorUtil;
import net.unesc.utilidades.JavaMailApp;
import net.unesc.utilidades.SmsSender;
import net.unesc.utilidades.TelaPadrao;

/**
 *
 * @author TI
 */
public class TelaEvento extends TelaPadrao {

    public TelaEvento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTxtDescricao = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jbTipoEvento = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jTxtCor = new javax.swing.JTextField();
        jbColor = new javax.swing.JButton();
        jbRegra = new javax.swing.JButton();
        jCkEmail = new javax.swing.JCheckBox();
        jCkPopUp = new javax.swing.JCheckBox();
        jCkNotificacao = new javax.swing.JCheckBox();
        jCkSms = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTxtDdd = new javax.swing.JTextField();
        jTxtNumero = new javax.swing.JTextField();
        jbExcluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Cadastro de Eventos");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setText("Descrição:");

        jTxtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtDescricaoActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Ativo");

        jLabel16.setText("Forma de Alerta:");

        jLabel17.setText("Tipo Evento:");

        jbTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Almoço", "Gasolina" }));

        jLabel18.setText("Cor Alerta");

        jTxtCor.setEditable(false);
        jTxtCor.setBackground(new java.awt.Color(0, 204, 204));
        jTxtCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCorActionPerformed(evt);
            }
        });

        jbColor.setText("...");
        jbColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbColorActionPerformed(evt);
            }
        });

        jbRegra.setText("Adicionar Regra");
        jbRegra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegraActionPerformed(evt);
            }
        });

        jCkEmail.setText("E-mail");

        jCkPopUp.setText("POPUP");

        jCkNotificacao.setText("Notificação");

        jCkSms.setText("SMS");

        jLabel19.setText("E-mail");

        jLabel20.setText("Celular");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jbColor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTxtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbTipoEvento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addGap(4, 4, 4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCkEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCkSms)
                                .addGap(13, 13, 13)
                                .addComponent(jCkPopUp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCkNotificacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbRegra)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTxtDdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jCkEmail)
                    .addComponent(jCkPopUp)
                    .addComponent(jCkNotificacao)
                    .addComponent(jCkSms)
                    .addComponent(jbRegra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jTxtDdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jbTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jbColor))
                    .addComponent(jTxtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbGravar.setText("Gravar");
        jbGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jbGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGravar)
                    .addComponent(jbExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
        Evento evento = new Evento();  
        
        try
        {
            evento.setCor(CorUtil.colorParaHexadecimal(jTxtCor.getBackground()));
            evento.setDescricao(jTxtDescricao.getText());
//            evento.setRegra(regra);
    //        evento.setTipoEvento(jbTipoEvento.getModel().getSelectedItem().toString());
            evento.setUsuario(Aplicacao.sessao.usuario());

        
            if(this.jCkEmail.isSelected()){
                JavaMailApp enviarEmail = new JavaMailApp();
                evento.addFormaAlerta(FormaAlerta.EMAIL);
                if(!this.jTxtEmail.getText().isEmpty()){
                    enviarEmail.setEmailDestino(this.jTxtEmail.getText());
                    enviarEmail.setTipoEvento(this.jbTipoEvento.getSelectedItem().toString());
                    try{
                        enviarEmail.EnviarEmail();
                        JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso!","Envio de e-mail",JOptionPane.INFORMATION_MESSAGE );
                    }catch(Exception e ){
                        e.printStackTrace(System.out);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Campo e-mail é obrigatório!","Atenção",JOptionPane.WARNING_MESSAGE);
                    this.jTxtEmail.grabFocus();
                } 
            }

            if(this.jCkSms.isSelected()){
                evento.addFormaAlerta(FormaAlerta.SMS);
                SmsSender enviarSms = new SmsSender();
                if(this.jTxtDdd.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo DDD é obrigatório!","Atenção",JOptionPane.INFORMATION_MESSAGE );
                    return;
                }

                if(this.jTxtNumero.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Campo número é obrigatório!","Atenção",JOptionPane.INFORMATION_MESSAGE );
                    return;
                }

                enviarSms.setTipoEvento(this.jbTipoEvento.getSelectedItem().toString());
                enviarSms.setDdd(Integer.parseInt(this.jTxtDdd.getText()));
                enviarSms.setNumeroCelular(Integer.parseInt(this.jTxtNumero.getText()));
                enviarSms.SmsSender();
                JOptionPane.showMessageDialog(null, "SMS enviada com sucesso!","Envio de SMS",JOptionPane.INFORMATION_MESSAGE );
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
  
    }//GEN-LAST:event_jbGravarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed

    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jTxtCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCorActionPerformed

    }//GEN-LAST:event_jTxtCorActionPerformed

    private void jbColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbColorActionPerformed
        JColorChooser chooser = new JColorChooser();
        Color cor = chooser.showDialog(chooser, "SHOW THE COLOR", chooser.getColor());
        jTxtCor.setBackground(cor);
    }//GEN-LAST:event_jbColorActionPerformed

    private void jbRegraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegraActionPerformed
        JInternalFrame regra = (JInternalFrame) new TelaRegra();
        TelaMenuPrincipal.jdPane.add(regra);
        int lDesk = TelaMenuPrincipal.jdPane.getWidth();
        int aDesk = TelaMenuPrincipal.jdPane.getHeight();
        int lIFrame = regra.getWidth();
        int aIFrame = regra.getHeight();
        regra.setLocation( lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2 );
        regra.show();
    }//GEN-LAST:event_jbRegraActionPerformed

    private void jTxtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtDescricaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCkEmail;
    private javax.swing.JCheckBox jCkNotificacao;
    private javax.swing.JCheckBox jCkPopUp;
    private javax.swing.JCheckBox jCkSms;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtCor;
    private javax.swing.JTextField jTxtDdd;
    private javax.swing.JTextField jTxtDescricao;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtNumero;
    private javax.swing.JButton jbColor;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbGravar;
    private javax.swing.JButton jbRegra;
    private javax.swing.JComboBox<String> jbTipoEvento;
    // End of variables declaration//GEN-END:variables
}