package hospital;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;

public class addDoctor extends JFrame{
	
	private JTextField di;
	private JTextField dn;
	private JTextField ds;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	
	public addDoctor() {
		initComponents();
	}
	private void initComponents() {
		jLabel1= new JLabel();
		jLabel2= new JLabel();
		jLabel3= new JLabel();
		jLabel4= new JLabel();
		di=new JTextField();
		dn=new JTextField();
		ds=new JTextField();
		jButton1=new JButton();
		jButton2=new JButton();
		jButton3=new JButton();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jLabel1.setFont(new Font("Times New Roman",1,24));
		jLabel1.setText("ADD Doctor Details ");
		
		jLabel2.setText("Doctor Name: ");
		
		jLabel3.setText("Doctor Id: ");
		
		jLabel4.setText("Doctor Specilization: ");
		
		jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
		jButton2.setText("Back");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
                        .addGap(181, 181, 181)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(dn, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ds, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(di, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(246, 246, 246)
                                    .addComponent(jButton3))))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(di, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
		
	}
	private void jButton1ActionPerformed(ActionEvent evt) {
		try{ Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
        
        String sql = "insert into doctor_record values (?,?,?)";
        PreparedStatement ptstmt = conn.prepareStatement(sql);
        ptstmt.setString(1, di.getText());
        ptstmt.setString(2, dn.getText());
        ptstmt.setString(3, ds.getText());
        ptstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "data inserted successfully");
        conn.close();
        
        
        di.setText("");dn.setText("");ds.setText("");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
        
    
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		Doctor obj =new Doctor();
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
            Logger.getLogger(addDoctor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(addDoctor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(addDoctor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(addDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addDoctor().setVisible(true);
            }
        });

	}

}
