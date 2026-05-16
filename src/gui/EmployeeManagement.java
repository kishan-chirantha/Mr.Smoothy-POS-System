/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class EmployeeManagement extends javax.swing.JPanel {

    HashMap<String, String> genderMap = new HashMap<>();
    HashMap<String, String> roleMap = new HashMap<>();

   
    /**
     * Creates new form EmployeeManagement
     */
    public EmployeeManagement() {
        initComponents();
        
        jTable1.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 13));
        jTable1.getTableHeader().setBackground(new Color(61,82,160));
        jTable1.getTableHeader().setForeground(new Color(255,255,255));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        
        loadEmployees();
        loadGender();
        loadRole();
    }
    
    public void setAddress(String line1, String line2, String city) {
        jLabel1.setText(line1 + ", " + line2 + ", " + city);
    }

    public void loadGender() {
        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `gender`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {

                vector.add(resultSet.getString("name"));
                genderMap.put(resultSet.getString("name"), resultSet.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadRole() {
        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee_type`");

            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {

                vector.add(resultSet.getString("type"));
                roleMap.put(resultSet.getString("type"), resultSet.getString("id"));

            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadAddress() {
        try {

            int row = jTable1.getSelectedRow();

            String email = String.valueOf(jTable1.getValueAt(row, 1));

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee_address` INNER JOIN `city` ON `employee_address`.`city_id`=`city`.`id` WHERE `employee_email`='" + email + "'");

            if (resultSet.next()) {

                jLabel1.setText(resultSet.getString("line1") + ", " + resultSet.getString("line2") + ", " + resultSet.getString("city.name"));

            } else {

                jLabel1.setText("Add Address");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadEmployees() {

        try {

            ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee` INNER JOIN `gender` ON `employee`.`gender_id`=`gender`.`id` INNER JOIN `employee_type` ON `employee`.`employee_type_id`=`employee_type`.`id`");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("full_name"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("nic"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("gender.name"));
                vector.add(resultSet.getString("employee_type.type"));

                dtm.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();

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

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel4.setText("EMPLOYEE MANAGEMENT");

        jTable1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Full Name", "Email", "NIC", "Mobile", "Gender", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Full Name :");

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setText("Email :");

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setText("NIC :");

        jTextField3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setText("Mobile :");

        jTextField4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel9.setText("Gender :");

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setText("Role :");

        jComboBox2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jButton8.setBackground(new java.awt.Color(61, 82, 160));
        jButton8.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Add");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(61, 82, 160));
        jButton9.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Update ");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(61, 82, 160));
        jButton10.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Clear All");
        jButton10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setText("Passsword :");

        jPasswordField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(102, 102, 102));
        jButton13.setText("Print");
        jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Address");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField1)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField3))
                                        .addGap(71, 71, 71)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton10)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();

        String fullName = String.valueOf(jTable1.getValueAt(row, 0));
        jTextField1.setText(fullName);

        String email = String.valueOf(jTable1.getValueAt(row, 1));
        jTextField2.setText(email);
        jTextField2.setEditable(false);

        String nic = String.valueOf(jTable1.getValueAt(row, 2));
        jTextField3.setText(nic);

        String mobile = String.valueOf(jTable1.getValueAt(row, 3));
        jTextField4.setText(mobile);

        String gender = String.valueOf(jTable1.getValueAt(row, 4));
        jComboBox1.setSelectedItem(gender);

        String role = String.valueOf(jTable1.getValueAt(row, 5));
        jComboBox2.setSelectedItem(role);

        jButton8.setEnabled(false);

        loadAddress();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        try {
            String fullName = jTextField1.getText();
            String email = jTextField2.getText();
            String nic = jTextField3.getText();
            String mobile = jTextField4.getText();
            String gender = String.valueOf(jComboBox1.getSelectedItem());
            String role = String.valueOf(jComboBox2.getSelectedItem());
            String password = String.valueOf(jPasswordField1.getPassword());

            if (fullName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Full name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Email", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")) {
                JOptionPane.showMessageDialog(this, "Invalid Email", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter NIC", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select Gender", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (role.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select Role", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Password", "Warning", JOptionPane.WARNING_MESSAGE);

            } else {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee` WHERE `email`='" + email + "' OR `nic`='" + nic + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "This user already registered", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {

                    Date date = new Date();
                    SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");

                    MySQL.executeIUD("INSERT INTO `employee`(`email`,`full_name`,`nic`,`password`,`mobile`,`date_registered`,`gender_id`,`employee_type_id`) VALUES ('" + email + "','" + fullName + "','" + nic + "','" + password + "','" + mobile + "','" + sdm.format(date) + "','" + genderMap.get(gender) + "','" + roleMap.get(role) + "')");

                    JOptionPane.showMessageDialog(this, "Successfully", "Infromation", JOptionPane.INFORMATION_MESSAGE);

                    loadEmployees();
                    reset();

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        try {
            String fullName = jTextField1.getText();
            String email = jTextField2.getText();
            String nic = jTextField3.getText();
            String mobile = jTextField4.getText();
            String gender = String.valueOf(jComboBox1.getSelectedItem());
            String role = String.valueOf(jComboBox2.getSelectedItem());
            String password = String.valueOf(jPasswordField1.getPassword());

            if (fullName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Full name", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (nic.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter NIC", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Mobile", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!mobile.matches("^07[01245678]{1}[0-9]{7}$")) {
                JOptionPane.showMessageDialog(this, "Invalid Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (gender.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select Gender", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (role.equals("Select")) {
                JOptionPane.showMessageDialog(this, "Please select Role", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                ResultSet resultSet = MySQL.executeSearch("SELECT * FROM `employee` WHERE `mobile`='" + mobile + "' OR `nic`='" + nic + "'");

                boolean canUpdate = false;

                if (resultSet.next()) {

                    if (!resultSet.getString("email").equals(email)) {
                        JOptionPane.showMessageDialog(this, "This Mobile number or NIC already used", "Warning", JOptionPane.WARNING_MESSAGE);

                    } else {
                        canUpdate = true;
                    }

                } else {
                    canUpdate = true;
                }

                if (canUpdate) {

                    MySQL.executeIUD("UPDATE `employee` SET `full_name`='" + fullName + "',`nic`='" + nic + "',`password`='" + password + "',`mobile`='" + mobile + "',`gender_id`='" + genderMap.get(gender) + "',`employee_type_id`='" + roleMap.get(role) + "' WHERE `email`='" + email + "'");

                    JOptionPane.showMessageDialog(this, "Successfully", "Infromation", JOptionPane.INFORMATION_MESSAGE);

                    loadEmployees();
                    reset();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        reset();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        try {

            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            String path = "src//report//EmployeeReportViva.jasper";

            HashMap<String,Object> params = new HashMap<>();
            params.put("Parameter1", date);

            JRTableModelDataSource dataSource = new JRTableModelDataSource(jTable1.getModel());

            JasperPrint jasperPrint = JasperFillManager.fillReport(path, params,dataSource);

            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int row = jTable1.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to Add Address", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {
            String email = String.valueOf(jTable1.getValueAt(row, 1));

            new AddAddressWindow(Dashboard.getFrame(), true, email).setVisible(true);
            
//            AddAddressWindow addressWindow = new AddAddressWindow(this, true, email);
//            addressWindow.setVisible(true);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jPasswordField1.setText("");
        jLabel1.setText("Add Address");
        jButton8.setEnabled(true);
        jTable1.clearSelection();
        jTextField2.setEditable(true);
    }
}
