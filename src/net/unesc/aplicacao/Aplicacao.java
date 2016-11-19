package net.unesc.aplicacao;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import static net.unesc.aplicacao.TelaMenuPrincipal.jlLogo;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.LoginException;
import net.unesc.utilidades.*;

public class Aplicacao {
    public static Sessao SESSAO = new Sessao();
    public static TelaMenuPrincipal TELA_MENU_PRINCIPAL;
    public static final Thread NOTIFICACOES__THREAD = new Thread() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                
                
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    };
    public static void main(String args[]){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NOTIFICACOES__THREAD.start();
                JFrame jfLogar = new TelaLogin();
                Tela.centralizar(jfLogar);
                jfLogar.setVisible(true);

            }
        });
    }
}
