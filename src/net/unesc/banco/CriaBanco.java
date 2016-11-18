package net.unesc.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriaBanco {
        
    public void criaTabelas(){
        String tabela[] = null;
        
        //Usuário
        tabela[0]="create table usuario (nm_usuario varchar(50), "
                + "ds_login varchar(50) not null, ds_senha varchar(50) ,"
                + "  ie_situacao char(1), PRIMARY KEY (ds_login))";
        
        //Evento
        tabela[1]="create table evento (nr_sequencia integer not null, "
                + "nm_usuario varchar(50), dt_inclusao timestamp, "
                + "ds_evento varchar(255), ie_email char(1), ie_sms char(1),"
                + " ie_popup char(1), ie_notificacao char(1), ds_email varchar(255),"
                + " nr_ddd_celular char(3), nr_celular varchar(9), ie_tipo_evento char(3),"
                + " cor varchar(15), ie_situacao char(1), primary key(nr_sequencia))";
        
        //Regra do Evento
        tabela[2]="create table regra_evento (nr_sequencia integer, nm_usuario varchar(50), "
                + "dt_inclusao timestamp, ds_regra varchar(255), dt_inicio_vigencia timestamp,"
                +"dt_fim_vigencia timestamp, ie_situacao char(1),ie_tipo_horario char(1),"
                +"qt_hh integer, qt_mm integer, qt_ss integer, qt_ml integer, dia_dom bit, dia_seg bit,"
                +"dia_ter bit, dia_qua bit, dia_qui bit, dia_sex bit, dia_sab bit, primary key(nr_sequencia))";

        
    }
     
}
