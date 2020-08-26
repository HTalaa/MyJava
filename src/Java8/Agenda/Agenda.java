package Java8.Agenda;



import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Agenda {
    private LocalDate date;
    private List<Tache> tacheList;
    private Personne personne;

    public Agenda(LocalDate date, List<Tache> tacheList, Personne personne) {
        this.date = date;
        this.tacheList = tacheList;
        this.personne = personne;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Tache> getTacheList() {
        return tacheList;
    }

    public void setTacheList(List<Tache> tacheList) {
        this.tacheList = tacheList;
    }

    public Personne getPerson() {
        return personne;
    }

    public void setPerson(Personne personne) {
        this.personne = personne;
    }

    public List<Tache> getAllPast(){

        List<Tache> past =getTacheList().stream().filter(tache -> tache.getDateExecution().isBefore(date)).collect(Collectors.toList());
        return past;
    }
    public List<Tache> getAllFutur(){

        List<Tache> past =getTacheList().stream().filter(tache -> tache.getDateExecution().isAfter(date.minusDays(1))).collect(Collectors.toList());
        return past;
    }
    public Tache getNext(){

        List<Tache> past =getTacheList().stream().filter(tache -> tache.getDateExecution().isAfter(date.minusDays(1))).collect(Collectors.toList());
        return past.get(0);
    }
    public void addTache(Tache tache){
        tacheList.add(tache);
    }
    public void deplaceLesTaches(int noJours){
        getTacheList().stream().filter(tache -> tache.getDateExecution().isAfter(date.minusDays(1))).forEach(tache -> tache.setDateExecution(tache.getDateExecution().plusDays(noJours)));
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "date=" + date +
                ", tacheList=" + tacheList +
                ", person=" + personne +
                '}';
    }
}
