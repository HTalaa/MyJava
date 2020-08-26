package Java8.exoTextDB.dao.Model;

import java.time.LocalDate;

public class Car {
    private int id;
    private int markId;
    private String model;
    private LocalDate dataAcquisition;

    public Car() {
    }

    public Car(int id, int markId, String model, LocalDate dataAcquisition) {
        this.id = id;
        this.markId = markId;
        this.model = model;
        this.dataAcquisition = dataAcquisition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getDataAcquisition() {
        return dataAcquisition;
    }

    public void setDataAcquisition(LocalDate dataAcquisition) {
        this.dataAcquisition = dataAcquisition;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", markId=" + markId +
                ", model='" + model + '\'' +
                ", dataAcquisition=" + dataAcquisition +
                '}';
    }
}
