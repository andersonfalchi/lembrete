package net.unesc.entidades;

import java.util.ArrayList;
import java.util.List;
import net.unesc.dao.EventoDao;
import net.unesc.exceptions.BancoException;
import net.unesc.exceptions.CampoObrigatorioException;
import net.unesc.exceptions.FormaAlertaException;
import net.unesc.log.LogSistema;
import net.unesc.log.TipoLog;

public class Evento {
    private String descricao;
    private String cor;
    private List<FormaAlerta> formasAlerta;
    private TipoEvento tipoEvento;
    private Regra regra;
    private Usuario usuario;
    private String email;
    private String ddd;
    private String celular;
    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws CampoObrigatorioException {
        if (descricao == null)
            throw new CampoObrigatorioException("A descrição é obrigatória");
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) throws CampoObrigatorioException {
        if (cor == null)
            throw new CampoObrigatorioException("A cor é obrigatória");
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    public void setTipoEvento(TipoEvento tipoEvento) throws CampoObrigatorioException {
        if (tipoEvento == null)
            throw new CampoObrigatorioException("O tipo de evento é obrigatório");
        this.tipoEvento = tipoEvento;
    }

    public Regra getRegra() {
        return regra;
    }

    public void setRegra(Regra regra) throws CampoObrigatorioException {
        if (regra == null)
            throw new CampoObrigatorioException("A regra é obrigatória");
        this.regra = regra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    public void salvar() throws BancoException,FormaAlertaException {
//        if (this.formasAlerta.size() < 1)
//        { 
//            throw new FormaAlertaException("Selecione ao menos uma forma de alerta");
//        }
        
        EventoDao.insert(this);
        LogSistema.inserir(TipoLog.INCLUSAO,"Gravou um novo Cadastro de eventos");
    }
    
}
