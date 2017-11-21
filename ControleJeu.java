package crazyEight;

import java.util.Date;

public class ControleJeu {
	
	private static Date tempsDeJeu;
	//le sens du jeu est le sens horaire par defaut(sensPartie=false)
	private boolean sensPartie=false;
	private JoueurVirtuel joueurEnCours;
	
	
	
	public boolean isSensPartie() {
		return sensPartie;
	}

	public void setSensPartie(boolean sensPartie) {
		this.sensPartie = sensPartie;
	}

	public JoueurVirtuel getJoueurEnCours() {
		return joueurEnCours;
	}

	public void setJoueurEnCours(JoueurVirtuel joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	/*public static void main(String[] args) {
		Date date = new Date();
		tempsDeJeu=date;
		System.out.print(tempsDeJeu);
	}*/
	
	
}