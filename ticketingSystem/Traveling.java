package ticketingSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Traveling {

	private JFrame frame;
	private JTextField txtTax;
	private JTextField txtSubTotal;
	private JTextField txtTotal;
	private JTextField txtClass;
	private JTextField txtTicket;
	private JTextField txtAdult;
	private JTextField txtChild;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtTicketNo;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtPrice;
	private JTextField txtRoute;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traveling window = new Traveling();
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
	public Traveling() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1370, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(51, 49, 624, 69);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Traveling Ticketing Systems");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		JLabel lblClass = new JLabel("Ticket Type");
		lblClass.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblClass.setBounds(19, 161, 656, 47);
		frame.getContentPane().add(lblClass);
		
		JRadioButton rdbtnStandard = new JRadioButton("Standard");
		rdbtnStandard.setBounds(21, 220, 141, 23);
		frame.getContentPane().add(rdbtnStandard);
		
		JRadioButton rdbtnEconomy = new JRadioButton("Economy");
		rdbtnEconomy.setBounds(19, 274, 141, 23);
		frame.getContentPane().add(rdbtnEconomy);
		
		JRadioButton rdbtnFirstClass = new JRadioButton("First Class");
		rdbtnFirstClass.setBounds(19, 329, 141, 23);
		frame.getContentPane().add(rdbtnFirstClass);
		
		JRadioButton rdbtnReturnTicket = new JRadioButton("Return Ticket");
		rdbtnReturnTicket.setBounds(283, 329, 141, 23);
		frame.getContentPane().add(rdbtnReturnTicket);
		
		JRadioButton rdbtnSingleTicket = new JRadioButton("Single Ticket");
		rdbtnSingleTicket.setBounds(283, 274, 141, 23);
		frame.getContentPane().add(rdbtnSingleTicket);
		
		JRadioButton rdbtnAdult = new JRadioButton("Adult");
		rdbtnAdult.setBounds(505, 274, 141, 23);
		frame.getContentPane().add(rdbtnAdult);
		
		JRadioButton rdbtnChild = new JRadioButton("Child");
		rdbtnChild.setBounds(505, 329, 141, 23);
		frame.getContentPane().add(rdbtnChild);
		
		JComboBox cmbDestination = new JComboBox();
		cmbDestination.setModel(new DefaultComboBoxModel(new String[] {"Destination", "Kilburn", "Preston", "Oxford", "Leed"}));
		cmbDestination.setBounds(128, 219, 547, 29);
		frame.getContentPane().add(cmbDestination);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(19, 475, 61, 16);
		frame.getContentPane().add(lblTax);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setBounds(19, 539, 61, 16);
		frame.getContentPane().add(lblSubtotal);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(19, 585, 61, 16);
		frame.getContentPane().add(lblTotal);
		
		txtTax = new JTextField();
		txtTax.setBounds(128, 470, 130, 26);
		frame.getContentPane().add(txtTax);
		txtTax.setColumns(10);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBounds(128, 534, 130, 26);
		frame.getContentPane().add(txtSubTotal);
		txtSubTotal.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(128, 580, 130, 26);
		frame.getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnNewButton = new JButton("Total");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double tax =8.2;
				double MilesK8=25.8;
				double MilesK12=35.40;
				double MilesK20=43.2;
				double MilesK30=50.8;
				double tot,eco=3.85,fclass=5.6;
				if((rdbtnStandard.isSelected())&&rdbtnSingleTicket.isSelected()&&rdbtnAdult.isSelected() && cmbDestination.getSelectedItem().equals("Kilburn")) {
					tot=(tax*MilesK8)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK8);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", MilesK8+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}else if((rdbtnStandard.isSelected())&&rdbtnReturnTicket.isSelected()&&rdbtnAdult.isSelected() && cmbDestination.getSelectedItem().equals("Kilburn")) {
					tot=(tax*MilesK8*2)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK8*2);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", (2*MilesK8)+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}else if((rdbtnStandard.isSelected())&&rdbtnSingleTicket.isSelected()&&rdbtnChild.isSelected() && cmbDestination.getSelectedItem().equals("Kilburn")) {
					tot=(tax*MilesK8)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK8);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", MilesK8+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NULL");
					txtChild.setText("ONE");
				}else if((rdbtnStandard.isSelected())&&rdbtnReturnTicket.isSelected()&&rdbtnChild.isSelected() && cmbDestination.getSelectedItem().equals("Kilburn")) {
					tot=(tax*MilesK8 *2)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK8 *2);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", (2*MilesK8)+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}
				else if((rdbtnStandard.isSelected())&&rdbtnSingleTicket.isSelected()&&rdbtnAdult.isSelected() && cmbDestination.getSelectedItem().equals("Preston")) {
					tot=(tax*MilesK12)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK12);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", MilesK12+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}else if((rdbtnStandard.isSelected())&&rdbtnReturnTicket.isSelected()&&rdbtnAdult.isSelected() && cmbDestination.getSelectedItem().equals("Preston")) {
					tot=(tax*MilesK12*2)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK12*2);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", (2*MilesK12)+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}else if((rdbtnStandard.isSelected())&&rdbtnSingleTicket.isSelected()&&rdbtnChild.isSelected() && cmbDestination.getSelectedItem().equals("Preston")) {
					tot=(tax*MilesK12)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK12);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", MilesK12+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NULL");
					txtChild.setText("ONE");
				}else if((rdbtnStandard.isSelected())&&rdbtnReturnTicket.isSelected()&&rdbtnChild.isSelected() && cmbDestination.getSelectedItem().equals("Preston")) {
					tot=(tax*MilesK12 *2)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK12 *2);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", (2*MilesK12)+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}
				else if((rdbtnStandard.isSelected())&&rdbtnSingleTicket.isSelected()&&rdbtnAdult.isSelected() && cmbDestination.getSelectedItem().equals("Oxford")) {
					tot=(tax*MilesK20)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK20);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", MilesK20+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}else if((rdbtnStandard.isSelected())&&rdbtnReturnTicket.isSelected()&&rdbtnAdult.isSelected() && cmbDestination.getSelectedItem().equals("Oxford")) {
					tot=(tax*MilesK20*2)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK20*2);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", (2*MilesK20)+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}else if((rdbtnStandard.isSelected())&&rdbtnSingleTicket.isSelected()&&rdbtnChild.isSelected() && cmbDestination.getSelectedItem().equals("Oxford")) {
					tot=(tax*MilesK20)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK20);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", MilesK20+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NULL");
					txtChild.setText("ONE");
				}else if((rdbtnStandard.isSelected())&&rdbtnReturnTicket.isSelected()&&rdbtnChild.isSelected() && cmbDestination.getSelectedItem().equals("Oxford")) {
					tot=(tax*MilesK20 *2)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK20 *2);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", (2*MilesK20)+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}
				else if((rdbtnStandard.isSelected())&&rdbtnSingleTicket.isSelected()&&rdbtnAdult.isSelected() && cmbDestination.getSelectedItem().equals("Leed")) {
					tot=(tax*MilesK30)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK30);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", MilesK30+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}else if((rdbtnStandard.isSelected())&&rdbtnReturnTicket.isSelected()&&rdbtnAdult.isSelected() && cmbDestination.getSelectedItem().equals("Leed")) {
					tot=(tax*MilesK30*2)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK30*2);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", (2*MilesK30)+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NULL");
				}else if((rdbtnStandard.isSelected())&&rdbtnSingleTicket.isSelected()&&rdbtnChild.isSelected() && cmbDestination.getSelectedItem().equals("Leed")) {
					tot=(tax*MilesK30)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK30);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", MilesK30+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NULL");
					txtChild.setText("ONE");
				}else if((rdbtnStandard.isSelected())&&rdbtnReturnTicket.isSelected()&&rdbtnChild.isSelected() && cmbDestination.getSelectedItem().equals("Leed")) {
					tot=(tax*MilesK30 *2)/100;
					String sTax=String.format("$%.2f", tot);
					txtTax.setText(sTax);
					String sSub=String.format("$%.2f", MilesK30 *2);
					txtSubTotal.setText(sSub);
					String sTot=String.format("$%.2f", (2*MilesK30)+tot);
					txtTotal.setText(sTot);
					txtPrice.setText(sTot);
					txtClass.setText("STD");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NULL");
					txtChild.setText("ONE");
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Time
				Calendar timer= Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime= new SimpleDateFormat("HH:mm:ss");
				txtTime.setText(tTime.format(timer.getTime()));
				//Date
				SimpleDateFormat tDate = new SimpleDateFormat("dd-MM-yyyy");
				txtDate.setText(tDate.format(timer.getTime()));
				//set default from (location)
				txtFrom.setText("*London");
				txtTo.setText("*"+(String) cmbDestination.getSelectedItem()+ "");
				//random numbere generator
				int num;
				String q1="";
				num=1325 +(int) (Math.random()*4238);
				q1+=num+1325;
				//set ticket number
				txtTicketNo.setText(q1);
				//set route
				txtRoute.setText("ANY");
			}
		});
		btnNewButton.setToolTipText("Total Cost of Ticket");
		btnNewButton.setBounds(51, 631, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("reset");
		btnNewButton_1.setToolTipText("Reset System");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				rdbtnAdult.setSelected(false);
				rdbtnChild.setSelected(false);
				rdbtnStandard.setSelected(false);
				rdbtnEconomy.setSelected(false);
				rdbtnFirstClass.setSelected(false);
				cmbDestination.setSelectedItem("Destination");
				rdbtnSingleTicket.setSelected(false);
				rdbtnReturnTicket.setSelected(false);
				txtTo.setText(null);
				txtFrom.setText(null);
				txtDate.setText(null);
				txtTime.setText(null);
				txtPrice.setText(null);
				txtRoute.setText(null);
				txtChild.setText(null);
				txtClass.setText(null);
				txtAdult.setText(null);
				txtTicketNo.setText(null);
				txtTicket.setText(null);
				
			}
		});
		btnNewButton_1.setBounds(211, 631, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("exit");
		btnNewButton_2.setToolTipText("Exit System");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to eixt","Ticketing Systems", 
					JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setBounds(387, 631, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(669, 196, -649, 12);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(19, 389, 656, 12);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(19, 613, 656, 12);
		frame.getContentPane().add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(19, 196, 656, 12);
		frame.getContentPane().add(separator_1_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(712, 43, 12, 609);
		frame.getContentPane().add(separator_2);
		
		txtClass = new JTextField();
		txtClass.setColumns(10);
		txtClass.setBounds(781, 219, 79, 26);
		frame.getContentPane().add(txtClass);
		
		txtTicket = new JTextField();
		txtTicket.setColumns(10);
		txtTicket.setBounds(901, 219, 79, 26);
		frame.getContentPane().add(txtTicket);
		
		txtAdult = new JTextField();
		txtAdult.setColumns(10);
		txtAdult.setBounds(1022, 219, 79, 26);
		frame.getContentPane().add(txtAdult);
		
		txtChild = new JTextField();
		txtChild.setColumns(10);
		txtChild.setBounds(1147, 219, 79, 26);
		frame.getContentPane().add(txtChild);
		
		JLabel lblClass_1 = new JLabel("Class");
		lblClass_1.setBounds(781, 161, 79, 23);
		frame.getContentPane().add(lblClass_1);
		
		JLabel lblTax_1_1 = new JLabel("Ticket");
		lblTax_1_1.setBounds(901, 161, 79, 23);
		frame.getContentPane().add(lblTax_1_1);
		
		JLabel lblTax_1_2 = new JLabel("Adult");
		lblTax_1_2.setBounds(1022, 161, 79, 23);
		frame.getContentPane().add(lblTax_1_2);
		
		JLabel lblTax_1_3 = new JLabel("Child");
		lblTax_1_3.setBounds(1147, 161, 79, 23);
		frame.getContentPane().add(lblTax_1_3);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(751, 196, 490, 11);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(751, 256, 490, 11);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(1288, 161, -28, 418);
		frame.getContentPane().add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(1272, 161, 18, 491);
		frame.getContentPane().add(separator_6);
		
		JLabel lblClass_1_1 = new JLabel("From");
		lblClass_1_1.setBounds(781, 278, 79, 23);
		frame.getContentPane().add(lblClass_1_1);
		
		JLabel lblClass_1_2 = new JLabel("To");
		lblClass_1_2.setBounds(781, 353, 79, 23);
		frame.getContentPane().add(lblClass_1_2);
		
		JLabel lblClass_1_3 = new JLabel("Ticket No.");
		lblClass_1_3.setBounds(1073, 356, 79, 23);
		frame.getContentPane().add(lblClass_1_3);
		
		txtFrom = new JTextField();
		txtFrom.setColumns(10);
		txtFrom.setBounds(860, 273, 105, 26);
		frame.getContentPane().add(txtFrom);
		
		txtTo = new JTextField();
		txtTo.setColumns(10);
		txtTo.setBounds(860, 351, 105, 26);
		frame.getContentPane().add(txtTo);
		
		txtTicketNo = new JTextField();
		txtTicketNo.setColumns(10);
		txtTicketNo.setBounds(1073, 390, 153, 26);
		frame.getContentPane().add(txtTicketNo);
		
		JLabel lblClass_1_2_1 = new JLabel("Date");
		lblClass_1_2_1.setBounds(781, 442, 79, 23);
		frame.getContentPane().add(lblClass_1_2_1);
		
		JLabel lblClass_1_2_2 = new JLabel("Time");
		lblClass_1_2_2.setBounds(781, 532, 79, 23);
		frame.getContentPane().add(lblClass_1_2_2);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(860, 440, 105, 26);
		frame.getContentPane().add(txtDate);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(860, 534, 105, 26);
		frame.getContentPane().add(txtTime);
		
		JLabel lblClass_1_3_1 = new JLabel("Price");
		lblClass_1_3_1.setBounds(1073, 445, 79, 23);
		frame.getContentPane().add(lblClass_1_3_1);
		
		JLabel lblClass_1_3_2 = new JLabel("Route");
		lblClass_1_3_2.setBounds(1073, 534, 79, 23);
		frame.getContentPane().add(lblClass_1_3_2);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(1073, 492, 153, 26);
		frame.getContentPane().add(txtPrice);
		
		txtRoute = new JTextField();
		txtRoute.setColumns(10);
		txtRoute.setBounds(1073, 580, 153, 26);
		frame.getContentPane().add(txtRoute);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(1002, 274, 18, 398);
		frame.getContentPane().add(separator_7);
	}
}
