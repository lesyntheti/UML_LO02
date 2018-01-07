package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modele.Main;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ChoixJoueursVue {

	private JFrame frame;
	public static int staticAdv=0;
	public static int niveau=0;

	private JTextField txtAdversaire1;
	private JTextField txtAdversaire2;
	private JTextField txtAdversaire3;
	
	public static String nom1, nom2, nom3;
	
	public static boolean reset=false;

	
	
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoixJoueursVue window = new ChoixJoueursVue();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public ChoixJoueursVue() {
		reset=false;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().repaint();
		
		frame.getContentPane().setBackground(new Color(51, 153, 204));
		frame.getContentPane().setLayout(null);
		
		JRadioButton radioButton = new JRadioButton("1");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				staticAdv=1;
				
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				
				
				JLabel lblAdversaire_1 = new JLabel("Adversaire 1");
				lblAdversaire_1.setBounds(123, 62, 78, 16);
				frame.getContentPane().add(lblAdversaire_1);
				
				txtAdversaire1 = new JTextField();
				txtAdversaire1.setBounds(213, 57, 130, 26);
				frame.getContentPane().add(txtAdversaire1);
				txtAdversaire1.setColumns(10);
				
				JButton btnReset = new JButton("reset");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						reset=true;
					}
				});
				btnReset.setBounds(6, 243, 117, 29);
				frame.getContentPane().add(btnReset);
				
				JButton btnValider = new JButton("Valider");
				btnValider.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("validation 1 joueur adv");
						Main.suivant=true;
						nom1=txtAdversaire1.getText();
					}
				});
				btnValider.setBounds(327, 243, 117, 29);
				frame.getContentPane().add(btnValider);
				
				BackgroundBis background = new BackgroundBis();
				background.setBounds(0, 0, 450, 300);
				frame.getContentPane().add(background);
			}
		});
		radioButton.setBounds(25, 58, 141, 23);
		frame.getContentPane().add(radioButton);
		
		
		
		
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staticAdv=2;
				
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				
				
				JLabel lblAdversaire_1 = new JLabel("Adversaire 1");
				lblAdversaire_1.setBounds(123, 62, 78, 16);
				frame.getContentPane().add(lblAdversaire_1);
				
				JLabel lblAdversaire_2 = new JLabel("Adversaire 2");
				lblAdversaire_2.setBounds(123, 108, 78, 16);
				frame.getContentPane().add(lblAdversaire_2);
				
				
				txtAdversaire1 = new JTextField();
				txtAdversaire1.setBounds(213, 57, 130, 26);
				frame.getContentPane().add(txtAdversaire1);
				txtAdversaire1.setColumns(10);
				
				txtAdversaire2 = new JTextField();
				txtAdversaire2.setColumns(10);
				txtAdversaire2.setBounds(213, 103, 130, 26);
				frame.getContentPane().add(txtAdversaire2);
				
				JButton btnReset = new JButton("reset");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						reset=true;
					}
				});
				btnReset.setBounds(6, 243, 117, 29);
				frame.getContentPane().add(btnReset);
				
				JButton btnValider = new JButton("Valider");
				btnValider.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("validation 2 joueurs adv");
						Main.suivant=true;
						nom1=txtAdversaire1.getText();
						nom2=txtAdversaire2.getText();
					}
				});
				btnValider.setBounds(327, 243, 117, 29);
				frame.getContentPane().add(btnValider);
				
				BackgroundBis background = new BackgroundBis();
				background.setBounds(0, 0, 450, 300);
				frame.getContentPane().add(background);
				
				
			}
		});
		radioButton_1.setBounds(25, 106, 141, 23);
		frame.getContentPane().add(radioButton_1);
		
		
		
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staticAdv=3;
				
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				
				JLabel lblAdversaire_1 = new JLabel("Adversaire 1");
				lblAdversaire_1.setBounds(123, 62, 78, 16);
				frame.getContentPane().add(lblAdversaire_1);
				
				JLabel lblAdversaire_2 = new JLabel("Adversaire 2");
				lblAdversaire_2.setBounds(123, 108, 78, 16);
				frame.getContentPane().add(lblAdversaire_2);
				
				JLabel lblAdversaire_3 = new JLabel("Adversaire 3");
				lblAdversaire_3.setBounds(123, 161, 78, 16);
				frame.getContentPane().add(lblAdversaire_3);
				
				
				txtAdversaire1 = new JTextField();
				txtAdversaire1.setBounds(213, 57, 130, 26);
				frame.getContentPane().add(txtAdversaire1);
				txtAdversaire1.setColumns(10);
				
				txtAdversaire2 = new JTextField();
				txtAdversaire2.setColumns(10);
				txtAdversaire2.setBounds(213, 103, 130, 26);
				frame.getContentPane().add(txtAdversaire2);
				
				txtAdversaire3 = new JTextField();
				txtAdversaire3.setColumns(10);
				txtAdversaire3.setBounds(213, 156, 130, 26);
				frame.getContentPane().add(txtAdversaire3);
				
				
				JButton btnReset = new JButton("reset");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						reset=true;
					}
				});
				btnReset.setBounds(6, 243, 117, 29);
				frame.getContentPane().add(btnReset);
				
				
				JButton btnValider = new JButton("Valider");
				btnValider.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("validation 3 joueurs adv");
						Main.suivant=true;
						nom1=txtAdversaire1.getText();
						nom2=txtAdversaire2.getText();
						nom3=txtAdversaire3.getText();
					}
				});
				btnValider.setBounds(327, 243, 117, 29);
				frame.getContentPane().add(btnValider);
				
				BackgroundBis background = new BackgroundBis();
				background.setBounds(0, 0, 450, 300);
				frame.getContentPane().add(background);
			}
		});
		radioButton_2.setBounds(25, 156, 141, 23);
		frame.getContentPane().add(radioButton_2);
		
		
		JLabel lblChoixDuNombre = new JLabel("Choix du Nombre d'opposants");
		lblChoixDuNombre.setBounds(132, 25, 192, 16);
		frame.add(lblChoixDuNombre);
		
		BackgroundBis background = new BackgroundBis();
		background.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(background);
		background.setLayout(null);
		
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//__________________________________________________________________________________________________
					//fin de l'initialisation
	
	
	//si le joueur appuie sur reset, on refait la fenetre avec cette methode
	public void initializeAgain(){
		
		frame.getContentPane().removeAll();
		
		JRadioButton radioButton = new JRadioButton("1");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				staticAdv=1;
				
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				
				
				JLabel lblAdversaire_1 = new JLabel("Adversaire 1");
				lblAdversaire_1.setBounds(123, 62, 78, 16);
				frame.getContentPane().add(lblAdversaire_1);
				
				txtAdversaire1 = new JTextField();
				txtAdversaire1.setBounds(213, 57, 130, 26);
				frame.getContentPane().add(txtAdversaire1);
				txtAdversaire1.setColumns(10);
				
				JButton btnReset = new JButton("reset");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						reset=true;
					}
				});
				btnReset.setBounds(6, 243, 117, 29);
				frame.getContentPane().add(btnReset);
				
				JButton btnValider = new JButton("Valider");
				btnValider.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("validation 1 joueur adv");
						Main.suivant=true;
						nom1=txtAdversaire1.getText();
					}
				});
				btnValider.setBounds(327, 243, 117, 29);
				frame.getContentPane().add(btnValider);
				
				BackgroundBis background = new BackgroundBis();
				background.setBounds(0, 0, 450, 300);
				frame.getContentPane().add(background);
			}
		});
		radioButton.setBounds(25, 58, 141, 23);
		frame.getContentPane().add(radioButton);
		
		
		
		
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staticAdv=2;
				
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				
				
				JLabel lblAdversaire_1 = new JLabel("Adversaire 1");
				lblAdversaire_1.setBounds(123, 62, 78, 16);
				frame.getContentPane().add(lblAdversaire_1);
				
				JLabel lblAdversaire_2 = new JLabel("Adversaire 2");
				lblAdversaire_2.setBounds(123, 108, 78, 16);
				frame.getContentPane().add(lblAdversaire_2);
				
				
				txtAdversaire1 = new JTextField();
				txtAdversaire1.setBounds(213, 57, 130, 26);
				frame.getContentPane().add(txtAdversaire1);
				txtAdversaire1.setColumns(10);
				
				txtAdversaire2 = new JTextField();
				txtAdversaire2.setColumns(10);
				txtAdversaire2.setBounds(213, 103, 130, 26);
				frame.getContentPane().add(txtAdversaire2);
				
				JButton btnReset = new JButton("reset");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						reset=true;
					}
				});
				btnReset.setBounds(6, 243, 117, 29);
				frame.getContentPane().add(btnReset);
				
				JButton btnValider = new JButton("Valider");
				btnValider.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("validation 2 joueurs adv");
						Main.suivant=true;
						nom1=txtAdversaire1.getText();
						nom2=txtAdversaire2.getText();
					}
				});
				btnValider.setBounds(327, 243, 117, 29);
				frame.getContentPane().add(btnValider);
				
				BackgroundBis background = new BackgroundBis();
				background.setBounds(0, 0, 450, 300);
				frame.getContentPane().add(background);
				
				
			}
		});
		radioButton_1.setBounds(25, 106, 141, 23);
		frame.getContentPane().add(radioButton_1);
		
		
		
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staticAdv=3;
				
				frame.getContentPane().removeAll();
				frame.getContentPane().repaint();
				
				JLabel lblAdversaire_1 = new JLabel("Adversaire 1");
				lblAdversaire_1.setBounds(123, 62, 78, 16);
				frame.getContentPane().add(lblAdversaire_1);
				
				JLabel lblAdversaire_2 = new JLabel("Adversaire 2");
				lblAdversaire_2.setBounds(123, 108, 78, 16);
				frame.getContentPane().add(lblAdversaire_2);
				
				JLabel lblAdversaire_3 = new JLabel("Adversaire 3");
				lblAdversaire_3.setBounds(123, 161, 78, 16);
				frame.getContentPane().add(lblAdversaire_3);
				
				
				txtAdversaire1 = new JTextField();
				txtAdversaire1.setBounds(213, 57, 130, 26);
				frame.getContentPane().add(txtAdversaire1);
				txtAdversaire1.setColumns(10);
				
				txtAdversaire2 = new JTextField();
				txtAdversaire2.setColumns(10);
				txtAdversaire2.setBounds(213, 103, 130, 26);
				frame.getContentPane().add(txtAdversaire2);
				
				txtAdversaire3 = new JTextField();
				txtAdversaire3.setColumns(10);
				txtAdversaire3.setBounds(213, 156, 130, 26);
				frame.getContentPane().add(txtAdversaire3);
				
				
				JButton btnReset = new JButton("reset");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						reset=true;
					}
				});
				btnReset.setBounds(6, 243, 117, 29);
				frame.getContentPane().add(btnReset);
				
				
				JButton btnValider = new JButton("Valider");
				btnValider.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("validation 3 joueurs adv");
						Main.suivant=true;
						nom1=txtAdversaire1.getText();
						nom2=txtAdversaire2.getText();
						nom3=txtAdversaire3.getText();
					}
				});
				btnValider.setBounds(327, 243, 117, 29);
				frame.getContentPane().add(btnValider);
				
				BackgroundBis background = new BackgroundBis();
				background.setBounds(0, 0, 450, 300);
				frame.getContentPane().add(background);
			}
		});
		radioButton_2.setBounds(25, 156, 141, 23);
		frame.getContentPane().add(radioButton_2);
		
		
		JLabel lblChoixDuNombre = new JLabel("Choix du Nombre d'opposants");
		lblChoixDuNombre.setBounds(132, 25, 192, 16);
		frame.add(lblChoixDuNombre);
		
		BackgroundBis background = new BackgroundBis();
		background.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(background);
		background.setLayout(null);
	
		
		frame.getContentPane().repaint();
		
	}
	
	
	
	//______________________________________________________________________________
	
	
	public void setDifficulty(){
		frame.getContentPane().removeAll();
		
		
		JButton btnDebutant = new JButton("Debutant");
		btnDebutant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("validation niveau bots");
				niveau=0;
				frame.setVisible(false);
				Main.suivant=true;
			}
		});
		btnDebutant.setBounds(98, 118, 117, 29);
		frame.getContentPane().add(btnDebutant);
		
		JButton btnAvance = new JButton("Avance");
		btnAvance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("validation niveau bots");
				niveau=1;
				frame.setVisible(false);
				Main.suivant=true;
			}
		});
		btnAvance.setBounds(257, 118, 117, 29);
		frame.getContentPane().add(btnAvance);
		
		JLabel lblChoisirLeNiveau = new JLabel("Choisir le niveau des bots");
		lblChoisirLeNiveau.setBounds(149, 48, 180, 16);
		frame.getContentPane().add(lblChoisirLeNiveau);
		
		BackgroundBis background = new BackgroundBis();
		background.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(background);
		
		frame.getContentPane().repaint();
	}

}
