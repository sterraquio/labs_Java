package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String db_nombre="reservaequipos";
    private String user="root";
    private String password="";
    private String url="jdbc:mysql://localhost:3306/"+this.db_nombre;
    
    Connection conexion = null;
    
    public Connection obtenerconexion(){
        try{
            //obtener valor del driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtener la conexión
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
        }catch(ClassNotFoundException e){
            System.out.println("Ha ocurrido un ClassNotFoundException "+e.getMessage());
        }catch(SQLException e){
            System.out.println("Ha ocurrido un SQLException");
        }
        
        return conexion;            
    }    
}
