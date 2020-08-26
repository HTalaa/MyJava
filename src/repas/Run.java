package repas;

public class Run {
    public static void main(String[] args) {
        Personne p1=new Personne(120,100);
        p1.acheter(new Repas("bonne"));
        System.out.println(p1.getListeDeRepas().toString());
        p1.travailler(-10);
    }
}
