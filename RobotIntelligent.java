package crazyeightBis;
import java.util.ArrayList;
public class RobotIntelligent implements RobotStrategie{
	
	@Override
	public Carte jouer(Jeu jeu) {
		// TODO Auto-generated method stub
		ArrayList<Carte> cartesJouables;
		ArrayList<Carte> main;
		cartesJouables=jeu.getJoueurEnCours().cartesJouables(jeu.getTalon().getCarteDessus());
		main=jeu.getJoueurEnCours().getMain();
		Carte carteJouee = cartesJouables.get(0);
		//pour recuperer le nombre de cartes dans chaque couleur
		int nbCoeur=0;
		int nbPique=0;
		int nbTrefle=0;
		int nbCarreau=0;
		for(int i=0; i<main.size();i++) {
	
			if (main.get(i).getCouleur()=="Coeur") {
				nbCoeur++;
			}
			if (main.get(i).getCouleur()=="Pique") {
				nbPique++;
			}
			if (main.get(i).getCouleur()=="Trèfle") {
				nbTrefle++;
			}
			if (main.get(i).getCouleur()=="Carreau") {
				nbCarreau++;
			}
		}
		for(int i=0;i<cartesJouables.size();i++) {
			//la carte prioritaire est la carte effet sauf les cartes 8
			if (carteJouee.getEffet()==1||carteJouee.getNumero()==7) {
				carteJouee=cartesJouables.get(i);
			}
			//la carte prioritaire ensuite est le numero le plus grand
			else if(carteJouee.getNumero()!=7) {
				if(carteJouee.getNumero()>cartesJouables.get(i).getNumero()) {
					carteJouee=cartesJouables.get(i);
				}
			}
			//si les numeros sont identiques, on choisit la couleur qui a le plus grand nombre.
			else {
				int nbCarteJouee = 0;
				int nbCarteEnCours = 0;
				switch (cartesJouables.get(i).getCouleur()) {
				case "Coeur": nbCarteEnCours=nbCoeur;
				break;
				case "Pique":nbCarteEnCours=nbPique;
				break;
				case "Trèfle": nbCarteEnCours=nbTrefle;
				break;
				case "Carreau": nbCarteEnCours=nbCarreau;
				break;
				}
				switch (carteJouee.getCouleur()) {
				case "Coeur": nbCarteJouee=nbCoeur;
				break;
				case "Pique":nbCarteJouee=nbPique;
				break;
				case "Trèfle": nbCarteJouee=nbTrefle;
				break;
				case "Carreau": nbCarteJouee=nbCarreau;
				break;
				}
				if(nbCarteJouee<=nbCarteEnCours) {
					carteJouee=cartesJouables.get(i);
				}
				}
			}
		return carteJouee;
	}
}
