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
}
