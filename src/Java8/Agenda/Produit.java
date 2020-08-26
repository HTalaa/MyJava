package Java8.Agenda;

public class Produit {
    private final Type type;
    private double prix;

    public Produit(Type type, double prix) {
        this.type = type;
        this.prix = prix;
    }

    public Type getType() {
        return type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "type=" + type +
                ", prix=" + prix +
                '}';
    }

    public enum Type{voiture, cd, tv}
}
