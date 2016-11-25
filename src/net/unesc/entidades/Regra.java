package net.unesc.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    private Integer codigo;
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
    private String nome;
    private Integer minuto;
    private Integer hora;
    private Integer segundo;
    private Integer milesimos;
    private Date inicioVigencia;
    private Date fimVigencia;
    private Usuario usuario;
    private String tipoHorario;
    private String situacao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    
    
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
    
    public boolean getDiaSemana(int dia) {
        return "1".equals(diasSemana[dia]);
    }

    public void setDiaSemana(int dia, boolean diaSemana) {
        diasSemana[dia] = diaSemana ? "1" : "0";
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public Integer getSegundo() {
        return segundo;
    }

    public void setSegundo(Integer segundo) {
        this.segundo = segundo;
    }

    public Integer getMilesimos() {
        return milesimos;
    }

    public void setMilesimos(Integer milesimos) {
        this.milesimos = milesimos;
    }

    public void setMinuto(String minuto) throws NumberFormatException {
        try
        {
            this.minuto = Integer.parseInt(minuto);
        }
        catch(NumberFormatException e) {
            throw new NumberFormatException("Minuto inválido");
        }
    }
    
    public void setHora(String hora) throws NumberFormatException  {
        try
        {
            this.hora = Integer.parseInt(hora);
        }
        catch(NumberFormatException e) {
            throw new NumberFormatException("Hora inválida");
        }
    }

    public void setSegundo(String segundo) throws NumberFormatException  {
        try
        {
            this.segundo = Integer.parseInt(segundo);
        }
        catch(NumberFormatException e) {
            throw new NumberFormatException("Segundo inválido");
        }
    }
    
    public void setMilesimos(String milesimos) throws NumberFormatException  {
        try
        {
            this.milesimos = Integer.parseInt(milesimos);
        }
        catch(NumberFormatException e) {
            throw new NumberFormatException("Milésimo inválido");
        }
    }

    @Override
    public String toString() {
        return codigo + " - " + nome;
    }
    
    public void fromResultSet(ResultSet rs)
    {
        try
        {
//            this.setCodigo(rs.getInt(""));
            this.setNome(rs.getString("ds_regra"));
            this.setInicioVigencia(rs.getDate("dt_inicio_vigencia"));
            this.setFimVigencia(rs.getDate("dt_fim_vigencia"));
            this.setSituacao(rs.getString("ie_situacao"));
            this.setTipoHorario(rs.getString("ie_tipo_horario"));

            this.setHora(rs.getInt("qt_hh"));
            this.setMinuto(rs.getInt("qt_mm"));
            this.setSegundo(rs.getInt("qt_ss"));
            this.setMilesimos(rs.getInt("qt_ml"));
            
            this.setDiaSemana(0, rs.getBoolean("dia_dom"));
            this.setDiaSemana(1, rs.getBoolean("dia_seg"));
            this.setDiaSemana(2, rs.getBoolean("dia_ter"));
            this.setDiaSemana(3, rs.getBoolean("dia_qua"));
            this.setDiaSemana(4, rs.getBoolean("dia_qui"));
            this.setDiaSemana(5, rs.getBoolean("dia_sex"));
            this.setDiaSemana(6, rs.getBoolean("dia_sab"));
            
        }
        catch(CampoObrigatorioException|DataException|SQLException e){
            e.printStackTrace();
        }
    }
    
}
