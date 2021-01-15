package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;

public class editPatient extends JFrame{
	private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField pd;
    private JTextField pi;
    private JTextField pn;
    
    public editPatient() {
    	initComponents();
    }
    
    public void initComponents() {
    	jLabel1 = new JLabel();
    	jLabel2 = new JLabel();
    	jLabel3 = new JLabel();
    	jLabel4 = new JLabel();
    	
    	jButton1 = new JButton();
    	jButton2 = new JButton();
    	jButton3 = new JButton();
    	
    	pd = new JTextField();
    	pi = new JTextField();
    	pn = new JTextField();
    	
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	
    	jLabel1.setFont(new Font("Times New Roman",1,24));
    	jLabel1.setText("Edit Patient Record");
    	jLabel2.setText("Patient Id: ");
    	jLabel3.setText("Patient Name: ");
    	jLabel4.setText("Patient Disease ");
    	
    	 jButton1.setText("UPDATE");
         jButton1.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent evt) {
                 jButton1ActionPerformed(evt);
             }
         });

         jButton2.setText("Back");
         jButton2.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent evt) {
                 jButton2ActionPerformed(evt);
             }
         });

         jButton3.setText("Logout");
         jButton3.addActionListener(new ActionListener() {
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
                         .addGap(97, 97, 97)
                         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                 .addComponent(jLabel1)
                                 .addGroup(layout.createSequentialGroup()
                                     .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                         .addComponent(jLabel2)
                                         .addComponent(jLabel3)
                                         .addComponent(jLabel4))
                                     .addGap(47, 47, 47)
                                     .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                         .addComponent(pi, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                         .addComponent(pn)
                                         .addComponent(pd)))
                                 .addComponent(jButton1))
                             .addGroup(layout.createSequentialGroup()
                                 .addGap(216, 216, 216)
                                 .addComponent(jButton3))))
                     .addGroup(layout.createSequentialGroup()
                         .addGap(50, 50, 50)
                         .addComponent(jButton2)))
                 .addContainerGap(80, Short.MAX_VALUE))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(GroupLayout.Alignment.LEADING)
             .addGroup(layout.createSequentialGroup()
                 .addGap(22, 22, 22)
                 .addComponent(jLabel1)
                 .addGap(35, 35, 35)
                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel2)
                     .addComponent(pi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                 .addGap(32, 32, 32)
                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel3)
                     .addComponent(pn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                 .addGap(28, 28, 28)
                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel4)
                     .addComponent(pd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                 .addComponent(jButton1)
                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                     .addComponent(jButton2)
                     .addComponent(jButton3))
                 .addGap(25, 25, 25))
         );

         pack();
    	
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
    	String pid = pi.getText();
        String pname= pn.getText();
        String pdis= pd.getText();
         try{ Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
        
        String sql = "update `paitient_record` SET `PatientName`='"+pname+"',`PatientDisease`='"+pdis+"'WHERE id='"+pid+"'";
        PreparedStatement ptstmt = conn.prepareStatement(sql);
        ptstmt.execute();
        
             JOptionPane.showMessageDialog(null, "Record updated successfully");
        
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
	
	public static void main(String args[]) {
	    

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(editPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(editPatient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(editPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editPatient().setVisible(true);
            }
        });
    }

}
