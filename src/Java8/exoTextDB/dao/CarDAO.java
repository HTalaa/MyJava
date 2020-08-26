package Java8.exoTextDB.dao;

import Java8.exoTextDB.dao.Model.Car;
import Java8.exoTextDB.dao.outil.OutilCar;


import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarDAO {
    String filePath =  "D:\\JAVA Prog\\MyJava\\src\\Java8\\exoTextDB\\textDB\\car.db";
    public void insert(Car car){

        String toAdd = car.getId() + "-" + car.getMarkId() +"-"+ car.getModel()+"-"+car.getDataAcquisition().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        try(FileWriter pw = new FileWriter(new File(filePath), true)){
            pw.append("\n");
            pw.append(toAdd);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
    public void edit(Car car){
        delete(car.getId());
        insert(car);


    }
    public Car getOne(int id){

       Car rslt = null;

        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath))))
        {
            rslt = br.lines()
                    .map(OutilCar::stringToCar).filter(car -> car.getId()==id).findFirst().get();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        return rslt;
    }
    public List<Car> getAll(){

        List<Car> rslt = null;

        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath))))
        {
            rslt = br.lines()
                    .map(OutilCar::stringToCar)
                    .collect(Collectors.toList());
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        return rslt;
    }
    public void delete(int id){

        List<String> remainingLines = null;

        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath))))
        {
            remainingLines = br.lines()
                    .filter(line -> Integer.parseInt( line.split("-")[0] ) != id )
                    .collect(Collectors.toList());

            try(PrintWriter pw = new PrintWriter(new File(filePath))){

                for (int i = 0; i < remainingLines.size(); i++) {
                    pw.append(remainingLines.get(i));
                    if(i!=remainingLines.size()-1)
                        pw.append("\n");
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("file not found");
            }

        }
        catch (IOException e)
        {
            System.out.println(e);
        }



    }
}
