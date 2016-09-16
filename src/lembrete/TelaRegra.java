package lembrete;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author TI
 */
public class TelaRegra extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form Usuario
     */
    public TelaRegra() {
   
        initComponents();
        
        MaskFormatter TextField2 = new MaskFormatter();
        MaskFormatter TextField7 = new MaskFormatter();
        
        try {
            TextField2.setMask("##/##/####");
            TextField7.setMask("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(TelaRegra.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        TextField2.install(jFormattedTextField2);
        TextField7.install(jFormattedTextField7);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTxtUsuario1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField7 = new javax.swing.JFormattedTextField();
        jbExcluir = new javax.swing.JButton();
        jbGravar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCkDomingo = new javax.swing.JCheckBox();
        jCkSegunda = new javax.swing.JCheckBox();
        jCkTerca = new javax.swing.JCheckBox();
        jCkQuarta = new javax.swing.JCheckBox();
        jCkQuinta = new javax.swing.JCheckBox();
        jCkSexta = new javax.swing.JCheckBox();
        jCkSabado = new javax.swing.JCheckBox();
        jCkTodos = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jRadioHoraFixo = new javax.swing.JRadioButton();
        jRadioCaraHora = new javax.swing.JRadioButton();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
        jFormattedTextField6 = new javax.swing.JFormattedTextField();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Cadastro de Usuário");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Definições da Regra"));

        jLabel15.setText("Descrição");

        jCheckBox1.setText("Ativo");

        jLabel16.setText("Inicio Vigência");

        jLabel17.setText("Fim Vigência");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFormattedTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTxtUsuario1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTxtUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Frequência - Semana"));

        jCkDomingo.setSelected(true);
        jCkDomingo.setText("Domingo");
        jCkDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkDomingoActionPerformed(evt);
            }
        });

        jCkSegunda.setSelected(true);
        jCkSegunda.setText("Segunda");
        jCkSegunda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkSegundaActionPerformed(evt);
            }
        });

        jCkTerca.setSelected(true);
        jCkTerca.setText("Terça");
        jCkTerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkTercaActionPerformed(evt);
            }
        });

        jCkQuarta.setSelected(true);
        jCkQuarta.setText("Quarta");
        jCkQuarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkQuartaActionPerformed(evt);
            }
        });

        jCkQuinta.setSelected(true);
        jCkQuinta.setText("Quinta");
        jCkQuinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkQuintaActionPerformed(evt);
            }
        });

        jCkSexta.setSelected(true);
        jCkSexta.setText("Sexta");
        jCkSexta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkSextaActionPerformed(evt);
            }
        });

        jCkSabado.setSelected(true);
        jCkSabado.setText("Sabádo");
        jCkSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkSabadoActionPerformed(evt);
            }
        });

        jCkTodos.setSelected(true);
        jCkTodos.setText("Todos");
        jCkTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCkTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCkDomingo)
                            .addComponent(jCkQuinta)
                            .addComponent(jCkTerca)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jCkSabado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCkTodos)
                    .addComponent(jCkQuarta)
                    .addComponent(jCkSexta)
                    .addComponent(jCkSegunda))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCkDomingo)
                    .addComponent(jCkSegunda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCkTerca)
                    .addComponent(jCkQuarta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCkQuinta)
                    .addComponent(jCkSexta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCkSabado)
                    .addComponent(jCkTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Frequência - Horário"));

        jRadioHoraFixo.setSelected(true);
        jRadioHoraFixo.setText("Horário fixo");
        jRadioHoraFixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioHoraFixoActionPerformed(evt);
            }
        });

        jRadioCaraHora.setText("A cada horário");
        jRadioCaraHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCaraHoraActionPerformed(evt);
            }
        });

        jLabel18.setText("Horas (24h) ");

        jLabel19.setText("Minutos");

        jLabel20.setText("Segundos");

        jLabel21.setText("Milésimos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioCaraHora)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioHoraFixo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioCaraHora)
                    .addComponent(jRadioHoraFixo))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jbGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGravar)
                    .addComponent(jbExcluir))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbGravarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed

    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jRadioHoraFixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioHoraFixoActionPerformed
        this.jRadioCaraHora.setSelected(false);
        this.jRadioHoraFixo.setSelected(true);
        
        this.jCkDomingo.setEnabled(true);
        this.jCkSegunda.setEnabled(true);
        this.jCkTerca.setEnabled(true);
        this.jCkQuarta.setEnabled(true);
        this.jCkQuinta.setEnabled(true);
        this.jCkSexta.setEnabled(true);
        this.jCkSabado.setEnabled(true);
        this.jCkTodos.setEnabled(true);
        
    }//GEN-LAST:event_jRadioHoraFixoActionPerformed

    private void jRadioCaraHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioCaraHoraActionPerformed
        this.jRadioHoraFixo.setSelected(false);
        this.jRadioCaraHora.setSelected(true);
        
        this.jCkDomingo.setSelected(false);
        this.jCkSegunda.setSelected(false);
        this.jCkTerca.setSelected(false);
        this.jCkQuarta.setSelected(false);
        this.jCkQuinta.setSelected(false);
        this.jCkSexta.setSelected(false);
        this.jCkSabado.setSelected(false);
        this.jCkTodos.setSelected(false);
        
        this.jCkDomingo.setEnabled(false);
        this.jCkSegunda.setEnabled(false);
        this.jCkTerca.setEnabled(false);
        this.jCkQuarta.setEnabled(false);
        this.jCkQuinta.setEnabled(false);
        this.jCkSexta.setEnabled(false);
        this.jCkSabado.setEnabled(false);
        this.jCkTodos.setEnabled(false);

            
    }//GEN-LAST:event_jRadioCaraHoraActionPerformed

    private void jCkTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkTodosActionPerformed
        if (this.jCkTodos.isSelected()){
            this.jCkDomingo.setSelected(true);
            this.jCkSegunda.setSelected(true);
            this.jCkTerca.setSelected(true);
            this.jCkQuarta.setSelected(true);
            this.jCkQuinta.setSelected(true);
            this.jCkSexta.setSelected(true);
            this.jCkSabado.setSelected(true);
        }else{
            this.jCkDomingo.setSelected(false);
            this.jCkSegunda.setSelected(false);
            this.jCkTerca.setSelected(false);
            this.jCkQuarta.setSelected(false);
            this.jCkQuinta.setSelected(false);
            this.jCkSexta.setSelected(false);
            this.jCkSabado.setSelected(false);
        }
    }//GEN-LAST:event_jCkTodosActionPerformed

    private void jCkDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkDomingoActionPerformed
        if (this.jCkTodos.isSelected() && !this.jCkDomingo.isSelected()){
            this.jCkTodos.setSelected(false);
        }else if(
            this.jCkDomingo.isSelected()&&
            this.jCkSegunda.isSelected()&&
            this.jCkTerca.isSelected()&&
            this.jCkQuarta.isSelected()&&
            this.jCkQuinta.isSelected()&&
            this.jCkSexta.isSelected()&&
            this.jCkSabado.isSelected()){
            this.jCkTodos.setSelected(true);
        }
    }//GEN-LAST:event_jCkDomingoActionPerformed

    private void jCkTercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkTercaActionPerformed
        if (this.jCkTodos.isSelected() && !this.jCkTerca.isSelected()){
            this.jCkTodos.setSelected(false);
        }else if(
            this.jCkDomingo.isSelected()&&
            this.jCkSegunda.isSelected()&&
            this.jCkTerca.isSelected()&&
            this.jCkQuarta.isSelected()&&
            this.jCkQuinta.isSelected()&&
            this.jCkSexta.isSelected()&&
            this.jCkSabado.isSelected()){
            this.jCkTodos.setSelected(true);
        }
    }//GEN-LAST:event_jCkTercaActionPerformed

    private void jCkSegundaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkSegundaActionPerformed
        if (this.jCkTodos.isSelected() && !this.jCkSegunda.isSelected()){
            this.jCkTodos.setSelected(false);
        }else if(
            this.jCkDomingo.isSelected()&&
            this.jCkSegunda.isSelected()&&
            this.jCkTerca.isSelected()&&
            this.jCkQuarta.isSelected()&&
            this.jCkQuinta.isSelected()&&
            this.jCkSexta.isSelected()&&
            this.jCkSabado.isSelected()){
            this.jCkTodos.setSelected(true);
        }
    }//GEN-LAST:event_jCkSegundaActionPerformed

    private void jCkQuartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkQuartaActionPerformed
        if (this.jCkTodos.isSelected() && !this.jCkQuarta.isSelected()){
            this.jCkTodos.setSelected(false);
        }else if(
            this.jCkDomingo.isSelected()&&
            this.jCkSegunda.isSelected()&&
            this.jCkTerca.isSelected()&&
            this.jCkQuarta.isSelected()&&
            this.jCkQuinta.isSelected()&&
            this.jCkSexta.isSelected()&&
            this.jCkSabado.isSelected()){
            this.jCkTodos.setSelected(true);
        }
    }//GEN-LAST:event_jCkQuartaActionPerformed

    private void jCkQuintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkQuintaActionPerformed
        if (this.jCkTodos.isSelected() && !this.jCkQuinta.isSelected()){
            this.jCkTodos.setSelected(false);
        }else if(
            this.jCkDomingo.isSelected()&&
            this.jCkSegunda.isSelected()&&
            this.jCkTerca.isSelected()&&
            this.jCkQuarta.isSelected()&&
            this.jCkQuinta.isSelected()&&
            this.jCkSexta.isSelected()&&
            this.jCkSabado.isSelected()){
            this.jCkTodos.setSelected(true);
        }
    }//GEN-LAST:event_jCkQuintaActionPerformed

    private void jCkSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkSabadoActionPerformed
        if (this.jCkTodos.isSelected() && !this.jCkSabado.isSelected()){
            this.jCkTodos.setSelected(false);
        }else if(
            this.jCkDomingo.isSelected()&&
            this.jCkSegunda.isSelected()&&
            this.jCkTerca.isSelected()&&
            this.jCkQuarta.isSelected()&&
            this.jCkQuinta.isSelected()&&
            this.jCkSexta.isSelected()&&
            this.jCkSabado.isSelected()){
            this.jCkTodos.setSelected(true);
        }
    }//GEN-LAST:event_jCkSabadoActionPerformed

    private void jCkSextaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCkSextaActionPerformed
        if (this.jCkTodos.isSelected() && !this.jCkSexta.isSelected()){
            this.jCkTodos.setSelected(false);
        }else if(
            this.jCkDomingo.isSelected()&&
            this.jCkSegunda.isSelected()&&
            this.jCkTerca.isSelected()&&
            this.jCkQuarta.isSelected()&&
            this.jCkQuinta.isSelected()&&
            this.jCkSexta.isSelected()&&
            this.jCkSabado.isSelected()){
            this.jCkTodos.setSelected(true);
        }
    }//GEN-LAST:event_jCkSextaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCkDomingo;
    private javax.swing.JCheckBox jCkQuarta;
    private javax.swing.JCheckBox jCkQuinta;
    private javax.swing.JCheckBox jCkSabado;
    private javax.swing.JCheckBox jCkSegunda;
    private javax.swing.JCheckBox jCkSexta;
    private javax.swing.JCheckBox jCkTerca;
    private javax.swing.JCheckBox jCkTodos;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JFormattedTextField jFormattedTextField6;
    private javax.swing.JFormattedTextField jFormattedTextField7;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioCaraHora;
    private javax.swing.JRadioButton jRadioHoraFixo;
    private javax.swing.JTextField jTxtUsuario1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbGravar;
    // End of variables declaration//GEN-END:variables
}
