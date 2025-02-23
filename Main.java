import java.util.*;
import java.util.concurrent.*;



public class Main {


    //Deals a random card
    static int deal(){
        int card = ThreadLocalRandom.current().nextInt(4,11);
        return card;
    }

    //Deals 2 cards
    static int initialDeal(){
        int playerTotal = 0;
        for(int i = 0; i< 2; i++){
            playerTotal += deal();
        }
        return playerTotal;
    }

    
    //checks if the hand busted
    static boolean isBusted(int total){
        if(total > 21){
            return true;
        }else{
            return false;
        }
    }
    
    //checks if the hand equals blackjack 
    static boolean blackJack(int total){
        if(total==21){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int playerTotal = initialDeal();
        int dealerTotal = initialDeal();

        while(true){
            playerTotal = initialDeal();
            dealerTotal = initialDeal();
            System.out.println("New Game!");
            System.out.println("Your total: " + playerTotal);
            if(playerTotal == 21){
                System.out.println("Blackjack!");
                continue;
            }else{
                while(true){
                    System.out.println("1 for Hit or 2 for Stand");
                    int choice = scanner.nextInt();
                    if(choice==1){ //hit
                        playerTotal += deal();
                        System.out.println("Total: " + playerTotal);
                        if(blackJack(playerTotal)){
                            System.out.println("Blackjack!");
                            break;
                        }else if(isBusted(playerTotal)){
                            System.out.println("BUSTED!");
                            break;
                        }else{
                            continue;
                        }

                    }else{//Stand
                        System.out.println("Dealers hand: " + dealerTotal);
                        if(dealerTotal == 21){
                            System.out.println("Blackjack! You lost!");
                            break;
                        }else if(playerTotal == dealerTotal){
                            System.out.println("Push!");
                            break;
                        }else{
                            while(dealerTotal < playerTotal && dealerTotal < 21){
                                dealerTotal += deal();
                                System.out.println("Dealer Hits!");
                                System.out.println("Dealer Total: " + dealerTotal);
                                if(dealerTotal > 21){
                                    System.out.println("Dealer BUSTED! You win!");
                                    break;
                                }else if(blackJack(dealerTotal)){
                                    System.out.println("Blackjack! You lost!");
                                    break;
                                }else if(dealerTotal > playerTotal && !blackJack(dealerTotal) && !isBusted(dealerTotal)){
                                    System.out.println("You lost!");
                                    break;
                                }
                            }
                        }
                    }
                    break; //leaves Hit or Stand
                }
            }
        }
    }
}