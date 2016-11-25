package net.unesc.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.unesc.aplicacao.Aplicacao;
import net.unesc.exceptions.LoginException;
import net.unesc.utilidades.*;

public class LogSistema {
    private static final String ROOT_FOLDER = "./build";
    private static final String LOG_FILE = ROOT_FOLDER+"/log_eventos.txt";
    private static File arquivo = new File(LOG_FILE);
    
    public static void inserir(TipoLog tipoLog, String descricao){
        try
        {
            String usuario = Aplicacao.SESSAO.usuario().getLogin();
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String acao = PreencherVariavel.rpad(tipoLog.toString()," ",20);
            usuario = PreencherVariavel.rpad(usuario," ",20);
            descricao = PreencherVariavel.rpad(descricao," ",50);

            try{
                FileWriter arq = new FileWriter(arquivo,true);
                arq.write("Ação: "+acao+"Usuário: "+usuario+"Descrição: "+descricao+"Data: "+formatador.format(data)+"\n");
                arq.close();

            }catch(IOException e){
                e.printStackTrace();
            }
        }
        catch(LoginException e)
        {
        }
                
    }
    
    
}
