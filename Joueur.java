package crazyeightBis;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Joueur {

	private String nom;
	private ArrayList<Carte> main;
	
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
