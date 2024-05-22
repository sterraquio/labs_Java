package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String db_nombre="reservaequipos";//nombre de la base de datos
    private String user="root";//user para entrar a la base
    private String password="";//contraseña para entrar a la base
    private String url="jdbc:mysql://localhost:3306/"+this.db_nombre;//url para establecer la coneccion 
    
    Connection conexion = null;
    
    //metodo para la conecccion
    public Connection obtenerconexion(){
        try{
            //obtener valor del driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtener la conexión
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
            //por si ocurre una excepcion saber cual es 
        }catch(ClassNotFoundException e){
            System.out.println("Ha ocurrido un ClassNotFoundException "+e.getMessage());
        }catch(SQLException e){
            System.out.println("Ha ocurrido un SQLException");
        }
        
        return conexion;            
    }    
}
