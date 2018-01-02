package modele;

import java.util.ArrayList;

public class Talon {

	private Carte carteDessus;
	private ArrayList<Carte> dessousPile = new ArrayList<Carte>();
	private ArrayList<Carte> pileT;
	
	
	
	//constructor
	public Talon(Carte premiereCarte){
		this.carteDessus=premiereCarte;
		this.dessousPile.add(premiereCarte);
		
	}
	
	
	public void ajouter(Carte carteJouee) {
		if (carteDessus==null)
			this.carteDessus=carteJouee;
		else{
			this.dessousPile.add(this.carteDessus);
			this.carteDessus=carteJouee;
		}
	
	}
	
	/*
	//reset le pile apres avoir utilise tous les cartes sur la table
		public void resetCartesJouees() {
			this.cartesJouees = null;
	}
	*/
	
	//getters and setters
	
	
	
	public Carte getCarteDessus() {
		return carteDessus;
	}

	public ArrayList<Carte> getDessousPile() {
		return dessousPile;
	}


	public void setDessousPile(ArrayList<Carte> dessousPile) {
		this.dessousPile = dessousPile;
	}

//méthode inutile normalement
	public void ajouterAPile(Carte carteJouee){
		if (this.dessousPile.isEmpty()){
			pileT = new ArrayList<Carte>();
			pileT.add(carteJouee);
			this.setDessousPile(pileT);
		}
		else{	
			pileT = new ArrayList<Carte>();
			pileT=this.getDessousPile();
			pileT.add(carteJouee);
			this.setDessousPile(pileT);
		}
			
		
	}
	
	
	public void setCarteDessus(Carte carteJouee) {
		if (carteDessus==null){
			this.carteDessus=carteJouee;
			this.dessousPile.add(carteJouee);  	//la carte est placée sur le dessus ET dans la pileDessous
		}									//ainsi on pourra modifier la couleur de la carte du dessus sans conséquence sur les cartes
		else{
			
			this.carteDessus=carteJouee;
			this.dessousPile.add(this.carteDessus); //on place la nouvelle carte sur le dessus ET dans la pile
		}
	}
	
	
	
}
