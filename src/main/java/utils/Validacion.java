
package utils;

import java.util.ArrayList;
import java.util.List;


public class Validacion {

    private int contador = 0;
    
    
    //Metodo de validacion
    public List<String> validacion(String[] cadena){
        
        contador++;

        List<String> errores = new ArrayList<>();
        
        if(cadena.length == 9){
                
            if(cadena[0].isBlank() || !cadena[0].matches("[a-zA-Z1-9-]+")){
                errores.add("Numero del campo: "+contador+ " El campo 1 (código) no puede ser nulo");
            }
            
            if(cadena[1].isBlank() || !cadena[1].matches("[a-zA-Z1-9 ]+")){
                errores.add("Numero del campo: "+contador+ " Campo 2 (nombre) no puede ser nulo");
            }
            
            if(cadena[2].isBlank()
                    || !( cadena[2].matches("CC")
                    || cadena[2].matches("NI")
                    || cadena[2].matches("PA")
                    || cadena[2].matches("RC"))){
                errores.add("Numero del campo: "+contador+ " El campo 3 (cod_tp_id) debe señalar una "
                        + "de las opciones CC, NI, PA, RC");
            }
            
            if(cadena[3].isBlank() || !cadena[3].matches("[1-9]+")){
                errores.add("Numero del campo: "+contador+ " Los valores del campo 4 (nro_id) deben ser numericos entre el 1 y 9");
            }
            
            if(cadena[4].isBlank()
                    || !(cadena[4].matches("PR")
                    || cadena[4].matches("PU")
                    || cadena[4].matches("MI"))){
                errores.add("Numero del campo: "+contador+ " Los valores del campo 5 (naturaleza)"
                        + " debe señalar uno de los caracteres PR, PU, MI");
            }
            
            if(cadena[5].matches("X")){
                cadena[5]="1";
            }else if(cadena[5].isBlank()){
                cadena[5]="0";
            }else{
                errores.add("Numero del campo: "+contador+ " El campo 6 debe ser nulo o X");
            }

            if(cadena[6].matches("X")){
                cadena[6]="1";
            }else if(cadena[6].isBlank()){
                cadena[6]="0";
            }else{
               errores.add("Numero del campo: "+contador+ " El campo 7 debe ser nulo o X");
            }

            if(cadena[7].matches("X")){
                cadena[7]="1";

            }else if(cadena[7].isBlank()){
                cadena[7]="0";
                cadena[8]="";
            }else{
                errores.add("Numero del campo: "+contador+ " El campo 8 debe ser nulo o X");
            }
            
            if((cadena[8].isBlank() && cadena[7].matches("X")) || 
                   !cadena[8].matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$")){
                    errores.add("Numero del campo: "+contador+ " El formato de la fecha debe ser DD/MM/YYYY");
            }
            
        }else{
            errores.add("Numero del campo: "+contador+" La cantidad de parámetros debe ser 9 y estar separados por ;");       
        }
       
        //Devuelve un na lista de errores del objeto
        return errores;
    }
}
