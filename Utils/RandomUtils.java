package Utils;

public class RandomUtils {
    public static int GetRandomNumber(int min, int max) {
        return (int) (min + (Math.random() * (max - min)));
    }

}
