package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Patient extends JFrame {
	private JLabel jLabel1;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	
	
	public Patient() {
		initComponents();
	}
	private void initComponents() {
		jLabel1= new JLabel();
		jButton1 = new JButton();
		jButton2 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();
		jButton5 = new JButton();
		jButton6 = new JButton();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Patient Module");
		
		jLabel1.setFont(new Font("condensed",1,18));
		jLabel1.setText("Patient Record");
		
		jButton1.setText("ADMIT NEW PATIENT");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jButton2.setText("EDIT PATIENT DETAILS");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jButton3.setText("DISCHARGE PATIENTS");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        jButton4.setText("VIEW PATIENT DETAILS");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        
        jButton5.setText("BACK");
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        
        jButton6.setText("LOGOUT");
        jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButton5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(36, 36, 36))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 193, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)))
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(79, 79, 79))
        );

        pack();
    }
	private void jButton1ActionPerformed(ActionEvent evt) {
		admitPatient obj = new admitPatient();
		obj.setVisible(true);
		dispose();
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		editPatient obj = new editPatient();
		obj.setVisible(true);
		dispose();
	}
	
	private void jButton3ActionPerformed(ActionEvent evt) {
		dischargePatient obj = new dischargePatient();
		obj.setVisible(true);
		dispose();
	}
	
	private void jButton4ActionPerformed(ActionEvent evt) {
		viewRecordsPatient obj = new viewRecordsPatient();
		obj.setVisible(true);
		dispose();
	}
	
	private void jButton5ActionPerformed(ActionEvent evt) {
		welcome obj = new welcome();
		obj.setVisible(true);
		dispose();
	}

	private void jButton6ActionPerformed(ActionEvent evt) {
		LoginPage obj = new LoginPage();
		obj.setVisible(true);
		dispose();
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
	            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
	        }
		 EventQueue.invokeLater(new Runnable() {
				 public void run() {
					 new Patient().setVisible(true);
				 }
		 });

	}

}
