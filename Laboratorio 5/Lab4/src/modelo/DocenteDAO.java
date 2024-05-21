
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class DocenteDAO {
    
    Conexion miConexion= new Conexion();
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public static int cedula_docente=0;
    public static String nombres_docente="";
    public static String apellidos_docente="";
    public static String profesion_docente="";
    
    //insertar
    public boolean insertarDocente(Docente unDocente){
        String query= "INSERT INTO docente(cedula, nombres, apellidos, profesion)"
                + "VALUES (?,?,?,?)";
        try{
            this.con=this.miConexion.obtenerconexion();
            
            pst= this.con.prepareStatement(query);
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
