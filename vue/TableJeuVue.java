package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import modele.Carte;
import modele.Jeu;
<<<<<<< HEAD
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPanel;
=======
import javax.swing.JTextField;
import javax.swing.JTextArea;
>>>>>>> 0e1422a437173eb5794c4f1dd8e0193eeb97c740

public class TableJeuVue implements Observer {

	private JFrame frame;
	private ArrayList<Carte> cartesMoi;
	private Jeu jeuEnCours;
	private Carte carteTalon;
	private int nbJoueursAdv;
	private int joueurActuel = 0;
	private JTextArea textArea;

	public static Carte carteSelectionnee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// a mettre en vert à l'execution
					// TableJeuVue window = new TableJeuVue();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public TableJeuVue(Jeu jeuEnCours, ArrayList<Carte> cartesMoi, Carte carteTalon) {
		// a enlever a l execution
		// createCards();

		initialize(cartesMoi, carteTalon);
		this.jeuEnCours = jeuEnCours;
		System.out.println("on ajoute un observer");
		this.jeuEnCours.addObserver(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Carte> cartesMoi, Carte carteTalon) {
		// System.out.println("initialise s execute");
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(4, 68, 15));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// afficher la fenêtre au milieu de l ecran (tout ecran confondu)
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		// ajout image et label pioche
		CarteCachee blank = new CarteCachee();
		blank.setBounds(52, 418, 82, 116);
		frame.getContentPane().add(blank);
		blank.setLayout(null);

		JLabel lblPioche = new JLabel("Pioche");
		lblPioche.setBounds(72, 536, 100, 16);
		frame.getContentPane().add(lblPioche);
		lblPioche.setForeground(Color.WHITE);

		// test

		// ajout jeux et labels adversaires selon le nombre d'adversaires
		this.nbJoueursAdv = ChoixJoueursVue.staticAdv;

		switch (nbJoueursAdv) {
		case 1:
			CarteCachee adv1cas1 = new CarteCachee();
			adv1cas1.setBounds((frame.getWidth() / 2) - 41, 52, 82, 116);
			frame.getContentPane().add(adv1cas1);

			JLabel lblj1c1 = new JLabel(ChoixJoueursVue.nom1 + " : 10");
			lblj1c1.setBounds((frame.getWidth() / 2) - 41, 170, 100, 16);
			frame.getContentPane().add(lblj1c1);
			lblj1c1.setForeground(Color.WHITE);
			break;

		case 2:
			CarteCachee adv1cas2 = new CarteCachee();
			adv1cas2.setBounds(52, (frame.getHeight() / 2) - 138, 82, 116);
			frame.getContentPane().add(adv1cas2);

			JLabel lblj1c2 = new JLabel(ChoixJoueursVue.nom1 + " : 8");
			lblj1c2.setBounds(52, (frame.getHeight() / 2) - 20, 100, 16);
			frame.getContentPane().add(lblj1c2);
			lblj1c2.setForeground(Color.WHITE);

			CarteCachee adv2cas2 = new CarteCachee();
			adv2cas2.setBounds(766, (frame.getHeight() / 2) - 138, 82, 116);
			frame.getContentPane().add(adv2cas2);

			JLabel lblj2c2 = new JLabel(ChoixJoueursVue.nom2 + " : 8");
			lblj2c2.setBounds(766, (frame.getHeight() / 2) - 20, 100, 16);
			frame.getContentPane().add(lblj2c2);
			lblj2c2.setForeground(Color.WHITE);
			break;

		case 3:
			CarteCachee adv1cas3 = new CarteCachee();
			adv1cas3.setBounds((frame.getWidth() / 2) - 41, 52, 82, 116);
			frame.getContentPane().add(adv1cas3);

			JLabel lblj1c3 = new JLabel(ChoixJoueursVue.nom2 + " : 6");
			lblj1c3.setBounds((frame.getWidth() / 2) - 41, 170, 100, 16);
			frame.getContentPane().add(lblj1c3);
			lblj1c3.setForeground(Color.WHITE);

			CarteCachee adv2cas3 = new CarteCachee();
			adv2cas3.setBounds(52, (frame.getHeight() / 2) - 138, 82, 116);
			frame.getContentPane().add(adv2cas3);

			JLabel lblj2c3 = new JLabel(ChoixJoueursVue.nom1 + " : 6");
			lblj2c3.setBounds(52, (frame.getHeight() / 2) - 20, 100, 16);
			frame.getContentPane().add(lblj2c3);
			lblj2c3.setForeground(Color.WHITE);

			CarteCachee adv3cas3 = new CarteCachee();
			adv3cas3.setBounds(766, (frame.getHeight() / 2) - 138, 82, 116);
			frame.getContentPane().add(adv3cas3);

			JLabel lblj3c3 = new JLabel(ChoixJoueursVue.nom3 + " : 6");
			lblj3c3.setBounds(766, (frame.getHeight() / 2) - 20, 100, 16);
			frame.getContentPane().add(lblj3c3);
			lblj3c3.setForeground(Color.WHITE);
			break;
		}

		// comme le joueur reel commence toujours a jouer, on lui dit que c est
		// a lui
		JLabel lblAVous = new JLabel("À vous de jouer");
		lblAVous.setBounds((frame.getWidth() / 2) - 50, 536, 100, 16);
		frame.getContentPane().add(lblAVous);
		lblAVous.setForeground(Color.RED);

		// on lie le jeu de carte modele à celui vue
		this.cartesMoi = cartesMoi;
		int j = 1;
		Iterator<Carte> i1 = cartesMoi.iterator(); // on crée un Iterator pour
													// parcourir notre ArrayList
		while (i1.hasNext()) {
			// System.out.println(i1.next()); //on affiche toute la main du
			// joueur
			CarteVue carteVue = new CarteVue(i1.next());
			int start = (frame.getWidth() / 2) - (cartesMoi.size() * 25);
			carteVue.setBounds(start + (j * 50), 418, 82, 116);
			frame.getContentPane().add(carteVue);
			j++;
			// System.out.println(i1.toString()); //affiche les cartes du
			// joueur, marche pas bien...
		}

		// on lie le talon du jeu à celui de la vue
		this.carteTalon = carteTalon;
		// Carte carteTalon = new Carte(0,0);
		CarteTalonVue carteTalonVue = new CarteTalonVue(carteTalon);
		carteTalonVue.setBounds((frame.getWidth() / 2) - 41, (frame.getHeight() / 2) - 58, 82, 116);
		frame.getContentPane().add(carteTalonVue);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(52, 52, 200, 16*3);
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 102, 0));
		panel.setBounds(47, 47, 210, (16*3)+10);
		frame.getContentPane().add(panel);

		// en dernier (background)
		BackgroundPanel background = new BackgroundPanel();
		background.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(background);
		background.setLayout(null);
		
<<<<<<< HEAD
		
		
		
=======
		JTextArea textArea = new JTextArea();
		textArea.setBounds(342, 215, 232, 24);
		background.add(textArea);
>>>>>>> 0e1422a437173eb5794c4f1dd8e0193eeb97c740

		frame.repaint();
		frame.setVisible(true);
	}

	// ________________________________________________________________________________________________________________

	public void actualiser(ArrayList<Carte> cartesMoi, Carte carteTalon, Jeu jeuEnCours) {

		// System.out.println("methode actualiser s execute");
		frame.getContentPane().removeAll();

		// ajout image et label pioche
		CarteCachee blank = new CarteCachee();
		blank.setBounds(52, 418, 82, 116);
		frame.getContentPane().add(blank);
		blank.setLayout(null);

		JLabel lblPioche = new JLabel("Pioche");
		lblPioche.setBounds(72, 536, 100, 16);
		frame.getContentPane().add(lblPioche);
		lblPioche.setForeground(Color.WHITE);

		// ajout jeux et labels adversaires selon le nombre d'adversaires
		this.nbJoueursAdv = ChoixJoueursVue.staticAdv;

		switch (nbJoueursAdv) {
		case 1:
			CarteCachee adv1cas1 = new CarteCachee();
			adv1cas1.setBounds((frame.getWidth() / 2) - 41, 52, 82, 116);
			frame.getContentPane().add(adv1cas1);

			// joueur 1 = pos0, joueur2 = pos1 (dans liste joueurs)
			JLabel lblj1c1 = new JLabel(ChoixJoueursVue.nom1 + " : " + jeuEnCours.listeJoueurs.get(0).getMain().size());
			lblj1c1.setBounds((frame.getWidth() / 2) - 41, 170, 100, 16);
			frame.getContentPane().add(lblj1c1);
			lblj1c1.setForeground(Color.WHITE);
			if ((joueurActuel) == 1) {
				lblj1c1.setForeground(Color.RED);
			}

			if ((joueurActuel) == 0) {
				JLabel lblAVous = new JLabel("À vous de jouer");
				lblAVous.setBounds((frame.getWidth() / 2) - 50, 536, 100, 16);
				frame.getContentPane().add(lblAVous);
				lblAVous.setForeground(Color.RED);
			}

			break;

		case 2:
			CarteCachee adv1cas2 = new CarteCachee();
			adv1cas2.setBounds(52, (frame.getHeight() / 2) - 138, 82, 116);
			frame.getContentPane().add(adv1cas2);

			JLabel lblj1c2 = new JLabel(ChoixJoueursVue.nom1 + " : " + jeuEnCours.listeJoueurs.get(0).getMain().size());
			lblj1c2.setBounds(52, (frame.getHeight() / 2) - 20, 100, 16);
			frame.getContentPane().add(lblj1c2);
			lblj1c2.setForeground(Color.WHITE);

			CarteCachee adv2cas2 = new CarteCachee();
			adv2cas2.setBounds(766, (frame.getHeight() / 2) - 138, 82, 116);
			frame.getContentPane().add(adv2cas2);

			JLabel lblj2c2 = new JLabel(ChoixJoueursVue.nom2 + " : " + jeuEnCours.listeJoueurs.get(1).getMain().size());
			lblj2c2.setBounds(766, (frame.getHeight() / 2) - 20, 100, 16);
			frame.getContentPane().add(lblj2c2);
			lblj2c2.setForeground(Color.WHITE);

			if (joueurActuel == 2) {
				lblj1c2.setForeground(Color.RED);
			}
			if (joueurActuel == 0) {
				lblj2c2.setForeground(Color.RED);
			}
			if ((joueurActuel) == 1) {
				JLabel lblAVous = new JLabel("À vous de jouer");
				lblAVous.setBounds((frame.getWidth() / 2) - 50, 536, 100, 16);
				frame.getContentPane().add(lblAVous);
				lblAVous.setForeground(Color.RED);
			}

			break;

		case 3:
			CarteCachee adv1cas3 = new CarteCachee();
			adv1cas3.setBounds((frame.getWidth() / 2) - 41, 52, 82, 116);
			frame.getContentPane().add(adv1cas3);

			JLabel lblj1c3 = new JLabel(ChoixJoueursVue.nom2 + " : " + jeuEnCours.listeJoueurs.get(1).getMain().size());
			lblj1c3.setBounds((frame.getWidth() / 2) - 41, 170, 100, 16);
			frame.getContentPane().add(lblj1c3);
			lblj1c3.setForeground(Color.WHITE);

			CarteCachee adv2cas3 = new CarteCachee();
			adv2cas3.setBounds(52, (frame.getHeight() / 2) - 138, 82, 116);
			frame.getContentPane().add(adv2cas3);

			JLabel lblj2c3 = new JLabel(ChoixJoueursVue.nom1 + " : " + jeuEnCours.listeJoueurs.get(0).getMain().size());
			lblj2c3.setBounds(52, (frame.getHeight() / 2) - 20, 100, 16);
			frame.getContentPane().add(lblj2c3);
			lblj2c3.setForeground(Color.WHITE);

			CarteCachee adv3cas3 = new CarteCachee();
			adv3cas3.setBounds(766, (frame.getHeight() / 2) - 138, 82, 116);
			frame.getContentPane().add(adv3cas3);

			JLabel lblj3c3 = new JLabel(ChoixJoueursVue.nom3 + " : " + jeuEnCours.listeJoueurs.get(2).getMain().size());
			lblj3c3.setBounds(766, (frame.getHeight() / 2) - 20, 100, 16);
			frame.getContentPane().add(lblj3c3);
			lblj3c3.setForeground(Color.WHITE);

			if (joueurActuel == 0) {
				lblj1c3.setForeground(Color.RED);
			}
			if (joueurActuel == 3) {
				lblj2c3.setForeground(Color.RED);
			}
			if (joueurActuel == 1) {
				lblj3c3.setForeground(Color.RED);
			}
			if ((joueurActuel) == 2) {
				JLabel lblAVous = new JLabel("À vous de jouer");
				lblAVous.setBounds((frame.getWidth() / 2) - 50, 536, 100, 16);
				frame.getContentPane().add(lblAVous);
				lblAVous.setForeground(Color.RED);
			}

			break;

		}

		this.cartesMoi = cartesMoi;
		int j = 1;
		Iterator<Carte> i1 = cartesMoi.iterator(); // on crée un Iterator pour
													// parcourir notre ArrayList
		while (i1.hasNext()) {
			// System.out.println(i1.next()); //on affiche toute la main du
			// joueur
			CarteVue carteVue = new CarteVue(i1.next());
			int start = (frame.getWidth() / 2) - (cartesMoi.size() * 25);
			carteVue.setBounds(start + (j * 50), 418, 82, 116);
			frame.getContentPane().add(carteVue);
			j++;
			// System.out.println(i1.toString());
		}

		this.carteTalon = carteTalon;
		// Carte carteTalon = new Carte(0,0);
		CarteTalonVue carteTalonVue = new CarteTalonVue(carteTalon);
		carteTalonVue.setBounds((frame.getWidth() / 2) - 41, (frame.getHeight() / 2) - 58, 82, 116);
		frame.getContentPane().add(carteTalonVue);
		
		
		
		JTextArea textArea = new JTextArea(jeuEnCours.getText());
		textArea.setBounds(52, 52, 200, 16*3);
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0,102,0));
		panel.setBounds(47, 47, 210, (16*3)+10);
		frame.getContentPane().add(panel);
		
		

		// en dernier (background)
		BackgroundPanel background = new BackgroundPanel();
		background.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(background);
		
		

		frame.repaint();
		frame.setVisible(true);

	}

	@Override
	public void update(Observable instanceObservable, Object arg) {
		// System.out.println("update s execute");
		if (instanceObservable instanceof modele.Jeu) {
			Jeu jeuEnCours = (Jeu) instanceObservable;
			// si il y a eu un changement dans notre main (et sur le talon donc)
			if (jeuEnCours.getJoueurEnCours().getNom() == "moi") {
				// System.out.println("actualisation moi");
				cartesMoi = jeuEnCours.getJoueurEnCours().getMain();
				carteTalon = jeuEnCours.getTalon().getCarteDessus();
				joueurActuel = jeuEnCours.getPosJoueurEnCours();
				actualiser(cartesMoi, carteTalon, jeuEnCours); // on refait le
																// plateau de
																// jeu avec le
																// nouvel
																// affichage de
																// sa main
			} else { // si un bot a joué une carte et que le talon a change donc
				// System.out.println("actualisation bot");
				carteTalon = jeuEnCours.getTalon().getCarteDessus();
				joueurActuel = jeuEnCours.getPosJoueurEnCours();
				actualiser(cartesMoi, carteTalon, jeuEnCours);
			}
			if(jeuEnCours.getChangeText()==true) {
				textArea.setText(jeuEnCours.getText());
			}
			if (jeuEnCours.isGagnant()) {
				frame.setVisible(false);
			}
			//if (jeuEnCours)
		}

	}

	public void createCards() {
		Carte carteAjoutee;
		cartesMoi = new ArrayList<Carte>();

		carteTalon = new Carte(0, 0);

		for (int i = 0; i < 4; i++) {
			carteAjoutee = new Carte(i, 0);
			cartesMoi.add(carteAjoutee);
		}
		for (int i = 0; i < 3; i++) {
			carteAjoutee = new Carte(i, 1);
			cartesMoi.add(carteAjoutee);
		}
		for (int i = 0; i < 2; i++) {
			carteAjoutee = new Carte(i, 2);
			cartesMoi.add(carteAjoutee);
		}
	}
}
