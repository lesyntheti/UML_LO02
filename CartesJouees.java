package crazyEight;

public class CartesJouees {
	private Carte carteDessus;
	private ArrayList<Carte> cartesJouees;
	
	
	public CartesJouees(Carte premiereCarte){
		this.carteDessus=premiereCarte;
	}

	public Carte getCarteDessus() {
		return carteDessus;
	}

	public void setCarteDessus(Carte carteDessus) {
		this.carteDessus = carteDessus;
	}
	
	public ArrayList<Carte> getCartesJouees() {
		return cartesJouees;
	}
	
	//reset le pile apres avoir utilise tous les cartes sur la table
	public void resetCartesJouees() {
		this.cartesJouees = null;
	}
	
	public void ajouter(Carte carte) {
		cartesJouees.add(carte);
	}
	
	
}
