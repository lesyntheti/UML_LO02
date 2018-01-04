package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;

import modele.Jeu;

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
	 */
	public VueGagnant(Jeu jeuTermine) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ajouter une jolie image
		//le nom du gagnant
		//le compte des points de chacun (seconde fenêtre ?)
		
		frame.setVisible(true);
	}

}
