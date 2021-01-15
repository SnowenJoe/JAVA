package hospital;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;

public class admitPatient extends JFrame implements Runnable{
	int hour,minutes,seconds;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	
	private JTextField pad;
	private JTextField pat;
	private JTextField pd;
	private JTextField pi;
	private JTextField pn;
	
	public admitPatient() {
		initComponents();
		showDate();
		Thread t= new Thread(this);
		t.start();
	}
	void showDate() {
		Date d= new Date();
		SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
		pad.setText(sd.format(d));
	}
	
	private void initComponents() {
		jLabel1=new JLabel();
		jLabel2=new JLabel();
		jLabel3=new JLabel();
		jLabel4=new JLabel();
		jLabel5=new JLabel();
		jLabel6=new JLabel();
		
		pad=new JTextField();
		pat=new JTextField();
		pd=new JTextField();
		pi=new JTextField();
		pn=new JTextField();
		
		jButton1=new JButton();
		jButton2= new JButton();
		jButton3= new JButton();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		jLabel1.setFont(new Font("Times New Roman",1,24));
		jLabel1.setText("Admit Patient");
		
		jLabel2.setText("Enter Patient's ID: ");
		jLabel3.setText("Enter Patient's NAME: ");
		jLabel4.setText("Enter Patient's DISEASE: ");
		jLabel5.setText("Enter Admit Date: ");
		jLabel6.setText("Enter Admit Time: ");
		
		jButton1.setText("ADMIT");
		jButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		
		jButton2.setText("BACK");
		jButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		
		jButton3.setText("LogOut");
		jButton3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pn, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(38, 38, 38)
                                    .addComponent(pi, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jButton2))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(pat, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pad, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pd, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, GroupLayout.Alignment.TRAILING)))))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(26, 26, 26))
        );

        pack();
	}
	private void jButton1ActionPerformed(ActionEvent evt) {
		 try{ Class.forName("com.mysql.jdbc.Driver");
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
	        
	        String sql = "insert into paitient_record values (?,?,?,?,?)";
	        PreparedStatement ptstmt = conn.prepareStatement(sql);
	        ptstmt.setString(1, pi.getText());
	        ptstmt.setString(2, pn.getText());
	        ptstmt.setString(3, pd.getText());
	        ptstmt.setString(4, pad.getText());
	        ptstmt.setString(5, pat.getText());
	        ptstmt.executeUpdate();
	        JOptionPane.showMessageDialog(null, "data inserted successfully");
	        conn.close();
	        pi.setText("");pn.setText("");pd.setText("");pat.setText("");
	        }catch(Exception e){
	        JOptionPane.showMessageDialog(null, e);
	        } 
	}
	private void jButton2ActionPerformed(ActionEvent evt) {
		Patient obj = new Patient();
		obj.setVisible(true);
		dispose();
	}
	
	private void jButton3ActionPerformed(ActionEvent evt) {
		LoginPage obj = new LoginPage();
		obj.setVisible(true);
		dispose();
	}
	public void run() {
	    while(true){
	    Calendar cal= Calendar.getInstance();
	    hour=cal.get(Calendar.HOUR_OF_DAY);
	    minutes=cal.get(Calendar.MINUTE);
	    seconds=cal.get(Calendar.SECOND);
	    
	        SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss:aa");
	        Date dat = cal.getTime();
	        String time24 =sdf24.format(dat);
	        pat.setText(time24);
	        
	        
	    
	    }
	}


	public static void main(String[] args) {
		try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admitPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(admitPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(admitPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(admitPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admitPatient().setVisible(true);
            }
        });
    }

	

}
