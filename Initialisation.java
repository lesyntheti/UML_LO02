package crazyeightBis;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class Initialisation {

	Scanner sc = new Scanner(System.in);
	
	private int nbJoueurs;
	private Pioche pioche;
	private Talon talon;
	private ArrayList<Joueur> listeJoueurs;
	
	
	public Initialisation(){
		System.out.println("objet initialisation créé");
	}
	
	public void initialiser(){
		//this.nbJoueurs=nbJoueurs;
		
		this.pioche = new Pioche();
		//System.out.println("pioche créée");
		
		this.talon = new Talon(this.pioche.tirerCarte());
		//System.out.println("talon créé \n première carte : "+this.talon.getCarteDessus());
		
		this.listeJoueurs= this.ajouterJoueurs(); //ajoute les joueurs avec leurs mains remplies
		//System.out.println("il y a "+listeJoueurs.size()+"joueur adverse, avec"+listeJoueurs.get(0).getMain().size()+"cartes");
	}
	
	
	public ArrayList<Joueur> ajouterJoueurs(){
		ArrayList<Joueur> listeTempJoueurs = new ArrayList<Joueur>();
		nbJoueurs=0;
		
		while(nbJoueurs<1 || nbJoueurs>4){
			System.out.println("nombre de joueurs adverses ? ");
			nbJoueurs = sc.nextInt();
			if (nbJoueurs<1 || nbJoueurs>4)
				System.out.println("nombre doit etre entre 1 et 4 please");
		
		}
		
		this.setNbJoueurs(nbJoueurs);
		
		String nom;
		
		
		for (int i=0; i<nbJoueurs; i++){
			System.out.println("nom du joueur ?\n");
			nom = sc.nextLine();
			nom = sc.nextLine();
			Joueur joueur = new Joueur(nom);
			ArrayList<Carte> mainTemp = new ArrayList<Carte>();
			mainTemp=this.distribuerCartes(nbJoueurs);
			joueur.setMain(mainTemp);//on remplis la main du joueur
			//on récupère le nom du joueur et l'envoi à la création du joueur virtuel
			listeTempJoueurs.add(joueur);
		}
		
		//on fini par se créer soit 
		nom ="moi";
		Joueur joueur = new Joueur(nom);
		ArrayList<Carte> mainTemp = new ArrayList<Carte>();
		mainTemp=this.distribuerCartes(nbJoueurs); //distribue X cartes selon le nombre d'adversaires
		joueur.setMain(mainTemp);
		listeTempJoueurs.add(joueur);
		nbJoueurs++;  //on doit se rajouter dans le compte du nombre de joueurs
		
		return listeTempJoueurs;		//retourne la liste des joueurs ajoutés dans l'attribut listeJoueurs de l'objet initialisation
	}
	
	
	
	public ArrayList<Carte> distribuerCartes(int nbJoueurs){		//on donne les cartes à un joueur lors de son instanciation
		//à faire
		ArrayList<Carte> deck = new ArrayList<Carte>();
		deck=this.pioche.getDeck();
		
		ArrayList<Carte> mainTemp = new ArrayList<Carte>();
		//on remplis cette mainTemp avec autant de cartes que nécessaire depuis la pioche
		if (nbJoueurs==0)
			System.out.println("erreur : aucun joueur adverse rentré");
		else if (nbJoueurs==1){
			for (int j=0; j<10; j++) 
			{
				Carte carte = this.pioche.tirerCarte();
				//System.out.println(carte);
				mainTemp.add(carte);
			}
		}
		else if (nbJoueurs==2){
			for (int j=0; j<8; j++) 
			{
				Carte carte = this.pioche.tirerCarte();
				//System.out.println(carte);
				mainTemp.add(carte);
			}
		}
		else
			for (int j=0; j<6; j++) 
			{
				Carte carte = this.pioche.tirerCarte();
				mainTemp.add(carte);
			}
		//on a fini de remplir notre main temporaire, on la renvoie dans celle du joueur en court d'ajout
		
		return mainTemp;
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
	
	
	
	
	
}
