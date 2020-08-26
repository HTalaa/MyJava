package Java8.exoTextDB.dao;

import Java8.exoTextDB.dao.Model.Car;
import Java8.exoTextDB.dao.Model.Mark;

import java.time.LocalDate;

public class Run {
    public static void main(String[] args) {
        Mark mark=new Mark(11,"hamid111");
        MarkDAO markDAO=new MarkDAO();
        CarDAO carDAO=new CarDAO();
        //markDAO.insert(mark);
        System.out.println(markDAO.getAll());
        //markDAO.delete(11);
        Car car=new Car(31,1,"hamid11", LocalDate.now());
        //carDAO.insert(car);
        carDAO.getAll();
        System.out.println(carDAO.getOne(31).toString());
        //carDAO.edit(car);
        carDAO.getAll();
        //carDAO.delete(31);
        //carDAO.getAll();
        carDAO.edit(car);
        System.out.println(carDAO.getAll());

    }
}
