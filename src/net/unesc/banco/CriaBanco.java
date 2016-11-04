package net.unesc.banco;

public class CriaBanco {
    
    public void CriaTabelas(){
        String usuario;
        usuario="create table usuario (nm_usuario varchar(50), "
                + "ds_login varchar(50) not null, ds_senha varchar(50) ,"
                + "  ie_situacao char(1), nr_seq_parametro integer,"
                + " PRIMARY KEY (ds_login))";
        
        
    }
    
    
    
    
    
    
    
    
}
