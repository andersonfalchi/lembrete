package net.unesc.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.unesc.dao.RegraEventoDao;
import net.unesc.exceptions.BancoException;
import net.unesc.exceptions.CampoObrigatorioException;
import net.unesc.exceptions.DataException;
import net.unesc.exceptions.FormatoDataException;
import net.unesc.log.LogSistema;
import net.unesc.log.TipoLog;

public class Regra {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
    private String nome;
    private String minuto;
    private String hora;
    private String segundo;
    private String milesimos;
    private Date inicioVigencia;
    private Date fimVigencia;
    private Usuario usuario;
    private String tipoHorario;
    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    private String[] diasSemana = new String[7];

    public String getTipoHorario() {
        return tipoHorario;
    }

    public void setTipoHorario(String tipoHorario) {
        this.tipoHorario = tipoHorario;
    }
       
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws CampoObrigatorioException {
        if (nome == null)
            throw new CampoObrigatorioException("O nome é obrigatório");
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String[] getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String[] diasSemana) {
        this.diasSemana = diasSemana;
    }
    
    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }
    
    private void checaVigencia(Date inicioVigencia, Date fimVigencia) throws DataException {
        if (inicioVigencia != null && fimVigencia != null)
        {
            if (inicioVigencia.after(fimVigencia))
            {
                throw new DataException("O início da vigência não pode ultrapssar o fim");
            }
        }
    }

    public void setInicioVigencia(Date inicioVigencia) throws CampoObrigatorioException, DataException {
        if (inicioVigencia == null)
            throw new CampoObrigatorioException("O início da vigência é obrigatório");
        checaVigencia(inicioVigencia, this.fimVigencia);
        this.inicioVigencia = inicioVigencia;
    }
    
    public void setInicioVigencia(String inicioVigencia) throws FormatoDataException, CampoObrigatorioException, DataException {
        try
        {
            setInicioVigencia(FORMATTER.parse(inicioVigencia));
        }
        catch(ParseException e)
        {
            e.printStackTrace();
            throw new FormatoDataException("A data de início da vigência é inválida");
        }
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }
    
    public void setFimVigencia(String fimVigencia) throws FormatoDataException, CampoObrigatorioException, DataException {
        try
        {
            setFimVigencia(FORMATTER.parse(fimVigencia));
        }
        catch(ParseException e)
        {
            e.printStackTrace();
            throw new FormatoDataException("A data de fim da vigência é inválida");
        }
    }

    public void setFimVigencia(Date fimVigencia) throws CampoObrigatorioException, DataException {
        if (fimVigencia == null)
            throw new CampoObrigatorioException("O fim da vigência é obrigatório");
        checaVigencia(inicioVigencia, fimVigencia);
        this.fimVigencia = fimVigencia;
    }

    public String getDiaSemana() {
        return String.join(",", diasSemana);
    }

    public void setDiaSemana(int dia, boolean diaSemana) {
        diasSemana[dia] = diaSemana ? "1" : "0";
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {
        this.segundo = segundo;
    }

    public String getMilesimos() {
        return milesimos;
    }

    public void setMilesimos(String milesimos) {
        this.milesimos = milesimos;
    }
    
    public void salvar() throws BancoException {
        RegraEventoDao.insert(this);
        LogSistema.inserir(TipoLog.INCLUSAO, "Gravou uma nova Regra do Evento");
    }
    
}
