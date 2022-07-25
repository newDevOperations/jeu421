package jeu421;

public class Jeu421 {
    
    private Joueur j1 = new Joueur("Joueur1");
    private Joueur j2 = new Joueur("Joueur2");
    private Arbitre arb = new Arbitre();
    int numTour=0;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
              
    //CONSTRUCTEUR
    public Jeu421() {
    }
    
    //METHODES
    public void afficherArbitrage(){
        int arbitrage = arb.arbitrer(j1,j2);  
        
        if (arbitrage>0) System.out.println(ANSI_GREEN+j1.nomJoueur+" GAGNE +" +arbitrage+" jetons");
        else if (arbitrage<0) System.out.println(ANSI_CYAN+j2.nomJoueur+" GAGNE +" +(-arbitrage)+" jetons");
        else System.out.println("Egalité parfaite");
    }
    
    public void afficherTour(){
        System.out.println("\n"+ANSI_RED+"Tour n°"+numTour);
        j1.afficherTirage();
        j2.afficherTirage();
        this.afficherArbitrage();
        j1.afficherCagnotteJoueur();
        j2.afficherCagnotteJoueur();
        
    }
    
  
    public void go(){
        this.numTour=0;
               
        //Début du jeu
        System.out.println(ANSI_RED+"Début du jeu");
        j1.afficherCagnotteJoueur();
        j2.afficherCagnotteJoueur();
        
        
        //Cycle de Jeu
        while (j1.nbrJetons>0 && j2.nbrJetons>0) {
            numTour++;
            j1.jouer();
            j2.jouer();
                     
            j1.modifierScore(arb.arbitrer(j1,j2));
            j2.modifierScore(-arb.arbitrer(j1,j2));
        
            afficherTour();
        }
        
        //Declaration du Gagnant
        if (j1.nbrJetons>0)
            System.out.println("\n"+ANSI_PURPLE+j1.nomJoueur.toUpperCase()+" a gagné !!!! en "+numTour+" lancers !");
        else
            System.out.println("\n"+ANSI_PURPLE+j2.nomJoueur.toUpperCase()+" a gagné !!!! en "+numTour+" lancers !");
                
    }
}
