package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Doctor extends JFrame{
	private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JLabel jLabel1;
    
    public Doctor() {
    	initComponents();
    }
    private void initComponents() {
    	jButton1 = new JButton();
    	jButton2 = new JButton();
    	jButton3 = new JButton();
    	jButton4 = new JButton();
    	jButton5 = new JButton();
    	jButton6 = new JButton();
    	jLabel1 = new JLabel();
    	
    	
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("DOCTORS RECORDS");

        jButton1.setText("ADD Doctors");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EDIT Doctors Detail");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("FIRE Doctor");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("View Doctors Detail");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Back");
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Logout");
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
                .addGap(94, 94, 94)
                .addComponent(jButton5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(26, 26, 26))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(289, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                        .addGap(188, 188, 188))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(165, 165, 165))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(31, 31, 31))
        );

        pack();
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
    	addDoctor obj = new addDoctor();
    	obj.setVisible(true);
    	dispose();
    }
	private void jButton2ActionPerformed(ActionEvent evt) {
		editDoctor obj = new editDoctor();
		obj.setVisible(true);
		dispose(); 
	}
	private void jButton3ActionPerformed(ActionEvent evt) {
		fireDoctor obj = new fireDoctor();
		obj.setVisible(true);
		dispose();
	}
	private void jButton4ActionPerformed(ActionEvent evt) {
		viewDetailDoc obj = new viewDetailDoc();
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
		// TODO Auto-generated method stub

	}

}
