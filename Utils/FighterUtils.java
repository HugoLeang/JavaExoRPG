package Utils;

public class FighterUtils {
    public static int getStatsModificator(int stat) {
        return (int) Math.floor((stat - 10) / 2);
    }
}
