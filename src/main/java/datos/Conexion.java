
package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;



public class Conexion {
    
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String JDBC_USER = "SYSTEM";
    private static final String JDBC_PASS = "1234";
    
    
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASS);
        ds.setInitialSize(50);
        return ds;
    }
    
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            
        }
    }
}
