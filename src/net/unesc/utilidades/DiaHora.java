package net.unesc.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DiaHora {
    
    public static String ObterDiaHora(String formato){
        /*
            dd/MM/yyyy HH:mm:ss - 01/01/2016 00:00:00
            dd/MM/yyyy HH:mm    - 01/01/2016 00:00
            dd/MM/yyyy HH       - 01/01/2016 00
            dd/MM/yyyy          - 01/01/2016
            dd/MM               - 01/01
            dd                  - 01
            MM                  - 01
        */
        
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat(formato);
        
        return formatador.format(data);
        
    }  
    
    public static String formatarData(Date data, String formato){
        SimpleDateFormat formatador = new SimpleDateFormat(formato);
        return formatador.format(data);
    }
    
}
