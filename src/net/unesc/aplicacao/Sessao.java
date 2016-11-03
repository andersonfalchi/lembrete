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
    private Map<String, Usuario> usuariosRegistrados = new HashMap<>();
    public Sessao() {
        lerArquivoSessao();
        lerAquivoLogs();
    }
    
//    File arquivo = new File("log_sessao.txt");
//    public File getArquivo(){
//        return arquivo;
//    }
    
    
    private void lerArquivoSessao()  {
        try
        {            
            FileInputStream fileIn = new FileInputStream(SESSAO_FILE);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            usuariosRegistrados = (Map<String, Usuario>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void lerAquivoLogs() {
        try{
            File arquivo = new File(LOG_FILE);
            if (arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                String linha = br.readLine();
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
        Usuario usuarioTemporario = new Usuario(login, senha);
        Usuario usuarioRegistrado = usuariosRegistrados.get(usuarioTemporario.getLogin());
        if(!usuarioTemporario.getSenha().equals(usuarioRegistrado.getSenha())){
            throw new LoginException("Senha inválida!");
        }
        //usuário logou
        this.usuarioLogado = usuarioTemporario;
        //salvar usuário no .ser caso nao exista
        if (usuariosRegistrados != null)
        {
            try
            {
                usuariosRegistrados.put(usuarioLogado.getLogin(), usuarioLogado);
                FileOutputStream fileOut = new FileOutputStream(SESSAO_FILE);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(usuariosRegistrados);
                out.close();
                fileOut.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                throw new LoginException("Erro ao salvar informações de sessão de usuário");
            }
        }
        
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
