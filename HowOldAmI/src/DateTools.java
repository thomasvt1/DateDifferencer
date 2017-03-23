import java.util.Calendar;
import java.util.Date;

public class DateTools {
	
	int year, month, day;
	
	public DateTools(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month - 1;
		this.day = day;
	}

	boolean isValidDate() {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.set(year, month, day);
		try {
		    cal.getTime();
		    return true;
		}
		catch (Exception e) {
		  return false;
		}
	}
	
	Calendar convertToCalc() {
		Calendar calc = Calendar.getInstance();
		calc.set(year, month, day);
		return calc;
	}
	
	Calendar getCalcResetHourMinSec() {
		Calendar calc = convertToCalc();
		calc.set(year, month, day, 0, 0, 0);
		return calc;
	}
	
	Date getDateResetHourMinSec() {
		Calendar calc = getCalcResetHourMinSec();
		return calc.getTime();
	}

	Date convertToDate() {
		Calendar calc = convertToCalc();
		return calc.getTime();
	}
}