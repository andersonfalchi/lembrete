package net.unesc.utilidades;

import java.awt.TrayIcon;
import java.util.Calendar;
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
import net.unesc.exceptions.FormaAlertaException;
import net.unesc.exceptions.LoginException;

public class ThreadNotificacao extends Thread {

    EventoDao eventoDao = new EventoDao();
    
    @Override
    public void run() {
        try {
            while(true)
            {
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
    
    static class EventoInativoException extends Exception {
        
    }
    
    private void checaDispararEvento(Evento evento) {
        Regra regra = evento.getRegra();
        
        Date dataAtual = new Date();
        try
        {
            Usuario usuario = Aplicacao.SESSAO.usuario();
        }
        catch(LoginException e)
        {
            return;
        }
        
        try
        {  
            if (evento.getUltimaOcorrencia() != null)
            {
                Date ultimaOcorrencia = DiaHora.adiciona(evento.getUltimaOcorrencia(), Calendar.MILLISECOND, 0);
                
                if(regra.getTipoHorario().equals("CH"))
                {
                    ultimaOcorrencia = DiaHora.adiciona(ultimaOcorrencia, Calendar.MILLISECOND, regra.getMilesimos());               
                    ultimaOcorrencia = DiaHora.adiciona(ultimaOcorrencia, Calendar.SECOND, regra.getSegundo());
                    ultimaOcorrencia = DiaHora.adiciona(ultimaOcorrencia, Calendar.MINUTE, regra.getMinuto());
                    ultimaOcorrencia = DiaHora.adiciona(ultimaOcorrencia, Calendar.HOUR, regra.getHora());
                    
                }else{
                    
                    ultimaOcorrencia = DiaHora.adiciona(ultimaOcorrencia, Calendar.HOUR, 24);  
                    
                }
                
                if (ultimaOcorrencia.after(dataAtual))
                {
                   return;
                }
            }
            
            if (DiaHora.beforeSemHorario(dataAtual, regra.getInicioVigencia()))
                throw new EventoInativoException();           
            
            if (DiaHora.afterSemHorario(dataAtual, regra.getFimVigencia()))
                throw new EventoInativoException();
            
            if(regra.getTipoHorario().equals("HF")){
                if (!regra.getDiaSemana(DiaHora.pegaDiaSemana(dataAtual)))
                    throw new EventoInativoException();
                
                if(DiaHora.pegaHora(dataAtual)!=regra.getHora()||
                        DiaHora.pegaMinuto(dataAtual)!=regra.getMinuto()||
                        DiaHora.pegaSegundo(dataAtual)!=regra.getSegundo()){
                   
                    return;
                }
            }   
            
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
            
            evento.setUltimaOcorrencia(dataAtual);
           
            try {
                eventoDao.atualiza(evento);
            } catch (BancoException|FormaAlertaException ex) {
                ex.printStackTrace();
            }
        }
        catch(EventoInativoException e)
        {
            System.out.println("Evento inativo");
            evento.setSituacao("I");
            try {
                eventoDao.atualiza(evento);
            } catch (BancoException|FormaAlertaException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
