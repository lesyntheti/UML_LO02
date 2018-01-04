package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import modele.Carte;

public class CarteVue extends JPanel implements Observer {

	private Carte carte;
	private Image image;

	/**
	 * Create the panel.
	 */
	public CarteVue(Carte carte) {

		//on charge l'image de la carte dans la variable carte, pour ensuite la réutiliser dans la méthode paintComponent
		try{
            this.image = ImageIO.read(new File(("Cartes/"+carte+".png")));
        } catch (IOException ex) {
            Logger.getLogger(CarteVue.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
		JPanel me = this;
		
		this.addMouseListener(new MouseListener() {

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
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
