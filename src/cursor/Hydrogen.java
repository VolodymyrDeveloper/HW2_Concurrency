package cursor;

import java.util.concurrent.atomic.AtomicInteger;

public class Hydrogen implements Runnable {

    public static AtomicInteger hydrogenCounter = new AtomicInteger();

    public Hydrogen() {
    }

    @Override
    public void run() {
        System.out.print("H");
    }
}
