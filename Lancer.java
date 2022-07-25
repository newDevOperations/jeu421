package jeu421;

public class Lancer {

protected int valeur1,valeur2,valeur3;
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_BLUE = "\u001B[34m";
        
    //CONSTRUCTEURS
    public Lancer() {}
    
    public void enregistrer(De val1,De val2, De val3) {
        this.valeur1 = val1.valeur;
        this.valeur2 = val2.valeur;
        this.valeur3 = val3.valeur;
        this.trier();
    }
    
    public void trier() { // décroissant
        int temp;

        if (valeur1 < valeur2) {
            temp = valeur2;
            valeur2 = valeur1;
            valeur1 = temp;
        }   
        if (valeur2 < valeur3) {
           temp = valeur3;
           valeur3 = valeur2;
           valeur2 = temp;
        }
        if (valeur1 < valeur2) {
            temp = valeur2;
            valeur2 = valeur1;
            valeur1 = temp;
         }  
    }
            
    public int valeurDecimal() {
        return (this.valeur1*100+this.valeur2*10+this.valeur3);
    }
    
    public boolean estQuatre21() {
        return (valeurDecimal()== 421);
    }
    
    public boolean estBrelan() {
        return (this.valeur1 == this.valeur2 && this.valeur2 == this.valeur3);
    }
    
    public boolean estBrelanDe(int valeur) {
        return (this.valeur1 == valeur && this.valeur2 == valeur && this.valeur3 == valeur);
    }
    
    public boolean estDeuxAs() {
        return (this.valeur3 == 1 && this.valeur2 == 1 && this.valeur1 != 1);
    }
    
    public boolean estDeuxAsEt(int valeur) {
        return (this.valeur3 == 1 && this.valeur2 == 1 && this.valeur1 == valeur);
    }
    
    public boolean estSuite () {
        return (this.valeur1 == this.valeur2+1 && this.valeur2 == this.valeur3+1);
    }
    
    public String identifieCombinaison() {
        if (estQuatre21()) return "Quatre 21";
        else if (estBrelanDe(1)) return "Brelan AS";
        else if (estBrelan()) return "Brelan "+this.valeur1;
        else if (estDeuxAs()) return "Deux AS + "+this.valeur1;
        else if (estSuite()) return "Suite";
        else return "Rien"; 
    }
    
    public void afficheLancer() {
        System.out.println(ANSI_BLUE+this.valeur1+" "+this.valeur2+" "+ this.valeur3+
                           ANSI_BLACK+" (" + identifieCombinaison()+")");
    }
}
