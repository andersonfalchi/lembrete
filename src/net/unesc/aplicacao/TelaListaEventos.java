package net.unesc.aplicacao;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.unesc.dao.EventoDao;
import net.unesc.entidades.Evento;
//import net.unesc.dao.EventoDao;

import net.unesc.exceptions.BancoException;
import net.unesc.exceptions.CampoObrigatorioException;
import net.unesc.utilidades.RetornoSimples;
import net.unesc.utilidades.TelaPadrao;

public class TelaListaEventos extends TelaPadrao {
    private EventoDao eventoDao = new EventoDao();
    private RetornoSimples<Evento> retornoSimples;
    private ArrayList<Evento> eventos;
    DefaultTableModel model = new DefaultTableModel();
    
    public void setRetornoSimples(RetornoSimples<Evento> retornoSimples) {
        this.retornoSimples = retornoSimples;
    }
    
    public TelaListaEventos() throws BancoException, CampoObrigatorioException {
        initComponents();
        montaGrid();
        eventos = eventoDao.getAll();
        atualizarListaEventos(eventos);
    }
    
    private void atualizarListaEventos(ArrayList<Evento> eventos){
        try
        {
            Integer linha=0;
  
            for(Evento t : eventos){
                    adicionaLinha();
                    jTableEventos.setValueAt(t.getCodigo(), linha, 0);
                    jTableEventos.setValueAt(t.getDescricao(), linha, 1);
                    jTableEventos.setValueAt(t.getSituacao(), linha, 2);
                    linha++;
            }
    
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void montaGrid(){
        model.addColumn("Código");
        model.addColumn("Descrição");
        model.addColumn("Situação");
    }
    
    private void adicionaLinha(){
         model.insertRow(jTableEventos.getRowCount(), new Object[] {});
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

        jBtSelecionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEventos = new javax.swing.JTable(model);
        jButton1 = new javax.swing.JButton();
        jTxtFiltroNome = new javax.swing.JTextField();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Regras");

        jBtSelecionar.setText("Selecionar");
        jBtSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSelecionarActionPerformed(evt);
            }
        });

        jLabel1.setText("Descrição");

        jTableEventos.setModel(model);
        jScrollPane2.setViewportView(jTableEventos);

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jBtSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 226, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFiltroNome)
                        .addGap(24, 24, 24)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jTxtFiltroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jBtSelecionar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSelecionarActionPerformed
        
        try{
            if(jTableEventos.getSelectedRow() <0)
                throw new IllegalArgumentException("Nenhum evento selecionado!");
            
            Evento evento = (Evento)eventos.get(jTableEventos.getSelectedRow());
            retornoSimples.retorno(evento);
            setVisible(false);
            dispose();
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, e.getMessage());
        }   
    }//GEN-LAST:event_jBtSelecionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String descricao;
        descricao = jTxtFiltroNome.getText();
        
        limpaGrid();
        
//        try {
//            usuarios = usuarioDao.getUsuarios(login, nome);
//            atualizarListaUsuarios(usuarios);
//        } catch (BancoException ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage());
//        }
                
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtSelecionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEventos;
    private javax.swing.JTextField jTxtFiltroNome;
    // End of variables declaration//GEN-END:variables
}
