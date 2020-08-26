package Java8.JAVA8_ProdVelo;
import java.time.LocalDate;

public class Launcher {

    public static void main(String[] args) {

        Product p1 = new Product("guidonMark1",
                                 "model1",
                                 55,
                                 2,
                                 17,
                                 ProductType.GUIDON,
                                 LocalDate.of(2020, 8, 18));

        Product p2 = new Product("guidonMark1",
                                 "model1",
                                 33,
                                 7,
                                 0,
                                 ProductType.GUIDON,
                                 LocalDate.of(2020, 8, 18));

        Product p3 = new Product("guidonMark1",
                                 "model1",
                                 18,
                                 233,
                                 2,
                                 ProductType.GUIDON,
                                 LocalDate.of(2020, 8, 18));




        Store store = new Store();
    }
}
