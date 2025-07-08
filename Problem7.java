// Convert Bar to Kpa(Kilopascal).
import java.util.*;

abstract class Conversion {
    abstract void convert(double bar);
}

class barTokpa extends Conversion {
    double kpa;

    barTokpa() {
        super();
    }

    @Override
    void convert(double bar) {
        this.kpa = bar * 100;
        System.out.println(bar+" bar is equal to "+ this.kpa + " kpa.");
    }
}

public class Problem7 {
    public static void main(String []args) {
        barTokpa con = new barTokpa();
        con.convert(6);
    }
}
