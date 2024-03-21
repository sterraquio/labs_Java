package Control;

import Control.ControladorAgregarAutoGUI;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.AgregarAutoGUI;
import Vista.ColeccionGUI;
import Modelo.Auto;
import Modelo.Coleccion;

public class ControladorColeccionGUI implements ActionListener {
    //atributos

    private ColeccionGUI unaColeccion;
    private Auto unAuto;
    private Coleccion unosAutos;

    //Constructor
    public ControladorColeccionGUI() {

        this.unaColeccion = new ColeccionGUI();
        this.unAuto = new Auto();
        this.unosAutos = new Coleccion();
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
        //posiblemente en esté evento hay que llamar a la clase agregarAutoGUI
        if (e.getSource() == this.unaColeccion.jButtonAgregarAuto) {
            ControladorAgregarAutoGUI agregarAuto = new ControladorAgregarAutoGUI();
            agregarAuto.setCtrlColeccion(this);
        }

        //Evento Borrar Auto
        if (e.getSource() == this.unaColeccion.jButtonBorrarAuto) {

            for (int i = 0; i < this.unosAutos.getAutos().size(); i++) {
                if (this.unosAutos.getAutos().get(i) != null) {

                    if (this.unaColeccion.jtf_anhoSerieC.getText().equals(this.unosAutos.getAutos().get(i))) {

                    }
                }
                javax.swing.JOptionPane.showMessageDialog(null,"No hay autos en la coleccion para borrar");
            }
            unosAutos.borrarAuto(Integer.parseInt(unaColeccion.jtf_anhoSerieC.getText()), Integer.parseInt(unaColeccion.jtf_numSerieC.getText()));

        }

        //Evento Listar Autos
        if (e.getSource() == this.unaColeccion.jButtonListarAuto) {
            //Listar es mejor hacerlo con un JOption
            unosAutos.listarColeccion();
        }

        //Evento Buscar auto
        if (e.getSource() == this.unaColeccion.jButtonBuscarAuto) {
            unosAutos.buscarAuto(Integer.parseInt(unaColeccion.jtf_anhoSerieC.getText()), Integer.parseInt(unaColeccion.jtf_numSerieC.getText()));
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

}
