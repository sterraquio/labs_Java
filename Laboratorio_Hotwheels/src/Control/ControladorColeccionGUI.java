package Control;

import Control.ControladorAgregarAutoGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.AgregarAutoGUI;
import Vista.ColeccionGUI;
import Modelo.Auto;

public class ControladorColeccionGUI implements ActionListener{
    //atributos

    private ColeccionGUI unaColeccion;
    private Auto unAuto;

    //Constructor
    public ControladorColeccionGUI() {

        this.unaColeccion = new ColeccionGUI();
        this.unAuto = new Auto();

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
        }

        //Evento Listar Autos
        if (e.getSource() == this.unaColeccion.jButtonListarAuto) {
            //Listar es mejor hacerlo con un JOption
        }

        //Evento Buscar auto
        if (e.getSource() == this.unaColeccion.jButtonBuscarAuto) {
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

