
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


//clase para la conecciona la base de datos para un Docente 
public class DocenteDAO {
    
    Conexion miConexion= new Conexion();//clase conexion
    
    Connection con; //establecer la conexion con una base de datos 
    PreparedStatement pst;//utiliza para ejecutar consultas SQL precompiladas con parámetros
    ResultSet rs;//almacenar y manipular los resultados obtenidos de una consulta 
    
    //Variables para enviar datos entre interfaces
    public static int cedula_docente=0;
    public static String nombres_docente="";
    public static String apellidos_docente="";
    public static String profesion_docente="";
    
    //insertar docente 
    public boolean insertarDocente(Docente unDocente){
        //insertar datos en una tabla 
        //insert into permite agregar una nueva fila a la tabla de la bd
        //primero van los encabezados de la tabla y despues los valores que se agregan en la casillas 
        String query= "INSERT INTO docente(cedula, nombres, apellidos, profesion)"
                + "VALUES (?,?,?,?)";
        try{
            this.con=this.miConexion.obtenerconexion();//obtengo la conexion
            
            pst= this.con.prepareStatement(query);//se prepara una sentencia y despues se utiliza para ejecutar operaciones
            pst.setInt(1, unDocente.getCedula());
            pst.setString(2, unDocente.getNombres());
            pst.setString(3, unDocente.getApellidos());
            pst.setString(4, unDocente.getProfesion());
            pst.execute();
            
            return true;

            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Error al ingresar los datos"+ e);
            return false;
        }
            
        
    }
    
    
}
