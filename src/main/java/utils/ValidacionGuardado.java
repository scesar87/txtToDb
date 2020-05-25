
package utils;

import datos.AdministradorJDBC;
import domain.Administradora;
import java.util.ArrayList;
import java.util.List;


public class ValidacionGuardado {

    private int contador = 0;
    
    
    //Metodo de validacion
    public List<String> validacion(String[] cadena){
        
        contador++;
        boolean error=false;
        List<String> errores = new ArrayList<>();
        
        if(cadena.length == 9){
                
            if(cadena[0].isBlank() || !cadena[0].matches("[a-zA-Z1-9]+")){
                errores.add("Numero del campo: "+contador+ " Codigo no puede ser nulo");
                error=true;
            }
            
            if(cadena[1].isBlank() || !cadena[1].matches("[a-zA-Z1-9 ]+")){
                errores.add("Numero del campo: "+contador+ " Nombre no puede ser nulo");
                error=true;
            }
            
            if(cadena[2].isBlank()
                    || !( cadena[2].matches("CC")
                    || cadena[2].matches("NI")
                    || cadena[2].matches("PA")
                    || cadena[2].matches("RC"))){
                errores.add("Numero del campo: "+contador+ " Debe contener los caracteres CC, NI, PA, RC");
                error=true;
            }
            
            if(cadena[3].isBlank() || !cadena[3].matches("[1-9]+")){
                errores.add("Numero del campo: "+contador+ " Los valores deben ser numericos entre el 1 y 9");
            }
            
            if(cadena[4].isBlank()
                    || !(cadena[4].matches("PR")
                    || cadena[4].matches("PU")
                    || cadena[4].matches("MI"))){
                errores.add("Numero del campo: "+contador+ " Debe contener los caracteres PR, PU, MI");
                error=true;
            }
            
            if(cadena[5].matches("X")){
                cadena[5]="1";
            }else if(cadena[5].isBlank()){
                cadena[5]="0";
            }else{
                errores.add("Numero del campo: "+contador+ " El campo debe ser nulo o X");
                error=true;
            }

            if(cadena[6].matches("X")){
                cadena[6]="1";
            }else if(cadena[6].isBlank()){
                cadena[6]="0";
            }else{
               errores.add("Numero del campo: "+contador+ " El campo debe ser nulo o X");
                error=true;
            }

            if(cadena[7].matches("X")){
                cadena[7]="1";

            }else if(cadena[7].isBlank()){
                cadena[7]="0";
                cadena[8]="";
            }else{
                errores.add("Numero del campo: "+contador+ " El campo debe ser nulo o X");
                error=true;
            }
            
            if((cadena[8].isBlank() && cadena[7].matches("X")) || 
                   !cadena[8].matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")){
                    errores.add("Numero del campo: "+contador+ " El formato de la fecha debe ser DD/MM/YYYY");
                    error=true;
            }
            
        }else{
            errores.add("Numero del campo: "+contador+" La cantidad de parámetros debe ser 9 y estar separados por ;");
            error=true;        
        }
        
        //Si no hay errores, guardar en la base de datos
        if(!error){
            AdministradorJDBC adminstradorJDBC = new AdministradorJDBC();
            Administradora administradora = new Administradora();
            adminstradorJDBC.insert(administradora.buildFromArray(cadena));
        }
        //Devuelve un na lista de errores del objeto
        return errores;
    }
}
