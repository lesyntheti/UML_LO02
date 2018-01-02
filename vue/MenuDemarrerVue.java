package vue;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modele.Main;
import javax.swing.JLabel;
import java.awt.Font;

public class MenuDemarrerVue implements Observer {

	private JFrame frame;
	private JButton btnDebuterPartie, btnQuitter;
	private Main main;

	

	/**
	 * Create the application.
	 */
	public MenuDemarrerVue() {
		Main main = new Main();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.BOLD, 12));
		frame.getContentPane().setBackground(new Color(0, 153, 0));
		frame.getContentPane().setLayout(null);
		
		btnDebuterPartie = new JButton("Debuter partie");
		btnDebuterPartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("fonctionne");
				
				frame.setVisible(false); //on "quitte" le menu démarrer pour passer au jeu
				modele.Main.suivant=true;
				
			}
		});
		btnDebuterPartie.setBounds(95, 117, 117, 29);
		frame.getContentPane().add(btnDebuterPartie);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setBounds(248, 117, 117, 29);
		frame.getContentPane().add(btnQuitter);
		
		JLabel lblBienvenueDansNotre = new JLabel("Bienvenue dans notre grand jeu de Crazy Eight !");
		lblBienvenueDansNotre.setForeground(new Color(255, 255, 204));
		lblBienvenueDansNotre.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		lblBienvenueDansNotre.setBackground(new Color(255, 255, 255));
		lblBienvenueDansNotre.setBounds(45, 19, 382, 59);
		frame.getContentPane().add(lblBienvenueDansNotre);
		
		BackgroundPanel background = new BackgroundPanel();
		background.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(background);
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
	public JFrame getFrame() {
		return frame;
	}
	
	public JButton getBtnDebuterPartie() {
		return btnDebuterPartie;
	}


	public JButton getBtnQuitter() {
		return btnQuitter;
	}

	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
