package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.AbstractList;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import vista.VistaReservaGUI;
import modelo.Reserva;
import modelo.ReservaDAO;

//clase que agrega los listeners a los botones de la vista
public class ControlReservaGUI implements ActionListener, TableModel {

    //atributos 
    private Reserva unaReserva;//clase Reserva
    private ReservaDAO unaReservaDao; // clase ReservaDao
    private VistaReservaGUI vista;//vista
    private String result;//atributo para listar
    private List<Reserva> listaReservas;

    //Constructor
    public ControlReservaGUI() {
        this.unaReserva = new Reserva();//inicializo la reserva
        this.unaReservaDao = new ReservaDAO();//incializo la reservaDao
        this.vista = new VistaReservaGUI();//inicializo la vista
        this.listaReservas = unaReservaDao.listarReservas(""); //Inicializo lista para mostrar las reservas

        this.vista.setVisible(true);//la vista se hace visible
        //agrega el escucha el listener a los botones
        this.vista.jButtonAgregar.addActionListener(this);
        this.vista.jButtonBuscarReserva.addActionListener(this);
        this.vista.jButtonEliminarReserva.addActionListener(this);
        this.vista.jButtonListar.addActionListener(this);
        this.vista.jButtonModificarReserva.addActionListener(this);
        this.vista.jButtonRegisDocente.addActionListener(this);
        this.vista.jButtonRegisEquipo.addActionListener(this);
    }
    //metodo del escucha

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean verdadRegistrar = false;//bandera para sabes si se agrego reserva
        int consecutivo;
        int cedDocente;
        int numEquipo;
        int consecutivoGrande = Integer.MIN_VALUE;
        Timestamp fechaHora = new Timestamp(new Date().getTime());
        //Agregar reserva
        if (e.getSource() == this.vista.jButtonAgregar) {
            List<Reserva> lista = unaReservaDao.listarReservas("");
            cedDocente = Integer.parseInt(this.vista.jTextFieldCedProfe.getText());
            numEquipo = Integer.parseInt(this.vista.jTextFieldNumEquip.getText());
            for (Reserva reserva : lista) {
                //Por qué no funciona está validación???
                if (cedDocente == reserva.getUnDocente().getCedula() && numEquipo == reserva.getEquipo().getNumeroEquipo()) { //cedDocente == reserva.getUnDocente().getCedula()
                    if (true) { //numEquipo == reserva.getEquipo().getNumeroEquipo()
                        //this.unaReserva.setNumReserva(reserva.getNumReserva() + 1);
                        this.unaReserva.setFecha(fechaHora);
                        this.unaReserva.getEquipo().setNumeroEquipo(numEquipo);
                        this.unaReserva.getUnDocente().setCedula(cedDocente);
                        unaReservaDao.insertarReserva(unaReserva);
                        JOptionPane.showMessageDialog(this.vista, "Se ha agregado con éxtioooooooooooooooooo" + null + "\n"
                                + "Numero de reserva : " + this.unaReserva.getNumReserva());
                        this.vista.jTextFieldCedProfe.setText("");
                        this.vista.jTextFieldNumEquip.setText("");
                        verdadRegistrar = true;
                        break;
                    }
                }
            }
            if (!verdadRegistrar) {
                JOptionPane.showMessageDialog(this.vista, "error, no coincide la CÉDULA del profesor o el NÚMERO de inventario del equipo de computo con la base de datos.");
            }
        }

        //Buscar reserva con los números de la cedula del docente
        int ced = -1;//bandera
        boolean verdad = false;//bandera
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
                        this.vista.jTextFieldCedProfe.setText("");
                        verdad = true;
                        break;
                    }
                }
                if (!verdad) {
                    JOptionPane.showMessageDialog(this.vista, "La cedula ingresada no coincide con ninguna de la base de datos.");
                }
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

    @Override
    public int getRowCount() {
        //Cantidad de filas, es decir, datos/filas
        return listaReservas.size();
    }

    @Override
    public int getColumnCount() {
        //Cantidad de columnas
        return 4;
    }

    @Override
    //Método para asignarle nombre a cada columna
    public String getColumnName(int columnIndex) {
        String titulo = null;
        // Para darle nombre a cada columna
        switch (columnIndex) {

            case 0:
                titulo = "Consecutivo";
                break;
            case 1:
                titulo = "Fecha Reserva";
                break;
            case 2:
                titulo = "Cedula del docente";
                break;
            case 3:
                titulo = "Numero de equipo";
                break;
        }
        return titulo;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //Retorna el tipo de clase que es cada columna
        return this.listaReservas.getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Hace que no se puedan editar la tabla
        return columnIndex != 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reserva reservita = listaReservas.get(rowIndex);

        //Insertar los valores a la tabla
        switch (columnIndex) {

            case 0:
                reservita.getNumReserva();
                break;
            case 1:
                reservita.getFecha();
                break;
            case 2:
                reservita.getUnDocente().getCedula();
                break;
            case 3:
                reservita.getEquipo().getNumeroEquipo();
                break;
        }
        //Debe retornar un objeto completo
        return reservita;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

}
