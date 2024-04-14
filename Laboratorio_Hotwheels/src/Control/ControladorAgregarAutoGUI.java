package Control;

//.
import Control.ControladorColeccionGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.AgregarAutoGUI;
import Modelo.Auto;
import Modelo.Coleccion;
import javax.swing.JOptionPane;

public class ControladorAgregarAutoGUI implements ActionListener {

    private AgregarAutoGUI vistaAgregar;
    private Auto carrito;
    private ControladorColeccionGUI ctrlColeccion;
    private Coleccion unosAutos;

    public ControladorAgregarAutoGUI() {

        this.unosAutos = new Coleccion();
        this.vistaAgregar = new AgregarAutoGUI();
        this.vistaAgregar.setVisible(true);

        this.vistaAgregar.jbt_AgregarAuto.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaAgregar.jbt_AgregarAuto) {
            try {
                carrito = new Auto();

                int anhoSerie = Integer.parseInt(this.vistaAgregar.jtf_anhoSerie.getText());
                int cantSerie = Integer.parseInt(this.vistaAgregar.jtf_canSerie.getText());
                int numSerie = Integer.parseInt(this.vistaAgregar.jtf_numSerie.getText());

                // Validaciones para campos numéricos
                if (anhoSerie < 1000) {
                    JOptionPane.showMessageDialog(null, "El año de la serie debe ser mayor o igual que 4 dígitos");
                    this.vistaAgregar.jtf_anhoSerie.setText("");
                    this.vistaAgregar.jtf_anhoSerie.grabFocus();
                    return;
                }
                if (numSerie <= 0 || numSerie > cantSerie) {
                    JOptionPane.showMessageDialog(null, "El número de serie debe ser mayor que 0 y menor o igual que la cantidad de serie");                    
                    this.vistaAgregar.jtf_numSerie.setText("");
                    this.vistaAgregar.jtf_numSerie.grabFocus();
                    return;
                }

                // Validaciones para campos alfanuméricos
                String marca = this.vistaAgregar.jtf_marca.getText();
                if (!marca.matches("[^0-9]+")) {
                    JOptionPane.showMessageDialog(null, "La marca no debe contener números.");
                    this.vistaAgregar.jtf_marca.setText("");
                    this.vistaAgregar.jtf_marca.grabFocus();
                    return;
                }

                String color = this.vistaAgregar.jtf_color.getText();
                if (!color.matches("[^0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El color no debe contener números.");
                    this.vistaAgregar.jtf_color.grabFocus();
                    this.vistaAgregar.jtf_color.setText("");
                    return;
                }

                // Si todas las validaciones pasan, asignar valores al auto y agregarlo a la colección
                carrito.setAnhoSerie(anhoSerie);
                carrito.setCantTotalSerie(cantSerie);
                carrito.setnumeroSerie(numSerie);
                carrito.setMarca(marca);
                carrito.setColor(color);

                this.ctrlColeccion.getColeccionAutos().getAutos().add(carrito);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(vistaAgregar, "El auto del año: " + anhoSerie
                        + "\nCon el número de serie: " + numSerie
                        + "\nFue agregado con éxito");
                this.vistaAgregar.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: Asegúrate de que todos los campos numéricos estén llenos con valores válidos.");
            }
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
        this.vistaAgregar.jtf_numSerie.setText(this.ctrlColeccion.getUnaColeccion().jtf_numSerieC.getText());
        this.vistaAgregar.jtf_anhoSerie.setText(this.ctrlColeccion.getUnaColeccion().jtf_anhoSerieC.getText());
    }

}
