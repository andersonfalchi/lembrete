package net.unesc.aplicacao;

import net.unesc.log.LogSistema;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.LoginException;
import java.io.File;
import java.io.FileReader;
import net.unesc.log.TipoLog;

public class Sessao {
    private static final String ROOT_FOLDER = "./build";
    private static final String LOG_FILE = ROOT_FOLDER+"/log_sessao.txt";
    private String ultimoLogin = "";
    public Usuario usuarioLogado;
    
    private File arquivo = new File(LOG_FILE);
    
    public Sessao() {
        lerLogSessao();  
    }
    
    public String getUltimoLogin(){
        return ultimoLogin.trim().toUpperCase();
    }

    private void lerLogSessao() {
        try{
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
             
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
     
            while (br.ready()) {
                ultimoLogin = br.readLine();
            }
            
            fr.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public Usuario usuario() throws LoginException {
        if (usuarioLogado == null)
            throw new LoginException();
        return usuarioLogado;
    }
    
    public void entrar(String login, String senha) throws LoginException {
        this.usuarioLogado = new Usuario(login, senha);
        //salva log de usuário
        try{
            FileWriter arq = new FileWriter(arquivo);
            arq.write(login.trim().toUpperCase());
            arq.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        this.usuarioLogado = new Usuario(login, senha);
        LogSistema.inserir(TipoLog.LOGIN, "Logou no sistema");        
    }
}
