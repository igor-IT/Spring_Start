package patterns;

import java.util.Random;

public class DBUtils {
   private static Random r = new Random();
    public static int getMailCode() {
        return r.nextInt(2)+1;
    }
}
