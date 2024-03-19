public class Auto{

	//atributos
	private int anhoSerie;
	private String marca;
	private String color;
	private int cantTotalSerie;
	private int numeroSerie;

	//Constructor
	public Auto(){}

	//Metodos set///////////////////////////////////////////////////////////////

	public void setAnhoSerie(int anSer){
		anhoSerie= anSer;
	}
	public void setMarca(String marc){
		marca= marc;
	}
	public void setColor(String col){
		color= col;
	}
	public void setCantTotalSerie(int cantTotSer){
		cantTotalSerie= cantTotSer;
	}
	public void setnumeroSerie(int numSer){
		numeroSerie= numSer;
	}
	//Metodos get///////////////////////////////////////////////////////////////

	public int getAnhoSerie(){
		return anhoSerie;
	}
	public String getMarca(){
		return marca;
	}
	public String getColor(){
		return color;
	}
	public int getCantTotalSerie(){
		return cantTotalSerie;
	}
	public int getNumeroSerie(){
		return numeroSerie;
	}	
}