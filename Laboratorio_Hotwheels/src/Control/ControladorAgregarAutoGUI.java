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
    //EVENTO BOTON REGISTRAR
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaAgregar.jbt_AgregarAuto) {
            while (true) {
                try {
                    carrito = new Auto();
                    carrito.setAnhoSerie(Integer.parseInt(this.vistaAgregar.jtf_anhoSerie.getText()));
                    carrito.setCantTotalSerie(Integer.parseInt(this.vistaAgregar.jtf_canSerie.getText()));
                    carrito.setnumeroSerie(Integer.parseInt(this.vistaAgregar.jtf_numSerie.getText()));
                    carrito.setMarca(this.vistaAgregar.jtf_marca.getText());
                    carrito.setColor(this.vistaAgregar.jtf_color.getText());

                    if (Integer.parseInt(this.vistaAgregar.jtf_anhoSerie.getText()) >= 1000) {
                        if (Integer.parseInt(this.vistaAgregar.jtf_numSerie.getText()) <= Integer.parseInt(this.vistaAgregar.jtf_canSerie.getText()) && Integer.parseInt(this.vistaAgregar.jtf_numSerie.getText()) > 0) {
                            //Agrega a la coleccion
                            this.ctrlColeccion.getColeccionAutos().getAutos().add(carrito);
                            //Para mostrar que se guardó correctamente
                            javax.swing.JOptionPane.showMessageDialog(vistaAgregar, "La auto del año : " + this.vistaAgregar.jtf_anhoSerie.getText()
                                    + "\nCon el numero de serie : " + this.vistaAgregar.jtf_numSerie.getText()
                                    + "\nFue agregado con Exito");
                            this.vistaAgregar.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "EROR, el número de serie debe ser igual o menor que la cantidad de la serie y mayor que 0");
                            this.vistaAgregar.jtf_numSerie.grabFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El año de la serie debe ser mayor o igual que 4 digitos");
                        this.vistaAgregar.jtf_anhoSerie.setText("");
                        this.vistaAgregar.jtf_anhoSerie.grabFocus();
                    }

                    break;
                } catch (NumberFormatException error_1) {
                    JOptionPane.showMessageDialog(null, "Error, con el año de serie o numero de serie o cantidad de serie. DEBEN SER VALORES NUMERICOS, además todos los recuadros deben estar llenos");
                    break;
                }
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
