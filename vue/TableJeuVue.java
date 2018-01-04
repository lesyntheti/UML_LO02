package vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import modele.Carte;
import modele.Jeu;
import javax.swing.JLabel;

public class TableJeuVue implements Observer{

	private JFrame frame;
	private ArrayList<Carte> cartesMoi;
	private Jeu jeuEnCours;
	private Carte carteTalon;
	private int nbJoueursAdv;
	
	public static Carte carteSelectionnee;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//a mettre en vert à l'execution
					//TableJeuVue window = new TableJeuVue();
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
	public TableJeuVue(Jeu jeuEnCours, ArrayList<Carte> cartesMoi, Carte carteTalon) {
		// a enlever a l execution
		//createCards();
		
		initialize(cartesMoi, carteTalon);
		this.jeuEnCours=jeuEnCours;
		System.out.println("on ajoute un observer");
		this.jeuEnCours.addObserver(this);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Carte> cartesMoi, Carte carteTalon) {
		System.out.println("initialise s execute");
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(4, 68, 15));
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//ajout image et label pioche
		CarteCachee blank = new CarteCachee();
		blank.setBounds(52,418, 82, 116);
		frame.getContentPane().add(blank);
		blank.setLayout(null);
		
		JLabel lblPioche = new JLabel("Pioche");
		lblPioche.setBounds(72, 536, 100, 16);
		frame.getContentPane().add(lblPioche);
		lblPioche.setForeground(Color.WHITE);
		
		//test
		
		
		
		
		
		//ajout jeux et labels adversaires selon le nombre d'adversaires
		this.nbJoueursAdv=ChoixJoueursVue.staticAdv;
		
		switch(nbJoueursAdv){
			case 1 : 
				CarteCachee adv1cas1 = new CarteCachee();
				adv1cas1.setBounds((frame.getWidth()/2)-41,52, 82, 116);
				frame.getContentPane().add(adv1cas1);
				
				JLabel lblj1c1 = new JLabel(ChoixJoueursVue.nom1);
				lblj1c1.setBounds((frame.getWidth()/2)-41,170, 100, 16);
				frame.getContentPane().add(lblj1c1);
				lblj1c1.setForeground(Color.WHITE);
			break;
		
			case 2 : 
				CarteCachee adv1cas2 = new CarteCachee();
				adv1cas2.setBounds(52,(frame.getHeight()/2)-138, 82, 116);
				frame.getContentPane().add(adv1cas2);
				
				JLabel lblj1c2 = new JLabel(ChoixJoueursVue.nom1);
				lblj1c2.setBounds(52,(frame.getHeight()/2)-20, 100, 16);
				frame.getContentPane().add(lblj1c2);
				lblj1c2.setForeground(Color.WHITE);
				
				CarteCachee adv2cas2 = new CarteCachee();
				adv2cas2.setBounds(766,(frame.getHeight()/2)-138, 82, 116);
				frame.getContentPane().add(adv2cas2);
				
				JLabel lblj2c2 = new JLabel(ChoixJoueursVue.nom2);
				lblj2c2.setBounds(766,(frame.getHeight()/2)-20, 100, 16);
				frame.getContentPane().add(lblj2c2);
				lblj2c2.setForeground(Color.WHITE);
			break;
			
			case 3 : 
				CarteCachee adv1cas3 = new CarteCachee();
				adv1cas3.setBounds((frame.getWidth()/2)-41,52, 82, 116);
				frame.getContentPane().add(adv1cas3);
				
				JLabel lblj1c3 = new JLabel(ChoixJoueursVue.nom1);
				lblj1c3.setBounds((frame.getWidth()/2)-41,170, 100, 16);
				frame.getContentPane().add(lblj1c3);
				lblj1c3.setForeground(Color.WHITE);
				
				
				CarteCachee adv2cas3 = new CarteCachee();
				adv2cas3.setBounds(52,(frame.getHeight()/2)-138, 82, 116);
				frame.getContentPane().add(adv2cas3);
				
				JLabel lblj2c3 = new JLabel(ChoixJoueursVue.nom2);
				lblj2c3.setBounds(52,(frame.getHeight()/2)-20, 100, 16);
				frame.getContentPane().add(lblj2c3);
				lblj2c3.setForeground(Color.WHITE);
				
				
				CarteCachee adv3cas3 = new CarteCachee();
				adv3cas3.setBounds(766,(frame.getHeight()/2)-138, 82, 116);
				frame.getContentPane().add(adv3cas3);
				
				JLabel lblj3c3 = new JLabel(ChoixJoueursVue.nom3);
				lblj3c3.setBounds(766,(frame.getHeight()/2)-20, 100, 16);
				frame.getContentPane().add(lblj3c3);
				lblj3c3.setForeground(Color.WHITE);
			break;
		}
		
		
		
		//on lie le jeu de carte modele à celui vue
		this.cartesMoi=cartesMoi;
		int j=1;
		Iterator<Carte> i1=cartesMoi.iterator(); // on crée un Iterator pour parcourir notre ArrayList
		while(i1.hasNext()) 
		{
			//System.out.println(i1.next());	//on affiche toute la main du joueur
			CarteVue carteVue = new CarteVue(i1.next());
			int start = (frame.getWidth()/2)-(cartesMoi.size()*25);
			carteVue.setBounds(start+(j*50),418, 82, 116);
			frame.getContentPane().add(carteVue);
			j++;
			//System.out.println(i1.toString());  //affiche les cartes du joueur, marche pas bien...
		}
		
		
		//on lie le talon du jeu à celui de la vue
		this.carteTalon=carteTalon;
		//Carte carteTalon = new Carte(0,0);
		CarteTalonVue carteTalonVue = new CarteTalonVue(carteTalon);
		carteTalonVue.setBounds((frame.getWidth()/2)-41, (frame.getHeight()/2)-58, 82, 116);
		frame.getContentPane().add(carteTalonVue);
		 
		
		
		//en dernier (background)
		BackgroundPanel background = new BackgroundPanel();
		background.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(background);
		background.setLayout(null);
		
		
		
		
		frame.repaint();
		frame.setVisible(true);
	}

	
	//________________________________________________________________________________________________________________
	
	
	
	public void actualiser(ArrayList<Carte> cartesMoi, Carte carteTalon){
	
		//System.out.println("methode actualiser s execute");
		frame.getContentPane().removeAll();
		

		//ajout image et label pioche
		CarteCachee blank = new CarteCachee();
		blank.setBounds(52,418, 82, 116);
		frame.getContentPane().add(blank);
		blank.setLayout(null);
		
		JLabel lblPioche = new JLabel("Pioche");
		lblPioche.setBounds(72, 536, 100, 16);
		frame.getContentPane().add(lblPioche);
		lblPioche.setForeground(Color.WHITE);
		
		
		
		//ajout jeux et labels adversaires selon le nombre d'adversaires
		this.nbJoueursAdv=ChoixJoueursVue.staticAdv;
		
		switch(nbJoueursAdv){
			case 1 : 
				CarteCachee adv1cas1 = new CarteCachee();
				adv1cas1.setBounds((frame.getWidth()/2)-41,52, 82, 116);
				frame.getContentPane().add(adv1cas1);
				
				JLabel lblj1c1 = new JLabel(ChoixJoueursVue.nom1);
				lblj1c1.setBounds((frame.getWidth()/2)-41,170, 100, 16);
				frame.getContentPane().add(lblj1c1);
				lblj1c1.setForeground(Color.WHITE);
			break;
		
			case 2 : 
				CarteCachee adv1cas2 = new CarteCachee();
				adv1cas2.setBounds(52,(frame.getHeight()/2)-138, 82, 116);
				frame.getContentPane().add(adv1cas2);
				
				JLabel lblj1c2 = new JLabel(ChoixJoueursVue.nom1);
				lblj1c2.setBounds(52,(frame.getHeight()/2)-20, 100, 16);
				frame.getContentPane().add(lblj1c2);
				lblj1c2.setForeground(Color.WHITE);
				
				CarteCachee adv2cas2 = new CarteCachee();
				adv2cas2.setBounds(766,(frame.getHeight()/2)-138, 82, 116);
				frame.getContentPane().add(adv2cas2);
				
				JLabel lblj2c2 = new JLabel(ChoixJoueursVue.nom2);
				lblj2c2.setBounds(766,(frame.getHeight()/2)-20, 100, 16);
				frame.getContentPane().add(lblj2c2);
				lblj2c2.setForeground(Color.WHITE);
			break;
			
			case 3 : 
				CarteCachee adv1cas3 = new CarteCachee();
				adv1cas3.setBounds((frame.getWidth()/2)-41,52, 82, 116);
				frame.getContentPane().add(adv1cas3);
				
				JLabel lblj1c3 = new JLabel(ChoixJoueursVue.nom1);
				lblj1c3.setBounds((frame.getWidth()/2)-41,170, 100, 16);
				frame.getContentPane().add(lblj1c3);
				lblj1c3.setForeground(Color.WHITE);
				
				
				CarteCachee adv2cas3 = new CarteCachee();
				adv2cas3.setBounds(52,(frame.getHeight()/2)-138, 82, 116);
				frame.getContentPane().add(adv2cas3);
				
				JLabel lblj2c3 = new JLabel(ChoixJoueursVue.nom2);
				lblj2c3.setBounds(52,(frame.getHeight()/2)-20, 100, 16);
				frame.getContentPane().add(lblj2c3);
				lblj2c3.setForeground(Color.WHITE);
				
				
				CarteCachee adv3cas3 = new CarteCachee();
				adv3cas3.setBounds(766,(frame.getHeight()/2)-138, 82, 116);
				frame.getContentPane().add(adv3cas3);
				
				JLabel lblj3c3 = new JLabel(ChoixJoueursVue.nom3);
				lblj3c3.setBounds(766,(frame.getHeight()/2)-20, 100, 16);
				frame.getContentPane().add(lblj3c3);
				lblj3c3.setForeground(Color.WHITE);
			break;
		}
		
		
		
		this.cartesMoi=cartesMoi;
		int j=1;
		Iterator<Carte> i1=cartesMoi.iterator(); // on crée un Iterator pour parcourir notre ArrayList
		while(i1.hasNext()) 
		{
			//System.out.println(i1.next());	//on affiche toute la main du joueur
			CarteVue carteVue = new CarteVue(i1.next());
			int start = (frame.getWidth()/2)-(cartesMoi.size()*25);
			carteVue.setBounds(start+(j*50),418, 82, 116);
			frame.getContentPane().add(carteVue);
			j++;
			//System.out.println(i1.toString());
		}
		
		
		
		this.carteTalon=carteTalon;
		//Carte carteTalon = new Carte(0,0);
		CarteTalonVue carteTalonVue = new CarteTalonVue(carteTalon);
		carteTalonVue.setBounds((frame.getWidth()/2)-41, (frame.getHeight()/2)-58, 82, 116);
		frame.getContentPane().add(carteTalonVue);
		 
		
		
		//en dernier (background)
		BackgroundPanel background = new BackgroundPanel();
		background.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(background);
		
		frame.repaint();
		frame.setVisible(true);
		
		
		
	}
	
	
	
	
	
	@Override
	public void update(Observable instanceObservable, Object arg) {
		//System.out.println("update s execute");
		if (instanceObservable instanceof modele.Jeu) {
			Jeu jeuEnCours=(Jeu)instanceObservable;
			//si il y a eu un changement dans notre main (et sur le talon donc)
			 if (jeuEnCours.getJoueurEnCours().getNom()=="moi"){
				 //System.out.println("actualisation moi");
				 cartesMoi=jeuEnCours.getJoueurEnCours().getMain();
				 carteTalon=jeuEnCours.getTalon().getCarteDessus();
				 actualiser(cartesMoi, carteTalon); //on refait le plateau de jeu avec le nouvel affichage de sa main
			 }
			 else{   //si un bot a joué une carte et que le talon a change donc
				 //System.out.println("actualisation bot");
				 carteTalon=jeuEnCours.getTalon().getCarteDessus();
				 actualiser(cartesMoi, carteTalon); 
			 }
			 if(jeuEnCours.isGagnant()){
				 frame.setVisible(false);
			 }
		}
		
	}

	
	public void createCards(){
		Carte carteAjoutee;
		cartesMoi= new ArrayList<Carte>();
		
		carteTalon = new Carte(0,0);
		
		for (int i=0; i<4;i++){
		carteAjoutee = new Carte(i,0);
		cartesMoi.add(carteAjoutee);
		}
		for (int i=0; i<3;i++){
			carteAjoutee = new Carte(i,1);
			cartesMoi.add(carteAjoutee);
			}
		for (int i=0; i<2;i++){
			carteAjoutee = new Carte(i,2);
			cartesMoi.add(carteAjoutee);
			}
	}
	
}
