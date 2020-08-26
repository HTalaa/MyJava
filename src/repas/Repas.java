package repas;

public class Repas {
    private double energie;
    private double prix;

    public Repas(double energie, double prix) {
        this.energie = energie;
        this.prix = prix;
    }

    public Repas(String qualite) {
        if(qualite.compareTo("bonne")== 0)
        {
            this.setPrix(40);
            this.setEnergie(100);
        }
        else if(qualite.compareTo("basse")== 0){
            this.setPrix(20);
            this.setEnergie(40);
        }
        else{
            throw new IllegalArgumentException("Entrez une valuer valide");
        }
    }

    public double getEnergie() {
        return energie;
    }

    public double getPrix() {
        return prix;
    }

    public void setEnergie(double energie) {
        this.energie = energie;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Repas{" +
                "energie=" + energie +
                ", prix=" + prix +
                '}';
    }
}
