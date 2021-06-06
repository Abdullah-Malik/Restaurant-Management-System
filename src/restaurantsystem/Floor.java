/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Abdullah
 */
public class Floor extends javax.swing.JFrame {

    /**
     * Creates new form Floor
     */
    RestaurantSystem r = RestaurantSystem.getInstance();
    /**
     * stores the table count
     */
    int tableCount = r.tablesCount;
    
    
    Color yellow = new Color(253,192,5);
    Color red = new Color(174,70,69);
    Color green = new Color(112,172,71);
    Color background = new Color(41,128,185);
    
    JFrame frame;
    
    public JButton button[] = new JButton[tableCount];
    public Floor() {
        
        initComponents();

        /**
         * creating a JPanel to add buttons to 
         */
        JPanel Panel=new JPanel((new FlowLayout(FlowLayout.CENTER, 0, 0)));  
        Panel.setBounds(20,20,360,420);
        frame = this;
        
        
        /**
         * creating and adding buttons to panel and setting different background color of buttons 
         * based on whether the table is clean, dirty or assigned
         */
        for(int i = 0; i < tableCount; i++)
        {
            button[i] = new JButton();
            button[i].setText(String.valueOf(i+1));
            button[i].addMouseListener(new MouseHandler(i));
            if(r.tables[i] == 0)
                button[i].setBackground(green);
            else if(r.tables[i] == 1)
                button[i].setBackground(yellow);
            else if(r.tables[i] == 2)
                button[i].setBackground(red);
            button[i].setPreferredSize(new Dimension(70, 70));
                //blocks[i][j].setSize(jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
            Panel.add(button[i]);
        }
        
        Panel.setBackground(background);
        this.setSize(510, 500);
       
        this.getContentPane().setBackground(background);
        this.add(Panel);
    }
    
    /**
     * This handles the actions on buttons
     */
    private class MouseHandler extends MouseAdapter {

        public int tableNo; // instance variables
        
        public MouseHandler(int i) {
            this.tableNo = i;
          
        }
        
        public void mouseClicked(MouseEvent e) {
            RestaurantSystem r = RestaurantSystem.getInstance();
            
            /**
             * The case when the table is Green
             */
            if(r.tables[tableNo] == 0)
            {
               
                Object[] options1 = {  "Continue","Go Back" };

                JPanel panel = new JPanel();
                panel.add(new JLabel("Enter Customer Name"));
                JTextField textField = new JTextField(10);
                panel.add(textField);

                int result = JOptionPane.showOptionDialog(null, panel, "Assign Table",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options1, null);
                if (result == JOptionPane.YES_OPTION){
                    r.customerNames[tableNo] = textField.getText();
                    r.tables[tableNo] = 1;
                    button[tableNo].setBackground(yellow);
                    //System.out.println(r.customerNames[tableNo] );
                    JOptionPane.showMessageDialog(null, "Table Assigned");
                    
                }

            }
            /**
             * The case when the table is Yellow
             */
            else if(r.tables[tableNo] == 1)
            {
                UIManager UI=new UIManager();
                UI.put("OptionPane.background", background);
                UI.put("Panel.background", background);

                int result = JOptionPane.showConfirmDialog(null, 
                                "Manage Order for "+ r.customerNames[tableNo],
                                null, 
                                JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION)
                {
                    frame.setVisible(false);
                    OrderPage.start();
                }
               
            }
            /**
             * The case when the table is red
             */
            else if(r.tables[tableNo] == 2)
            {
                Object[] options1 = {  "Continue","Go Back" };
                JPanel panel = new JPanel();
                panel.add(new JLabel("Mark Table " + String.valueOf(tableNo+1)+ " clean" ));
                int result = JOptionPane.showOptionDialog(null, panel, "Assign Table",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options1, null);
                if (result == JOptionPane.YES_OPTION){
                    r.tables[tableNo] = 0;
                    button[tableNo].setBackground(green);
                    JOptionPane.showMessageDialog(null, "Table Cleaning Done");

                }
            }
            
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Sign out");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Orders");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(383, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(319, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Login.start();
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * Prints the Order queue
     * @param evt 
     */
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        RestaurantSystem r = RestaurantSystem.getInstance();
        System.out.println("Total Orders: " + r.orderlist.size());
        for(int i = 0; i < r.orderlist.size();i++)
        {
            System.out.println("Order#"+ String.valueOf(i+1));
            for(int j = 0; j< r.orderlist.get(i).getOrderList().size() ; j++)
            {
                System.out.println(r.orderlist.get(i).getOrderList().get(j).getName());
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void start() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Floor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Floor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Floor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Floor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Floor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
