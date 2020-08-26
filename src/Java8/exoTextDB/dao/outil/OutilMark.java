package Java8.exoTextDB.dao.outil;

import Java8.exoTextDB.dao.Model.Mark;

public class OutilMark {
    public static Mark stringToMark(String chaine){
        String[] tab = chaine.split("-");
        Mark rslt = new Mark();

        try{
            rslt.setId(Integer.parseInt(tab[0]));
            rslt.setName(tab[1]);
        }
        catch(Exception e)
        {
            System.out.println("format incorrect");
            return null;
        }

        return rslt;
    }
}
