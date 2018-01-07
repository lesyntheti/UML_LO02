package vue;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Carte;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class FenetreTest extends JPanel {

	private JFrame frame;
	ArrayList<Carte> carteJouable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreTest window = new FenetreTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FenetreTest() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// afficher la fenêtre au milieu de l ecran (tout ecran confondu)
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		// le nom du gagnant

		JLabel lblWinner = new JLabel("\"Joueur\" remporte la partie !");
		lblWinner.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblWinner.setBounds(440, 150, 312, 33);
		frame.add(lblWinner);

		// le compte des points de chacun (seconde fenêtre ?)

		for (int i = 0; i < 3; i++) {

			JLabel lblPoints = new JLabel(i + " a obtenu " + i * 2 + " point!");
			lblPoints.setBounds(486, 210 + (i * 50), 300, 25);

			lblPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			frame.add(lblPoints);

		}

		/*
		 * JLabel lblPoints = new JLabel("Points1"); lblPoints.setBounds(436,
		 * 154, 61, 16); frame.add(lblPoints);
		 * 
		 * JLabel lblPoints_1 = new JLabel("Points2");
		 * lblPoints_1.setBounds(436, 199, 61, 16); frame.add(lblPoints_1);
		 * 
		 * JLabel lblPoints_2 = new JLabel("Points3");
		 * lblPoints_2.setBounds(436, 249, 61, 16); frame.add(lblPoints_2);
		 * 
		 */

		// ajouter une jolie image

		JLabel lblAVous = new JLabel("À vous de jouer");
		lblAVous.setBounds((frame.getWidth() / 2) - 50, 536, 100, 16);
		frame.getContentPane().add(lblAVous);
		lblAVous.setForeground(Color.RED);

		VictoryPic victoryPic = new VictoryPic();
		frame.getContentPane().add(victoryPic);
		victoryPic.setLayout(null);

		frame.setVisible(true);

	}
}
