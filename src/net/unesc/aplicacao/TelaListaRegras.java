package net.unesc.aplicacao;

import net.unesc.log.LogSistema;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import net.unesc.dao.RegraEventoDao;
import net.unesc.entidades.Regra;
import net.unesc.exceptions.BancoException;
import net.unesc.log.TipoLog;
import net.unesc.utilidades.RetornoSimples;
import net.unesc.utilidades.TelaPadrao;

public class TelaListaRegras extends TelaPadrao {
    private RegraEventoDao regraEventoDao = new RegraEventoDao();
    private RetornoSimples<Regra> retornoSimples;
    
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        srcContatos = new javax.swing.JScrollPane();
        jListRegras = new javax.swing.JList();
        jTxtPesquisar = new javax.swing.JTextField();
        jBtNovo = new javax.swing.JButton();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Regras");

        jListRegras.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListRegrasValueChanged(evt);
            }
        });
        srcContatos.setViewportView(jListRegras);

        jBtNovo.setText("Novo");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                    .addComponent(srcContatos))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtPesquisar)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srcContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListRegrasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListRegrasValueChanged
//        Pessoa c = (Pessoa) jListRegras.getSelectedValue();
//        if (c != null) {
//            contato = c;
//            txtNome.setText(contato.getNome());
//            txtEndereco.setText(contato.getEndereco());
//            txtTelefone.setText(contato.getTelefone());
//        }
    }//GEN-LAST:event_jListRegrasValueChanged

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtNovoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtNovo;
    private javax.swing.JList jListRegras;
    private javax.swing.JTextField jTxtPesquisar;
    private javax.swing.JScrollPane srcContatos;
    // End of variables declaration//GEN-END:variables
}
