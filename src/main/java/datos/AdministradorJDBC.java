
package datos;

import domain.Administradora;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdministradorJDBC {
    
    private Connection conexionTr;
    private static final String SQL_SELECT = "SELECT id_cod, codogo, nombre, cod_tp_id,"
            + " nro_id, naturaleza, multiple_arp, fsp, fusionada, fecha_fusion FROM administradora"; 
    private static final String SQL_INSERT = "INSERT INTO administradora(codigo, nombre, cod_tp_id,"
            + " nro_id, naturaleza, multiple_arp, fsp, fusionada, fecha_fusion)"
            + " VALUES(?,?,?,?,?,?,?,?,?)";
    
       
    public List<Administradora> select(){
        
        Connection con = null;
        PreparedStatement stmt=null;
        ResultSet rs = null;
        Administradora administradora = null;
        List<Administradora> administradoras = new ArrayList<Administradora>();
        
        try {
            
            con = this.conexionTr != null ? this.conexionTr : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre= rs.getString("nombre");
                String cod_tp_id= rs.getString("cod_tp_id");
                String nro_id= rs.getString("nro_id");
                String naturaleza= rs.getString("naturaleza");
                int multiple_arp= rs.getInt("multiple_arp");
                int fsp= rs.getInt("fsp");
                int fusionada= rs.getInt("fusionada");
                String fecha_fusion= rs.getString("fecha_fusion");
                administradora = new Administradora();
                administradora.setId(id);
                administradora.setCodigo(codigo);
                administradora.setNombre(nombre);
                administradora.setCod_tp_id(cod_tp_id);
                administradora.setNro_id(nro_id);
                administradora.setNaturaleza(naturaleza);
                administradora.setMultiple_arp(multiple_arp);
                administradora.setFsp(fsp);
                administradora.setFusionada(fusionada);
                administradora.setFecha_fusion(fecha_fusion);
                administradoras.add(administradora);

            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexionTr == null){
                Conexion.close(con);
            }
        }
        return administradoras;
    }
    
    
    public int insert(Administradora administradora){
        
        Connection con = null;
        PreparedStatement stmt=null;
        ResultSet rs = null;
        int rows = 0;
        
        try {
            
            con = this.conexionTr != null ? this.conexionTr : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, administradora.getCodigo());
            stmt.setString(2, administradora.getNombre());
            stmt.setString(3, administradora.getCod_tp_id());
            stmt.setString(4, administradora.getNro_id());
            stmt.setString(5, administradora.getNaturaleza());
            stmt.setString(6, Integer.toString(administradora.getMultiple_arp()));
            stmt.setString(7, Integer.toString(administradora.getFsp()));
            stmt.setString(8, Integer.toString(administradora.getFusionada()));
            stmt.setString(9, administradora.getFecha_fusion());
            rows = stmt.executeUpdate();   
            System.out.println("Registros afectados: "+ rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            if(this.conexionTr == null){
                Conexion.close(con);
            }

        }
        return rows;
    }
}
