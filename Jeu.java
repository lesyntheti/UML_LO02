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
	private ControleJeu controleJeu;
	private int posJoueurEnCours;
	
	
	//doit avoir créé une initialisation d'abord !
	//constructeur du jeu avec les paramètres de initialisation
	public Jeu(Pioche pioche, Talon talon, int nbJoueurs, ArrayList<Joueur> listeJoueurs) {
		this.pioche = pioche;
		this.talon = talon;
		this.nbJoueurs = nbJoueurs;
		this.listeJoueurs = listeJoueurs;
		this.controleJeu = new ControleJeu();
	}


//méthode de tour de jeu  (à appeler une fois que tous les éléments ont étés initialisés avec l'objet initialisation)
	public boolean tourDeJeu(Joueur joueurEnCours){
		
		posJoueurEnCours=this.listeJoueurs.size();
		this.joueurEnCours = this.listeJoueurs.get(posJoueurEnCours-1); //dans le main il faudra envoyer controleJeu.joueurEnCours dans cette méthode
		ArrayList<Carte> carteJouable= new ArrayList<Carte>();
		carteJouable = this.joueurEnCours.cartesJouables(this.talon.getCarteDessus());
		int nbCartesJouables = carteJouable.size();
		ArrayList<Carte> mainSuppr = new ArrayList<Carte>();
		
		if(nbCartesJouables==0){
			this.joueurEnCours.piocherCarte(1, this.pioche);
			System.out.println("\n"+this.joueurEnCours.getNom() +" pioche 1 carte");
		}
		
		else if (this.joueurEnCours.getNom()=="moi")  //si c'est à nous de jouer 
		{	
			Carte carteJouee;
			carteJouee=this.joueurEnCours.jouerCarte(carteJouable, this.talon.getCarteDessus());
			this.talon.ajouterAPile(carteJouee); //on joue la carte
			
			
			mainSuppr = this.joueurEnCours.getMain();
			mainSuppr.remove(carteJouee);
			this.joueurEnCours.setMain(mainSuppr); //on supprime la carte jouée de la main du joueur
			
			//on vérifie si le joueur a encore des cartes (si oui, on continue, si non, il a gagné !)
			if (this.joueurEnCours.getMain().isEmpty()){
				System.out.println("vous n'avez plus de cartes, bravo !");
				return true;
			}
			else{
				int nbCartesReste;
				System.out.println("Il reste au joueur " + this.joueurEnCours.getNom() +"" + this.joueurEnCours.getMain().size() +" cartes.");
				prochainJoueur();
				
			
				mainSuppr = this.joueurEnCours.getMain();
				mainSuppr.remove(carteJouee);
				this.joueurEnCours.setMain(mainSuppr);
				
				return false;
			}
		
		}
		
		else{		//si le joueur est un robot
			
			//développer la méthode pour que le robot joue
			
		//if stratégie = 0
			//méthode simple : toujours jouer la 1e carte jouable (aucune stratégie)
			Carte carteJouee;
			carteJouee=carteJouable.get(1);
			this.talon.ajouterAPile(carteJouee); //on joue la carte
			
			mainSuppr = this.joueurEnCours.getMain();
			mainSuppr.remove(carteJouee);
			this.joueurEnCours.setMain(mainSuppr);
			
			
			if (this.joueurEnCours.getMain().isEmpty()){
				System.out.println("le joueur " + this.joueurEnCours.getNom() +" n'a plus de cartes");
				return true;
			}
			else{
				int nbCartesReste;
				System.out.println("Il reste au joueur " + this.joueurEnCours.getNom() +"" + this.joueurEnCours.getMain().size() +" cartes.");
				prochainJoueur();
				
			
				mainSuppr = this.joueurEnCours.getMain();
				mainSuppr.remove(carteJouee);
				this.joueurEnCours.setMain(mainSuppr);
				
				return false;
			}
			
		}
		
		
		
		
		this.verifPiocheVide();  //fin du tour : on vérifie que la pioche est pas vide/trop petite pour le prochain tour
		
		return gagnant;
	}


	
	
	
	

	public void verifPiocheVide(){   //à faire tourner à chaque fin de tour
		if (this.pioche.getDeck().size()<4){		//si la pioche devient trop petite, on la remplie
			ArrayList<Carte> nouvellePioche = new ArrayList<Carte>();
			
			nouvellePioche =this.pioche.getDeck();
			nouvellePioche.addAll(this.talon.getDessousPile());
			this.pioche.setDeck(nouvellePioche);			//on remplie la pioche avec les cartes du talon
			
			ArrayList<Carte> nouveauTalon = new ArrayList<Carte>();
			nouveauTalon.clear();				
			this.talon.setDessousPile(nouveauTalon);	//on vide le talon
		}
	}

	
	
	public void prochainJoueur(){
		int posJoueurEnCours;
		posJoueurEnCours=this.listeJoueurs.indexOf(joueurEnCours);
		
		if(controleJeu.isSensPartie()) { //si la partie va dans le sens "normal"

			//this.joueurEnCours = (this.posJoueurEnCours + 1) % getNombreJoueur();
			
			
			posJoueurEnCours=this.listeJoueurs.indexOf(joueurEnCours); //on récupère l'index du joueur précédent
			posJoueurEnCours = (posJoueurEnCours +1)%this.listeJoueurs.size(); //on l'incrémente dans la limite du nombre de joueurs 
			this.joueurEnCours=this.listeJoueurs.get(posJoueurEnCours); //on désigne le nouveau joueurEnCours

		}
		//si on va dans le sens inverse de la "normale"
		else{

			if(posJoueurEnCours==0){
				posJoueurEnCours = (this.listeJoueurs.size()-1);
				this.joueurEnCours=this.listeJoueurs.get(posJoueurEnCours);
				
			}
			else{
				posJoueurEnCours--;
				this.joueurEnCours=this.listeJoueurs.get(posJoueurEnCours);
			}
		}
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


	public boolean isGagnant() {
		return gagnant;
	}


	public void setGagnant(boolean gagnant) {
		this.gagnant = gagnant;
	}


	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}


	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}


	public ControleJeu getControleJeu() {
		return controleJeu;
	}


	public void setControleJeu(ControleJeu controleJeu) {
		this.controleJeu = controleJeu;
	}


	public int getPosJoueurEnCours() {
		return posJoueurEnCours;
	}


	public void setPosJoueurEnCours(int posJoueurEnCours) {
		this.posJoueurEnCours = posJoueurEnCours;
	}
	
	
	

	
	
	
}
