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
