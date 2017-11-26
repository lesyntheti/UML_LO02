package crazyeightBis;

import java.util.*;

public class Variante {

	Scanner sc = new Scanner(System.in);
	
	public Variante(){
		
	}
	
	//l'appel de nouvelleVariante se fait lors de l'initialisation
	
	public Pioche nouvelleVariante(Pioche pioche){
		
		int numeroVariante=0;
		
		System.out.println("\nQuelle variante voulez-vous jouer ?");
		System.out.println("tappez 1 pour la variante minimaliste");
		System.out.println("tappez 2 pour la variante \"carte et maou\"");
		System.out.println("tappez 3 pour la variante \"Monclar\"");
		
		
		while(numeroVariante<1 || numeroVariante>4){
			numeroVariante = sc.nextInt();
			if (numeroVariante<1 || numeroVariante>4)
				System.out.println("nombre doit etre entre 1 et 3 please");
		//on s'assure que le joueur rentre un nombre entre 1 et 3
		}
		
		//selon le numéro entré, la méthode appelle la variante correspondante
		
		switch (numeroVariante)
		{
		  case 1: //minimaliste
			  			//10=rejouer, 8=change-couleur
			  
			//boucle changement des effets des 10
			  	int index=0;
			  	Iterator<Carte> i1=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i1.hasNext()) 
				{
					
					if (i1.next().getNumero()==9){  //si la carte est un 10
						pioche.getDeck().get(index).setEffet(1);
					}
					index++;
				}
			  
				//boucle changement des effets des 8
				index=0;
				Iterator<Carte> i2=pioche.getDeck().iterator(); 
				while(i2.hasNext()) 
				{		
					if (i2.next().getNumero()==7){  //si la carte est un 8
						pioche.getDeck().get(index).setEffet(5);
					}
					index++;
				}
			  
		    
		    break; 
		    
		  case 2:  //carte et maou
			    		//10 rejouer, 8 passe le suivant, 7 fait piocher deux cartes, valet ch.couleur
			  
			  		//boucle changement des effets des 10 (effet 1)
			  	index=0;
			  	Iterator<Carte> i3=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i3.hasNext()) 
				{
					
					if (i3.next().getNumero()==9){  //si la carte est un 10  
						pioche.getDeck().get(index).setEffet(1);
					}
					index++;
				}
			  
					//boucle changement des effets des 8  (effet 3)
			  	index=0;
			  	Iterator<Carte> i4=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i4.hasNext()) 
				{
					
					if (i4.next().getNumero()==7){  //si la carte est un 8
						pioche.getDeck().get(index).setEffet(3);
					}
					index++;
				}  
			  
					//boucle changement des effets des 7  (effet 42)
			  	index=0;
			  	Iterator<Carte> i5=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i5.hasNext()) 
				{
					
					if (i5.next().getNumero()==6){  //si la carte est un 7
						pioche.getDeck().get(index).setEffet(42);
					}
					index++;
				} 
				
				
					//boucle changement des effets des Valets(10)  (effet 5)
			  	index=0;
			  	Iterator<Carte> i6=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i6.hasNext()) 
				{
					
					if (i6.next().getNumero()==10){  //si la carte est un valet
						pioche.getDeck().get(index).setEffet(5);
					}
					index++;
				} 
				
			  
			    break; 
			    
		  case 3:  //monclar
			   		
					//boucle changement des effets des 10 (effet 1)
			  	index=0;
			  	Iterator<Carte> i7=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i7.hasNext()) 
				{
					
					if (i7.next().getNumero()==9){  //si la carte est un 10  
						pioche.getDeck().get(index).setEffet(1);
					}
					index++;
				}
			  
				
					//boucle changement des effets des 7  (effet 3)
			  	index=0;
			  	Iterator<Carte> i8=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i8.hasNext()) 
				{
					
					if (i8.next().getNumero()==6){  //si la carte est un 7
						pioche.getDeck().get(index).setEffet(3);
					}
					index++;
				}  
				
				//boucle changement des effets des valets  (effet 2)
			  	index=0;
			  	Iterator<Carte> i9=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i9.hasNext()) 
				{
					
					if (i9.next().getNumero()==10){  //si la carte est un valet
						pioche.getDeck().get(index).setEffet(2);
					}
					index++;
				}  
			  
				//boucle changement des effets des 9  (effet 41)
			  	index=0;
			  	Iterator<Carte> i10=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i10.hasNext()) 
				{
					
					if (i10.next().getNumero()==8){  //si la carte est un 9
						pioche.getDeck().get(index).setEffet(41);
					}
					index++;
				} 
				
				//boucle changement des effets des As  (effet 43)
			  	index=0;
			  	Iterator<Carte> i11=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i11.hasNext()) 
				{
					
					if (i11.next().getNumero()==0){  //si la carte est un As
						pioche.getDeck().get(index).setEffet(43);
					}
					index++;
				} 
				
				//boucle changement des effets des 8
				index=0;
				Iterator<Carte> i12=pioche.getDeck().iterator(); 
				while(i12.hasNext()) 
				{		
					if (i12.next().getNumero()==7){  //si la carte est un 8
						pioche.getDeck().get(index).setEffet(5);
					}
					index++;
				}
			  
			  
			  
			    break; 
			    
		  default:
		         System.out.println("erreur : pas de variante entrée"); //message optionnel car ce cas n'est pas censé être possible
		}
		
		
		return pioche;
	}
	
}
