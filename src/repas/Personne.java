package repas;

import java.util.ArrayList;

public class Personne {
    private double energie;
    private ArrayList<Repas> listeDeRepas=new ArrayList<>();
    private double argent;

    public Personne(double energie, double argent) {
        this.energie = energie;
        this.argent = argent;
    }

    public double getEnergie() {
        return energie;
    }

    public void setEnergie(double energie) {
        this.energie = energie;
    }

    public ArrayList<Repas> getListeDeRepas() {
        return listeDeRepas;
    }

    public void setListeDeRepas(ArrayList<Repas> listeDeRepas) {
        this.listeDeRepas = listeDeRepas;
    }

    public double getArgent() {
        return argent;
    }

    public void setArgent(double argent) {
        this.argent = argent;
    }
    public void manger(){
        if(listeDeRepas.size()>0){
            this.energie+=listeDeRepas.get(0).getEnergie();
            listeDeRepas.remove(0);
        }
        else{
            this.energie+=10;
        }


    }
    public void acheter(Repas repas){
        if(argent<repas.getPrix()){
            throw new IllegalArgumentException("vous n'avez pas assez de l'argent");
        }
        else
        {
            listeDeRepas.add(repas);
            argent-=repas.getPrix();
        }


    }
    public void travailler(double nbrH){
        double ener=nbrH*10;
        double hNbr=nbrH*30;
        if(nbrH<0){
            throw new IllegalArgumentException("le numbre d'heur doit etre positif");
        }
        else if(ener<this.energie){
            throw new IllegalArgumentException("Vous n'avez pas assez d'energie");
        }
        else
        {
            argent+=hNbr;
            energie-=ener;
        }

    }

}
