
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import vista.VistaReservaGUI;
import modelo.Reserva;
import modelo.ReservaDAO;



public class ControlReservaGUI implements ActionListener{

    private Reserva unaReserva;
    private ReservaDAO unaReservaDao;
    private VistaReservaGUI vista;
    
    public ControlReservaGUI() {
        this.unaReserva = new Reserva();
        this.unaReservaDao = new ReservaDAO();
        this.vista = new VistaReservaGUI();
        
        this.vista.setVisible(true);
        this.vista.jButtonAgregar.addActionListener(this);
        this.vista.jButtonBuscarReserva.addActionListener(this);
        this.vista.jButtonListar.addActionListener(this);
        this.vista.jButtonRegisDocente.addActionListener(this);
        this.vista.jButtonRegisEquipo.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        Timestamp fechaHora = new Timestamp(new Date().getTime());
        if(e.getSource() == this.vista.jButtonAgregar){}
        if(e.getSource() == this.vista.jButtonBuscarReserva){}
        if(e.getSource() == this.vista.jButtonListar){}
        
        if(e.getSource() == this.vista.jButtonRegisDocente){
            ControlDocenteGUI vistaDocente = new ControlDocenteGUI();
        }
        if(e.getSource() == this.vista.jButtonRegisEquipo){
        ControlEquipoComputoGUI vistaComputo = new ControlEquipoComputoGUI();
        }
        
    }
    
}
