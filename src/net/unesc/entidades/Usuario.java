package net.unesc.entidades;

import java.io.Serializable;
import net.unesc.dao.UsuarioDao;
import net.unesc.exceptions.BancoException;
import net.unesc.log.LogSistema;
import net.unesc.log.TipoLog;

public class Usuario implements Serializable {
    private String nome;
    private String login;
    private String senha;
    private String situacao;

    public Usuario() {
    }
    
    public Usuario(String login, String senha) {
        setLogin(login);
        setSenha(senha);
    }
    
    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public void setLogin(String login) {
        if (login == null || login.trim().isEmpty())
            throw new IllegalArgumentException("O login não pode ser vazio");
        this.login = login.trim();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.trim().isEmpty())
            throw new IllegalArgumentException("A senha não pode ser vazia");
        this.senha = senha.trim();
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Usuario{" + "login=" + login + ", senha=" + senha + '}';
    }
}
