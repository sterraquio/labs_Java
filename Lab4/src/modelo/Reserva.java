package modelo;

public class Reserva {
    // Atributos:

    private String fecha;
    private int numReserva;
    private Docente unDocente;
    private EquipoComputo equipo;
    private int docenteReserva;
    private int equipoReservado;

    public Reserva() {
        this.docenteReserva = this.unDocente.getCedula();
        this.equipoReservado = this.equipo.getNumeroEquipo();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public int getDocenteReserva() {
        return docenteReserva;
    }

    public void setDocenteReserva(int docenteReserva) {
        this.docenteReserva = docenteReserva;
    }

    public int getEquipoReservado() {
        return equipoReservado;
    }

    public void setEquipoReservado(int equipoReservado) {
        this.equipoReservado = equipoReservado;
    }

}
