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

public class viewDetailDoc extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    
    public viewDetailDoc() {
    	initComponents();
    }
    private void initComponents() {
    	jButton1 = new JButton();
    	jButton2 = new JButton();
    	jButton3 = new JButton();
    	
    	jLabel1 = new JLabel();
    	jScrollPane1 = new JScrollPane();
    	jTable1 = new JTable();
    	
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	
    	jLabel1.setFont(new Font("Times New Roman",1,24));
    	jLabel1.setText("View Details");
    	
    	jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String [] {
                    "Id", "Doctor name", "Specialization"
                }
            ));
            jScrollPane1.setViewportView(jTable1);

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

            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3)
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(150, 150, 150))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(183, 183, 183))))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jLabel1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton1)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton2))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
    	try{ Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
        Statement st= conn.createStatement();
        String sql="select * from doctor_record";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs= pstmt.executeQuery();
        DefaultTableModel tm=(DefaultTableModel)jTable1.getModel();
        tm.setRowCount(0);
        while(rs.next()){
        Object o[]={rs.getInt("ID"),rs.getString("DOCTORNAME"),rs.getString("SPECIALIZATION")};
        tm.addRow(o);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

    }
	private void jButton2ActionPerformed(ActionEvent evt) {
		Doctor obj = new Doctor();
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewDetailDoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(viewDetailDoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(viewDetailDoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(viewDetailDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewDetailDoc().setVisible(true);
            }
        });

	}

}
