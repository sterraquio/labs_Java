package Control;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.AgregarAutoGUI;
import Modelo.Auto;



public class ControladorAgregarAutoGUI implements ActionListener {
    
    private AgregarAutoGUI vistaAgregar;
    private Auto carrito;
    private ControladorColeccionGUI ctrlColeccion;
    
    
    public ControladorAgregarAutoGUI(){
        
        this.vistaAgregar= new AgregarAutoGUI();
        this.vistaAgregar.setVisible(true);
        
        this.vistaAgregar.jbt_AgregarAuto.addActionListener(this);
    }    
    
    
    @Override
    //EVENTO BOTON REGISTRAR
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaAgregar.jbt_AgregarAuto){
            carrito = new Auto();
            
            
            
            carrito.setAnhoSerie(Integer.parseInt(this.vistaAgregar.jtf_anhoSerie.getText()));
            carrito.setCantTotalSerie(Integer.parseInt(this.vistaAgregar.jtf_canSerie.getText()));
            carrito.setnumeroSerie(Integer.parseInt(this.vistaAgregar.jtf_numSerie.getText()));
            carrito.setMarca(this.vistaAgregar.jtf_marca.getText());
            carrito.setColor(this.vistaAgregar.jtf_color.getText());
            
            //this.ctrlColeccion. FALTA COMPLETARLO 
           
            
            
            
            javax.swing.JOptionPane.showMessageDialog(vistaAgregar, "La auto del año : "+this.vistaAgregar.jtf_anhoSerie.getText()+
                                                                       "\nCon el numero de serie : "+this.vistaAgregar.jtf_numSerie.getText()+
                                                                        "\nFue agregado con Exito");
            this.vistaAgregar.dispose();
        }
    }

    public AgregarAutoGUI getVistaAgregar() {
        return vistaAgregar;
    }

    public void setVistaAgregar(AgregarAutoGUI vistaAgregar) {
        this.vistaAgregar = vistaAgregar;
    }

    public Auto getCarrito() {
        return carrito;
    }

    public void setCarrito(Auto carrito) {
        this.carrito = carrito;
    }

    public ControladorColeccionGUI getCtrlColeccion() {
        return ctrlColeccion;
    }

    public void setCtrlColeccion(ControladorColeccionGUI ctrlColeccion) {
        this.ctrlColeccion = ctrlColeccion;
//        this.vistaAgregar.jtf_numSerie.setText(this.ctrlColeccion.getVistaParqueadero().jtf_placaMoto.getText());
    }

    
    
    
}
