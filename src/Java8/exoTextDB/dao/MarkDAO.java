package Java8.exoTextDB.dao;

import Java8.exoTextDB.dao.Model.Mark;
import Java8.exoTextDB.dao.outil.OutilMark;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class MarkDAO {
    String filePath =  "D:\\JAVA Prog\\MyJava\\src\\Java8\\exoTextDB\\textDB\\marque.db";
    public void insert(Mark mark){

        String toAdd = mark.getId() + "-" + mark.getName();

        try(FileWriter pw = new FileWriter(new File(filePath), true)){
            pw.append("\n");
            pw.append(toAdd);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }

    public List<Mark> getAll(){

        List<Mark> rslt = null;

        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath))))
        {
            rslt = br.lines()
                    .map(OutilMark::stringToMark)
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
