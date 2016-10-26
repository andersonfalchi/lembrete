package net.unesc.entidades;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String descricao;
    private String cor;
    private List<FormaAlerta> formasAlerta;
    private TipoEvento tipoEvento;
    private Regra regra;
    private Usuario usuario;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<FormaAlerta> getFormasAlerta() {
        return formasAlerta;
    }

    public void setFormasAlerta(List<FormaAlerta> formasAlerta) {
        this.formasAlerta = formasAlerta;
    }
    
    public void addFormaAlerta(FormaAlerta formaAlerta) {
        if (this.formasAlerta == null)
            this.formasAlerta = new ArrayList<>();
        this.formasAlerta.add(formaAlerta);
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Regra getRegra() {
        return regra;
    }

    public void setRegra(Regra regra) {
        this.regra = regra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
