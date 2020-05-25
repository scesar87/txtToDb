
package test;


import java.util.ArrayList;
import java.util.List;
import utils.TextoHerramientas;
import utils.ValidacionGuardado;


public class MainClass {
    public static void main(String[] args) {
        
        
        TextoHerramientas tx = new TextoHerramientas();
        ValidacionGuardado validador = new ValidacionGuardado();
        List<String[]> lista = new ArrayList<>();
        List<String> erroresList = new ArrayList<>();
        
        //Obtengo una lista de Arreglos tipo String que contienen la informacion de
        //los objetos
        lista=tx.getTexto();
        
        
        //Uso el objeto validador con su método validar
        //Guardo en la base de datos si no hay errores en la validación;
        for(String[] linea: lista){
            List<String> errores = validador.validacion(linea);
            
           
            //Acumulo los errores en una sola lista
            if(errores!=null){
                for(String error : errores){
                    erroresList.add(error);
                }
            }
        }
        
        //Escribo el archivo con todos los errores
        tx.setTexto(erroresList);
        
        
    }
}
