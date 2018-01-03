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

public class TableJeuVue implements Observer{

	private JFrame frame;
	private ArrayList<Carte> cartesMoi;
	private Jeu jeuEnCours;
	private Carte carteTalon;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//createCards();
					//TableJeuVue window = new TableJeuVue(cartesMoi, carteTalon);
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
	public TableJeuVue(ArrayList<Carte> cartesMoi, Carte carteTalon) {
		
		initialize(cartesMoi, carteTalon);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Carte> cartesMoi, Carte carteTalon) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		CarteCachee blank = new CarteCachee();
		blank.setBounds(52,418, 82, 116);
		frame.getContentPane().add(blank);
		
		
		
		
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
			System.out.println(i1.toString());
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

	
	public void actualiser(ArrayList<Carte> cartesMoi, Carte carteTalon){
	
		frame.getContentPane().removeAll();
		
		CarteCachee blank = new CarteCachee();
		blank.setBounds(52,418, 82, 116);
		frame.getContentPane().add(blank);
		
		
		
		
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
			System.out.println(i1.toString());
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
		if (instanceObservable instanceof modele.Jeu) {
			Jeu jeuEnCours=(Jeu)instanceObservable;
			//si il y a eu un changement dans notre main (et sur le talon donc)
			 if (jeuEnCours.getJoueurEnCours().getNom()=="moi"){
				 cartesMoi=jeuEnCours.getJoueurEnCours().getMain();
				 actualiser(cartesMoi, carteTalon); //on refait le plateau de jeu avec le nouvel affichage de sa main
			 }
			 else{   //si un bot a joué une carte et que le talon a change donc
				 actualiser(cartesMoi, carteTalon); 
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
