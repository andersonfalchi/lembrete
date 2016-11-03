package net.unesc.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String login;
    private String senha;
    private Parametro parametro;
    
    
    public Usuario(String login, String senha) {
        setLogin(login);
        setSenha(senha);
    }

    public String getLogin() {
        return login;
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

    public Parametro getParametro() {
        return parametro;
    }

    public void setParametro(Parametro parametro) {
        this.parametro = parametro;
    }

    @Override
    public String toString() {
        return "Usuario{" + "login=" + login + ", senha=" + senha + '}';
    }
}
