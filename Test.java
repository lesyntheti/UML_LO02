package crazyeightBis;
import java.util.*;


public class Test {

	
	public static void main(String[] args) {
		Initialisation initialisation = new Initialisation();
		initialisation.initialiser();
		
		//important de récupérer les éléments de initialisation pour la création de l'objet jeu
		Jeu jeu = new Jeu(initialisation.getPioche(), initialisation.getTalon(), initialisation.getNbJoueurs(), initialisation.getListeJoueurs());
		System.out.println("test 1e carte talon = " +jeu.getTalon().getCarteDessus());
		System.out.println("test nbJoueurs = " +jeu.getNbJoueurs());
		
		
		/*
		 * il faudra penser, une fois la partie commencée, à faire autant de tour de jeu que nécessaire jusqu'à ce qu'un gagnant ressorte
		 * , dans quel cas la partie se terminera.
		 * 
		 * while (!gagnant){  //tant qu'il n'y a pas de gagnant, on refais un tour de jeu
		 */
		
		
	}
	
}



