package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import modele.Carte;

public class Carte8Controleur {
	private Carte carte;
	private JPanel me;

	public Carte8Controleur(Carte carte, JPanel me) {
		
		this.carte=carte;
		this.me=me;
		me.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				//me.setBounds(me.getX(), me.getY() - 45, me.getWidth(), me.getHeight());
				System.out.println(carte.getCouleur());
				modele.Jeu.nouvelleCouleur=carte.getNumeroCouleur();
				modele.Jeu.attenteNouvelleCouleur=false;
				
				}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				me.setBounds(me.getX(), me.getY() - 10, me.getWidth(), me.getHeight());
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				me.setBounds(me.getX(), me.getY() + 10, me.getWidth(), me.getHeight());
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				me.setBounds(me.getX(), me.getY() - 15, me.getWidth(), me.getHeight());
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				me.setBounds(me.getX(), me.getY() + 15, me.getWidth(), me.getHeight());
			}

		});

	}

	
}
