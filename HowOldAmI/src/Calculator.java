import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

public class Calculator {
	
	Date date1,date2;
	
	public Calculator(Date date1, Date date2) {
		super();
		this.date1 = date1;
		this.date2 = date2;
	}
	
	private long toPositive(long a) {
		if (a < 0)
			return a = a * -1;
		return a;
	}
	
	public static Calendar getCal(Date date) {
	    Calendar cal = Calendar.getInstance(Locale.US);
	    cal.setTime(date);
	    return cal;
	}

	private long getDateDiff(TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}
	
	public void calculateYears(JLabel label) {
		label.setEnabled(true);
		
		
		Calendar a = getCal(date1);
	    Calendar b = getCal(date2);
	    
	    int YEAR = Calendar.YEAR;
	    int MONTH = Calendar.MONTH;
	    int DATE = Calendar.DATE;
		
		int diff = b.get(YEAR) - a.get(YEAR);
	    if (a.get(MONTH) > b.get(MONTH) || 
	        (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
	        diff--;
	    }
	    //return diff;
	    label.setText(diff+"");
		
	}
	
	public void calculateDays(JLabel label) {
		label.setEnabled(true);
		long answer = toPositive(getDateDiff(TimeUnit.DAYS));
		label.setText(answer+"");
	}
	
	public void calculateHours(JLabel label) {
		label.setEnabled(true);
		long answer = toPositive(getDateDiff(TimeUnit.HOURS));
		label.setText(answer+"");
	}
	
	public void calculateMinutes(JLabel label) {
		label.setEnabled(true);
		long answer = toPositive(getDateDiff(TimeUnit.MINUTES));
		label.setText(answer+"");
	}
	
	public void calculateSeconds(JLabel label) {
		label.setEnabled(true);
		long answer = toPositive(getDateDiff(TimeUnit.SECONDS));
		label.setText(answer+"");
	}

	public void calculateMiliseconds(JLabel label) {
		label.setEnabled(true);
		long answer = toPositive(getDateDiff(TimeUnit.MILLISECONDS));
		label.setText(answer+"");
	}
}
