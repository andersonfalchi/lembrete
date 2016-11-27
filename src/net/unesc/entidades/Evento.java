package net.unesc.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.unesc.dao.EventoDao;
import net.unesc.exceptions.BancoException;
import net.unesc.exceptions.CampoObrigatorioException;
import net.unesc.exceptions.FormaAlertaException;
import net.unesc.log.LogSistema;
import net.unesc.log.TipoLog;

public class Evento {
    private Integer codigo;
    private String descricao;
    private String cor;
    private List<FormaAlerta> formasAlerta = new ArrayList<>();
    private TipoEvento tipoEvento;
    private Regra regra;
    private Usuario usuario;
    private String email;
    private String ddd;
    private String celular;
    private String situacao;
    private Date ultimaOcorrencia;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    
    
    public String getEnviar(FormaAlerta formaAlertaChecar) {
        return isEnviar(formaAlertaChecar) ? "S" : "N";
    }
    
    public boolean isEnviar(FormaAlerta formaAlertaChecar) {
        for (FormaAlerta formaAlerta : formasAlerta) {
            if (formaAlerta.equals(formaAlertaChecar))
                return true;
        }
        return false;
    }
    
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
        if (descricao == null || descricao.trim().isEmpty())
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
    
    public void addFormaAlerta(FormaAlerta formaAlerta, String ehAdd) {
        if (this.formasAlerta == null)
            this.formasAlerta = new ArrayList<>();
        if (ehAdd != null && "S".equals(ehAdd.toUpperCase()))
            this.formasAlerta.add(formaAlerta);
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

    public void setEmail(String email) throws CampoObrigatorioException {
        if (isEnviar(FormaAlerta.EMAIL) && (email == null || email.trim().isEmpty())) {
            throw new CampoObrigatorioException("O e-mail é obrigatório");
        }
        this.email = email;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) throws CampoObrigatorioException {
        if (isEnviar(FormaAlerta.SMS) && (ddd == null || ddd.trim().isEmpty())) {
            throw new CampoObrigatorioException("O ddd é obrigatório");
        }
        this.ddd = ddd;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) throws CampoObrigatorioException {
        if (isEnviar(FormaAlerta.SMS) && (celular == null || celular.trim().isEmpty())) {
            throw new CampoObrigatorioException("O celular é obrigatório");
        }
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

    public Date getUltimaOcorrencia() {
        return ultimaOcorrencia;
    }

    public void setUltimaOcorrencia(Date ultimaOcorrencia) {
        this.ultimaOcorrencia = ultimaOcorrencia;
    }
    
    

    @Override
    public String toString() {
        return codigo + " - " + descricao;
    }
    
    public void fromResultSet(ResultSet rs) {
        try
        {
            System.out.println("Ok");
            this.setCodigo(rs.getInt("nr_sequencia"));
            this.setUsuario(new Usuario(rs.getString("nm_usuario")));
            this.setDescricao(rs.getString("ds_evento"));
            this.addFormaAlerta(FormaAlerta.EMAIL, rs.getString("ie_email"));
            this.addFormaAlerta(FormaAlerta.SMS, rs.getString("ie_sms"));
            this.addFormaAlerta(FormaAlerta.POPUP, rs.getString("ie_popup"));
            this.addFormaAlerta(FormaAlerta.NOTIFICACAO, rs.getString("ie_notificacao"));
            this.setEmail(rs.getString("ds_email"));
            this.setDdd(rs.getString("nr_ddd_celular"));
            this.setCelular(rs.getString("nr_celular"));
            this.setTipoEvento(TipoEvento.porDescricao(rs.getString("ie_tipo_evento").toUpperCase()));
            this.setCor(rs.getString("cor"));
            this.setSituacao(rs.getString("ie_situacao"));
            this.setUltimaOcorrencia(rs.getTimestamp("dt_ultima_execucao"));
        }
        catch(CampoObrigatorioException|SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}
