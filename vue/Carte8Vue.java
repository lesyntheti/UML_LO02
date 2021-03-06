import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controleur.Carte8Controleur;
import controleur.CarteControleur;
import modele.Carte;

public class Carte8Vue extends JPanel {

	private Carte carte;
	private Image image;
	private JPanel carteMe;

	/**
	 * Create the panel.
	 */
	public Carte8Vue(Carte carte) {

		//on charge l'image de la carte dans la variable carte, pour ensuite la r茅utiliser dans la m茅thode paintComponent
		try{
            this.image = ImageIO.read(new File(("src/Cartes/"+carte+".png")));
        } catch (IOException ex) {
            Logger.getLogger(CarteVue.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
		carteMe = this;
		new Carte8Controleur (carte,carteMe);
		
		/*this.addMouseListener(new MouseListener() {

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

		});*/

	}

	/*
	public void paintComponent(Graphics g){
	    try {
	      Image img = ImageIO.read(new File("Cartes/1 de Pique.png"));
	      //g.drawImage(img, 0, 0, this);
	      //Pour une image de fond
	      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }                
	  }
	*/
	
	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
	
	

}
