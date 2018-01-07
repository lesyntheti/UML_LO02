package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JTextField;

import vue.ChoixJoueursVue;

public class Initialisation {

	Scanner sc = new Scanner(System.in);
	private int nbJoueurs;
	private Pioche pioche;
	private Talon talon;
	private ArrayList<Joueur> listeJoueurs;
	private int numStrategie;

	public Initialisation() {
		System.out.println("--Partie commencée--\n");
	}

	public void initialiser() {

		// this.nbJoueurs=nbJoueurs;
		this.pioche = new Pioche();
		// System.out.println("pioche créée");
		Variante variante = new Variante(); // demande variante voulue, et
											// afffectation des cartes
		this.pioche = variante.nouvelleVariante(this.pioche);
		this.talon = new Talon(this.pioche.tirerCarte());
		// System.out.println("talon créé \n première carte :
		// "+this.talon.getCarteDessus());
		this.listeJoueurs = this.ajouterJoueurs(); // ajoute les joueurs avec
													// leurs mains remplies
		// System.out.println("il y a "+listeJoueurs.size()+"joueur adverse,
		// avec"+listeJoueurs.get(0).getMain().size()+"cartes");
		//this.numStrategie = setNumStrategie();  // ne se fait plus car pris en charge par la GUI
		// System.out.println("Quelle mode voulez-vous jouer? Entrez 0 pour les
		// robots betes et 1 pour les robots intelligents");
	}

	// -------------------Ajout des joueurs--------------------

	public ArrayList<Joueur> ajouterJoueurs() {

		ArrayList<Joueur> listeTempJoueurs = new ArrayList<Joueur>();
		nbJoueurs = 0;

		Main.suivant = false;
		

		ChoixJoueursVue choixJ = new ChoixJoueursVue();
		choixJ.reset=false;
		
		

		while (!Main.suivant) {
			try {
				// System.out.println("attente joueurs");
				if (choixJ.reset){
					choixJ.reset = false;
					choixJ.initializeAgain();
				}
				
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Main.suivant = false;
		
		choixJ.setDifficulty();
		numStrategie=ChoixJoueursVue.niveau;
		
		while (!Main.suivant) {		//on attend que le joueur choisisse la difficulte
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Main.suivant=false;

		/*
		 * while(nbJoueurs<1 || nbJoueurs>4){
		 * System.out.println("nombre de joueurs adverses ? "); nbJoueurs =
		 * sc.nextInt(); if (nbJoueurs<1 || nbJoueurs>4)
		 * System.out.println("nombre doit etre entre 1 et 4 please"); }
		 */

		this.setNbJoueurs(ChoixJoueursVue.staticAdv);

		String nom1 = ChoixJoueursVue.nom1;
		String nom2 = ChoixJoueursVue.nom2;
		String nom3 = ChoixJoueursVue.nom3;

		for (int i = 0; i < nbJoueurs; i++) {

			Joueur joueur = new Joueur();
			System.out.println("Joueur " + i + " cree.");

			if (i == 0) {

				joueur.setNom(nom1);
			} else if (i == 1) {
				joueur.setNom(nom2);
			} else {
				joueur.setNom(nom3);
			}

			ArrayList<Carte> mainTemp = new ArrayList<Carte>();
			mainTemp = this.distribuerCartes(nbJoueurs);
			joueur.setMain(mainTemp);// on remplis la main du joueur
			// on récupère le nom du joueur et l'envoi à la création du joueur
			// virtuel
			listeTempJoueurs.add(joueur);
		}

		/*
		 * for (int i=0; i<nbJoueurs; i++){
		 * System.out.println("nom du joueur adverse "+(i+1)+" ? \n"); nom =
		 * sc.nextLine(); nom += sc.nextLine(); Joueur joueur = new Joueur(nom);
		 * ArrayList<Carte> mainTemp = new ArrayList<Carte>();
		 * mainTemp=this.distribuerCartes(nbJoueurs);
		 * joueur.setMain(mainTemp);//on remplis la main du joueur //on récupère
		 * le nom du joueur et l'envoi à la création du joueur virtuel
		 * listeTempJoueurs.add(joueur); }
		 */

		// on fini par se créer soit
		String nom = "moi";
		Joueur joueur = new Joueur(nom);
		ArrayList<Carte> mainTemp = new ArrayList<Carte>();
		mainTemp = this.distribuerCartes(nbJoueurs); // distribue X cartes selon
														// le nombre
														// d'adversaires
		joueur.setMain(mainTemp);
		listeTempJoueurs.add(joueur);
		nbJoueurs++; // on doit se rajouter dans le compte du nombre de joueurs
		return listeTempJoueurs; // retourne la liste des joueurs ajoutés dans
									// l'attribut listeJoueurs de l'objet
									// initialisation
		
		
		
		
		
		
	}

	// -------------------distribution des cartes--------------------

	public ArrayList<Carte> distribuerCartes(int nbJoueurs) { // on donne les
																// cartes à un
																// joueur lors
																// de son
																// instanciation
																// à faire
		ArrayList<Carte> deck = new ArrayList<Carte>();
		deck = this.pioche.getDeck();
		ArrayList<Carte> mainTemp = new ArrayList<Carte>();
		// on remplis cette mainTemp avec autant de cartes que nécessaire depuis
		// la pioche
		if (nbJoueurs == 0)
			System.out.println("erreur : aucun joueur adverse rentré");
		else if (nbJoueurs == 1) {
			for (int j = 0; j < 10; j++) {
				Carte carte = this.pioche.tirerCarte();
				// System.out.println(carte);
				mainTemp.add(carte);
			}
		} else if (nbJoueurs == 2) {
			for (int j = 0; j < 8; j++) {
				Carte carte = this.pioche.tirerCarte();
				// System.out.println(carte);
				mainTemp.add(carte);
			}
		} else
			for (int j = 0; j < 6; j++) {
				Carte carte = this.pioche.tirerCarte();
				mainTemp.add(carte);
			}
		// on a fini de remplir notre main temporaire, on la renvoie dans celle
		// du joueur en court d'ajout
		return mainTemp;
	}

	// -------------------Getters et Setters--------------------

	public int setNumStrategie() {

		System.out.println(
				"Quelle mode voulez-vous jouer? Entrez 0 pour les robots betes et 1 pour les robots intelligents");
		numStrategie = sc.nextInt();
		return numStrategie;
	}

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
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

	public ArrayList<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(ArrayList<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	public int getNumStrategie() {
		return numStrategie;
	}

}
