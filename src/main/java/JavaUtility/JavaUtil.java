package JavaUtility;

import java.time.LocalDate;
import java.util.Random;

public class JavaUtil {
	public static int generateRandomNumber(int i) {
		Random random = new Random();
		return random.nextInt(i);	
	}
	public static String getCurrentDate() {
		LocalDate edate = LocalDate.now();
		return edate.toString();
	}
	public static String getNextDate() {
		LocalDate ndate=  LocalDate.now();
		 return ndate.plusDays(20).toString();
		
	}
}