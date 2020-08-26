package repas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {
    Personne p=new Personne(120,100);
    @Test
    void getEnergie() {

    }

    @Test
    void setEnergie() {

    }

    @Test
    void getListeDeRepas() {
    }

    @Test
    void setListeDeRepas() {
    }

    @Test
    void getArgent() {
    }

    @Test
    void setArgent() {
    }

    @Test
    void manger() {
    }

    @Test
    void acheter() {
        assertAll(() -> assertThrows(IllegalArgumentException.class, () -> p.acheter(new Repas("ffff"))),
                () -> assertThrows(IllegalArgumentException.class, () -> p.acheter(new Repas("bonne"))));
    }

    @Test
    void travailler() {

        assertAll(() -> assertThrows(IllegalArgumentException.class, () -> p.travailler(-10)),
                () -> assertThrows(IllegalArgumentException.class, () -> p.travailler(10)));

    }
}