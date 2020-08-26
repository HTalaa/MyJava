package GUI;

import static org.junit.jupiter.api.Assertions.*;

class calcTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void div() {
        double res=calc.div(4,0);
      //  assertEquals(true, Double.isInfinite(res), "Divide by zero gives infinity as result");
    }
}