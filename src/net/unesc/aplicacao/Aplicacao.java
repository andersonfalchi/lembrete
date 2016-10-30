package net.unesc.aplicacao;

import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JInternalFrame;
import static net.unesc.aplicacao.TelaMenuPrincipal.jlLogo;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.LoginException;
import net.unesc.utilidades.*;

public class Aplicacao {
    public static Sessao sessao = new Sessao();

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
                TelaMenuPrincipal menu = new TelaMenuPrincipal();
                
                menu.setVisible(true);
                menu.setExtendedState(MAXIMIZED_BOTH);         
                menu.jdPane.setBounds(menu.getBounds());
                menu.jdPane.setPreferredSize(menu.getPreferredSize());
                JInternalFrame jfLogar = new TelaLogin();
                menu.jdPane.add(jfLogar);
                Tela.centralizar(jfLogar);
                jfLogar.show();

                Tela.centralizar(jlLogo);

            }
        });
    }
}
