import java.util.List;
import java.util.ArrayList;

public class Coleccion{

	//atributos
	private List<Auto> autos= new ArrayList<>();
	
	
	//Constructor
	public Coleccion(){}

	//Metodos
	/*****************************************************************************************/
	public void agregarAuto(Auto carrito){

		autos.add(carrito);
	}
	/*****************************************************************************************/
	public int borrarAuto(int anhSerie, int numSerie){

		Auto unCarro= new Auto();

		for(int i=0; i<autos.size(); i++){
			unCarro= autos.get(i);

			System.out.println(unCarro.getAnhoSerie());
			System.out.println(unCarro.getNumeroSerie());

			if(unCarro.getAnhoSerie() == anhSerie){
				if(unCarro.getNumeroSerie() == numSerie){
					autos.remove(i);
					return 1;
				}
			}
		}
		return 0;
	}
	/*****************************************************************************************/	
	public String listarColeccion(){

		Auto unCarro= new Auto();
		String coleccion="";

		for(int i=0; i<autos.size(); i++){
			unCarro= autos.get(i);
			coleccion +=	"Año Serie: "+unCarro.getAnhoSerie()+
					" - Marca: "+unCarro.getMarca()+
					" - Color: "+unCarro.getColor()+
					" - cantTotalSerie: "+unCarro.getCantTotalSerie()+
					" - numeroSerie: "+unCarro.getNumeroSerie()+"\n";
		}
		return coleccion;
	}
	/*****************************************************************************************/
	public String buscarAuto(int anhSerie, int numSerie){

		Auto unCarro= new Auto();	
		String datosAuto="El auto no se encuentra";

		for(int i=0; i<autos.size(); i++){
			unCarro= autos.get(i);
			if(unCarro.getAnhoSerie() == anhSerie){
				if(unCarro.getNumeroSerie() == numSerie){
					datosAuto +=	"Año Serie: "+unCarro.getAnhoSerie()+"\n"+
							"Marca: "+unCarro.getMarca()+"\n"+
							"Color: "+unCarro.getColor()+"\n"+
							"cantTotalSerie: "+unCarro.getCantTotalSerie()+"\n"+
							"numeroSerie: "+unCarro.getNumeroSerie()+"\n";
					return datosAuto;
				}
			}
		}
		return datosAuto;
	}

}