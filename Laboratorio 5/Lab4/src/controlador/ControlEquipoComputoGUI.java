package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.VistaEquipoComputoGUI;
import modelo.EquipoComputo;
import modelo.EquipoComputoDao;
import java.util.List;

//clase que agrega los listeners a los botones de la vista
public class ControlEquipoComputoGUI implements ActionListener {

    //atributos
    private boolean consultado = false;
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
        boolean verdad = false;//Variable para saber si se hizo la consulta de manera correcta
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
                        if (!marca.matches("[^0-9]+")) {//verifica que si contiene caracteres de tipo numerico
                            JOptionPane.showMessageDialog(this.vista, "El recuadro de marca no debe tener números");
                        } else {
                            //Despues de las validaciones se asigna a los atributos de EquipoComputo
                            this.unEquipo.setNumeroEquipo(numInventario);
                            this.unEquipo.setMarca(marca);
                            this.unEquipo.setCapacidadDD(capacidadDD);
                            //se utiliza un metodo de la clase EquipoComputoDao para agregar un EquipoComputo
                            this.unEquipoDao.insertarEquicoComputo(unEquipo);
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
<<<<<<< Updated upstream

        // Botón de consultar
        if (e.getSource() == this.vista.jButtonConsultar) {
            try {
                if (true) {

                    //Poner en un objeto el resultado del método consultaEquipos
                    this.unEquipo = this.unEquipoDao.consultarEquiposComputo(Integer.parseInt(this.vista.jTextFieldNumInvent.getText()));

                    //Poner en los Texfield la consulta
                    this.vista.jTextFieldCapacidadDD.setText(this.unEquipo.getCapacidadDD());
                    this.vista.jTextFieldMarca.setText(this.unEquipo.getMarca());
                    verdad = true;
                } else if (!verdad) {
                    JOptionPane.showMessageDialog(this.vista, "No se ha encontrado el equipo con ese número.");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.vista, "El campo Número de inventario es obligatorio\nY deben ser en formato numérico");
            }

        }
        // Botón de listar
        if (e.getSource() == this.vista.jButtonListar) {
            EquipoComputo equipitoTemp = new EquipoComputo();//Crear un nuevo objeto para almacenar el resultado del la lista que contendra el método listarEquipos
            List<EquipoComputo> ListaEquipito;//Lista que almacenará lo retornado por el método listar

            String resultado = "#invetario--Capacidad--Marca\n";//Para separar los atributos de la consulta

            ListaEquipito = this.unEquipoDao.listarEquipos();//Asignar a la lista el reusltado del método

            for (int i = 0; i < ListaEquipito.size(); i++) {//Búcle para acceder a todos los datos de la tabla
                equipitoTemp = ListaEquipito.get(i);

                //Almacenar los resultados de la lista
                resultado += equipitoTemp.getNumeroEquipo() + "--" + equipitoTemp.getCapacidadDD() + "--" + equipitoTemp.getMarca() + "\n";

            }
            JOptionPane.showMessageDialog(this.vista, resultado);//Mostrar el resultado de la lista
        }
        // Botón de modificar
        if (e.getSource() == this.vista.jButtonModificar) {
            //Validar que no hayan letras en los campos
            try {
                //Validación si ya se hizo previamente la consulta del equipo
                if (true) {

                    //Guardar en un objeto los datos que se quieren modificar
                    this.unEquipo.setNumeroEquipo(Integer.parseInt(this.vista.jTextFieldNumInvent.getText()));
                    this.unEquipo.setCapacidadDD(this.vista.jTextFieldCapacidadDD.getText() + " GB");
                    this.unEquipo.setMarca(this.vista.jTextFieldMarca.getText());
                    //Validar si los campos no estén vacíos
                    if (!this.unEquipo.getMarca().equals("") && !this.unEquipo.getCapacidadDD().equals("")) {
                        //Ejecutar método para insertar los datos en la base de datos
                        if (this.unEquipoDao.actualizarEquiposComputo(unEquipo)) {
                            JOptionPane.showMessageDialog(this.vista, "Se ha actualizado con éxtio");
                            this.vista.jTextFieldCapacidadDD.setText("");
                            this.vista.jTextFieldMarca.setText("");
                            this.vista.jTextFieldNumInvent.setText("");
                        } else {
                            JOptionPane.showMessageDialog(this.vista, "Datos no actualizados!!!");

                        }
                    } else {
                        JOptionPane.showMessageDialog(this.vista, "No se pueden actualizar los datos \n Datos no actualizados");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.vista, "error con el primer If");

                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.vista, "El campo número de inventario es obligatorios\nY debe ser en formato numérico");
            }
        }
        // Botón de Eliminar
        if (e.getSource() == this.vista.jButtonEliminar) {
            try {
                int inventario = Integer.parseInt(this.vista.jTextFieldNumInvent.getText());
                if (this.unEquipoDao.eliminarPersona(inventario)) {
                    JOptionPane.showMessageDialog(this.vista, "Datos ELIMINADOSSSSSSSSSSSSSS");
                    this.vista.jTextFieldNumInvent.setText("");
                    this.vista.jTextFieldMarca.setText("");
                    this.vista.jTextFieldCapacidadDD.setText("");
                } else {
                    JOptionPane.showMessageDialog(this.vista, "No se ha eliminado :c");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this.vista, "El campo de Número de inventario es obligatorio\nY debe estar en formato númerico");
            }
=======
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
        
>>>>>>> Stashed changes
        }
    }

}
