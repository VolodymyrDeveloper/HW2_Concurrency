package cursor;

import java.util.concurrent.atomic.AtomicInteger;

public class Oxygen implements Runnable {

    public static AtomicInteger oxygenCounter = new AtomicInteger();

    public Oxygen() {
    }

    @Override
    public void run() {
        System.out.print("O");
    }
}
