package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.VistaEquipoComputoGUI;
import modelo.EquipoComputo;
import modelo.EquipoComputoDao;

public class ControlEquipoComputoGUI implements ActionListener {

    private VistaEquipoComputoGUI vista;
    private EquipoComputo unEquipo;
    private EquipoComputoDao unEquipoDao;

    public ControlEquipoComputoGUI() {
        this.vista = new VistaEquipoComputoGUI();
        this.unEquipo = new EquipoComputo();
        this.unEquipoDao = new EquipoComputoDao();

        this.vista.setVisible(true);
        this.vista.jButtonAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vista.jButtonAgregar) {
            try {
                int numInventario = Integer.parseInt(this.vista.jTextFieldNumInvent.getText());
                String marca = this.vista.jTextFieldMarca.getText().trim();
                String capacidadDD = this.vista.jTextFieldCapacidadDD.getText().trim() + "GB";
                if (numInventario >= 0) {
                    if (!marca.equals("") || !capacidadDD.equals("")) {
                        this.unEquipo.setNumeroEquipo(numInventario);
                        this.unEquipo.setMarca(marca);
                        this.unEquipo.setCapacidadDD(capacidadDD);
                        this.unEquipoDao.insertarPersona(unEquipo);
                        JOptionPane.showMessageDialog(this.vista, "Se ha ingresado correctamente el equipo");
                    } else {
                        JOptionPane.showMessageDialog(this.vista, "Error, hay espacios en los recuadros de Marca y capacidada");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.vista, "El número de invetario debe ser un número igual o mayor a 0");
                }

            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(this.vista, "Error con: " + err.getMessage());
            }

        }
    }

}
