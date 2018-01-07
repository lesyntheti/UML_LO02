package vue;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import modele.Jeu;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Font;

public class VueGagnant {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//VueGagnant window = new VueGagnant();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public VueGagnant(Jeu jeuTermine) {
		initialize(jeuTermine);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Jeu jeu) {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//afficher la fenêtre au milieu de l ecran (tout ecran confondu)
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		
		// le nom du gagnant
		
		JLabel lblWinner = new JLabel(jeu.getJoueurEnCours().getNom()+" remporte la partie !");
		lblWinner.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblWinner.setBounds(440, 150, 312, 33);
		frame.add(lblWinner);
		
		// le compte des points de chacun (seconde fenêtre ?)
		
		
		
		for (int i = 0; i < jeu.listeJoueurs.size(); i++) {
			
			if (jeu.listeJoueurs.get(i).getPoint() != 0) {
				System.out.println(jeu.listeJoueurs.get(i).getNom() + " a obtenu " + jeu.listeJoueurs.get(i).getPoint()
						+ " point!");
				JLabel lblPoints = new JLabel(jeu.listeJoueurs.get(i).getNom() + " a obtenu " + jeu.listeJoueurs.get(i).getPoint()
						+ " point");
				lblPoints.setBounds(486, 210+(i*50), 300, 25);
				lblPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				frame.add(lblPoints);
				
			}
		}
		
		
		/*
		JLabel lblPoints = new JLabel("Points1");
		lblPoints.setBounds(436, 150, 61, 16);
		frame.add(lblPoints);
		
		JLabel lblPoints_1 = new JLabel("Points2");
		lblPoints_1.setBounds(436, 200, 61, 16);
		frame.add(lblPoints_1);
		
		JLabel lblPoints_2 = new JLabel("Points3");
		lblPoints_2.setBounds(436, 250, 61, 16);
		frame.add(lblPoints_2);
		*/
		
		
		// ajouter une jolie image
		
		VictoryPic victoryPic = new VictoryPic();
		frame.getContentPane().add(victoryPic);
		victoryPic.setLayout(null);
		
		
		
		

		frame.setVisible(true);
	}
}
