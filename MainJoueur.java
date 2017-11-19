package crazyEight;
import java.util.ArrayList;
import java.util.Iterator;

public class MainJoueur {

	private ArrayList<Carte> main;
	
	public MainJoueur(){
	main = new ArrayList<Carte>();
	}
	
	public void afficherMain(){
		Iterator<Carte> i=main.iterator(); // on crée un Iterator pour parcourir notre ArrayList
		while(i.hasNext()) 
		{
			System.out.println(i.next()); // on affiche le suivant
		}
	}
	
	public void ajouter(Carte carte){
		if (carte == null)
			System.out.println("Erreur : pas de carte à ajouter");
		else
		main.add(carte);
	}
	
	//méthode à approfondir
	public Carte jouerCarte(Carte dessusPile){
		Carte carteJouee = new Carte(0,0);
		//comparer la carte à jouer avec celle sur la pile (if...)

		//si c'est autorisé, on stocke la carte de la main du joueur dans carteJouee
		main.remove(carteJouee);
		return carteJouee;
	}
	
}
