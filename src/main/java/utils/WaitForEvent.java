package utils;

public abstract class WaitForEvent {

    public static void sleep(long waitingTime) {
        long start = System.currentTimeMillis();
        long passedTime;
        do {
            passedTime = System.currentTimeMillis() - start;
        }
        while (waitingTime > passedTime);
    }
}
