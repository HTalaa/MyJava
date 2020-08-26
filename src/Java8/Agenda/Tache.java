package Java8.Agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tache {
    LocalDate dateExecution ;

    public Tache(LocalDate dateExecution) {
        this.dateExecution = dateExecution;
    }

    public LocalDate getDateExecution() {
        return dateExecution;
    }

    public void setDateExecution(LocalDate dateExecution) {
        this.dateExecution = dateExecution;
    }
    public void execute(){
        System.out.println("execute la tache");
    }

    @Override
    public String toString() {
        return "Tache{" +
                "dateExecution=" + dateExecution +
                '}';
    }
}
