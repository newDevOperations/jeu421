package jeu421;
import java.util.Random;

public class De {
    
    protected int nbrFaces;
    protected int valeur;
     

    public De(){
        this.nbrFaces=6;
        this.valeur=1;
    }
    
    public void rouler(){
        this.valeur = (int)(Math.random()*this.nbrFaces+1);
    }
    
    public int getValeur(){
        return this.valeur;
    }

}

