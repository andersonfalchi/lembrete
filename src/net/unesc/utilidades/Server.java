package net.unesc.utilidades;
import java.io.IOException;

public class Server {   
    public void server()throws IOException{
        if(System.getProperty("os.name").toUpperCase().contains("WINDOWS")){
            Runtime.getRuntime().exec("rundb.bat");
        }else{
            Runtime.getRuntime().exec("sh rundb.sh");
        }
    }   
}
