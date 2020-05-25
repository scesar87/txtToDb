
package utils;

import domain.Administradora;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import java.util.stream.Stream;


public class TextoHerramientas {
    

    public List<String[]> getTexto(){
        
        String ficheros = "src//main//files//base_de_datos.txt";
        List<String[]> lista = new ArrayList<>();
        
	try (Stream<String> stream = Files.lines(Paths.get(ficheros))) {
	    	
            lista = stream.map(linea -> linea.split(";"))
                    .map(Administradora::toStringArray)
                    .collect(Collectors.toList());
            
	    } catch (IOException e) {
	        e.printStackTrace(System.out);
	    }
        return lista;
    }
    
    public void setTexto(List<String> errores){

        FileWriter fichero = null;
        PrintWriter pw = null;
        System.out.println("Paso 1");
        try
        {
            System.out.println("Paso 2");
            fichero = new FileWriter("src\\main\\files\\errores.txt");
            pw = new PrintWriter(fichero);

            for(String error: errores){
                pw.println(error);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
    }
}
