package Modelo;

import java.util.List;
import java.util.ArrayList;

public class Coleccion {

    //atributos
    private List<Auto> autos = new ArrayList<>();

    //Constructor
    public Coleccion() {
    }

    //Metodos
    /**
     * **************************************************************************************
     */
    public void agregarAuto(Auto carrito) {

        autos.add(carrito);
    }

    /**
     * **************************************************************************************
     */
    public int borrarAuto(int anhSerie, int numSerie) {

        Auto unCarro = new Auto();

        for (int i = 0; i < autos.size(); i++) {
            unCarro = autos.get(i);

            System.out.println(unCarro.getAnhoSerie());
            System.out.println(unCarro.getNumeroSerie());

            if (unCarro.getAnhoSerie() == anhSerie) {
                if (unCarro.getNumeroSerie() == numSerie) {
                    autos.remove(i);
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * **************************************************************************************
     */
    public String listarColeccion() {
        StringBuilder listaAutos = new StringBuilder();
        for (Auto auto : autos) {
            listaAutos.append("Año Serie: ").append(auto.getAnhoSerie())
                    .append(" - Marca: ").append(auto.getMarca())
                    .append(" - Color: ").append(auto.getColor())
                    .append(" - CantTotalSerie: ").append(auto.getCantTotalSerie())
                    .append(" - Numero Serie: ").append(auto.getNumeroSerie())
                    .append("\n");
        }
        return listaAutos.toString();
    }

    /**
     * **************************************************************************************
     */
    public String buscarAuto(int anhSerie, int numSerie) {

        Auto unCarro = new Auto();
        String datosAuto = "El auto no se encuentra";

        for (int i = 0; i < autos.size(); i++) {
            unCarro = autos.get(i);
            if (unCarro.getAnhoSerie() == anhSerie) {
                if (unCarro.getNumeroSerie() == numSerie) {
                    datosAuto = "Año Serie: " + unCarro.getAnhoSerie() + "\n"
                            + "Marca: " + unCarro.getMarca() + "\n"
                            + "Color: " + unCarro.getColor() + "\n"
                            + "cantTotalSerie: " + unCarro.getCantTotalSerie() + "\n"
                            + "numeroSerie: " + unCarro.getNumeroSerie() + "\n";
                    return datosAuto;
                }
            }
        }
        return datosAuto;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

}
