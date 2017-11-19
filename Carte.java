package crazyEight;

public class Carte {

	private int numero, couleur;
	
	public Carte(int numero, int couleur){
		this.numero=numero;
		this.couleur=couleur;
	}
	
	
	//getters (pas de setters car on modifie pas les cartes)
	
	public int getNumero() {
		return numero;
	}

	public String getCouleur() {
		if (couleur==0)return "Coeur";
		if (couleur==1)return "Pique";
		if (couleur==2)return "Carreau";
		else return "Trèfle";
		
	}

	//toString : retourne le numero et couleur de la carte (ex : 8 de Coeur)
	public String toString(){
		String sortie;
		if (numero==10) sortie = "Valet";
		if (numero==11) sortie = "Dame";
		if (numero==12) sortie = "Roi";
		else sortie = "" + (numero+1);
		return sortie + " de " + getCouleur();
		
	}
	
	
	/*
	public static void main(String[] args) {
		Carte roiDeTrefle = new Carte(12,4);
		System.out.println(roiDeTrefle.toString());
	}
	*/
	
}
