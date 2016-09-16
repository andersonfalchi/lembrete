package entidades;

public class Evento {
    private String descricao;
    private String cor;
    private FormaAlerta formaAlerta;
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

    public FormaAlerta getFormaAlerta() {
        return formaAlerta;
    }

    public void setFormaAlerta(FormaAlerta formaAlerta) {
        this.formaAlerta = formaAlerta;
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
