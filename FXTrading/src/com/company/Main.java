package com.company;
import java.util.Scanner;
import java.util.ArrayList;
class Trade{
    String name;
    float Amount;
    String rate;
    String currencyPair;
}
public class Main {

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
                if(!temp.currencyPair.equals("USDINR")&&!temp.currencyPair.equals("usdinr")){
                    System.out.println("Invalid Input");
                }
                else{
                    System.out.println("Enter amount to transfer");
                    temp.Amount=scan.nextInt();
                    System.out.println("Do you want to get Rate");
                    temp.rate=scan.next();
                    scan.nextLine();
                    if ( temp.rate.equals("Yes") ||  temp.rate.equals("yes") ||  temp.rate.equals("YES")) {
                        System.out.println("You are transferring INR" + (temp.Amount * rateOfInterset_USDINR) + "to " + temp.name);
                    }
                    System.out.println("Book/Cancel this trade?");
                    System.out.println("1 : Book");
                    System.out.println("2 : Cancel");
                    int book = scan.nextInt();
                    switch (book) {
                        case 1 :
                                {
                                    arr.add(temp);
                                    System.out.println("Trade for "+temp.currencyPair+" has been booked with rate"+rateOfInterset_USDINR+",The amount of Rs"+(temp.Amount*rateOfInterset_USDINR)+"will be transferred in 2 working days to "+temp.name);
                                break;
                                }
                        case 2 : {
                            System.out.println("Trade is Canceled.\n");
                            break;
                        }
                        default : {
                            System.out.println("Invalid Option!! Please Enter Correct Option...");
                            break;
                        }
                    }
                }
            }
            else if(option==2){
                System.out.println("TradeNo\tCurrencyPair\tCustomerName\tAmount\tRate");
                for(int iterI=0;iterI<arr.size();iterI++){
                    Trade temp=arr.get(iterI);
                    System.out.println((iterI+1)+"\t\t"+temp.currencyPair+"\t\t"+temp.name+"\t\t"+"INR"+(temp.Amount*rateOfInterset_USDINR)+"\t\t"+rateOfInterset_USDINR);
                }
            }
            else{
                System.out.println("Do you really want to exit (y/n)");
                char opt=scan.next().charAt(0);
                if(opt=='Y'||opt=='y'){
                    System.out.println("Bye - have a good day");
                    break;
                }
            }
        }
    }
}