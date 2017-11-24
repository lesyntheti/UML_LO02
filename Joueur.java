package crazyeightBis;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Joueur {

	private String nom;
	private ArrayList<Carte> main;
	
	private Carte carteJouee; 
	
	public Joueur(String nom){
		this.nom=nom;
		this.main = new ArrayList<Carte>();
		//on créé un joueur avec une main vide
	}
	public void jouerUneCarte(Carte dessusPile,ArrayList<Carte> main, Talon talon,Pioche pioche) {
		
		this.main=main;

		Iterator<Carte> i=main.iterator();

		Carte carteEnCours = (Carte) i;

		boolean peutJoue = false;

		if(carteEnCours.pouvoirJoue(dessusPile)==true) {

			peutJoue=true;

		} 

		while((peutJoue==false)&&(i.hasNext())){

			carteEnCours=i.next();

			if(carteEnCours.pouvoirJoue(dessusPile)==true) {

				peutJoue=true;

			}

		}

		//On utilise la cartes 8, si on ne peut rien jouer.
		
		if(peutJoue==false) {
			int j=0;
			while((j<=main.size())&&peutJoue==false) {
				Carte carteEnCours2 = main.get(j);
				if(carteEnCours2.getNumero()==8) {
					peutJoue=true;
				}
			}		
		}
		if (peutJoue==true) {

			main.remove(carteEnCours);	
			talon.setCarteDessus(carteEnCours);
			

		}
		//Si on ne peut rien jouer, ajouter une autre carte.
		if (peutJoue==false) {
			main.add(piocher(pioche));
		}

	}
	
  
  //piocher une carte
	public Carte piocher(Pioche pioche) {

		return 	pioche.tirerCarte();
	}

 
  //s'il reste qu'une seule carte
	public void annoncerCarte() {
		if (this.nbCarteMain==1) {
			System.out.println("");
		}
		
	}
	
	
	public ArrayList<Carte> cartesJouables(Carte carteTalon){
		//(rappel : this est un Joueur)
		ArrayList<Carte> mainJoueurJouableTemp= new ArrayList<Carte>();
		Carte carte;
		
		Iterator<Carte> carteIt = this.main.iterator();

		while (carteIt.hasNext()) {		//on teste les cartes 1 par 1 et compare avec la carte du dessus du talon
			carte=carteIt.next();
			if(carte!=null){
				if (carte.getNumero() == carteTalon.getNumero() || carte.getCouleur() == carteTalon.getCouleur() || carte.getNumero() == 8) {
					mainJoueurJouableTemp.add(carte); //si la carte est jouable, on la place dans la mainJouableTemporaire du joueur
				}
			}
		
			
		}	
		return mainJoueurJouableTemp;
	}
	
	
	
	public void piocherCarte(int nbCartes, Pioche pioche){
		for (int i=0; i<nbCartes; i++)
			this.main.add(pioche.tirerCarte());  //le joueur pioche autant de cartes que précisé dans l'appel
	}
	
	
	public Carte jouerCarte(ArrayList<Carte> cartesJouables, Carte carteDessus){
		
		carteJouee=choixCarte(cartesJouables, carteDessus);//on fait un choix parmis les cartes
	        //on appelle une méthode pour demander au joueur de choisir une de ses cartes jouables
		
		return carteJouee;
	}
	
	
	public Carte choixCarte(ArrayList<Carte> cartesJouables, Carte carteDessus){
		Carte carteChoisie;
		Carte carteTestee;
		
		
		Scanner sc= new Scanner(System.in);  
		
		System.out.println("\nVos cartes sont :\n");
		Iterator<Carte> i1=this.main.iterator(); // on crée un Iterator pour parcourir notre ArrayList
		while(i1.hasNext()) 
		{
			System.out.println(i1.next());	//on affiche toute la main du joueur
			
		}
		
		int index;
		System.out.println("\nVos cartes jouables sont :\n");
		Iterator<Carte> i2=this.main.iterator(); // on crée un Iterator pour parcourir notre ArrayList
		while(i2.hasNext()) 
		{
			carteTestee=(i2.next());
			if  (carteTestee.pouvoirJoue(carteDessus)){	//si la carte est compatible, on l'affiche
				index=  cartesJouables.indexOf(carteTestee);
				System.out.println(index +" : "+carteTestee);
			}
			
		}
		
		int numCarteChoisie;
		do {
            System.out.println("\nEntrer quelle carte vous voulez jouer (entier entre 0 et " + (cartesJouables.size()-1) + ")");
            numCarteChoisie = sc.nextInt();
        } while (numCarteChoisie < 0 || numCarteChoisie > (cartesJouables.size()-1));
		
		 carteChoisie=cartesJouables.get(numCarteChoisie);
		 System.out.println("vous avez choisi le/la "+carteChoisie);
		
		return carteChoisie;
	}
	
	

  	public void finirTour() {
		if (this.nbCarteMain==0) {
			System.out.println(this.nom + " gagnent!");
		}
		
	}
  
	public void changerNom() {
				System.out.println("Saisir un nom vous voulez donner.");
				Scanner sc = new Scanner(System.in);
				this.nom=sc.next();
			}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Carte> getMain() {
		return main;
	}

	public void setMain(ArrayList<Carte> main) {
		this.main = main;
	}
	
	
	
}
