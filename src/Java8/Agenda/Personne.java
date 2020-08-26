package Java8.Agenda;

import java.time.LocalDate;
import java.util.List;

public class Personne {
    private String nom;
    private double solde;
    private List<Produit> listeDePossession ;
    private LocalDate dateAnniversaire;
    private double salaire;

    public Personne(String nom, double solde, List<Produit> listeDePossession, LocalDate dateAnniversaire, double salaire) {
        this.nom = nom;
        this.solde = solde;
        this.listeDePossession = listeDePossession;
        this.dateAnniversaire = dateAnniversaire;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Produit> getListeDePossession() {
        return listeDePossession;
    }

    public void setListeDePossession(List<Produit> listeDePossession) {
        this.listeDePossession = listeDePossession;
    }

    public LocalDate getDateAnniversaire() {
        return dateAnniversaire;
    }

    public void setDateAnniversaire(LocalDate dateAnniversaire) {
        this.dateAnniversaire = dateAnniversaire;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    public void acheter(Produit produit){
        if(getSolde()>=produit.getPrix()){
            this.listeDePossession.add(produit);

        }
        else{
            System.out.println("vous n'avez pas assez d'argent");
        }
    }
    public void visiter(Personne personne){
        System.out.println("visiter: "+personne.getNom());

    }
    public void travailler(){
        this.setSolde(this.getSolde()+this.getSalaire());
    }
    public void seFormer(){
        this.setSalaire(this.getSalaire()+100);
    }
    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", solde=" + solde +
                ", listeDePossession=" + listeDePossession +
                ", dateAnniversaire=" + dateAnniversaire +
                ", salaire=" + salaire +
                '}';
    }
}
