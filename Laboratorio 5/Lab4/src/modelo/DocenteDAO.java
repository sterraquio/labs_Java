
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    
    //Consultar Persona
    public Docente consultarDocente(int cedula){
        String query = "SELECT * FROM docente WHERE cedula = ?";
        Docente unDocente= new Docente();
        
        try{
            this.con= this.miConexion.obtenerconexion();
            pst = this.con.prepareStatement(query);
            
            //se pasan los parametro ingresados por el usuario
            pst.setInt(1, cedula);
            System.out.println("contenido del query:\n"+pst);
            rs= pst.executeQuery();
            
            if(rs.next()){
                unDocente.setCedula(rs.getInt("cedula"));
                cedula_docente= unDocente.getCedula();
                
                unDocente.setNombres(rs.getString("nombres"));
                nombres_docente= unDocente.getNombres();
                
                unDocente.setApellidos(rs.getString("apellidos"));
                apellidos_docente= unDocente.getApellidos();
                
                unDocente.setProfesion(rs.getString("profesion"));
                profesion_docente= unDocente.getProfesion();
                
            }else{
                JOptionPane.showMessageDialog(null, "Docente no encontrado ");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del docente: "+e);
        }
        
        return unDocente;
    }
    
    //Listar Docente
    public List listarDocentes(){
        List<Docente> ListaDocentes = new ArrayList();
        String query = "SELECT * FROM docente ORDER BY cedula ASC";
                
        try{
            this.con= this.miConexion.obtenerconexion();
            
            pst= this.con.prepareStatement(query);
            rs= pst.executeQuery();            
            
            while(rs.next()){
                Docente unDocente= new Docente();
                
                unDocente.setCedula(rs.getInt("cedula"));
                unDocente.setNombres(rs.getString("nombres"));
                unDocente.setApellidos(rs.getString("apellidos"));
                unDocente.setProfesion(rs.getString("profesion"));
                ListaDocentes.add(unDocente);
            }
            
        }catch(SQLException e ){
            JOptionPane.showMessageDialog(null, "Error al listar los datos: "+e);
        }
        
        return ListaDocentes;
    }
    
    //Modificar Docente
    public boolean actualizarDocente(Docente unDocente){
        String query= "UPDATE docente SET cedula=?, nombres=?, apellidos=?, profesion=? WHERE cedula=?";
                
        
        try{
            this.con= this.miConexion.obtenerconexion();
            
            pst= this.con.prepareStatement(query);
            pst.setInt(1, unDocente.getCedula());
            pst.setString(2, unDocente.getNombres());
            pst.setString(3, unDocente.getApellidos());
            pst.setString(4, unDocente.getProfesion());
            pst.setInt(5, unDocente.getCedula());
            System.out.println(pst);
            pst.execute();
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al modificar los datos (Clase DAO):\n"+e);
            return false;
        }
        
    }
    
    //Eliminar Docente
    public boolean eliminarDocente(int cedula){
        String query= "DELETE FROM docente WHERE cedula = ?";

        
        try{
            //Obtener la conexión
            this.con= this.miConexion.obtenerconexion();
            //Pasar la consulta
            pst = this.con.prepareStatement(query);
            System.out.println(pst);
            //Ejecutar la consulta
            pst.execute();
            
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos: "+e);
            return false;
        }
        
    }
    
    
}
