
package test;


import datos.AdministradorJDBC;
import domain.Administradora;
import java.util.ArrayList;
import java.util.List;
import utils.TextoHerramientas;
import utils.Validacion;


public class MainClass {
    public static void main(String[] args) {
        
        
        TextoHerramientas tx = new TextoHerramientas();
        Validacion validador = new Validacion();
        List<String[]> lista = new ArrayList<>();
        List<String> erroresList = new ArrayList<>();
        Administradora administradora = new Administradora(); 
        AdministradorJDBC adminiJDBC = new AdministradorJDBC();
        
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
        
        //
        if(erroresList.isEmpty()){
            for(String[] linea: lista){
               //si no hay errores en la lista guarda cada registro en la base de datos
                adminiJDBC.insert(administradora.buildFromArray(linea));
                
            }
        }else{
            //Si hay escribe un archivo de texto
            tx.setTexto(erroresList);
        }
        
    }
}
