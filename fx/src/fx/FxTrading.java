/**
 * 
 */
package fx;

/**
 * @author dp
 *
 */
import java.util.Scanner;
import java.util.ArrayList;
class Trade{
    String name;
    int amnt;
    String rate;
    String currencyPair;
}
public class FxTrading {
 static ArrayList<Trade> arr=new ArrayList<Trade>();
    static Double rateOfInterset_USDINR=66.00;
    public static void main(String[] args) {
        while(true){
        Scanner scan=new Scanner(System.in);
        System.out.println(" l Book Trade -1\n l Print Trades - 2\n l Exit - 3");
        int option=scan.nextInt();
        if(option==1){
            Trade temp=new Trade();
            System.out.println("Enter customer Name");
            temp.name=scan.next();
            scan.nextLine();
            System.out.println("Enter Currency Pair");
            temp.currencyPair=scan.next();
            if(!temp.currencyPair.equals("USDINR")){
                System.out.println("Invalid Input");
            }
            else{
            System.out.println("Enter amount to transfer");
            temp.amnt=scan.nextInt();
            System.out.println("Do you want to get Rate");
            temp.rate=scan.next();
            scan.nextLine();
            // System.out.println();
            System.out.println("You are transferring INR"+(temp.amnt*rateOfInterset_USDINR)+"to "+temp.name);
            System.out.println("Book/Cancel this trade?");
            String book_cancel=scan.next();
            if(book_cancel.equals("Book")){
                arr.add(temp);
                System.out.println("Trade for "+temp.currencyPair+" has been booked with rate"+rateOfInterset_USDINR+",The amount of Rs"+(temp.amnt*rateOfInterset_USDINR)+"will be transferred in 2 working days to "+temp.name);
            }
            else{
                System.out.println("Trade is Canceled.");
            }
        }
        }
        else if(option==2){
            System.out.println("TradeNo\tCurrencyPair\tCustomerName\tAmount\tRate");
            for(int iterI=0;iterI<arr.size();iterI++){
                Trade temp=arr.get(iterI);
                System.out.println((iterI+1)+"\t\t"+temp.currencyPair+"\t\t"+temp.currencyPair+"\t\t"+(temp.amnt*rateOfInterset_USDINR)+"\t\t"+rateOfInterset_USDINR);
            }
        }
        else{
            System.out.println("Do you really want to exit (y/n)");
            char opt=scan.next().charAt(0);
            if(opt=='Y'){
                System.out.println("Bye - have a good day");
                break;
            }
        }
    }
}
}