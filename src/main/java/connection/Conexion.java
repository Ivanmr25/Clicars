package connection;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class Conexion {
    public static Connection conecta() {
    	String url="jdbc:oracle:thin:clicars/clicars@80.28.158.14:1521:oradai";
 
        OracleConnectionPoolDataSource ocpds;
        Connection con=null;
       	try {
       		ocpds=new OracleConnectionPoolDataSource();
	        ocpds.setURL(url);
	        con=ocpds.getConnection();
	        System.out.println("Conectado con éxito...");
		} catch (SQLException e) {
			System.out.println("Error en la conexion: "+e.getMessage());
		}
       	return con;
    }
    public static void close(Connection con) {
        try {
            con.close();

        } catch (SQLException e) {
        	System.out.println("Error en la conexion: "+e.getMessage());
        }
    }
}
