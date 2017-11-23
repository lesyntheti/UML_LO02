package crazyeightBis;
import java.util.*;


public class Test {

	
	public static void main(String[] args) {
		Initialisation initialisation = new Initialisation();
		initialisation.initialiser(1);
		Jeu jeu = new Jeu(initialisation.getPioche(), initialisation.getTalon(), initialisation.getNbJoueurs(), initialisation.getListeJoueurs());
		System.out.println(jeu.getTalon().getCarteDessus());
		//System.out.println(initialisation.nbJoueurs);
		
	}
	
}



