package crazyeightBis;

import java.util.ArrayList;


public class Jeu {

	private Initialisation initialisation;
	private Pioche pioche;
	private Talon talon;
	private int nbJoueurs;
	protected ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	private boolean gagnant=false; //à envoyer vers le main (partie)
	private Joueur joueurEnCours;   //pour savoir qui faire jouer à chaque étape d'un tour
	
	
	
	//doit avoir créé une initialisation d'abord !
	//constructeur du jeu avec les paramètres de initialisation
	public Jeu(Pioche pioche, Talon talon, int nbJoueurs, ArrayList<Joueur> listeJoueurs) {
		this.pioche = pioche;
		this.talon = talon;
		this.nbJoueurs = nbJoueurs;
		this.listeJoueurs = listeJoueurs;
	}


//méthode de tour de jeu  (à appeler une fois que tous les éléments ont étés initialisés avec l'objet initialisation)
	public void tourDeJeu(){
		
			
			
			
		
	}





	
	
	
	
	
	
	
	//getters and setters
	
	public Initialisation getInitialisation() {
		return initialisation;
	}
	public void setInitialisation(Initialisation initialisation) {
		this.initialisation = initialisation;
	}

	public Pioche getPioche() {
		return pioche;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	public Talon getTalon() {
		return talon;
	}

	public void setTalon(Talon talon) {
		this.talon = talon;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}
	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}
	public ArrayList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}
	public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	
	
	

	
	
	
}
