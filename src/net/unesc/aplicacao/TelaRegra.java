package net.unesc.aplicacao;

import net.unesc.log.LogSistema;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import net.unesc.dao.RegraEventoDao;
import net.unesc.entidades.FormaAlerta;
import net.unesc.entidades.Regra;
import net.unesc.exceptions.BancoException;
import net.unesc.log.TipoLog;
import net.unesc.utilidades.DiaHora;
import net.unesc.utilidades.RetornoSimples;
import net.unesc.utilidades.TelaPadrao;

public class TelaRegra extends TelaPadrao {
    private RegraEventoDao regraEventoDao = new RegraEventoDao();
    private RetornoSimples<Regra> retornoSimples;
    DiaHora diaHora = new DiaHora();
    
    Regra regra = new Regra();
    
    public void setRetornoSimples(RetornoSimples<Regra> retornoSimples) {
        this.retornoSimples = retornoSimples;
    }
    
    public TelaRegra(Regra regra) {
        this();
        preenche(regra);
        ativaBotoes();
    }
    
    public TelaRegra() {
        initComponents();
        LogSistema.inserir(TipoLog.FUNCAO, "Abriu a função Regra do Evento");
        MaskFormatter dataMaskInicio = new MaskFormatter();
        MaskFormatter dataMaskFim = new MaskFormatter();
        try {
            dataMaskInicio.setMask("##/##/####");
            dataMaskFim.setMask("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }
     
        dataMaskInicio.install(jTxtInicioVigencia);
        dataMaskFim.install(jTxtFimVigencia);
    }
    
    public void ativaBotoes(){
        jbExcluir.setEnabled(true);
    }
    
    private void preenche(Regra regra)  {
        if (regra != null)
        {
            jTxtDescricao.setText(regra.getNome());
            jTxtInicioVigencia.setText(diaHora.formatarData(regra.getInicioVigencia(),"dd/MM/yyyy"));
            jTxtFimVigencia.setText(diaHora.formatarData(regra.getFimVigencia(),"dd/MM/yyyy"));
            jTxtHoras.setText(regra.getHora().toString());
            jTxtMinutos.setText(regra.getMinuto().toString());
            jTxtSegundos.setText(regra.getSegundo().toString());
            jTxtMilesimos.setText(regra.getMilesimos().toString());
            
            if(regra.getSituacao().equals("A")){
                jCkSituacao.setSelected(true);
            }else{
                jCkSituacao.setSelected(false);
            }
            
            if(regra.getTipoHorario().equals("CH")){
                this.jRadioCadaHora.setSelected(true);
                this.jRadioHoraFixo.setSelected(false);
                desativaAtivaDias("D");
                limpaDias();
                
            }else{
                this.jRadioCadaHora.setSelected(false);
                this.jRadioHoraFixo.setSelected(true);
                desativaAtivaDias("A");
                
                if(!regra.getDiaSemana(0)){
                    jCkDomingo.setSelected(true);
                }else{
                    jCkDomingo.setSelected(false);
                    jCkTodos.setSelected(false);
                }

                if(!regra.getDiaSemana(1)){
                    jCkSegunda.setSelected(true);
                }else{
                    jCkSegunda.setSelected(false);
                    jCkTodos.setSelected(false);
                }

                if(!regra.getDiaSemana(2)){
                    jCkTerca.setSelected(true);
                }else{
                    jCkTerca.setSelected(false);
                    jCkTodos.setSelected(false);
                }

                if(!regra.getDiaSemana(3)){
                    jCkQuarta.setSelected(true);
                }else{
                    jCkQuarta.setSelected(false);
                    jCkTodos.setSelected(false);
                }

                if(!regra.getDiaSemana(4)){
                    jCkQuinta.setSelected(true);
                }else{
                    jCkQuinta.setSelected(false);
                    jCkTodos.setSelected(false);
                }

                if(!regra.getDiaSemana(5)){
                    jCkSexta.setSelected(true);
                }else{
                    jCkSexta.setSelected(false);
                    jCkTodos.setSelected(false);
                }

                if(!regra.getDiaSemana(6)){
                    jCkSabado.setSelected(true);
                }else{
                    jCkSabado.setSelected(false);
                    jCkTodos.setSelected(false);
                }
                
            }
        }
    }
    
    public void limpaDias(){
        this.jCkDomingo.setSelected(false);
        this.jCkSegunda.setSelected(false);
        this.jCkTerca.setSelected(false);
        this.jCkQuarta.setSelected(false);
        this.jCkQuinta.setSelected(false);
        this.jCkSexta.setSelected(false);
        this.jCkSabado.setSelected(false);
        this.jCkTodos.setSelected(false);
    }
    
    private void desativaAtivaDias(String opcao){
        if(opcao.equals("A")){
            this.jCkDomingo.setEnabled(true);
            this.jCkSegunda.setEnabled(true);
            this.jCkTerca.setEnabled(true);
            this.jCkQuarta.setEnabled(true);
            this.jCkQuinta.setEnabled(true);
            this.jCkSexta.setEnabled(true);
            this.jCkSabado.setEnabled(true);
            this.jCkTodos.setEnabled(true);
        }else{
            this.jCkDomingo.setEnabled(false);
            this.jCkSegunda.setEnabled(false);
            this.jCkTerca.setEnabled(false);
            this.jCkQuarta.setEnabled(false);
            this.jCkQuinta.setEnabled(false);
            this.jCkSexta.setEnabled(false);
            this.jCkSabado.setEnabled(false);
            this.jCkTodos.setEnabled(false);
        }
    }
    
    private void limpar() {
        this.jTxtDescricao.setText("");
        this.jTxtInicioVigencia.setText("");
        this.jTxtFimVigencia.setText("");
        this.jTxtHoras.setText("");
        this.jTxtMinutos.setText("");
        this.jTxtSegundos.setText("");
        this.jTxtMilesimos.setText("");
        
        desativaAtivaDias("A");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTxtDescricao = new javax.swing.JTextField();
        jCkSituacao = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTxtFimVigencia = new javax.swing.JFormattedTextField();
        jTxtInicioVigencia = new javax.swing.JFormattedTextField();
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
        jRadioCadaHora = new javax.swing.JRadioButton();
        jTxtHoras = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTxtMinutos = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jTxtSegundos = new javax.swing.JFormattedTextField();
        jTxtMilesimos = new javax.swing.JFormattedTextField();

        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Regra do Evento");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Definições da Regra"));

        jLabel15.setText("Descrição");

        jCkSituacao.setSelected(true);
        jCkSituacao.setText("Ativo");

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
                        .addComponent(jTxtInicioVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFimVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTxtDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCkSituacao)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTxtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCkSituacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jTxtFimVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtInicioVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);
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
        jCkDomingo.setLabel("Domingo");
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

        jRadioCadaHora.setText("A cada horário");
        jRadioCadaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioCadaHoraActionPerformed(evt);
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
                        .addComponent(jRadioCadaHora)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioHoraFixo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtMilesimos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioCadaHora)
                    .addComponent(jRadioHoraFixo))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTxtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jTxtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTxtSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jTxtMilesimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(179, 179, 179)
                        .addComponent(jbGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGravarActionPerformed
        try
        {
            regra.setNome(jTxtDescricao.getText());
            regra.setUsuario(Aplicacao.SESSAO.usuario());
            regra.setDiaSemana(0, this.jCkDomingo.isSelected());
            regra.setDiaSemana(1, this.jCkSegunda.isSelected());
            regra.setDiaSemana(2, this.jCkTerca.isSelected());
            regra.setDiaSemana(3, this.jCkQuarta.isSelected());
            regra.setDiaSemana(4, this.jCkQuinta.isSelected());
            regra.setDiaSemana(5, this.jCkSexta.isSelected());
            regra.setDiaSemana(6, this.jCkSabado.isSelected());
            regra.setHora(jTxtHoras.getText());
            regra.setMinuto(jTxtMinutos.getText());
            regra.setSegundo(jTxtSegundos.getText());
            regra.setMilesimos(jTxtMilesimos.getText());
            regra.setInicioVigencia(jTxtInicioVigencia.getText());
            regra.setFimVigencia(jTxtFimVigencia.getText());
            regra.setTipoHorario(jRadioCadaHora.isSelected() ? "CH" : "HF");
            regra.setSituacao(jCkSituacao.isSelected() ? "A" : "I");
            
            if(!jbExcluir.isEnabled()){
                regraEventoDao.inserir(regra);
            }else{
                //regraEventoDao.alterar(regra);
            }
                        
            if (retornoSimples != null)
                retornoSimples.retorno(regra);
            limpar();
            setVisible(false);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_jbGravarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try{
            if(JOptionPane.showConfirmDialog( null,"Deseja realmente excluir o registro?\n"+
                    "Regra: "+regra.getCodigo()+" - "+regra.getNome(),
                    "Exclusão de registros",JOptionPane.YES_NO_OPTION)==0){
                regraEventoDao.excluirRegra(regra);
                limpar();
                //ativaDesativaCampos("D");
                
                if (retornoSimples != null)
                    retornoSimples.retorno(regra);
                limpar();
                setVisible(false);
            }
        }catch(BancoException e){
            JOptionPane.showMessageDialog(this, e.getMessage());  
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jRadioHoraFixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioHoraFixoActionPerformed
        this.jRadioCadaHora.setSelected(false);
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

    private void jRadioCadaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioCadaHoraActionPerformed
        this.jRadioHoraFixo.setSelected(false);
        this.jRadioCadaHora.setSelected(true);
        
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

            
    }//GEN-LAST:event_jRadioCadaHoraActionPerformed

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
    private javax.swing.JCheckBox jCkDomingo;
    private javax.swing.JCheckBox jCkQuarta;
    private javax.swing.JCheckBox jCkQuinta;
    private javax.swing.JCheckBox jCkSabado;
    private javax.swing.JCheckBox jCkSegunda;
    private javax.swing.JCheckBox jCkSexta;
    private javax.swing.JCheckBox jCkSituacao;
    private javax.swing.JCheckBox jCkTerca;
    private javax.swing.JCheckBox jCkTodos;
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
    private javax.swing.JRadioButton jRadioCadaHora;
    private javax.swing.JRadioButton jRadioHoraFixo;
    private javax.swing.JTextField jTxtDescricao;
    private javax.swing.JFormattedTextField jTxtFimVigencia;
    private javax.swing.JFormattedTextField jTxtHoras;
    private javax.swing.JFormattedTextField jTxtInicioVigencia;
    private javax.swing.JFormattedTextField jTxtMilesimos;
    private javax.swing.JFormattedTextField jTxtMinutos;
    private javax.swing.JFormattedTextField jTxtSegundos;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbGravar;
    // End of variables declaration//GEN-END:variables
}
