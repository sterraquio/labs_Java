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

    //Ingresar
    public boolean insertarReserva(Reserva unaReserva) {
        String query = "INSERT INTO reserva(consecutivo, fechaReserva, docenteCedula, numeroEquipo)"
                + "VALUES (?,?,?,?)";
        Timestamp fechaHora = new Timestamp(new Date().getTime());

        try {
            this.con = this.miConexion.obtenerconexion();

            pst = this.con.prepareStatement(query);
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

    //Listar
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

                //unaReserva.setNumReserva(rs.getInt("consecutivo"));
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

    //Buscar
    public Reserva buscarReserva(int docenteCedula) {
        //busca una de la tabla reserva el campo donde la cedula sea igual al indicador "?" donde sera proporcionado
        //mas tarde de manera dinamica 
        String query = "SELECT * FROM reserva WHERE docenteCedula = ?";
        Reserva unaReserva = new Reserva();//inicializa el objeto

        try {
            this.con = this.miConexion.obtenerconexion();//conexion
            pst = this.con.prepareStatement(query);//prepara para una operacion

            //se pasan los parametro ingresados por el usuario
            pst.setInt(1, docenteCedula);//se pasa docenteCedula a "?"
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
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la persona: " + e.getMessage());
        }

        return unaReserva;
    }

}
