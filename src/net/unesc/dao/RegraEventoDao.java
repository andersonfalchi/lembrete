package net.unesc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.unesc.banco.*;
import net.unesc.entidades.*;
import net.unesc.exceptions.BancoException;
import net.unesc.utilidades.DiaHora;

public class RegraEventoDao{
    public static void inserir(Regra regra) throws BancoException {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexao.getConnection();
            Integer proxSequencia = Funcoes.obterSequencia("regra_evento");
            
            String sql = "insert into regra_evento (nr_sequencia, nm_usuario, dt_inclusao, "
                    + "ds_regra, dt_inicio_vigencia, dt_fim_vigencia, ie_situacao, ie_tipo_horario, "
                    + "qt_hh, qt_mm, qt_ss, qt_ml, dia_dom, dia_seg, dia_ter, dia_qua, dia_qui, dia_sex, dia_sab)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, proxSequencia);
            ps.setString(2, regra.getUsuario().getLogin());
            ps.setString(3, DiaHora.ObterDiaHora("yyyy-MM-dd HH:mm:ss"));
            ps.setString(4, regra.getNome());
            ps.setString(5, DiaHora.formatarData(regra.getInicioVigencia(),"yyyy-MM-dd HH:mm:ss"));
            ps.setString(6, DiaHora.formatarData(regra.getFimVigencia(),"yyyy-MM-dd HH:mm:ss"));
            ps.setString(7, regra.getSituacao());
            ps.setString(8, regra.getTipoHorario());
            ps.setInt(9, regra.getHora());
            ps.setInt(10, regra.getMinuto());
            ps.setInt(11, regra.getSegundo());
            ps.setInt(12, regra.getMilesimos());
            ps.setBoolean(13, regra.getDiaSemana(0));
            ps.setBoolean(14, regra.getDiaSemana(1));
            ps.setBoolean(15, regra.getDiaSemana(2));
            ps.setBoolean(16, regra.getDiaSemana(3));
            ps.setBoolean(17, regra.getDiaSemana(4));
            ps.setBoolean(18, regra.getDiaSemana(5));
            ps.setBoolean(19, regra.getDiaSemana(6));
            
            ps.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Regra cadastrada com sucesso!","Cadastro de Regra",JOptionPane.INFORMATION_MESSAGE);
            
        } catch(SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage(),"Erro ao cadastar Regra",JOptionPane.ERROR_MESSAGE);      
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"Erro ao cadastar Regra",JOptionPane.ERROR_MESSAGE);
                }
            }

        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"Erro ao cadastar Regra",JOptionPane.ERROR_MESSAGE);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"Erro ao cadastar Regra",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
