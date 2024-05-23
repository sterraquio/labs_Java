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

//***************************************************************************************************************************  
//Constructor
public class ReservaDAO {

    private Reserva unaReserva = new Reserva();
    Conexion miConexion = new Conexion();

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public static int consecutivo_reserva = 0;
    public static Timestamp fechaReserva_reserva;
    public static int docenteCedula_reserva = 0;
    public static int numeroEquipo_reserva = 0;

//***************************************************************************************************************************  
    //Ingresar reserva
    public boolean insertarReserva(Reserva unaReserva) {
        String query = "INSERT INTO reserva(consecutivo, fechaReserva, docenteCedula, numeroEquipo)"
                + "VALUES (?,?,?,?)";
        Timestamp fechaHora = new Timestamp(new Date().getTime());

        try {
            this.con = this.miConexion.obtenerconexion();

            pst = this.con.prepareStatement(query);
            //Se comenta está línea de código porque el consecutivo ya es automatico por medio del SQL
            pst.setInt(1, unaReserva.getNumReserva());
            pst.setTimestamp(2, fechaHora);
            //if(){}
            pst.setInt(3, unaReserva.getUnDocente().getCedula());
            pst.setInt(4, unaReserva.getEquipo().getNumeroEquipo());
            pst.execute();

            return true;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al ingresar los datos" + e);
            return false;
        }
    }
//***************************************************************************************************************************  
    //Listar todas las reservas

    public List listarReservas(String value) {
        List<Reserva> listaReservas = new ArrayList();

        //Seleciona todas las columnas de la tabla reserva y las ordena de manera ascendente 
        //dependiendo de la columna consecutivo
        String query = "SELECT * FROM reserva ORDER BY consecutivo ASC";

        //busca un valor de la tabla reserva que coicida con el "value"
        String query_Busqueda = "SELEC * FROM reserva WHERE consecutivo=" + value;

        try {
            this.con = this.miConexion.obtenerconexion();//obtener la conexion

            if (value.equalsIgnoreCase("")) {//verifica si value es vacio si lo es ignora si hay mayusculas o minusculas 
                pst = this.con.prepareStatement(query);//si es vacia prepara para consultar todos los registros de la tabla
                rs = pst.executeQuery();
            } else {
                pst = this.con.prepareStatement(query_Busqueda);//si no es vacia prepara para consulatar el registro 
                //donde el "consecutivo" coincide con el valor de value
                rs = pst.executeQuery();//se ejecuta la consulta preparada y el resultado se asigna a un objeto rs
            }

            while (rs.next()) {//se utiliza para mover el cursor al siguiente registro
                Reserva unaReserva = new Reserva(); //inicializa el objeto

                unaReserva.setNumReserva(rs.getInt("consecutivo"));
                unaReserva.setFecha(rs.getTimestamp("fechaReserva"));
                unaReserva.getUnDocente().setCedula(rs.getInt("docenteCedula"));
                unaReserva.getEquipo().setNumeroEquipo(rs.getInt("numeroEquipo"));
                listaReservas.add(unaReserva);//agrega los datos a una lista de tipo reserva
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los datos: " + e);
        }

        return listaReservas;
    }

//***************************************************************************************************************************  
    //Listar reservas por cada porfesor
    public List listarReservasDocente(int docenteCedula) {
        //busca una de la tabla reserva el campo donde la cedula sea igual al indicador "?" donde sera proporcionado
        //mas tarde de manera dinamica 
        List<Reserva> ListaReservasDocente = new ArrayList();
        String query = "SELECT * FROM reserva WHERE docenteCedula = "+docenteCedula;

        try {
            this.con = this.miConexion.obtenerconexion();//conexion
            pst = this.con.prepareStatement(query);//prepara para una operacion
            rs = pst.executeQuery();//se ejecuta la consulta preparada y se obtiene los resultados

            while (rs.next()) {
                
                Reserva unaReserva = new Reserva();
                
                
                // se recuperan los datos de la consulta y se asignan a objetos de reserva
                unaReserva.setNumReserva(rs.getInt("consecutivo"));
                unaReserva.setFecha(rs.getTimestamp("fechaReserva"));
                unaReserva.getUnDocente().setCedula(rs.getInt("docenteCedula"));
                unaReserva.getEquipo().setNumeroEquipo(rs.getInt("numeroEquipo"));
                ListaReservasDocente.add(unaReserva);


            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar las reservas del docente: " + e.getMessage());
        }

        return ListaReservasDocente;
    }

    //***************************************************************************************************************************  
    //Buscar reserva por el número de reserva
    public Reserva buscarReservaPorNumeroR(int NumReserva) {
        //busca una de la tabla reserva el campo donde la cedula sea igual al indicador "?" donde sera proporcionado
        //mas tarde de manera dinamica 
        String query = "SELECT * FROM reserva WHERE consecutivo = ?";
        Reserva unaReserva = new Reserva();//inicializa el objeto

        try {
            this.con = this.miConexion.obtenerconexion();//conexion
            pst = this.con.prepareStatement(query);//prepara para una operacion

            //se pasan los parametro ingresados por el usuario
            pst.setInt(1, NumReserva);//se pasa docenteCedula a "?"
            System.out.println("contenido del query:\n" + pst);
            rs = pst.executeQuery();//se ejecuta la consulta preparada y se obtiene los resultados

            if (rs.next()) {
                // se recuperan los datos de la consulta y se asignan a objetos de reserva
                unaReserva.setNumReserva(rs.getInt("consecutivo"));
                consecutivo_reserva = unaReserva.getNumReserva();
                unaReserva.setFecha(rs.getTimestamp("fechaReserva"));
                fechaReserva_reserva = unaReserva.getFecha();
                unaReserva.getUnDocente().setCedula(rs.getInt("docenteCedula"));
                docenteCedula_reserva = unaReserva.getUnDocente().getCedula();
                unaReserva.getEquipo().setNumeroEquipo(rs.getInt("numeroEquipo"));
                numeroEquipo_reserva = unaReserva.getEquipo().getNumeroEquipo();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la reserva: " + e.getMessage());
        }

        return unaReserva;
    }
//***************************************************************************************************************************  
    //Eliminar reserva con el número de reserva
    public boolean EliminarReserva(int numeroReserva) {
        String query = "DELETE FROM reserva WHERE consecutivo =" + numeroReserva;

        try {
            this.con = this.miConexion.obtenerconexion();
            pst = this.con.prepareStatement(query);
            System.out.println("pst = " + pst);
            pst.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar : " + e.getMessage());
            return false;

        }

    }
//***************************************************************************************************************************  
    //Modifica la reserva por el número de reserva 
    public boolean modificarReserva(Reserva unaReserva) {
        String query = "UPDATE reserva SET fechaReserva=?, docenteCedula =?, numeroEquipo =? WHERE consecutivo=" + unaReserva.getNumReserva();
        Timestamp fechaHora = new Timestamp(new Date().getTime());
        try {
            this.con = this.miConexion.obtenerconexion();
            pst = this.con.prepareStatement(query);
            pst.setTimestamp(1,   fechaHora);
            pst.setInt(2, unaReserva.getUnDocente().getCedula());
            pst.setInt(3, unaReserva.getEquipo().getNumeroEquipo() );
            System.out.println("pst = " + pst);
            pst.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error : " + e.getMessage());
            return false;
        }
    }

}
//***************************************************************************************************************************  