package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Docente;
import modelo.DocenteDAO;
import vista.VistaDocenteGUI;

/**
 *
 * @author UNIVALLE
 */
public class ControlDocenteGUI implements ActionListener {

    private VistaDocenteGUI vistaDocente;
    private ControlReservaGUI ctrlReserva;
    private Docente modeloDocente;
    private DocenteDAO modeloDocenteDao;

    public ControlDocenteGUI() {
        this.vistaDocente = new VistaDocenteGUI();
        this.modeloDocenteDao = new DocenteDAO();

        vistaDocente.setVisible(true);
        vistaDocente.jButtonAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Registrar 
        if (ae.getSource() == this.vistaDocente.jButtonAgregar) {
            // Verificación de campos vacíos
            if (this.vistaDocente.jTextFieldCed.getText().isEmpty()
                    || this.vistaDocente.jTextFieldNombre.getText().isEmpty()
                    || this.vistaDocente.jTextFieldApellido.getText().isEmpty()
                    || this.vistaDocente.jTextFieldProfesion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaDocente, "Todos los campos deben estar llenos.");
                return;
            }
            try {
                modeloDocente = new Docente();

                int cedula = Integer.parseInt(this.vistaDocente.jTextFieldCed.getText());

                String nombre = this.vistaDocente.jTextFieldNombre.getText().toLowerCase();
                if (!nombre.matches("[^0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre  no debe contener números.");
                    this.vistaDocente.jTextFieldNombre.setText("");
                    this.vistaDocente.jTextFieldNombre.grabFocus();
                    return;
                }
                String Apellido = this.vistaDocente.jTextFieldNombre.getText().toLowerCase();
                if (!Apellido.matches("[^0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El apellido no debe contener números.");
                    this.vistaDocente.jTextFieldApellido.setText("");
                    this.vistaDocente.jTextFieldApellido.grabFocus();
                    return;
                }

                String Profesion = this.vistaDocente.jTextFieldNombre.getText().toLowerCase();
                if (!Profesion.matches("[^0-9]+")) {
                    JOptionPane.showMessageDialog(null, "la profesion no debe contener números.");
                    this.vistaDocente.jTextFieldNombre.setText("");
                    this.vistaDocente.jTextFieldNombre.grabFocus();
                    return;
                }

                modeloDocente.setCedula(cedula);
                modeloDocente.setNombres(nombre);
                modeloDocente.setApellidos(Apellido);
                modeloDocente.setProfesion(Profesion);

                modeloDocenteDao.insertarDocente(modeloDocente);

                javax.swing.JOptionPane.showMessageDialog(vistaDocente, "docente se agrego con exito : " + nombre);
                vistaDocente.dispose();

            } catch (NumberFormatException ex) {
                // Manejo de excepción si el campo cedula no es un número
                JOptionPane.showMessageDialog(vistaDocente, "La cédula no debe tener texto. Introduce un número válido.");
                this.vistaDocente.jTextFieldCed.setText("");
                this.vistaDocente.jTextFieldCed.grabFocus();
            } catch (Exception ex) {
                // Manejo de cualquier otra excepción
                JOptionPane.showMessageDialog(vistaDocente, "Ocurrió un error: " + ex.getMessage());
            }
        }
    }

    public VistaDocenteGUI getVistaDocente() {
        return vistaDocente;
    }

    public void setVistaDocente(VistaDocenteGUI vistaDocente) {
        this.vistaDocente = vistaDocente;
    }



    public Docente getModeloDocente() {
        return modeloDocente;
    }

    public void setModeloDocente(Docente modeloDocente) {
        this.modeloDocente = modeloDocente;
    }

    public DocenteDAO getModeloDocenteDao() {
        return modeloDocenteDao;
    }

    public void setModeloDocenteDao(DocenteDAO modeloDocenteDao) {
        this.modeloDocenteDao = modeloDocenteDao;
    }

}
