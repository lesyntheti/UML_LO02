package crazyEight;
import java.util.*;
//import java.util.Collections;

public class CartesNonDistribuees {
	
	//private static final int TAILLE_MAX = 52;

	
	
	public static ArrayList<Carte> initialiserCarte(ArrayList<Carte> deck){
		
		//méthode pour retourner les 52 cartes dans une collection Array (besoin d'être ordonné pour le shuffle)
		for (int i=0; i<12; i++){
			for (int j=0; j<4; j++){
				//carte(i).numero=i, carte(i).couleur=j
				deck.add(new Carte (i,j));
			}
		}
		return deck;
		
		/*  //méthode pour afficher le deck
		Iterator<Carte> i=deck.iterator(); // on crée un Iterator pour parcourir notre HashSet
		while(i.hasNext()) 
		{
			System.out.println(i.next()); // on affiche le suivant
		}
		*/
	}
	
	public static void melanger(ArrayList<Carte> deck){
		Collections.shuffle(deck);
	}
	
	public static void afficherDeck(ArrayList<Carte> deck){
		Iterator<Carte> i=deck.iterator(); // on crée un Iterator pour parcourir notre ArrayList
		while(i.hasNext()) 
		{
			System.out.println(i.next()); // on affiche le suivant
		}
	}
	
	
	/*  tests de la classe
	
public static void main(String[] args) {
		
		ArrayList<Carte> deck = new ArrayList<Carte>();
		initialiserCarte(deck);
		afficherDeck(deck);
		System.out.println("\n suffle\n");
		melanger(deck);
		afficherDeck(deck);
		
	}
	*/
	
}
