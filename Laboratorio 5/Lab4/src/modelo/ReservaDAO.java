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

        String query = "SELECT * FROM reserva ORDER BY consecutivo ASC";
        String query_Busqueda = "SELEC * FROM reserva WHERE consecutivo=" + value;

        try {
            this.con = this.miConexion.obtenerconexion();
            if (value.equalsIgnoreCase("")) {
                pst = this.con.prepareStatement(query);
                rs = pst.executeQuery();
            } else {
                pst = this.con.prepareStatement(query_Busqueda);
                rs = pst.executeQuery();
            }

            while (rs.next()) {
                Reserva unaReserva = new Reserva();

                //unaReserva.setNumReserva(rs.getInt("consecutivo"));
                unaReserva.setFecha(rs.getTimestamp("fechaReserva"));
                unaReserva.getUnDocente().setCedula(rs.getInt("docenteCedula"));
                unaReserva.getEquipo().setNumeroEquipo(rs.getInt("numeroEquipo"));
                listaReservas.add(unaReserva);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los datos: " + e);
        }

        return listaReservas;
    }

    //Buscar
    public Reserva buscarReserva(int docenteCedula) {
        String query = "SELECT * FROM reserva WHERE docenteCedula = ?";
        Reserva unaReserva = new Reserva();

        try {
            this.con = this.miConexion.obtenerconexion();
            pst = this.con.prepareStatement(query);

            //se pasan los parametro ingresados por el usuario
            pst.setInt(1, docenteCedula);
            System.out.println("contenido del query:\n" + pst);
            rs = pst.executeQuery();

            if (rs.next()) {
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
