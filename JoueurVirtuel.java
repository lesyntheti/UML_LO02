
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
	
	public void jouerUneCarte(Carte dessusPile,MainDuJoueur main) {
		
		Iterator<Carte> i=main.main.iterator();
		Carte carteEnCours = (Carte) i;
		boolean peutJoue = false;
		if(carteEnCours.pouvoirJoue(dessusPile)==true) {
			peutJoue=true;
		} 
		while((peutJoue==false)&(i.hasNext())){
			carteEnCours=i.next();
			if(carteEnCours.pouvoirJoue(dessusPile)==true) {
				peutJoue=true;
			}
		}
		//On utilise les cartes a effect, si on ne peut rien jouer.
		//Pas encore fini...
		if(peutJoue==false) {
			Carte carteEnCours2 = (Carte) i;
			
		}
		if (peutJoue==true) {
			main.main.remove(carteEnCours);
			
		}
	}
	
	
}

