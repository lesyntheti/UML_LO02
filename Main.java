package crazyeightBis;

public class Main {

	public static void main(String[] args) {
		
		Initialisation initialisation = new Initialisation();
		initialisation.initialiser();
		//important de récupérer les éléments de initialisation pour la création de l'objet jeu
		Jeu jeu = new Jeu(initialisation.getPioche(), initialisation.getTalon(), initialisation.getNbJoueurs(), initialisation.getListeJoueurs(),initialisation.getNumStrategie());
		
		
		
		while (!jeu.isGagnant()){
			jeu.tourDeJeu(jeu.getJoueurEnCours());
		}
		
		System.out.println("\n -Partie terminée-\n\nLe vainqueur est " + jeu.getJoueurEnCours().getNom());
		
		
		//comptage des points
		jeu.comptePoints();
		for(int i=0;i<jeu.listeJoueurs.size();i++){
			if(jeu.listeJoueurs.get(i).getPoint()!=0) {
				System.out.println(jeu.listeJoueurs.get(i).getNom()+" a obtenu "+jeu.listeJoueurs.get(i).getPoint()+" point!");
			}
		}
	}

}
