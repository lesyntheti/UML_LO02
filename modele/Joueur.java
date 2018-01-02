package modele;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Joueur  {

	private String nom;
	private ArrayList<Carte> main;
	private int point;
	
	private Carte carteJouee; 
	
	public Joueur(String nom){
		this.nom=nom;
		this.main = new ArrayList<Carte>();
		//on créé un joueur avec une main vide
	}

	public Joueur(){
		this.main = new ArrayList<Carte>();
		//on créé un joueur avec une main vide
	}
	
 	
	public void jouerUneCarte(Carte dessusPile,ArrayList<Carte> main) {
		
		this.main=main;
		Iterator<Carte> i=main.iterator();
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
			main.remove(carteEnCours);
			
		}
	}
	
	
	//-------------------méthode cartes jouables--------------------
	
	
	public ArrayList<Carte> cartesJouables(Carte carteTalon){
		//(rappel : this est un Joueur)
		ArrayList<Carte> mainJoueurJouableTemp= new ArrayList<Carte>();
		Carte carte;
		
		
		

		if (carteTalon.getEffet()==43){ //si le joueur doit contrer une attaque
			Iterator<Carte> carteIt = this.main.iterator();
			while (carteIt.hasNext()) {		//on teste les cartes 1 par 1 et compare avec la carte du dessus du talon
				carte=carteIt.next();
				if(carte!=null){
					if (carte.getNumero() == 0) {
						mainJoueurJouableTemp.add(carte); //si la carte est jouable, on la place dans la mainJouableTemporaire du joueur
						
					}
					else if (carte.getNumero() == 7){
						mainJoueurJouableTemp.add(carte); //si la carte est jouable, on la place dans la mainJouableTemporaire du joueur
					}
				}	
			}
			
		}
			
		else{
			Iterator<Carte> carteIt = this.main.iterator();
			while (carteIt.hasNext()) {		//on teste les cartes 1 par 1 et compare avec la carte du dessus du talon
				carte=carteIt.next();
				if(carte!=null){
					if (carte.getNumero() == carteTalon.getNumero() || carte.getCouleur() == carteTalon.getCouleur() || carte.getEffet()==5) {
						mainJoueurJouableTemp.add(carte); //si la carte est jouable, on la place dans la mainJouableTemporaire du joueur
					}
				}	
			}
		}
			
		return mainJoueurJouableTemp;
	}
	
	
	//-------------------méthode piocher carte--------------------
	
	public void piocherCarte(int nbCartes, Pioche pioche){
		for (int i=0; i<nbCartes; i++)
			this.main.add(pioche.tirerCarte());  //le joueur pioche autant de cartes que précisé dans l'appel
	}
	
	
	//-------------------méthodes jouerCarte/choixCarte--------------------
	
	
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
		 System.out.println("vous avez choisi le "+carteChoisie);
		
		return carteChoisie;
	}
	
	
	//-------------------Getters et Setters--------------------
	
	
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


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
}
