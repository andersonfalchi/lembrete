package net.unesc.aplicacao;

import net.unesc.entidades.Usuario;
import net.unesc.exceptions.LoginException;

public class Sessao {
    private Usuario usuarioLogado;

    public Usuario usuario() throws LoginException {
        if (usuarioLogado == null)
            throw new LoginException();
        return usuarioLogado;
    }
    public void entrar(String login, String senha) throws LoginException {
        if(!login.toUpperCase().equals("RAFAEL") || !senha.equals("123")){
            throw new LoginException("Nome de usuário e/ou senha inválidos");
        }
        this.usuarioLogado = new Usuario(login, senha);
    }
}
