package cursor;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {

    private static Semaphore semaphore;
    private static int moleculs = 0;

    public static void main(String[] args) throws InterruptedException {
        String inputData = "HOHHHO";
        moleculs = inputData.length() / 3;
        semaphore = new Semaphore(inputData.length());
        Random random = new Random();
        do {
            if (random.nextInt(2) == 1) {
                releaseHydrogen();
            } else {
                releaseOxygen();
            }
            if (semaphore.availablePermits() == 0) {
                semaphore.release(inputData.length());
            }
        } while (inputData.length() != Hydrogen.hydrogenCounter.get() + Oxygen.oxygenCounter.get());
    }

    private static void releaseOxygen() throws InterruptedException {
        if (Oxygen.oxygenCounter.get() != moleculs) {
            semaphore.acquire();
            Oxygen.oxygenCounter.incrementAndGet();
            new Thread(new Oxygen()).start();
        }
    }

    private static void releaseHydrogen() throws InterruptedException {
        if (Hydrogen.hydrogenCounter.get() != moleculs * 2) {
            semaphore.acquire();
            Hydrogen.hydrogenCounter.incrementAndGet();
            new Thread(new Hydrogen()).start();
        }
    }

}
