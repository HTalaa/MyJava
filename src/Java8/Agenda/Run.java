package Java8.Agenda;



import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        Produit produit=new Produit(Produit.Type.cd,25);
        Produit produit1=new Produit(Produit.Type.tv,200);
        ArrayList<Produit> produitList=new ArrayList<>();
        produitList.add(produit);
        produitList.add(produit1);
        Personne person=new Personne("Hamid",500,produitList, LocalDate.of(1988,4,23),1000);
        TacheSimple tacheSimple=new TacheSimple(LocalDate.now().plusDays(5),"bla bla zefz");
        ArrayList<Tache> taches=new ArrayList<>();
        taches.add(tacheSimple);
        Agenda agenda=new Agenda(LocalDate.now(),taches,person);
        System.out.println(person.getSalaire());
        System.out.println(person.toString());
        System.out.println(person.getListeDePossession());
        person.travailler();
        System.out.println(person.getSolde());
        person.seFormer();
        System.out.println(person);
        System.out.println(agenda.getTacheList());
        System.out.println(agenda.getAllFutur());
        System.out.println(agenda.getAllPast());
        System.out.println(agenda.getNext());

    }
}
