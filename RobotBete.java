package crazyeightBis;

import java.util.ArrayList;

public class RobotBete implements RobotStrategie{
	
	@Override
	public Carte jouer(Jeu jeu) {
		// TODO Auto-generated method stub
		ArrayList<Carte> cartesJouables;
		cartesJouables=jeu.getJoueurEnCours().cartesJouables(jeu.getTalon().getCarteDessus());
		Carte carteJouee = cartesJouables.get(0);
		return carteJouee;
	}
}
