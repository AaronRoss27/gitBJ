import java.util.*;
import java.util.concurrent.*;

public class Main{

    public static int dealCards(int amount){
        int total = 0;
        for(int i = 1; i <= amount; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(4,11);
            total += randomNum;
        }
        return total;
    }
    public static void main(String[] args){
        System.out.println(dealCards(2));
    }
}
