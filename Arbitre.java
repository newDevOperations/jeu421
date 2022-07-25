package jeu421;

public class Arbitre {
    
   public Arbitre (){
    }
    
   public int calculerPoint(Lancer lanc){
        int sommePoints=1;
        if (lanc.estQuatre21()) sommePoints=8;
        else if (lanc.estBrelan()){
            sommePoints=3;
            if (lanc.estBrelanDe(1))sommePoints+=4;
            }
            else if (lanc.estDeuxAs())sommePoints=lanc.valeur1;
            else if (lanc.estSuite())sommePoints=2;
        return sommePoints;
    }    
    
    //Egalité à 3 -> Cas 1: deux as 3 + brelan - Cas 2: brelan + brelan
    public int departagerEgaliteA3(Lancer lanc1,Lancer lanc2){
        if (lanc1.estDeuxAsEt(3) && lanc2.estBrelan()) return 3;
        else if (lanc2.estDeuxAsEt(3) && lanc1.estBrelan()) return -3;
        else if (lanc1.valeur1 > lanc2.valeur1) return 3;
        else if (lanc2.valeur1 > lanc1.valeur1) return -3;
        else return 0;
   }    
    
    //Egalité à 2 -> Cas 1: deux as 2 + suite - Cas 2: 2 suites
    public int departagerEgaliteA2(Lancer lanc1,Lancer lanc2){
        if (lanc1.estDeuxAsEt(2) && lanc2.estSuite()) return 2;
        else if (lanc2.estDeuxAsEt(2) && lanc1.estSuite()) return -2;
        else if (lanc1.estSuite() && lanc1.estSuite() && lanc1.valeur1>lanc2.valeur1) return 2;
        else if (lanc1.estSuite() && lanc1.estSuite() && lanc1.valeur1<lanc2.valeur1) return -2;
        else return 0;
    } 
    
    //Egalité à 1 -> Aucune combinaison
    public int departagerEgaliteA1(Lancer lanc1,Lancer lanc2){
        if (lanc1.valeurDecimal() > lanc2.valeurDecimal()) return 1;
        else if (lanc1.valeurDecimal() < lanc2.valeurDecimal()) return -1;
        else return 0;
    }  
    
    public int arbitrer(Joueur joueur1, Joueur joueur2){
        int scoreJ1,scoreJ2;
        
        scoreJ1=this.calculerPoint(joueur1.dernierLancer);
        scoreJ2=this.calculerPoint(joueur2.dernierLancer);
        
        if (scoreJ1 > scoreJ2) return scoreJ1;
        else if (scoreJ2 > scoreJ1) return -scoreJ2;
        else if (scoreJ1==3) return departagerEgaliteA3(joueur1.dernierLancer,joueur2.dernierLancer);
        else if (scoreJ1==2) return departagerEgaliteA2(joueur1.dernierLancer,joueur2.dernierLancer);
        else if (scoreJ1==1) return departagerEgaliteA1(joueur1.dernierLancer,joueur2.dernierLancer);
        else return 0;
    }
    
}
