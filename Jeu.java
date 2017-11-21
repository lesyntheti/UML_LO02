package crazyEight;

import java.util.*;

public class Jeu {

	
	private Initialisation initialisation;
	private CartesNonDistribuees cartesNonDistribuees;
	private CartesJouees cartesJouees;
	private int nbJoueurs;
	protected ArrayList<JoueurVirtuel> listeJoueurs = new ArrayList<JoueurVirtuel>();
	
	
	
	public boolean tourDeJeu(){
		
	}

	
	
	
//getters et setters

	public Initialisation getInitialisation() {
		return initialisation;
	}



	public void setInitialisation(Initialisation initialisation) {
		this.initialisation = initialisation;
	}



	public CartesNonDistribuees getCartesNonDistribuees() {
		return cartesNonDistribuees;
	}



	public void setCartesNonDistribuees(CartesNonDistribuees cartesNonDistribuees) {
		this.cartesNonDistribuees = cartesNonDistribuees;
	}



	public CartesJouees getCartesJouees() {
		return cartesJouees;
	}



	public void setCartesJouees(CartesJouees cartesJouees) {
		this.cartesJouees = cartesJouees;
	}



	public int getNbJoueurs() {
		return nbJoueurs;
	}



	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}



	public ArrayList<JoueurVirtuel> getListeJoueurs() {
		return listeJoueurs;
	}



	public void setListeJoueurs(ArrayList<JoueurVirtuel> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}



	
		
	
	
	

		
		
	

}
