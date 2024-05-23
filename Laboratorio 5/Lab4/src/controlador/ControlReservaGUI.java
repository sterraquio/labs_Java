package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.AbstractList;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import vista.VistaReservaGUI;
import modelo.Reserva;
import modelo.ReservaDAO;

//***************************************************************************************************************************
//clase que agrega los listeners a los botones de la vista
public class ControlReservaGUI implements ActionListener {

    //atributos 
    private Reserva unaReserva;//clase Reserva
    private ReservaDAO unaReservaDao; // clase ReservaDao
    private VistaReservaGUI vista;//vista
    private String result;//atributo para listar
    private List<Reserva> listaReservas;
    
//***************************************************************************************************************************

    //Constructor
    public ControlReservaGUI() {
        this.unaReserva = new Reserva();//inicializo la reserva
        this.unaReservaDao = new ReservaDAO();//incializo la reservaDao
        this.vista = new VistaReservaGUI();//inicializo la vista
        this.listaReservas = unaReservaDao.listarReservas(""); //Inicializo lista para mostrar las reservas

        this.vista.setVisible(true);//la vista se hace visible
        //agrega el escucha el listener a los botones
        this.vista.jButtonAgregarReserva.addActionListener(this);
        this.vista.jButtonBuscarReserva.addActionListener(this);
        this.vista.jButtonEliminarReserva.addActionListener(this);
        this.vista.jButtonListarReservasTotales.addActionListener(this);
        this.vista.jButtonModificarReserva.addActionListener(this);
        this.vista.jButtonVistaDocente.addActionListener(this);
        this.vista.jButtonVistaEquipos.addActionListener(this);
 
    }
    
//***************************************************************************************************************************    
    //metodo del escucha

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean verdadRegistrar = false;//bandera para sabes si se agrego reserva
        int consecutivo;
        int cedDocente;
        int numEquipo;
        
        Timestamp fechaHora = new Timestamp(new Date().getTime());
        //Agregar reserva
        
//***************************************************************************************************************************        
        if (e.getSource() == this.vista.jButtonAgregarReserva) {
            List<Reserva> lista = unaReservaDao.listarReservas("");
            cedDocente = Integer.parseInt(this.vista.jTextFieldCedProfe.getText());
            numEquipo = Integer.parseInt(this.vista.jTextFieldNumEquip.getText());
            for (Reserva reserva : lista) {
                try {
                    if (true) {
                        if (true) {
                            //this.unaReserva.setNumReserva(reserva.getNumReserva() + 1);
                            this.unaReserva.setFecha(fechaHora);
                            this.unaReserva.getEquipo().setNumeroEquipo(numEquipo);
                            this.unaReserva.getUnDocente().setCedula(cedDocente);
                            if (unaReservaDao.insertarReserva(unaReserva)) {

                                JOptionPane.showMessageDialog(this.vista, "Se ha agregado con éxtioooooooooooooooooo");
                                this.vista.jTextFieldCedProfe.setText("");
                                this.vista.jTextFieldNumEquip.setText("");
                            } else {
                                JOptionPane.showMessageDialog(this.vista, "No se ha ingresado, porque no se ha encontrado la cedula del docente o el numero del equipo ");
                            }
                            verdadRegistrar = true;
                            break;
                        }
                    }
                } catch (NumberFormatException exd) {
                    JOptionPane.showMessageDialog(this.vista, "Los campos deben ser números y deben tener algún valor");
                }
            }
        }

//***************************************************************************************************************************
        //Buscar reserva con los números de la cedula del docente
        int ced = -1;//bandera
        boolean verdad = false;//bandera
        if (e.getSource() == this.vista.jButtonBuscarReserva) {
            try {
                ced =Integer.parseInt(this.vista.jTextFieldCedProfe.getText());
                 unaReserva = this.unaReservaDao.buscarReservaPorCedula(ced);
       
            } catch (NumberFormatException exd) {
                JOptionPane.showMessageDialog(this.vista, "Error, debe haber números en la seccion de las cedula del docente");
            }

        }
//***************************************************************************************************************************        

        //Listar todas las reservas hechas
        if (e.getSource() == this.vista.jButtonListarReservasTotales) {
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
//***************************************************************************************************************************  
//listar reservas hechas por un docente 
if(e.getSource() == this.vista.jbt_listarReservasDocente){
               List<Reserva> lista = unaReservaDao.buscarReservaPorCedula(Integer.parseInt(this.vista.jTextFieldCedProfe.getText()));
            for (Reserva reserva : lista) {
                result += ("Número de Reserva: " + reserva.getNumReserva()) + "\n";
                result += ("Fecha: " + reserva.getFecha()) + "\n";
                result += ("Cédula del Docente: " + reserva.getUnDocente().getCedula()) + "\n";
                result += ("Número de Equipo: " + reserva.getEquipo().getNumeroEquipo()) + "\n";
                result += ("--------------------------------------") + "\n";
            }
            JOptionPane.showMessageDialog(this.vista, result);
    
}
        
//***************************************************************************************************************************        
        //Ejecutar vista de agregar al docente
        if (e.getSource() == this.vista.jButtonVistaDocente) {
            ControlDocenteGUI vistaDocente = new ControlDocenteGUI();
//***************************************************************************************************************************            
        }
        //Ejecutar vista de agregar al equipo de conmputo
        if (e.getSource() == this.vista.jButtonVistaEquipos) {
            ControlEquipoComputoGUI vistaComputo = new ControlEquipoComputoGUI();
        }
//***************************************************************************************************************************        

    }

}
