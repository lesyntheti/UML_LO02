package crazyeightBis;

public class Main {

	public static void main(String[] args) {
		
		Initialisation initialisation = new Initialisation();
		initialisation.initialiser();
		
		//important de récupérer les éléments de initialisation pour la création de l'objet jeu
		Jeu jeu = new Jeu(initialisation.getPioche(), initialisation.getTalon(), initialisation.getNbJoueurs(), initialisation.getListeJoueurs());
		
		
		
		while (!jeu.isGagnant()){
			jeu.tourDeJeu(jeu.getJoueurEnCours());
		}
		
		System.out.println("\n -Partie terminée-\n\nLe vainqueur est " + jeu.getJoueurEnCours().getNom());
		
		

	}

}
