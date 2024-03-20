package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.AgregarAutoGUI;
import Vista.ColeccionGUI;
import Modelo.Auto;

class ControladorColeccionGUI {
    
    //atributos
    private ColeccionGUI unaColeccion;
    private Auto unAuto;
    
        
    //Constructor
    public ControladorColeccionGUI() {
        this.unAuto = new Auto();
        this.unaColeccion = new ColeccionGUI();
        
        
        this.unaColeccion.setVisible(true);
        
        //Agregar escuchas o listener de botones
        //error con el this como parametro
        this.unaColeccion.jButtonAgregarAuto.addActionListener(this);
        this.unaColeccion.jButtonBorrarAuto.addActionListener(this);
        this.unaColeccion.jButtonBuscarAuto.addActionListener(this);
        this.unaColeccion.jButtonListarAuto.addActionListener(this);
        
              
    }

    //Métodos
    public void actionPerformed(ActionEvent e){
        //eventos
        //evento Agregar auto
        //posiblemente en esté evento hay que llamar a la clase agregarAutoGUI
        if(e.getSource() == this.unaColeccion.jButtonAgregarAuto){}
        
        //Evento Borrar Auto
        if(e.getSource()== this.unaColeccion.jButtonBorrarAuto){}
        
        //Evento Listar Autos
        if(e.getSource()== this.unaColeccion.jButtonListarAuto){
        //Listar es mejor hacerlo con un JOption
        }
        
        //Evento Buscar auto
        if(e.getSource()== this.unaColeccion.jButtonBuscarAuto){}
        
        
        
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