package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.VistaEquipoComputoGUI;
import modelo.EquipoComputo;
import modelo.EquipoComputoDao;

//clase que agrega los listeners a los botones de la vista
public class ControlEquipoComputoGUI implements ActionListener {
    //atributos
    private VistaEquipoComputoGUI vista;//vista
    private EquipoComputo unEquipo;//Clase EquipoComputo
    private EquipoComputoDao unEquipoDao;//Clase EquipoComputoDao
    
    //constructor
    public ControlEquipoComputoGUI() {
        this.vista = new VistaEquipoComputoGUI();//inicializa la vista  
        this.unEquipo = new EquipoComputo();//inicializa la Clase EquipoComputo 
        this.unEquipoDao = new EquipoComputoDao();//inicializa la clase EquipoComputoDao

        this.vista.setVisible(true);//vista visible 
        this.vista.jButtonAgregar.addActionListener(this);//agrega el listener al boton
        this.vista.jButtonConsultar.addActionListener(this);// Listener al botón
        this.vista.jButtonEliminar.addActionListener(this);// Listener al botón
        this.vista.jButtonListar.addActionListener(this);// Listener al botón
        this.vista.jButtonModificar.addActionListener(this);// Listener al botón
    }

    
    //metodo del escucha 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Boton agregar 
        if (e.getSource() == this.vista.jButtonAgregar) {
            //validaciones
            try {
                //se pasa lo que contenga el jtf a una variable 
                int numInventario = Integer.parseInt(this.vista.jTextFieldNumInvent.getText());
                String marca = this.vista.jTextFieldMarca.getText().trim().toLowerCase();
                String capacidadDD = this.vista.jTextFieldCapacidadDD.getText().trim() + "GB";
                //el toLowerCase convierte los caracteres de la cadena todos en minusculas 
                //el .trim elimina los espacios vacios al inicio y al final
                
                if (numInventario >= 0) {
                    if (!marca.equals("") || !capacidadDD.equals("")) {//verifica que no tenga cadenas de texto vacias
                        if (!marca.matches("[^0-9]+" )) {//verifica que si contiene caracteres de tipo numerico
                            JOptionPane.showMessageDialog(this.vista, "El recuadro de marca no debe tener números");
                        }else{
                            //Despues de las validaciones se asigna a los atributos de EquipoComputo
                            this.unEquipo.setNumeroEquipo(numInventario);
                            this.unEquipo.setMarca(marca);
                            this.unEquipo.setCapacidadDD(capacidadDD);
                            //se utiliza un metodo de la clase EquipoComputoDao para agregar un EquipoComputo
                            this.unEquipoDao.insertarPersona(unEquipo);
                            JOptionPane.showMessageDialog(this.vista, "Se ha ingresado correctamente el equipo");
                            this.vista.dispose();
                        }
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
        // Botón de consultar
        if(e.getSource() == this.vista.jButtonConsultar){
        
        }
        // Botón de listar
        if(e.getSource() == this.vista.jButtonListar){
        
        }
        // Botón de modificar
        if(e.getSource() == this.vista.jButtonModificar){
        
        }
        // Botón de Eliminar
        if(e.getSource() == this.vista.jButtonEliminar){
        
        }
    }

}
