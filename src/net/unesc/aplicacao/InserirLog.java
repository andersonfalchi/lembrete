package net.unesc.aplicacao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.unesc.utilidades.*;

public class InserirLog {
    private static final String ROOT_FOLDER = "./build";
    private static final String LOG_FILE = ROOT_FOLDER+"/log_eventos.txt";
    private File arquivo = new File(LOG_FILE);
    
    public InserirLog(){
    }
    
    public InserirLog(String acao, String usuario, String descricao){
        
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        acao = PreencherVariavel.rpad(acao," ",20);
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
    
    
}
