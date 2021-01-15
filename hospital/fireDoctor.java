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


public class fireDoctor extends JFrame{
	
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;

    private JLabel jLabel1;
    private JLabel jLabel2;
    
    private JTextField fd;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    
    public fireDoctor() {
    	initComponents();
    }
    private void initComponents() {
    	jLabel1 = new JLabel();
    	jLabel2 = new JLabel();
    	
    	jButton1 = new JButton();
    	jButton2 = new JButton();
    	jButton3 = new JButton();
    	jButton4 = new JButton();
    	
    	fd = new JTextField();
    	jScrollPane1 = new JScrollPane();
    	jTable1 = new JTable();
    	
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	
    	jLabel1.setFont(new Font("Times New Roman",1,24));
    	jLabel1.setText("Fire Doctor");
    	
    	jLabel2.setText("To Fire the doctor, Write his Id : ");
    	
    	jButton1.setText("View Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Doctor Name", "Specialization"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        
        jButton2.setText("Fire");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fd, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(221, 221, 221))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(200, 200, 200))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
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
		  String fid=fd.getText();
          try{ Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
          Statement st= conn.createStatement();
          String sql="DELETE FROM `doctor_record` WHERE ID="+fid;
          PreparedStatement pstmt=conn.prepareStatement(sql);
          pstmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "data deleted successfully");
          conn.close();
          fd.setText("");
          } catch(Exception e) {
          JOptionPane.showMessageDialog(null, e);
          }
	    	    
	}
	private void jButton3ActionPerformed(ActionEvent evt) {
		Doctor obj = new Doctor();
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fireDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fireDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fireDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fireDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fireDoctor().setVisible(true);
            }
        });

	}

}
