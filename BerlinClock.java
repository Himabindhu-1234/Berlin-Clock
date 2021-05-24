package JavaPrograms;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class BerlinClock {
 
	
	    public static String berlinClock(int hours, int minutes, int seconds) {
	        return getSeconds(seconds) + " " + getHours(hours) + " " + getMinutes(minutes);
	    }

	    protected static String getSeconds(int seconds) {
	        return seconds % 2 == 0 ? "Y" : "O";
	    }

	    protected static String getHours(int hours) {
	        int numberTopHourLamps = hours / 5;
	        int numberBottomHourLamps = hours % 5;

	        StringBuilder sb = new StringBuilder();
	        sb.append(getLampRow(4, numberTopHourLamps, "R"))
	                .append(" ")
	                .append(getLampRow(4, numberBottomHourLamps, "R"));

	        return sb.toString();
	    }

	    protected static String getMinutes(int minutes) {
	        int numberTopMinutesLamps = minutes / 5;
	        int numberBottomMinutesLamps = minutes % 5;

	        StringBuilder sb = new StringBuilder();
	        IntStream.rangeClosed(1, 11)
	                .forEach(i -> sb.append(i <= numberTopMinutesLamps ? getMinuteLampColour(i) : "O"));

	        sb.append(" ");

	        sb.append(getLampRow(4, numberBottomMinutesLamps, "Y"));

	        return sb.toString();
	    }

	    private static String getLampRow(int totalNumberLamps, int numberLampsOn, String lampSymbol) {
	        StringBuilder sb = new StringBuilder();
	        IntStream.rangeClosed(1, totalNumberLamps)
	                .forEach(i -> sb.append(i <= numberLampsOn ? lampSymbol : "O"));
	        return sb.toString();
	    }

	    private static String getMinuteLampColour(int index) {
	        return index % 3 == 0 ? "R" : "Y";
	    }
	    public static void main(String[] args)
	    {
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("Enter hours:");
	    	int Hours= sc.nextInt();
	    	System.out.println("Enter minutes :");
	    	int minutes= sc.nextInt();
	    	System.out.println("Enter seconds:");
	    	int sec= sc.nextInt();
	    	System.out.println("output is" +berlinClock(Hours,minutes,sec));
	    	
	    }
	}