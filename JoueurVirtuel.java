package crazyEight;


public class JoueurVirtuel {
	
	String nom;
	MainJoueur main;
	
	public JoueurVirtuel(String nom){
		this.nom = nom;
		MainJoueur main = new MainJoueur();
	}
	
	//méthodes pour jouer une carte
	//inclure la stratégie aussi
	
	public String toString(){
		return this.nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public MainJoueur getMain() {
		return main;
	}

	public void setMain(MainJoueur main) {
		this.main = main;
	}
	
	
	
}

