package net.unesc.aplicacao;

import java.io.FileWriter;
import java.io.IOException;
import net.unesc.entidades.Usuario;
import net.unesc.exceptions.LoginException;
import net.unesc.aplicacao.TelaLogin;
import java.io.File;

public class Sessao {
    private Usuario usuarioLogado;

    public Usuario usuario() throws LoginException {
        if (usuarioLogado == null)
            throw new LoginException();
        return usuarioLogado;
    }
    public void entrar(String login, String senha, File arquivo) throws LoginException {

        if(login.trim().isEmpty()){
            throw new LoginException("Usuário inválido!");
        }
        
        if(senha.trim().isEmpty()){
            throw new LoginException("Senha inválida!");
        }
        
        try{
            FileWriter arq = new FileWriter(arquivo);
            arq.write(login.trim().toUpperCase());
            arq.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        this.usuarioLogado = new Usuario(login, senha);
    }
}
