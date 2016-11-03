package net.unesc.aplicacao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.LoginException;
import net.unesc.aplicacao.TelaLogin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Sessao {
    private static final String ROOT_FOLDER = "./build";
    private static final String SESSAO_FILE = ROOT_FOLDER+"/sessao.ser";
    private static final String LOG_FILE = ROOT_FOLDER+"/log.txt";

    private Usuario usuarioLogado;

    public String lerAquivoLogs() {
        try{
            File arquivo = new File(LOG_FILE);
            if (arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            String linha = "";
            while (br.ready()) {
                linha = br.readLine();
            }
            fr.close();
            br.close();
            return linha;
        }catch(IOException e){
            e.printStackTrace();
        }
        return "";
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
            File arquivo = new File(LOG_FILE);
            FileWriter arq = new FileWriter(arquivo);
            arq.write(login.trim().toUpperCase());
            arq.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    
    
}
