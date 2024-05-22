package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Docente;
import modelo.DocenteDAO;
import vista.VistaDocenteGUI;

/**
 *
 * @author UNIVALLE
 */
//clase que agrega los listeners a los botones de la vista
public class ControlDocenteGUI implements ActionListener {

    // atributos 
    private VistaDocenteGUI vistaDocente;//vista
    private Docente modeloDocente;//clase docente 
    private DocenteDAO modeloDocenteDao;//clase docenteDao

    //constructor
    public ControlDocenteGUI() {
        this.vistaDocente = new VistaDocenteGUI();//inicializa la vista
        this.modeloDocenteDao = new DocenteDAO();//inicializa la clase Dao

        vistaDocente.setVisible(true);//hace visible la vista
        vistaDocente.jButtonAgregar.addActionListener(this);//agrega el listener al boton
        this.vistaDocente.jButtonConsultar.addActionListener(this);// Listener al botón
        this.vistaDocente.jButtonEliminar.addActionListener(this);// Listener al botón
        this.vistaDocente.jButtonListar.addActionListener(this);// Listener al botón
        this.vistaDocente.jButtonModificar.addActionListener(this);// Listener al botón
    }

    //metodo del escucha 
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Registrar 
        if (ae.getSource() == this.vistaDocente.jButtonAgregar) {
            // Verificación de campos vacíos
            if (this.vistaDocente.jTextFieldCed.getText().isEmpty()
                    || this.vistaDocente.jTextFieldNombre.getText().isEmpty()
                    || this.vistaDocente.jTextFieldApellido.getText().isEmpty()
                    || this.vistaDocente.jTextFieldProfesion.getText().isEmpty()) {
                //el isEmpty sirve para conpara la longitud de una cadena de texto es decir 
                //que si es 0 devuelve true si no un false,si devuelve 0 es porque esta vacia

                JOptionPane.showMessageDialog(vistaDocente, "Todos los campos deben estar llenos.");
                return;
            }

            try {
                modeloDocente = new Docente();//inicializa la clase docente 

                //pasa lo que esta en el jtf a una variable
                int cedula = Integer.parseInt(this.vistaDocente.jTextFieldCed.getText().trim());

                //pasa lo que esta en el jtf a una variable 
                String nombre = this.vistaDocente.jTextFieldNombre.getText().toLowerCase().trim();
                //el toLowerCase convierte los caracteres de la cadena todos en minusculas
                //el .trim elimina los espacios vacios al inicio y al final
                //verifica que la variable de tipo String contenga caracteres numericos
                if (!nombre.matches("[^0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El nombre  no debe contener números.");
                    this.vistaDocente.jTextFieldNombre.setText("");//coloca una cadena "" en el jtf
                    this.vistaDocente.jTextFieldNombre.grabFocus();//centra el foco en el jtf
                    return;
                }
                //pasa lo que esta en el jtf a una variable 
                String Apellido = this.vistaDocente.jTextFieldNombre.getText().toLowerCase().trim();
                //verifica que la variable de tipo String no contenga caracteres numericos
                if (!Apellido.matches("[^0-9]+")) {
                    JOptionPane.showMessageDialog(null, "El apellido no debe contener números.");
                    this.vistaDocente.jTextFieldApellido.setText("");
                    this.vistaDocente.jTextFieldApellido.grabFocus();
                    return;
                }

                //pasa lo que esta en el jtf a una variable 
                String Profesion = this.vistaDocente.jTextFieldNombre.getText().toLowerCase().trim();
                //verifica que la variable de tipo String no contenga caracteres numericos
                if (!Profesion.matches("[^0-9]+")) {
                    JOptionPane.showMessageDialog(null, "la profesion no debe contener números.");
                    this.vistaDocente.jTextFieldNombre.setText("");
                    this.vistaDocente.jTextFieldNombre.grabFocus();
                    return;
                }

                //Despues de las validaciones se asigna a los atributos de Docente
                modeloDocente.setCedula(cedula);
                modeloDocente.setNombres(nombre);
                modeloDocente.setApellidos(Apellido);
                modeloDocente.setProfesion(Profesion);

                //se utiliza un metodo de la clase docenteDao para agregar un Docente
                modeloDocenteDao.insertarDocente(modeloDocente);

                javax.swing.JOptionPane.showMessageDialog(vistaDocente, "docente se agrego con exito : " + nombre);
                vistaDocente.dispose();

            } catch (NumberFormatException ex) {
                // Manejo de excepción si el campo cedula no es un número
                JOptionPane.showMessageDialog(vistaDocente, "La cédula no debe tener texto. Introduce un número válido.(￣ω￣)");
                this.vistaDocente.jTextFieldCed.setText("");
                this.vistaDocente.jTextFieldCed.grabFocus();
            } catch (Exception ex) {
                // Manejo de cualquier otra excepción
                JOptionPane.showMessageDialog(vistaDocente, "Ocurrió un error: " + ex.getMessage());
            }
        }
        // Botón de consultar
        if (ae.getSource() == this.vistaDocente.jButtonConsultar) {
            try{
                this.modeloDocente = modeloDocenteDao.consultarDocente(Integer.parseInt(this.vistaDocente.jTextFieldCed.getText().trim()));
                
                this.vistaDocente.jTextFieldCed.setText(this.modeloDocente.getCedula()+"");
                this.vistaDocente.jTextFieldNombre.setText(this.modeloDocente.getNombres());
                this.vistaDocente.jTextFieldApellido.setText(this.modeloDocente.getApellidos());
                this.vistaDocente.jTextFieldProfesion.setText(this.modeloDocente.getProfesion());
                
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(vistaDocente, "revise que el campo cedula este completo y no contenga letras ⤜(ʘ_ʘ)⤏");
                this.vistaDocente.jTextFieldCed.grabFocus();
            }
            
           

        }
        // Botón de listar
        if (ae.getSource() == this.vistaDocente.jButtonListar) {
            
            Docente elDocente = new Docente();
            List<Docente> listaDeDocentes;
            
            String lista = "CEDULA || NOMBRE || APELLIDO || PROFESION "+"\n";
            
            listaDeDocentes = this.modeloDocenteDao.listarDocentes();
            
            for (int i=0; i< listaDeDocentes.size();i++){
                elDocente = listaDeDocentes.get(i);
                lista  += elDocente.getCedula() +" || "+ elDocente.getNombres()+" || "+ elDocente.getApellidos()+
                        " || "+ elDocente.getProfesion() +"\n";
                  
            }
            JOptionPane.showMessageDialog(vistaDocente, lista);

        }
        // Botón de modificar
        if (ae.getSource() == this.vistaDocente.jButtonModificar) {
            //se obtienen los datos de la lista        
            //se valida que los datos numéricos no vengan vacios o con datos diferentes a números por conversión de tipos o parseo
            try{
              
                this.modeloDocente.setCedula(Integer.parseInt(this.vistaDocente.jTextFieldCed.getText()));
                
                this.modeloDocente.setApellidos(this.vistaDocente.jTextFieldApellido.getText());
                this.modeloDocente.setNombres(this.vistaDocente.jTextFieldNombre.getText());        
                this.modeloDocente.setProfesion(this.vistaDocente.jTextFieldProfesion.getText());
                
                
                //se valida que los campos tipo texto no esten vacíos
                if(!this.modeloDocente.getNombres().equals("") && !this.modeloDocente.getApellidos().equals("")&& !this.modeloDocente.getProfesion().equals("")){
                    //se ejecuta la inserción en la base de datos
                    if(this.modeloDocenteDao.actualizarDocente(modeloDocente)){
                        JOptionPane.showMessageDialog(this.vistaDocente, "Datos actualizados con éxito ʕ•́ᴥ•̀ʔっ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(this.vistaDocente, "Datos no actualizados (ㆆ_ㆆ)");
                    }
                }else{
                    JOptionPane.showMessageDialog(this.vistaDocente,"Todos los campos son obligatorios\nY ninguno debe ir en blanco (👍≖‿‿≖)👍");
                }                
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this.vistaDocente,"Los campos Cédula y Edad son obligatorios\nY deben ser en formato numérico (⌐■_■)");
            }

        }
        // Botón de Eliminar
        if (ae.getSource() == this.vistaDocente.jButtonEliminar) {

        
          try{
                int cedula= Integer.parseInt(this.vistaDocente.jTextFieldCed.getText());
            
                if(this.modeloDocenteDao.eliminarDocente(cedula)){
                    JOptionPane.showMessageDialog(this.vistaDocente, "Datos Eliminados!!! (¬‿¬ )");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(this.vistaDocente, "Datos No Eliminados!!!");
                }
                
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this.vistaDocente,"El campo Cédula es obligatorio\nY deben ser en formato numérico");
            }            
        } 

    }
    
     public void limpiarCampos(){
        this.vistaDocente.jTextFieldCed.setText("");
        this.vistaDocente.jTextFieldNombre.setText("");
        this.vistaDocente.jTextFieldApellido.setText("");
        this.vistaDocente.jTextFieldProfesion.setText("");
        
    }

    //gets y sets
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
