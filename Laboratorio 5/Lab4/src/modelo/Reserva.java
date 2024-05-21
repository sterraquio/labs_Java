
package modelo;

import java.sql.Timestamp;


public class Reserva {
    // Atributos:

    private Timestamp fecha;
    private int numReserva;
    private Docente unDocente = new Docente();
    private EquipoComputo equipo= new EquipoComputo();

    public Reserva() {
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }



    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }



    public Docente getUnDocente() {
        return unDocente;
    }

    public void setUnDocente(Docente unDocente) {
        this.unDocente = unDocente;
    }

    public EquipoComputo getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoComputo equipo) {
        this.equipo = equipo;
    }

   
    
}
