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
        this.vista.jButtonAgregar.addActionListener(this);
        this.vista.jButtonListarReservaDocente.addActionListener(this);
        this.vista.jButtonEliminarReserva.addActionListener(this);
        this.vista.jButtonListar.addActionListener(this);
        this.vista.jButtonModificarReserva.addActionListener(this);
        this.vista.jButtonAbrirVistaDocente.addActionListener(this);
        this.vista.jButtonAbrirVistaEquipos.addActionListener(this);
        this.vista.jButtonConsultarReservasPorNumeroReserva.addActionListener(this);

    }

//***************************************************************************************************************************    
    //metodo del escucha
    @Override
    public void actionPerformed(ActionEvent e) {

        boolean verdadConsulta = false;//Bandera para saber si se consultó primero 
        boolean verdadRegistrar = false;//bandera para sabes si se agrego reserva
        int consecutivo;
        int cedDocente;
        int numEquipo;

        Timestamp fechaHora = new Timestamp(new Date().getTime());

//***************************************************************************************************************************        
        //Agregar reserva
        if (e.getSource() == this.vista.jButtonAgregar) {
            List<Reserva> lista = unaReservaDao.listarReservas("");
            cedDocente = Integer.parseInt(this.vista.jTextFieldCedProfe.getText());
            numEquipo = Integer.parseInt(this.vista.jTextFieldNumEquip.getText());
            try {
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

            } catch (NumberFormatException exd) {
                JOptionPane.showMessageDialog(this.vista, "Los campos deben ser números y deben tener algún valor");
            }

        }

//***************************************************************************************************************************
        //Listar reservas por cedula del docente
        if (e.getSource() == this.vista.jButtonListarReservaDocente) {
            int docenteCedula = Integer.parseInt(this.vista.jTextFieldCedProfe.getText());
            Reserva unaReserva = new Reserva();
            List<Reserva> ListaReservasDocente;

            String lista = "CEDULA PROFE || NUMERO EQUIPO || NUMERO RESERVA " + "\n";
            ListaReservasDocente = this.unaReservaDao.listarReservasDocente(docenteCedula);

            for (int i = 0; i < ListaReservasDocente.size(); i++) {
                unaReserva = ListaReservasDocente.get(i);
                lista += unaReserva.getUnDocente().getCedula() + " || " + unaReserva.getEquipo().getNumeroEquipo()
                        + " || " + unaReserva.getNumReserva() + "\n";

            }
            JOptionPane.showMessageDialog(this.vista, lista);

        }

//***************************************************************************************************************************        
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
//***************************************************************************************************************************        
//Boton consultar reservas por reserva número de reservass
        if (e.getSource() == this.vista.jButtonConsultarReservasPorNumeroReserva) {
            try {
                this.unaReserva = unaReservaDao.buscarReservaPorNumeroR(Integer.parseInt(this.vista.jTextFieldNumReserva.getText().trim()));

                this.vista.jTextFieldNumReserva.setText(this.unaReserva.getNumReserva() + "");
                this.vista.jTextFieldCedProfe.setText(this.unaReserva.getUnDocente().getCedula() + "");
                this.vista.jTextFieldNumEquip.setText(this.unaReserva.getEquipo().getNumeroEquipo() + "");
                verdadConsulta = true;

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista, "Error revise el numero de reserva ingresado que no contenga letras y este correcto ");
                this.vista.jTextFieldNumReserva.grabFocus();
            }

        }

//***************************************************************************************************************************        
        //Eliminar reserva a partir del número de reserva
        if (e.getSource() == this.vista.jButtonEliminarReserva) {
            try {
                int numReserva = Integer.parseInt(this.vista.jTextFieldNumReserva.getText());

                if (this.unaReservaDao.EliminarReserva(numReserva)) {
                    JOptionPane.showMessageDialog(this.vista, "Datos Eliminados!!!");
                    this.vista.jTextFieldCedProfe.setText("");
                    this.vista.jTextFieldNumEquip.setText("");
                    this.vista.jTextFieldNumReserva.setText("");
                } else {
                    JOptionPane.showMessageDialog(this.vista, "Datos No Eliminados!!!");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.vista, "El campo numero reserva no debe estar vacío \nY deben ser en formato numérico");

            }
        }

        //***************************************************************************************************************************        
        //Modificar reserva por el número de reserva
        if (e.getSource() == this.vista.jButtonModificarReserva) {
            if (true) {

                try {
                    this.unaReserva.getEquipo().setNumeroEquipo(Integer.parseInt(this.vista.jTextFieldNumEquip.getText()));
                    this.unaReserva.getUnDocente().setCedula(Integer.parseInt(this.vista.jTextFieldCedProfe.getText()));
                    this.unaReserva.setNumReserva(Integer.parseInt(this.vista.jTextFieldNumReserva.getText()));

                    if (this.unaReservaDao.modificarReserva(this.unaReserva)) {
                        JOptionPane.showMessageDialog(this.vista, "Si se actualizooooooooooooo");
                        this.vista.jTextFieldCedProfe.setText("");
                        this.vista.jTextFieldNumEquip.setText("");
                        this.vista.jTextFieldNumReserva.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this.vista, "No se ha actualizado :c");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this.vista, "El campo reserva no debe estar vacío\nY deben ser en formato numérico");

                }
            }
            
            

        }

//***************************************************************************************************************************        
        //Ejecutar vista de agregar al docente
        if (e.getSource() == this.vista.jButtonAbrirVistaDocente) {
            ControlDocenteGUI vistaDocente = new ControlDocenteGUI();
        }
//***************************************************************************************************************************            
        //Ejecutar vista de agregar al equipo de conmputo
        if (e.getSource() == this.vista.jButtonAbrirVistaEquipos) {
            ControlEquipoComputoGUI vistaComputo = new ControlEquipoComputoGUI();
        }
//***************************************************************************************************************************        

    }

}
