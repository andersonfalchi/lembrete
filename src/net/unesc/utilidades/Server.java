package net.unesc.utilidades;
import java.io.IOException;

public class Server {   
    
    private Process processo;
    
    public void abreBanco()throws IOException{
        if(System.getProperty("os.name").toUpperCase().contains("WINDOWS")){
            processo = Runtime.getRuntime().exec("cmd /c start rundb.bat");
        }else{
            processo = Runtime.getRuntime().exec("sh rundb.sh");
        }
    }   
   
    public void fechaBanco(){
        System.out.println("antes: "+processo);
        processo.destroy();
        System.out.println("depois: "+processo);
    }
    
}
