/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Items extends javax.swing.JFrame {   
    public Items() {
        initComponents();
        Connect();
        load();
        
    }
      
    
    
    
    
    
    Connection con;
    PreparedStatement pat;
    DefaultTableModel df;
    
    public void Connect()
    {
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/inventory","root","");
        
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void load()
        {
        int a;
        try {
            pat = con.prepareStatement("select * from items");
            ResultSet rs = pat.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            a = rd.getColumnCount();
            df = (DefaultTableModel)jTable1.getModel(); 
            df.setRowCount(0);
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                for(int i=1; i<=a; i++)
                {
                  v2.add(rs.getString("id"));
                  v2.add(rs.getString("pname"));
                  v2.add(rs.getString("description"));
                  v2.add(rs.getString("barcode"));
                  v2.add(rs.getString("cprice"));
                  v2.add(rs.getString("rprice"));
                  v2.add(rs.getString("qty"));
                  v2.add(rs.getString("rlevel"));
                }
                df.addRow(v2);
            }     
            
            
                    } catch (SQLException ex) {
            Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
   
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdes = new javax.swing.JTextField();
        txtpn = new javax.swing.JTextField();
        txtbar = new javax.swing.JTextField();
        txtcp = new javax.swing.JTextField();
        txtrol = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txtrp = new javax.swing.JTextField();
        lblImage = new javax.swing.JButton();
        lblImage1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Items");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Product Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Description:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Barcode:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cost Price:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Retail Price:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Quantity:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("ReOrder Level:");

        txtbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbarActionPerformed(evt);
            }
        });

        txtcp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcpActionPerformed(evt);
            }
        });

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image1/bms/search.png"))); // NOI18N
        lblImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblImageActionPerformed(evt);
            }
        });

        lblImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image1/bms/search.png"))); // NOI18N
        lblImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblImage1ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtrol))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtqty))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtrp))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcp))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtbar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdes))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(164, 164, 164))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(txtdes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtbar, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtrp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtrol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3, jButton4, jButton5});

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Product Name", "Description", "Barcode", "Cost Price", "Retail Price", "Quantity", "ReOrder Level"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(138, 138, 138))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        // TODO add your handling code here:
        
         df = (DefaultTableModel)jTable1.getModel(); 
         int selected = jTable1.getSelectedRow();
         int id = Integer.parseInt(df.getValueAt(selected,0).toString());
         
            String pname= txtpn.getText();        
            String description= txtdes.getText();
            String barcode= txtbar.getText();     
            String costprice= txtcp.getText();         
            String retailprice= txtrp.getText();        
            String quantity= txtqty.getText();          
            String reorderlevel= txtrol.getText(); 
            // TODO add your handling code here:
        try {
            pat = con.prepareStatement("update items set pname=?,description=?,barcode=?,cprice=?,rprice=?,qty=?,rlevel=? where id=? ");
            pat.setString(1, pname);        
            pat.setString(2, description);      
            pat.setString(3, barcode);
            pat.setString(4, costprice);         
            pat.setString(5, retailprice);
            pat.setString(6, quantity);        
            pat.setString(7, reorderlevel);
            pat.setInt(8,id);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Edit Successful");
        
             txtpn.setText("");
             txtdes.setText("");         
             txtbar.setText("");  
             txtcp.setText("");
             txtcp.setText("");
             txtrp.setText("");   
             txtqty.setText("");          
             txtrol.setText("");          
             txtpn.requestFocus();
            load();
            jButton1.setEnabled(true);
        
        
        } catch (SQLException ex) {
            Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
        }
           
         
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void txtbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbarActionPerformed

    private void txtcpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcpActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        df = (DefaultTableModel)jTable1.getModel(); 
         int selected = jTable1.getSelectedRow();
         int id = Integer.parseInt(df.getValueAt(selected,0).toString());
         txtpn.setText(df.getValueAt(selected,1).toString());
         txtdes.setText(df.getValueAt(selected,2).toString());
         txtbar.setText(df.getValueAt(selected,3).toString());
         txtcp.setText(df.getValueAt(selected,4).toString());
         txtrp.setText(df.getValueAt(selected,5).toString());
         txtqty.setText(df.getValueAt(selected,6).toString());
         txtrol.setText(df.getValueAt(selected,7).toString());
         jButton1.setEnabled(false);
                 
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        df = (DefaultTableModel)jTable1.getModel(); 
         int selected = jTable1.getSelectedRow();
         int id = Integer.parseInt(df.getValueAt(selected,0).toString());
         
        
        try {
            pat = con.prepareStatement("delete from items where id=? ") ;
           
            pat.setInt(1,id);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Delete successfull");
        
             txtpn.setText("");
             txtdes.setText("");         
             txtbar.setText("");  
             txtcp.setText("");
             txtcp.setText("");
             txtrp.setText("");   
             txtqty.setText("");          
             txtrol.setText("");  
            txtpn.requestFocus();
            load();
            jButton1.setEnabled(true);
         
        
        
        } catch (SQLException ex) {
            Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                           
        try {
            String pname= txtpn.getText();        
            String description= txtdes.getText();
            String barcode= txtbar.getText();     
            String costprice= txtcp.getText();         
            String retailprice= txtrp.getText();        
            String quantity= txtqty.getText();          
            String reorderlevel= txtrol.getText();  
                                             
            pat = con.prepareStatement("insert into items(pname,description,barcode,cprice,rprice,qty,rlevel)values(?,?,?,?,?,?,?)");
            pat.setString(1, pname);        
            pat.setString(2, description);      
            pat.setString(3, barcode);
            pat.setString(4, costprice);         
            pat.setString(5, retailprice);
            pat.setString(6, quantity);        
            pat.setString(7, reorderlevel);
            pat.executeUpdate();   
            
            JOptionPane.showMessageDialog(this, "Item Added succesfully");
        
             txtpn.setText("");
             txtdes.setText("");         
             txtbar.setText("");  
             txtcp.setText("");
             txtcp.setText("");
             txtrp.setText("");   
             txtqty.setText("");          
             txtrol.setText("");          
             txtpn.requestFocus();
             load();      
             
          
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here: txtname.setText("");
            txtpn.setText("");
             txtdes.setText("");         
             txtbar.setText("");  
             txtcp.setText("");
             txtcp.setText("");
             txtrp.setText("");   
             txtqty.setText("");          
             txtrol.setText("");          
             txtpn.requestFocus();
            load();
            jButton1.setEnabled(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void lblImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblImageActionPerformed
        try {
            // TODO add your handling code here:
            String pname=txtpn.getText();
            pat = con.prepareStatement("select * from items where pname =?");
            pat.setString(1,pname);
            ResultSet rs = pat.executeQuery();
            
            
            if(rs.next()== false)
            {
                JOptionPane.showMessageDialog(this, "Product Not  Found!!!!!!!!!!");
            }
            else
            {
                String des = rs.getString("description");
                String bar = rs.getString("barcode");
                String cprice = rs.getString("cprice");
                String rprice = rs.getString("rprice");
                String qty = rs.getString("qty");
                String rol = rs.getString("rlevel");
                
                txtdes.setText(des.trim());
                txtbar.setText(bar.trim());
                txtcp.setText(cprice.trim());
                txtrp.setText(rprice.trim());
                txtqty.setText(qty.trim());
                txtrol.setText(rol.trim());
              //  txtpn.setEditable(false);
                
        
        
                
                
                jButton1.setEnabled(false);
                 
                
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
        
    }//GEN-LAST:event_lblImageActionPerformed

    private void lblImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblImage1ActionPerformed
      /*  // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            String bar=txtbar.getText();
            pat = con.prepareStatement("select * from items where barcode =?");
            pat.setString(1,bar);
            ResultSet rs = pat.executeQuery();
            
            
            if(rs.next()== false)
            {
                JOptionPane.showMessageDialog(this, "Barcode Not  Found!!!!!!!!!!");
            }
            else
            {
                
                String pname = rs.getString("pname");
                String des = rs.getString("description");
                String cprice = rs.getString("cprice");
                String rprice = rs.getString("rprice");
                String qty = rs.getString("qty");
                String rol = rs.getString("rlevel");
                txtpn.setText(pname.trim());
                txtdes.setText(des.trim());
                txtcp.setText(cprice.trim());
                txtrp.setText(rprice.trim());
                txtqty.setText(qty.trim());
                txtrol.setText(rol.trim());
               // txtbar.setEditable(false);
                
         
                
                
                jButton1.setEnabled(false);
                 
                
            }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        */
        
        
        
    }//GEN-LAST:event_lblImage1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
            
          //String pname= txtpn.getText();        
            String description= txtdes.getText();
            String barcode= txtbar.getText();     
            String costprice= txtcp.getText();         
            String retailprice= txtrp.getText();        
            String quantity= txtqty.getText();          
            String reorderlevel= txtrol.getText(); 
            // TODO add your handling code here:
        try {
            pat = con.prepareStatement("update items set description=?,barcode=?,cprice=?,rprice=?,qty=?,rlevel=? where pname=? ");
          // pat.setString(1, pname);        
            pat.setString(2, description);      
            pat.setString(3, barcode);
            pat.setString(4, costprice);         
            pat.setString(5, retailprice);
            pat.setString(6, quantity);        
            pat.setString(7, reorderlevel);
           // pat.setInt(8,id);
            pat.executeUpdate();
            JOptionPane.showMessageDialog(this, "Edit Successful");
        
            // txtpn.setText("");
             txtdes.setText("");         
             txtbar.setText("");  
             txtcp.setText("");
             txtcp.setText("");
             txtrp.setText("");   
             txtqty.setText("");          
             txtrol.setText("");          
            // txtpn.requestFocus();
            load();
            jButton1.setEnabled(true);
        
        
        } catch (SQLException ex) {
            Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        
        
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Items().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton lblImage;
    private javax.swing.JButton lblImage1;
    private javax.swing.JTextField txtbar;
    private javax.swing.JTextField txtcp;
    private javax.swing.JTextField txtdes;
    private javax.swing.JTextField txtpn;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtrol;
    private javax.swing.JTextField txtrp;
    // End of variables declaration//GEN-END:variables
}
