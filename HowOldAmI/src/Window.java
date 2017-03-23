import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Component;

public class Window {

	private JFrame frame;
	
	public HashMap<String, Component> componentMap = new HashMap<String, Component>();
	

	/**
	 * Launch the application.
	 */
	public void launchWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 518, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_left = new JPanel();
		frame.getContentPane().add(panel_left, BorderLayout.WEST);
		panel_left.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_north = new JPanel();
		panel_left.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_north_day = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_north_day.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_north.add(panel_north_day, BorderLayout.NORTH);
		
		JLabel lblDay = new JLabel("Day");
		panel_north_day.add(lblDay);
		
		JTextField north_day = new JTextField();
		panel_north_day.add(north_day);
		north_day.setName("north_day");
		north_day.setColumns(10);
		
		JPanel panel_north_month = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_north_month.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_north.add(panel_north_month, BorderLayout.WEST);
		
		JLabel label_2 = new JLabel("Month");
		panel_north_month.add(label_2);
		
		JTextField north_month = new JTextField();
		north_month.setColumns(10);
		north_month.setName("north_month");
		panel_north_month.add(north_month);
		
		JPanel panel_north_year = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_north_year.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_north.add(panel_north_year, BorderLayout.SOUTH);
		
		JLabel label_3 = new JLabel("Year");
		panel_north_year.add(label_3);
		
		JTextField north_year = new JTextField();
		north_year.setColumns(10);
		north_year.setName("north_year");
		panel_north_year.add(north_year);
		
		JPanel panel_south = new JPanel();
		panel_left.add(panel_south, BorderLayout.SOUTH);
		panel_south.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_south_day = new JPanel();
		panel_south.add(panel_south_day, BorderLayout.NORTH);
		
		JLabel label_1 = new JLabel("Day");
		panel_south_day.add(label_1);
		
		JTextField south_day = new JTextField();
		south_day.setColumns(10);
		south_day.setName("south_day");
		panel_south_day.add(south_day);
		
		JPanel panel_south_month = new JPanel();
		panel_south.add(panel_south_month, BorderLayout.WEST);
		
		JLabel label_5 = new JLabel("Month");
		panel_south_month.add(label_5);
		
		JTextField south_month = new JTextField();
		south_month.setColumns(10);
		panel_south_month.add(south_month);
		south_month.setName("south_month");
		
		JPanel panel_south_year = new JPanel();
		panel_south.add(panel_south_year, BorderLayout.SOUTH);
		
		JLabel label_4 = new JLabel("Year");
		panel_south_year.add(label_4);
		
		JTextField south_year = new JTextField();
		south_year.setColumns(10);
		south_year.setName("south_year");
		panel_south_year.add(south_year);
		
		JPanel panel_center_1 = new JPanel();
		panel_left.add(panel_center_1, BorderLayout.CENTER);
		panel_center_1.setLayout(new MigLayout("", "[][]", "[][][]"));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Jaren");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setName("check_year");
		panel_center_1.add(chckbxNewCheckBox, "cell 0 0");
		
		JCheckBox chckbxSeconden = new JCheckBox("Seconden");
		chckbxSeconden.setSelected(true);
		chckbxSeconden.setName("check_seconds");
		panel_center_1.add(chckbxSeconden, "cell 1 0");
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Dagen");
		chckbxNewCheckBox_1.setSelected(true);
		chckbxNewCheckBox_1.setName("check_day");
		panel_center_1.add(chckbxNewCheckBox_1, "cell 0 1,aligny baseline");
		
		JCheckBox chckbxMiliseconden = new JCheckBox("Miliseconden");
		chckbxMiliseconden.setSelected(true);
		chckbxMiliseconden.setName("check_miliseconds");
		panel_center_1.add(chckbxMiliseconden, "cell 1 1");
		
		JCheckBox chckbxUren = new JCheckBox("Uren");
		chckbxUren.setSelected(true);
		chckbxUren.setName("check_hour");
		panel_center_1.add(chckbxUren, "cell 0 2");
		
		JPanel panel_right = new JPanel();
		frame.getContentPane().add(panel_right, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ClickHandler(frame).mouseClicked(e);
			}
		});
		panel_right.add(btnNewButton);
		
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_center.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[][]", "[][][][][]"));
		
		JLabel lblJaren = new JLabel("Jaren");
		panel_1.add(lblJaren, "cell 0 0");
		
		JLabel jaren = new JLabel("-");
		jaren.setEnabled(false);
		jaren.setName("response_year");
		panel_1.add(jaren, "cell 1 0");
		
		JLabel lblDagen = new JLabel("Dagen");
		panel_1.add(lblDagen, "cell 0 1");
		
		JLabel dagen = new JLabel("-");
		dagen.setEnabled(false);
		dagen.setName("response_day");
		panel_1.add(dagen, "cell 1 1");
		
		JLabel lblUren = new JLabel("Uren");
		panel_1.add(lblUren, "cell 0 2");
		
		JLabel uren = new JLabel("-");
		uren.setEnabled(false);
		uren.setName("response_hour");
		panel_1.add(uren, "cell 1 2");
		
		JLabel lblSeconden = new JLabel("Seconden");
		panel_1.add(lblSeconden, "cell 0 3");
		
		JLabel seconden = new JLabel("-");
		seconden.setEnabled(false);
		seconden.setName("response_seconds");
		panel_1.add(seconden, "cell 1 3");
		
		JLabel lblMiliseconden = new JLabel("Miliseconden");
		panel_1.add(lblMiliseconden, "cell 0 4");
		
		JLabel miliseconden = new JLabel("-");
		miliseconden.setEnabled(false);
		miliseconden.setName("response_miliseconds");
		panel_1.add(miliseconden, "cell 1 4");
		
		JPanel panel = new JPanel();
		panel_center.add(panel, "cell 0 1,grow");
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel error = new JLabel("ERROR");
		error.setForeground(Color.RED);
		error.setName("error");
		error.setVisible(false);
		panel.add(error, BorderLayout.CENTER);
	}

}