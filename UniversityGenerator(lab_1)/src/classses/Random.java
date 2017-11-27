package classses;
import java.util.concurrent.ThreadLocalRandom;

public class Random {
    public int getRandomNumber(int min,int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
