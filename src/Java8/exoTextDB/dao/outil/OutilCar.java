package Java8.exoTextDB.dao.outil;


import Java8.exoTextDB.dao.Model.Car;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OutilCar {
    public static Car stringToCar(String chaine){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String[] tab = chaine.split("-");
        Car rslt = new Car();

        try{
            rslt.setId(Integer.parseInt(tab[0]));
            rslt.setMarkId(Integer.parseInt(tab[1]));
            rslt.setModel(tab[2]);
            System.out.println(tab[3]);
            rslt.setDataAcquisition( LocalDate.parse(tab[3], formatter));
        }
        catch(Exception e)
        {
            System.out.println("format incorrect");
            return null;
        }

        return rslt;
    }
}
