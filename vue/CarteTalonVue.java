package vue;

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

import modele.Carte;

public class CarteTalonVue extends JPanel {

	private Carte carte;
	private Image image;

	/**
	 * Create the panel.
	 */
	public CarteTalonVue(Carte carte) {

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
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				//me.setBounds(me.getX(), me.getY() - 10, me.getWidth(), me.getHeight());
				
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				//me.setBounds(me.getX(), me.getY() + 10, me.getWidth(), me.getHeight());
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				//me.setBounds(me.getX(), me.getY() - 15, me.getWidth(), me.getHeight());
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				//me.setBounds(me.getX(), me.getY() + 15, me.getWidth(), me.getHeight());
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
	

	public void waitShort(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


