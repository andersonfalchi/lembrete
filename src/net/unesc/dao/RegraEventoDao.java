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
            ps.setString(9, regra.getHora());
            ps.setString(10, regra.getMinuto());
            ps.setString(11, regra.getSegundo());
            ps.setString(12, regra.getMilesimos());
            ps.setString(13, null);
            ps.setString(14, null);
            ps.setString(15, null);
            ps.setString(16, null);
            ps.setString(17, null);
            ps.setString(18, null);
            ps.setString(19, null);
            
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
