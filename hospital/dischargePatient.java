package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;

public class dischargePatient extends JFrame{
	
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	
	private JTextField pd;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	
	public dischargePatient() {
		initComponents();
	}
	public void initComponents() {
		jButton1 = new JButton();
		jButton2 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();
		
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		
		pd= new JTextField();
		jTable1 = new JTable();
		jScrollPane1 = new JScrollPane();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		jLabel1.setFont(new Font("Times New Roman",1,24));
		jLabel1.setText("Discharge Patient");
		
		jLabel2.setText("To Fire the doctor, Write his Id :");
		
		jTable1.setModel(new DefaultTableModel(
				new Object [][] {
					{null,null,null,null,null},
					{null,null,null,null,null},
					{null,null,null,null,null},
					{null,null,null,null,null}
				},
				new String [] {
						"ID", "Patient Name", "Disease", "Date", "Time"
				}
		));
		jScrollPane1.setViewportView(jTable1);;
		
		jButton1.setText("VIEW RECORD");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jButton2.setText("FIRE");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pd, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(199, 199, 199))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(pd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(140, 140, 140))
        );

        pack();
	}
	private void jButton1ActionPerformed(ActionEvent evt) {
		try{ Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
        Statement st= conn.createStatement();
        String sql="select * from paitient_record";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs= pstmt.executeQuery();
        DefaultTableModel tm=(DefaultTableModel)jTable1.getModel();
        tm.setRowCount(0);
        while(rs.next()){
        	Object o[]={rs.getInt("ID"),rs.getString("PatientName"),rs.getString("PatientDisease"),rs.getString("Date"),rs.getString("Time")};
        	tm.addRow(o);
        }


        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
		
	}
	private void jButton2ActionPerformed(ActionEvent evt) {
		String pid=pd.getText();
        try{ Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
            Statement st= conn.createStatement();
            String sql="DELETE FROM `paitient_record` WHERE ID="+pid;
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "data deleted successfully");
            conn.close();
            pd.setText("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
	}
	private void jButton3ActionPerformed(ActionEvent evt) {
		Patient obj = new Patient();
		obj.setVisible(true);
		dispose();
	}
	private void jButton4ActionPerformed(ActionEvent evt) {
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
            Logger.getLogger(dischargePatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(dischargePatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(dischargePatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(dischargePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dischargePatient().setVisible(true);
            }
        });

	}

}
