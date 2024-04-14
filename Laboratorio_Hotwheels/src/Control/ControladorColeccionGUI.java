package Control;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.ColeccionGUI;
import Modelo.Auto;
import Modelo.Coleccion;

public class ControladorColeccionGUI implements ActionListener {
    //atributos

    private ColeccionGUI unaColeccion;
    private Auto unAuto;
    private Coleccion coleccionAutos;
    private int anhoS;
    private int numS;

    //Constructor
    public ControladorColeccionGUI() {

        this.unaColeccion = new ColeccionGUI();
        this.unAuto = new Auto();
        this.coleccionAutos = new Coleccion();
        this.unaColeccion.setVisible(true);

        //Agregar escuchas o listener de botones
        //error con el this como parametro
        this.unaColeccion.jButtonAgregarAuto.addActionListener((ActionListener) this);
        this.unaColeccion.jButtonBorrarAuto.addActionListener(this);
        this.unaColeccion.jButtonBuscarAuto.addActionListener(this);
        this.unaColeccion.jButtonListarAuto.addActionListener(this);

    }

    //Métodos
    public void actionPerformed(ActionEvent e) {
        //eventos
        //evento Agregar auto
        if (e.getSource() == this.unaColeccion.jButtonAgregarAuto) {

            ControladorAgregarAutoGUI agregarAuto = new ControladorAgregarAutoGUI();
            agregarAuto.setCtrlColeccion(this);

        }

        //Evento Borrar Auto
        //No está borrando carros
        if (e.getSource() == this.unaColeccion.jButtonBorrarAuto) {

            if (this.coleccionAutos.getAutos().size() != 0) {
                int anhoSBoton = Integer.parseInt(this.unaColeccion.jtf_anhoSerieC.getText());
                int numBoton = Integer.parseInt(this.unaColeccion.jtf_numSerieC.getText());

                int resultBorrar = this.coleccionAutos.borrarAuto(anhoSBoton, numBoton);

                if (resultBorrar == 1) {
                    javax.swing.JOptionPane.showMessageDialog(unaColeccion, "se ha borrado correctamente el auto.");
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "No hay autos en la coleccion para borrar");

            }
        }

        //Evento Listar Autos
        if (e.getSource() == this.unaColeccion.jButtonListarAuto) {
            String listaAutos = coleccionAutos.listarColeccion();
            JOptionPane.showMessageDialog(null, listaAutos, "Lista de Autos", JOptionPane.INFORMATION_MESSAGE);
        }

        //Evento Buscar autos
        if (e.getSource() == this.unaColeccion.jButtonBuscarAuto) {
            // Implementar la lógica para buscar un auto
            anhoS = Integer.parseInt(this.unaColeccion.jtf_anhoSerieC.getText());
            numS = Integer.parseInt(this.unaColeccion.jtf_numSerieC.getText());
            String resultadoBusqueda = coleccionAutos.buscarAuto(anhoS, numS);
            JOptionPane.showMessageDialog(null, resultadoBusqueda, "Resultado de la búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // getters and setters
    public ColeccionGUI getUnaColeccion() {
        return unaColeccion;
    }

    public void setUnaColeccion(ColeccionGUI unaColeccion) {
        this.unaColeccion = unaColeccion;
    }

    public Auto getUnAuto() {
        return unAuto;
    }

    public void setUnAuto(Auto unAuto) {
        this.unAuto = unAuto;
    }

    public Coleccion getColeccionAutos() {
        return coleccionAutos;
    }

    public void setColeccionAutos(Coleccion coleccionAutos) {
        this.coleccionAutos = coleccionAutos;
    }

}
