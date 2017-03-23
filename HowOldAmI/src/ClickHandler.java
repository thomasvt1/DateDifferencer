import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClickHandler {

	private FrameTools tools;

	private JTextField north_day;
	private JTextField north_month;
	private JTextField north_year;

	private JTextField south_day;
	private JTextField south_month;
	private JTextField south_year;

	private JLabel response_year;
	private JLabel response_day;
	private JLabel response_hour;
	private JLabel response_seconds;
	private JLabel response_miliseconds;

	private JCheckBox check_year;
	private JCheckBox check_day;
	private JCheckBox check_hour;
	private JCheckBox check_seconds;
	private JCheckBox check_miliseconds;

	private JLabel error;

	public ClickHandler(JFrame frame) {
		super();
		tools = new FrameTools(frame);
		fillFields();
		error.setVisible(false);
	}

	void fillFields() {
		north_day = (JTextField) tools.getComponentByName("north_day");
		north_month = (JTextField) tools.getComponentByName("north_month");
		north_year = (JTextField) tools.getComponentByName("north_year");

		south_day = (JTextField) tools.getComponentByName("south_day");
		south_month = (JTextField) tools.getComponentByName("south_month");
		south_year = (JTextField) tools.getComponentByName("south_year");

		response_year = (JLabel) tools.getComponentByName("response_year");
		response_day = (JLabel) tools.getComponentByName("response_day");
		response_hour = (JLabel) tools.getComponentByName("response_hour");
		response_seconds = (JLabel) tools.getComponentByName("response_seconds");
		response_miliseconds = (JLabel) tools.getComponentByName("response_miliseconds");

		check_year = (JCheckBox) tools.getComponentByName("check_year");
		check_day = (JCheckBox) tools.getComponentByName("check_day");
		check_hour = (JCheckBox) tools.getComponentByName("check_hour");
		check_seconds = (JCheckBox) tools.getComponentByName("check_seconds");
		check_miliseconds = (JCheckBox) tools.getComponentByName("check_miliseconds");

		error = (JLabel) tools.getComponentByName("error");
	}

	private boolean fieldLengthNull(JTextField tf) {
		return tf.getText().length() == 0;
	}

	boolean southEmpty() {
		if (south_day == null || south_month == null || south_year == null)
			return true;
		if (fieldLengthNull(south_day) || fieldLengthNull(south_month) || fieldLengthNull(south_year))
			return true;
		return false;
	}

	boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	boolean dataValid(String year, String month, String day) {
		if (year.length() == 0 || month.length() == 0 || day.length() == 0)
			return false;
		if (!isInt(year) || !isInt(month) || !isInt(day))
			return false;
		return true;
	}

	/*
	private void debugComponents(List<Component> components) {
		for (Component c : components) {
			if (c.getName() != null)
				System.out.println(c.getName());
		}
	}
	*/

	private DateTools getNorthDate() {
		int i_north_year = Integer.parseInt(north_year.getText());
		int i_north_month = Integer.parseInt(north_month.getText());
		int i_north_day = Integer.parseInt(north_day.getText());

		DateTools north = new DateTools(i_north_year, i_north_month, i_north_day);
		return north;
	}

	private DateTools getSouthDate() {
		int i_south_year = Integer.parseInt(south_year.getText());
		int i_south_month = Integer.parseInt(south_month.getText());
		int i_south_day = Integer.parseInt(south_day.getText());

		DateTools north = new DateTools(i_south_year, i_south_month, i_south_day);
		return north;
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("Button clicked!");

		if (southEmpty()) {
			System.out.println("South empty!");
			LocalDateTime date = LocalDateTime.now();
			south_day.setText(date.getDayOfMonth() + "");
			south_month.setText(date.getMonthValue() + "");
			south_year.setText(date.getYear() + "");
		}

		if (!dataValid(north_year.getText(), north_month.getText(), north_day.getText())) {
			System.out.println("No date entered!");
			error.setText("Please enter a date");
			error.setVisible(true);
			return;
		}

		DateTools north = getNorthDate();
		DateTools south = getSouthDate();

		if (!(north.isValidDate() && south.isValidDate())) {
			System.out.println("DATE NOT VALIDOS");
			error.setText("Date entered not valid");
			error.setVisible(true);
			return;
		}

		handleCalculate(north.getDateResetHourMinSec(), south.convertToDate());
	}

	private void handleCalculate(Date date1, Date date2) {

		Calculator calc = new Calculator(date1, date2);

		// Calculate days
		if (check_day.isSelected())
			calc.calculateDays(response_day);
		else {
			response_day.setText("-");
			response_day.setEnabled(false);
		}
		// Calculate years
		if (check_year.isSelected())
			calc.calculateYears(response_year);
		else {
			response_year.setText("-");
			response_year.setEnabled(false);
		}
		// Calculate hours
		if (check_hour.isSelected())
			calc.calculateHours(response_hour);
		else {
			response_hour.setText("-");
			response_hour.setEnabled(false);
		}

		// Calculate seconds
		if (check_seconds.isSelected())
			calc.calculateSeconds(response_seconds);
		else {
			response_seconds.setText("-");
			response_seconds.setEnabled(false);
		}

		// Calculate milliseconds
		if (check_miliseconds.isSelected())
			calc.calculateMiliseconds(response_miliseconds);
		else {
			response_miliseconds.setText("-");
			response_miliseconds.setEnabled(false);
		}
	}
}