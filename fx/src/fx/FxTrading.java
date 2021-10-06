/**
 * 
 */
package fx;

/**
 * @author dp
 *
 */
import java.util.Scanner;

public class FxTrading {
	public static Scanner scanner = new Scanner(System.in);
	   
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		char close = '\0';
		
		System.out.println("Book Trade - 1 \nPrint Trades - 2 \nExit - 3");
		BookTrade Book=new BookTrade();
		
		int userSelect=scanner.nextInt();
		
		do {
		switch (userSelect){
			case 1:{
				Book.Book();
				
			}
			case 2:
			{
				Book.printTrades();
				
			}
			case 3:
			{
				System.out.println("Do you really want to exit (Y/N)");
                close = scanner.next().charAt(0);  
			}
		}
		}while(close == 'n'|| close == 'N');
		
		 System.out.println("Bye - have a good day");
	}				
}
class BookTrade{
		public static Scanner scanner = new Scanner(System.in);
		public static final double getRate = 66.00;
		public static String customerName="";
		public static String currencyPair="";
		public static double rupees;
		public static String rate="";
	    public BookTrade() {}
	    public BookTrade(String name, String currencyPair, double rupees, String rate) {
	        this.customerName = name;
	        this.currencyPair = currencyPair;
	        this.rupees = rupees;
	        this.rate = rate;
	    }
	public static void Book() {
		 	System.out.println("Enter customer Name");
	        customerName = scanner.next();
	        System.out.println("Enter Currency Pair");
	        currencyPair = scanner.next();
	        if((currencyPair.equals("USDINR")) || (currencyPair.equals("usdinr"))){
	            System.out.println("Enter amount to transfer");
	            long amountToTransfer = scanner.nextInt();
	            convertUSDtoINR(amountToTransfer);
	            System.out.println("Do you want to get Rate");
	            rate = scanner.next();
	            if (rate.equals("yes") || rate.equals("YES")){
	              getRatePrint();
	            }
	        }
	        System.out.println("\nBook/Cancel this trade?");
	        System.out.println("1 : Book");
	        System.out.println("2 : Cancel");
	        int book = scanner.nextInt();
	        switch (book) {
	            case 1 : System.out.println("Trade for USDINR has been booked with rate " + getRate + ", The amount of Rs " + rupees + " will be transferred in 2 working days to " + customerName + ".");
	            case 2 : System.out.println("Trade is Canceled.\n");
	            default : System.out.println("Invalid Option!! Please Enter Correct Option...");
	}
}
	public static void convertUSDtoINR(long amountToTransfer){
	        rupees = amountToTransfer * getRate;
	    }
	public static  void getRatePrint(){
	        System.out.println("You are transferring INR " + rupees + " to " + customerName);
	    }

	public static  void printTrades(){
	        System.out.println(" TradeNo\t CurrencyPair\t CustomerName\t Amount\t\t\t Rate ");
	        System.out.println("\t" + "1" + "\t\t\t" + currencyPair + "\t\t\t" + customerName + "\t\tINR" + rupees + "\t\t" + getRate);
	    }
}
