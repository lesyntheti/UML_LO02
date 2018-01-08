
package controleur;

import javax.swing.JPanel;
import modele.Carte;
import vue.CarteVue;
import vue.TableJeuVue;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CarteControleur {
	
	private Carte carte;
	private JPanel me;
	
	public CarteControleur(Carte carte,JPanel me) {
		this.carte=carte;
		this.me=me;
		
		me.addMouseListener(new MouseListener() {

		@Override
			public void mouseClicked(MouseEvent arg0) {
				//me.setBounds(me.getX(), me.getY() - 45, me.getWidth(), me.getHeight());
				System.out.println(carte);
				TableJeuVue.carteSelectionnee=carte;
				modele.Jeu.attenteChoixCarte=false;
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
