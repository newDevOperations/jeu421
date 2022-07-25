package jeu421;
import java.util.Scanner;

public class Joueur {

protected String nomJoueur; 
protected final int nbrJetonsDepart = 11;
protected int nbrJetons;
protected De d1 = new De();
protected De d2 = new De();
protected De d3 = new De();
protected Lancer dernierLancer = new Lancer();
public Scanner key = new Scanner(System.in);
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_GREEN = "\u001B[32m";
    
   public Joueur() {
        System.out.print("Nom du joueur : ");
        this.nomJoueur = key.nextLine();
        this.nbrJetons = this.nbrJetonsDepart;
    }
    
    public Joueur(String nom) {
        this.nomJoueur = nom;
        this.nbrJetons = this.nbrJetonsDepart;
    }
    
    //METHODES
    public void jouer(){
        this.d1.rouler();
        this.d2.rouler();
        this.d3.rouler();
        this.dernierLancer.enregistrer(d1,d2,d3);
    }
    
    public void modifierScore(int v){
        this.nbrJetons+=v;
    }
    
    public void afficherTirage(){
        System.out.print(ANSI_BLUE+this.nomJoueur+" joue -> ");
        this.dernierLancer.afficheLancer();
    }
    
    public void afficherCagnotteJoueur(){
        System.out.println(this.nomJoueur+" -> " + this.nbrJetons+" jetons");
    }
    
}
