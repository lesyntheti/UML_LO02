
package vue;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class VarianteVue {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public VarianteVue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 153, 0));
		frame.getContentPane().setLayout(null);

		
		JButton btnMinimaliste = new JButton("Minimaliste");
		btnMinimaliste.setToolTipText("<html>"+"10=rejouer<br>"+"8=change-couleur"+"</html>");
		btnMinimaliste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1 entered");
				modele.Variante.numeroVarianteG = 1;
				frame.setVisible(false);
			}
		});
		btnMinimaliste.setBounds(178, 66, 117, 29);
		frame.getContentPane().add(btnMinimaliste);

		JButton btnCarteEtMaou = new JButton("Carte et Maou");
		btnCarteEtMaou.setToolTipText("<html>"+"10 rejoue"+"<br>8 passe le suivant"+"<br>7 fait piocher deux cartes"+"<br>valet changer la couleur"+"</html>");
		btnCarteEtMaou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modele.Variante.numeroVarianteG = 2;
				frame.setVisible(false);
			}
		});
		btnCarteEtMaou.setBounds(178, 118, 117, 29);
		frame.getContentPane().add(btnCarteEtMaou);

		JButton btnMonclar = new JButton("Monclar");
		btnMonclar.setToolTipText("<html>"+"7 : le joueur suivant passe son tour" + 
				"<br>Valet : change le sens du jeu" + 
				"<br>9 : fait piocher une carte au joueur suivant sans recours" + 
				"<br>As : fait piocher<br>"+"8 : permet de changer de couleur et arrête les attaques"+"</html>");
		btnMonclar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modele.Variante.numeroVarianteG = 3;
				frame.setVisible(false);
			}
		});
		btnMonclar.setBounds(178, 170, 116, 29);
		frame.getContentPane().add(btnMonclar);
		
		BackgroundPanel background = new BackgroundPanel();
		background.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(background);
		background.setLayout(null);
		
		JLabel lblChoixDeLa = new JLabel("Choix de la variante");
		lblChoixDeLa.setForeground(new Color(255, 255, 204));
		lblChoixDeLa.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblChoixDeLa.setBounds(162, 25, 162, 16);
		background.add(lblChoixDeLa);
		

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
