package net.unesc.aplicacao;

import net.unesc.log.LogSistema;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import net.unesc.dao.RegraEventoDao;
import net.unesc.entidades.Regra;
import net.unesc.exceptions.BancoException;
import net.unesc.log.TipoLog;
import net.unesc.utilidades.RetornoSimples;
import net.unesc.utilidades.Tela;
import net.unesc.utilidades.TelaPadrao;

public class TelaListaRegras extends TelaPadrao {
    private RegraEventoDao regraEventoDao = new RegraEventoDao();
    private RetornoSimples<Regra> retornoSimples;
    private Regra regraSelecionada;
 
    public void setRetornoSimples(RetornoSimples<Regra> retornoSimples) {
        this.retornoSimples = retornoSimples;
    }
    
    public TelaListaRegras() {
        initComponents();
        atualizarListaRegras();
    }
    
    private void atualizarListaRegras() {
        try
        {
            List<Regra> regras = regraEventoDao.getAll();
            jListRegras.setListData(new Vector(regras));
        }
        catch(BancoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void telaRegra(Regra regra) {
        TelaRegra telaRegra = new TelaRegra(regra);
        telaRegra.setRetornoSimples(new RetornoSimples<Regra>() {
            @Override
            public void retorno(Regra t) {
                retornoSimples.retorno(t);
                setVisible(false);
            }
        });
        TelaMenuPrincipal.jdPane.add((JInternalFrame)telaRegra);
        Tela.centralizar(telaRegra);
        telaRegra.show();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        srcContatos = new javax.swing.JScrollPane();
        jListRegras = new javax.swing.JList();
        jTxtPesquisar = new javax.swing.JTextField();
        jBtNovo = new javax.swing.JButton();
        jBtSelecionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBtAlterar = new javax.swing.JButton();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Regras");

        jListRegras.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListRegrasValueChanged(evt);
            }
        });
        srcContatos.setViewportView(jListRegras);

        jBtNovo.setText("Nova regra");
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

        jBtAlterar.setText("Alterar");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(srcContatos, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jBtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
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
                    .addComponent(jBtNovo)
                    .addComponent(jBtAlterar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListRegrasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListRegrasValueChanged
        Regra regra = (Regra) jListRegras.getSelectedValue();
        if (regra != null) {
            this.regraSelecionada = regra;
            jBtSelecionar.setEnabled(true);
            jBtAlterar.setEnabled(true);
        }
        else {
            jBtSelecionar.setEnabled(false);
            jBtAlterar.setEnabled(false);
        }
    }//GEN-LAST:event_jListRegrasValueChanged

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        telaRegra(null);
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        retornoSimples.retorno(regraSelecionada);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        retornoSimples.retorno(regraSelecionada);
        telaRegra(regraSelecionada);
    }//GEN-LAST:event_jBtAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jListRegras;
    private javax.swing.JTextField jTxtPesquisar;
    private javax.swing.JScrollPane srcContatos;
    // End of variables declaration//GEN-END:variables
}
