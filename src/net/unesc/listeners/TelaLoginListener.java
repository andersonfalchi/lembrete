/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unesc.listeners;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.unesc.aplicacao.Aplicacao;
import net.unesc.aplicacao.TelaMenuPrincipal;

public class TelaLoginListener implements ActionListener {

    private JFrame tela;
    private JTextField txtLogin;   
    private JTextField txtSenha;

    public TelaLoginListener(JFrame tela, JTextField txtLogin, JTextField txtSenha) {
        this.tela = tela;
        this.txtLogin = txtLogin;
        this.txtSenha = txtSenha;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch(actionEvent.getActionCommand().toLowerCase()) {
            case "logar":
                try
                {
                    Aplicacao.SESSAO.entrar(this.txtLogin.getText(), this.txtSenha.getText());
                    tela.setVisible(false);

                    Aplicacao.TELA_MENU_PRINCIPAL = new TelaMenuPrincipal();
                    Aplicacao.TELA_MENU_PRINCIPAL.setVisible(true);
                    Aplicacao.TELA_MENU_PRINCIPAL.setExtendedState(MAXIMIZED_BOTH);         
                    Aplicacao.TELA_MENU_PRINCIPAL.jdPane.setBounds(Aplicacao.TELA_MENU_PRINCIPAL.getBounds());
                    Aplicacao.TELA_MENU_PRINCIPAL.jdPane.setPreferredSize(Aplicacao.TELA_MENU_PRINCIPAL.getPreferredSize());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);

                    if(txtLogin.getText().trim().isEmpty()){
                        txtLogin.requestFocus();
                    }else{    
                        if(txtSenha.getText().trim().isEmpty())
                            txtSenha.requestFocus();
                    }
                }
                break;
            case "limpar":
                this.txtSenha.setText("");
                this.txtLogin.setText("");
                this.txtLogin.requestFocus();  
                break;
            default:
                return;
        }
    }
    
}
