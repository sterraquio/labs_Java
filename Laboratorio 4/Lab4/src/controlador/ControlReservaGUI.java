package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.AbstractList;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.VistaReservaGUI;
import modelo.Reserva;
import modelo.ReservaDAO;

public class ControlReservaGUI implements ActionListener {

    private Reserva unaReserva;
    private ReservaDAO unaReservaDao;
    private VistaReservaGUI vista;
    private String result;
    

    public ControlReservaGUI() {
        this.unaReserva = new Reserva();
        this.unaReservaDao = new ReservaDAO();
        this.vista = new VistaReservaGUI();

        this.vista.setVisible(true);
        this.vista.jButtonAgregar.addActionListener(this);
        this.vista.jButtonBuscarReserva.addActionListener(this);
        this.vista.jButtonListar.addActionListener(this);
        this.vista.jButtonRegisDocente.addActionListener(this);
        this.vista.jButtonRegisEquipo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Timestamp fechaHora = new Timestamp(new Date().getTime());
        //Agregar reserva
        if (e.getSource() == this.vista.jButtonAgregar) {
            
        }

        //Buscar reserva con los números de la cedula del docente
        int ced = -1;
        boolean verdad=false;
        if (e.getSource() == this.vista.jButtonBuscarReserva) {
            try {
                List<Reserva> lista = unaReservaDao.listarReservas("");
                ced = Integer.parseInt(this.vista.jTextFieldCedProfe.getText());
                for (Reserva reserva : lista) {
                    if (ced == reserva.getUnDocente().getCedula()) {
                        Reserva reservita = unaReservaDao.buscarReserva(ced);
                        String mensajito = "Número de Reserva: " + reservita.getNumReserva() + "\n"
                                + "Fecha: " + reservita.getFecha() + "\n"
                                + "Cédula del Docente: " + reservita.getUnDocente().getCedula() + "\n"
                                + "Número de Equipo: " + reservita.getEquipo().getNumeroEquipo();
                        JOptionPane.showMessageDialog(null, mensajito, "Detalles de la Reserva", JOptionPane.INFORMATION_MESSAGE);
                        verdad = true;
                    }   
                }
                if(!verdad){JOptionPane.showMessageDialog(this.vista, "La cedula ingresada no coincide con ninguna de la base de datos.");}
            } catch (NumberFormatException exd) {
                JOptionPane.showMessageDialog(this.vista, "Error, debe haber números en la seccion de las cedula del docente");
            }

        }

        //Listar todas las reservas hechas
        if (e.getSource() == this.vista.jButtonListar) {
            List<Reserva> lista = unaReservaDao.listarReservas("");
            for (Reserva reserva : lista) {
                result += ("Número de Reserva: " + reserva.getNumReserva()) + "\n";
                result += ("Fecha: " + reserva.getFecha()) + "\n";
                result += ("Cédula del Docente: " + reserva.getUnDocente().getCedula()) + "\n";
                result += ("Número de Equipo: " + reserva.getEquipo().getNumeroEquipo()) + "\n";
                result += ("--------------------------------------") + "\n";
            }
            JOptionPane.showMessageDialog(this.vista, result);
        }
        //Ejecutar vista de agregar al docente
        if (e.getSource() == this.vista.jButtonRegisDocente) {
            ControlDocenteGUI vistaDocente = new ControlDocenteGUI();
        }
        //Ejecutar vista de agregar al equipo de conmputo
        if (e.getSource() == this.vista.jButtonRegisEquipo) {
            ControlEquipoComputoGUI vistaComputo = new ControlEquipoComputoGUI();
        }

    }

}
