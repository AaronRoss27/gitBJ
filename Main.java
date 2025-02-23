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

    public static boolean isBlackJack(int total){
        if(total == 21){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isBust(int total){
        if(total > 21){
            return true;
        }else{
            return false;
        }
    }




    public static void main(String[] args){
        
        int playerTotal = 0;
        int dealerTotal = 0;
        
    }
}
