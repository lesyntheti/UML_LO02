package crazyEight;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class CartesNonDistribuees {

	protected ArrayList<Carte> deck;
	
	public CartesNonDistribuees(){
		
		this.deck=initialiserCarte(deck);
		//afficherDeck(deck);
		//System.out.println("\n shuffle\n");
		melanger(deck);
		//afficherDeck(deck);
	}
	
	
	public  ArrayList<Carte> initialiserCarte(ArrayList<Carte> deck){
		
		//méthode pour retourner les 52 cartes dans une collection Array (besoin d'être ordonné pour le shuffle)
		for (int i=0; i<12; i++){
			for (int j=0; j<4; j++){
				//carte(i).numero=i, carte(i).couleur=j
				deck.add(new Carte (i,j));
			}
		}
		return deck;
	}
	
	
	public void melanger(ArrayList<Carte> deck){
		Collections.shuffle(deck);
	}
	
	public void afficherDeck(ArrayList<Carte> deck){
		Iterator<Carte> i=deck.iterator(); // on crée un Iterator pour parcourir notre ArrayList
		while(i.hasNext()) 
		{
			System.out.println(i.next()); // on affiche le suivant
		}
	}
	

	

	
	public Carte tirerCarte(){
		
		Carte carteTiree =deck.get((int)Math.random()*51);
		deck.remove(carteTiree);
		return carteTiree;
	}


	
	
	public ArrayList<Carte> getDeck() {
		return deck;
	}


	public void setDeck(ArrayList<Carte> deck) {
		this.deck = deck;
	}

	
	
	
}
