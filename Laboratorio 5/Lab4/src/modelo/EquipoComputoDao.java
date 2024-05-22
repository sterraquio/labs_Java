package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EquipoComputoDao {
    //Crear la conexión usando la clase Conexion;

    Conexion miConexion = new Conexion();

    Connection con;//establecer la conexion con una base de datos 
    PreparedStatement pst; //para ejecutar las consultas
    ResultSet rs; //para obtener los resultados de la consulta

    //Variables para enviar datos entre interfaces
    public static int numInventarioEquipo = 0;
    public static String marcaEquipo = "";
    public static String capacidadDDEquipo = "";

    //Registar persona
    
    public boolean insertarPersona(EquipoComputo unEquipo) {
         //insertar datos en una tabla 
        //insert into permite agregar una nueva fila a la tabla de la bd
        //primero van los encabezados de la tabla y despues los valores que se agregan en la casillas
        String query = "INSERT INTO equipocomputo(numeroInventario, marca, capacidadDisco)"
                + "VALUES(?,?,?)";

        try {
            this.con = this.miConexion.obtenerconexion();//obtengo la conexion

            pst = this.con.prepareStatement(query);//se prepara una sentencia y despues se utiliza para ejecutar operaciones
            pst.setInt(1, unEquipo.getNumeroEquipo());
            pst.setString(2, unEquipo.getMarca());
            pst.setString(3, unEquipo.getCapacidadDD());
            pst.execute();

            return true;
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al ingresar los datos: " + e);
            return false;
        }

    }
  
    //Consultar Persona
    public Docente consultarDocente(int cedula){
        String query = "SELECT * FROM equipocomputo WHERE numeroInventario = ?";
        EquipoComputo unEquipo= new EquipoComputo();
        
        try{
            this.con= this.miConexion.obtenerconexion();
            pst = this.con.prepareStatement(query);
            
            //se pasan los parametro ingresados por el usuario
            pst.setInt(1, cedula);
            System.out.println("contenido del query:\n"+pst);
            rs= pst.executeQuery();
            
            if(rs.next()){
                unEquipo.setNumeroEquipo(rs.getInt("numeroInventario"));
                numInventarioEquipo = unEquipo.getNumeroEquipo();
                unEquipo.setNombres(rs.getString("nombres"));
                nombres_docente= unDocente.getNombres();
                
                unEquipo.setApellidos(rs.getString("apellidos"));
                apellidos_docente= unDocente.getApellidos();
                
                
                
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
        String query= "UPDATE docente SET cedula=?, nombres=?, apellidos=?, profesion=?"
                + "WHERE cedula=?";
        
        try{
            this.con= this.miConexion.obtenerconexion();
            
            pst= this.con.prepareStatement(query);
            pst.setInt(1, unDocente.getCedula());
            pst.setString(2, unDocente.getNombres());
            pst.setString(3, unDocente.getApellidos());
            pst.setString(4, unDocente.getProfesion());
            System.out.println(pst);
            pst.execute();
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al modificar los datos (Clase DAO):\n"+e);
            return false;
        }
        
    }
    
    //Eliminar Docente
    public boolean eliminarPersona(int cedula){
        String query= "DELETE FROM docente WHERE cedula="+cedula;
        
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

