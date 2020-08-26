package Opt;

import java.util.function.Predicate;

public class Burger {
    private double tauxSel;
    private double tauxDeGout;
    private int quantite;

    public Burger(double tauxSel, double tauxDeGout, int quantite) {
        this.tauxSel = tauxSel;
        this.tauxDeGout = tauxDeGout;
        this.quantite = quantite;
    }

    public double getTauxSel() {
        return tauxSel;
    }

    public void setTauxSel(double tauxSel) {
        this.tauxSel = tauxSel;
    }

    public double getTauxDeGout() {
        return tauxDeGout;
    }

    public void setTauxDeGout(double tauxDeGout) {
        this.tauxDeGout = tauxDeGout;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
/*public boolean estDeQualité(Predicate<Burger>){
        return true;
    }*/
}
