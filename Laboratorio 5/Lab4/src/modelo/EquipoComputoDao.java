package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
//***************************************************************************************************************************
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
//***************************************************************************************************************************
    //Registar un Equipo Computo
    public boolean insertarEquicoComputo(EquipoComputo unEquipo) {
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
//***************************************************************************************************************************  
    //Consultar EquipoComputo
    public EquipoComputo consultarEquiposComputo(int numInventario){
        String query = "SELECT * FROM equipocomputo WHERE numeroInventario = ?";
        EquipoComputo unEquipo= new EquipoComputo();
        
        try{
            this.con= this.miConexion.obtenerconexion();
            pst = this.con.prepareStatement(query);
            
            //se pasan los parametro ingresados por el usuario
            pst.setInt(1, numInventario);
            System.out.println("contenido del query:\n"+pst);
            rs= pst.executeQuery();
            
            if(rs.next()){
                unEquipo.setNumeroEquipo(rs.getInt("numeroInventario"));
                numInventarioEquipo = unEquipo.getNumeroEquipo();
                
                unEquipo.setMarca(rs.getString("marca"));
                marcaEquipo= unEquipo.getMarca();
               
                unEquipo.setCapacidadDD(rs.getString("capacidadDisco"));
                capacidadDDEquipo= unEquipo.getCapacidadDD();
                
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Equipo no encontrado ");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del equipo: "+e);
        }
        
        return unEquipo;
    }
//***************************************************************************************************************************    
    //Listar EquiposComputo
    public List listarEquipos(){
        List<EquipoComputo> ListaEquipos = new ArrayList();
        String query = "SELECT * FROM equipocomputo ORDER BY numeroInventario ASC";
                
        try{
            this.con= this.miConexion.obtenerconexion();
            
            pst= this.con.prepareStatement(query);
            rs= pst.executeQuery();            
            
            while(rs.next()){
                EquipoComputo unEquipo= new EquipoComputo();
                
                unEquipo.setNumeroEquipo(rs.getInt("numeroInventario"));
                unEquipo.setMarca(rs.getString("marca"));
                unEquipo.setCapacidadDD(rs.getString("capacidadDisco"));
                
                ListaEquipos.add(unEquipo);
            }
            
        }catch(SQLException e ){
            JOptionPane.showMessageDialog(null, "Error al listar los datos: "+e);
        }
        
        return ListaEquipos;
    }
//***************************************************************************************************************************    
    //Modificar Docente
    public boolean actualizarEquiposComputo(EquipoComputo unEquipo){
        String query= "UPDATE equipocomputo SET numeroInventario=?, marca=?, capacidadDisco=?"
                + "WHERE numeroInventario=?";
        
        try{
            this.con= this.miConexion.obtenerconexion();
            
            pst= this.con.prepareStatement(query);
            pst.setInt(1, unEquipo.getNumeroEquipo());
            pst.setString(2, unEquipo.getMarca()+"");
            pst.setString(3, unEquipo.getCapacidadDD());
            System.out.println(pst);
            pst.setInt(4, unEquipo.getNumeroEquipo());
            pst.execute();
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al modificar los datos (Clase DAO):\n"+e);
            return false;
        }
        
    }
//***************************************************************************************************************************    
    //Eliminar Docente
    public boolean eliminarEquipoComputo(int cedula){
        String query= "DELETE FROM equipocomputo WHERE numeroInventario="+cedula;
        
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
//***************************************************************************************************************************