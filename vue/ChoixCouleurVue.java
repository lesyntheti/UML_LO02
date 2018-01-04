package vue;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import modele.Carte;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ChoixCouleurVue {

	private JFrame frame, frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoixCouleurVue window = new ChoixCouleurVue();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChoixCouleurVue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(325, 225, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Carte carte0= new Carte(0,0);
		Carte carte1= new Carte(0,1);
		Carte carte2= new Carte(0,2);
		Carte carte3= new Carte(0,3);
		
		Carte8Vue carteVue0 = new Carte8Vue(carte0);
		frame.getContentPane().add(carteVue0);
		carteVue0.setBounds(123, 19, 82, 116);
		Carte8Vue carteVue1 = new Carte8Vue(carte1);
		frame.getContentPane().add(carteVue1);
		carteVue1.setBounds(245, 19, 82, 116);
		Carte8Vue carteVue2 = new Carte8Vue(carte2);
		frame.getContentPane().add(carteVue2);
		carteVue2.setBounds(123, 147, 82, 116);
		Carte8Vue carteVue3 = new Carte8Vue(carte3);
		frame.getContentPane().add(carteVue3);
		carteVue3.setBounds(245, 147, 82, 116);
		
		JLabel lblChangementCouleurQuelle = new JLabel("Changement couleur, quelle couleur choisissez-vous ?");
		lblChangementCouleurQuelle.setForeground(new Color(255, 255, 204));
		lblChangementCouleurQuelle.setBounds(53, 285, 349, 16);
		frame.getContentPane().add(lblChangementCouleurQuelle);
		
		
		BackgroundPanel background = new BackgroundPanel();
		background.setForeground(new Color(255, 255, 204));
		background.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(background);
		background.setLayout(null);
		
		
		frame.setVisible(true);
	
		
	}
}
