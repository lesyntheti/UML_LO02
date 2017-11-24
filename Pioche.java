package crazyeightBis;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.*;


public class Pioche {

	private ArrayList<Carte> deck;
	
	public Pioche(){
		
		ArrayList<Carte> deck = new ArrayList<Carte>();
		deck=initialiserCarte(deck);
		melanger(deck);
		this.setDeck(deck);
		//afficherDeck(deck);
		//System.out.println("\n shuffle\n");
		
		//afficherDeck(deck);
	}
	
	
	public ArrayList<Carte> initialiserCarte(ArrayList<Carte> deck){
		
		
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
		
		
		Carte carteTiree =this.deck.get((int)Math.random()*this.deck.size());
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
