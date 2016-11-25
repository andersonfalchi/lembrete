package net.unesc.utilidades;

import java.awt.TrayIcon;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.unesc.aplicacao.Aplicacao;
import static net.unesc.aplicacao.TelaMenuPrincipal.NOTIFICACAO;
import net.unesc.dao.EventoDao;
import net.unesc.entidades.Evento;
import net.unesc.entidades.FormaAlerta;
import net.unesc.entidades.Regra;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.BancoException;
import net.unesc.exceptions.LoginException;

public class ThreadNotificacao extends Thread {

    EventoDao eventoDao = new EventoDao();
    
    @Override
    public void run() {
        try {
            while(true)
            {
                System.out.println("COMEÇAR");
                Thread.sleep(1000);
                List<Evento> eventos = eventoDao.getAtivosERegra();
                for(Evento evento : eventos) {
                    checaDispararEvento(evento);
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (BancoException ex) {
            ex.printStackTrace();
        }
    }
    
    private void checaDispararEvento(Evento evento) {
        System.out.println("evento = " + evento);
        System.out.println("evento = " + evento.isEnviar(FormaAlerta.EMAIL));
        System.out.println("evento = " + evento.isEnviar(FormaAlerta.NOTIFICACAO));
        System.out.println("evento = " + evento.getUltimaOcorrencia());
        Regra regra = evento.getRegra();
        Date dataAtual = new Date();
        if (DiaHora.beforeSemHorario(dataAtual, regra.getInicioVigencia()))
            return;
        if (DiaHora.afterSemHorario(dataAtual, regra.getFimVigencia()))
            return;
        if (!regra.getDiaSemana(DiaHora.pegaDiaSemana(dataAtual)))
            return;
        try
        {
            Usuario usuario = Aplicacao.SESSAO.usuario();
            if (evento.isEnviar(FormaAlerta.NOTIFICACAO) && NOTIFICACAO != null)
            {
                NOTIFICACAO.ICON.displayMessage("Notificação de evento", 
                        evento.getDescricao(),
                        TrayIcon.MessageType.INFO);
            }
            if (evento.isEnviar(FormaAlerta.POPUP))
            {
                JOptionPane.showMessageDialog(null, evento.getDescricao(), "Popup de evento", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(LoginException e){
            e.printStackTrace();
        }
    }
    
}
