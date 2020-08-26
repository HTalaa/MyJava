package Java8.Agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TacheSimple extends Tache {
    private String action;

    public TacheSimple(LocalDate dateExecution, String action) {
        super(dateExecution);
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
