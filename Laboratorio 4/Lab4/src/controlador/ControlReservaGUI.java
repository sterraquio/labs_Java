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
    private List<String> lista = new ArrayList<>();

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
        if (e.getSource() == this.vista.jButtonBuscarReserva) {

        }

        //Listar todas las reservas hechas
        if (e.getSource() == this.vista.jButtonListar) {

            lista = unaReservaDao.listarReservas("");
            JOptionPane.showMessageDialog(this.vista, lista.get(0));
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
