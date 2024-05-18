package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Docente;
import modelo.DocenteDAO;
import vista.VistaDocenteGUI;

/**
 *
 * @author UNIVALLE
 */
public class ControlDocenteGUI implements ActionListener{
    
    private VistaDocenteGUI vistaDocente;
    private ControlReservaGUI ctrlReserva;
    private Docente modeloDocente;
    private DocenteDAO modeloDocenteDao;

    public ControlDocenteGUI() {
        this.vistaDocente = new VistaDocenteGUI();
        this.ctrlReserva = new ControlReservaGUI();
        this.modeloDocenteDao = new DocenteDAO();
        
        
        
        vistaDocente.setVisible(true);
        vistaDocente.jButtonAgregar.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==this.vistaDocente.jButtonAgregar){
            modeloDocente = new Docente();
            modeloDocente.setCedula(Integer.parseInt(this.vistaDocente.jTextFieldCed.getText()));
            modeloDocente.setNombres(this.vistaDocente.jTextFieldNombre.getText());
            modeloDocente.setApellidos(this.vistaDocente.jTextFieldNombre.getText());
            modeloDocente.setProfesion(this.vistaDocente.jTextFieldNombre.getText());
            
            modeloDocenteDao.insertarDocente(modeloDocente);
            javax.swing.JOptionPane.showMessageDialog(vistaDocente, "docente se agrego con exito ");
            vistaDocente.setVisible(false);
        }
        
        
    }

    public VistaDocenteGUI getVistaDocente() {
        return vistaDocente;
    }

    public void setVistaDocente(VistaDocenteGUI vistaDocente) {
        this.vistaDocente = vistaDocente;
    }

    public ControlReservaGUI getCtrlReserva() {
        return ctrlReserva;
    }

    public void setCtrlReserva(ControlReservaGUI ctrlReserva) {
        this.ctrlReserva = ctrlReserva;
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
