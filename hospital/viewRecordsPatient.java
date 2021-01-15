package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;

public class viewRecordsPatient extends JFrame{
	private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    public viewRecordsPatient() {
    	initComponents();
    }
    private void initComponents() {
    	jLabel1 = new JLabel();
    	jButton1 = new JButton();
    	jButton2 = new JButton();
    	jButton3 = new JButton();
    	
    	jScrollPane1 = new JScrollPane();
    	jTable1 = new JTable();
    	
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	
    	jLabel1.setFont(new Font("Times New Roman",1,24));
    	jLabel1.setText("View Details");
    	
    	jButton1.setText("VIEW RECORDS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("LOGOUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Patient Name", "Disease", "Date", "Time"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 154, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(178, 178, 178))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(146, 146, 146))))))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(132, 132, 132)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(104, Short.MAX_VALUE)))
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
    	 Patient obj = new Patient();
    	 obj.setVisible(true);
    	 dispose();
	}
	private void jButton3ActionPerformed(ActionEvent evt) {
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
            Logger.getLogger(viewRecordsPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(viewRecordsPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(viewRecordsPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(viewRecordsPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewRecordsPatient().setVisible(true);
            }
        });

	}

}
