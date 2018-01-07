package modele;

import vue.MenuDemarrerVue;
import vue.VueGagnant;

public class Main {

	public static boolean suivant = false;

	public static void main(String[] args) {

		

		MenuDemarrerVue menuVue = new MenuDemarrerVue();

		while (!suivant) {
			//System.out.println("patiente");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Initialisation initialisation = new Initialisation();
		initialisation.initialiser();
		// important de récupérer les éléments de initialisation pour la
		// création de l'objet jeu
		Jeu jeu = new Jeu(initialisation.getPioche(), initialisation.getTalon(), initialisation.getNbJoueurs(),
				initialisation.getListeJoueurs(), initialisation.getNumStrategie());

		while (!jeu.isGagnant()) {
			jeu.tourDeJeu(jeu.getJoueurEnCours());
		}

		
		System.out.println("\n -Partie terminée-\n\nLe vainqueur est " + jeu.getJoueurEnCours().getNom());


		// comptage des points
		jeu.comptePoints();
		
		//affichage scores et gagnant
		VueGagnant finalwindow = new VueGagnant(jeu);
		
		for (int i = 0; i < jeu.listeJoueurs.size(); i++) {
			//System.out.println("en pause");
			if (jeu.listeJoueurs.get(i).getPoint() != 0) {
				System.out.println(jeu.listeJoueurs.get(i).getNom() + " a obtenu " + jeu.listeJoueurs.get(i).getPoint()
						+ " point!");
			}
		}
	}

	public boolean isSuivant() {
		return suivant;
	}

	public void setSuivant(boolean suivant) {
		this.suivant = suivant;
	}

	

}
