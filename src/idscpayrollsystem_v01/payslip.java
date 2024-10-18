/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idscpayrollsystem_v01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author lyren
 */
public class payslip extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form payslip
     */
    public payslip() {
        initComponents();
        conn = dbconn.java_db();
        //presentabsent_days();
        calculations();
        
    }
    
    public void calculate(){
        try{
            String sql = "select hoursWorked from attendance values (ROUND((TIME_TO_SEC(time_out) - TIME_TO_SEC(time_in)) / 3600))";
            
        } catch (Exception e){
        
        }
    }
    
    public int salary = 22000; 
    //public int monthlyRate = 22000;
    public int dailyRate = 1000;
    
    
    //String sql = "select hoursWorked from attendance values (ROUND((TIME_TO_SEC(time_out) - TIME_TO_SEC(time_in)) / 3600))";
    //int hoursWorked = rs.getInt(sql);
    //int absent = rs.getInt("absent_days");
    //System.out.println(absent);
    
    public void employeePayslip(){
        try {
            String sql = "select * from employee_information where emp_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,txt_empid.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                txt_empid.setText(rs.getString("emp_id"));
                txt_fullname.setText(rs.getString("fullname"));
                txt_department.setText(rs.getString("department"));
            }
            String sqlQuery = "SELECT emp_id, COUNT(CASE WHEN time_in IS NOT NULL AND time_out IS NOT NULL THEN 1 END) AS present_days FROM attendance GROUP BY emp_id";
                pst = conn.prepareStatement(sqlQuery);
                pst.setString(1,txt_empid.getText());
                rs=pst.executeQuery();
                if(rs.next()){
                    int presentDays = rs.getInt("present_days");
                     //String absentDays = rs.getString("absent_days");
                     txt_worked.setText(Integer.toString(presentDays));
                     int ad = 22;
                     //String pd = rs.getString(presentDays).toInt();
                     int total = (1000 * 22);
                     txt_total.setText(Integer.toString(total));
                     System.out.println(total);
                 }
        } catch (Exception e){
        
        }
    }
    
    public void presentabsent_days(){
        try {
            String sql = "SELECT emp_id, COUNT(CASE WHEN time_in IS NOT NULL AND time_out IS NOT NULL THEN 1 END) AS present_days, COUNT(CASE WHEN time_in IS NULL OR time_out IS NULL THEN 1 END) AS absent_days FROM attendance GROUP BY emp_id;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                int present = rs.getInt("present_days");
                System.out.println(present);
                int absent = rs.getInt("absent_days");
                System.out.println(absent);
            }
        } catch (Exception e){
        
        }
    }
    
    public void calculations(){
        String add4 = "22000";
        txt_monthly.setText(add4);
        
        String add5 = "22000";
        txt_salary.setText(add5);
        
        double pagibig = calculatePagibig(salary);
        String add6 = Double.toString(pagibig);
        txt_pagibig.setText(add6);
        
        double sss = calculateSSS(salary);
        String add7 = Double.toString(sss);
        txt_sss.setText(add7);
        
        //double ps = calculateSSS(salary) + calculatePagibig(salary);
    }
    
    private static double calculateSalary(double monthlyRate, double dailyRate, int daysWorked, double hoursWorked){
        if (monthlyRate > 0) {
            return monthlyRate;
        } else {
            return dailyRate * daysWorked + (hoursWorked - 8 * daysWorked) * 1.5 * 312;
        }
    }
    
    private static double calculatePagibig(double salary) {
        // You can implement your own logic for Pag-IBIG contribution
        // This is just a placeholder, you should adjust it according to your rules
        return salary * 0.02; // Example: 2% of salary for Pag-IBIG
    }
    
    private static double calculateSSS(double salary){
        return salary * 0.03;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        txt_fullname = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txt_department = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txt_empid = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        txt_monthly = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txt_salary = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        txt_worked = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txt_less = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txt_pagibig = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        txt_netpay = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel80 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        txt_sss = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        txt_absent = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/idscpayrollsystem_v01/images/80.png"))); // NOI18N
        jLabel1.setText("i");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html>\n<center>\nInfotech Development Systems Colleges <br>\nNatera St. Dunao, Ligao City\n</center>\n</html>");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PAYSLIP");

        jLabel67.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel67.setText("NAME:");

        txt_fullname.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_fullname.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fullnameActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel68.setText("DEPARTMENT:");

        txt_department.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_department.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_departmentActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel69.setText("EMP ID:");

        txt_empid.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_empid.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_empidActionPerformed(evt);
            }
        });
        txt_empid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_empidKeyReleased(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel70.setText("MONTHLY:");

        txt_monthly.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_monthly.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_monthlyActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel71.setText("COMPENSATION");

        jLabel72.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel72.setText("DEDUCTION");

        jLabel73.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel73.setText("SALARIES & WAGES:");

        txt_salary.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_salary.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_salaryActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("<html>\n<center>\nNO. OF DAYS<br>\nWORKED:\n</center>\n</html>");

        txt_worked.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_worked.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_worked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_workedActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("<html> <center> NO. OF DAYS<br> ABSENT: </center> </html>");

        jLabel76.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel76.setText("LESS:");

        txt_less.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_less.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_less.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lessActionPerformed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel77.setText("PAGIBIG:");

        txt_pagibig.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_pagibig.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_pagibig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pagibigActionPerformed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel78.setText("NETPAY:");

        txt_netpay.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_netpay.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_netpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_netpayActionPerformed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel79.setText("TOTAL:");

        txt_total.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_total.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("SIGNATURE OVER PRINTED NAME");

        jButton17.setBackground(new java.awt.Color(160, 38, 38));
        jButton17.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Save as PDF");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        txt_sss.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        txt_sss.setPreferredSize(new java.awt.Dimension(169, 30));
        txt_sss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sssActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel81.setText("SSS:");

        jButton18.setBackground(new java.awt.Color(160, 38, 38));
        jButton18.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Cancel");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        txt_absent.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_worked, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_less, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(txt_absent, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_pagibig, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_sss, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(jSeparator2))))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_empid, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_department, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_monthly, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_netpay, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_monthly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_less, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_worked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_absent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_pagibig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_netpay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fullnameActionPerformed

    private void txt_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_departmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_departmentActionPerformed

    private void txt_empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_empidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_empidActionPerformed

    private void txt_monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_monthlyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_monthlyActionPerformed

    private void txt_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salaryActionPerformed

    private void txt_workedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_workedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_workedActionPerformed

    private void txt_lessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lessActionPerformed

    private void txt_pagibigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pagibigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pagibigActionPerformed

    private void txt_netpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_netpayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_netpayActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void txt_sssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sssActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sssActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void txt_empidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_empidKeyReleased
        // TODO add your handling code here:
        try {
            String empIdInput = txt_empid.getText().trim();
            if (empIdInput.isEmpty()) {
                // Clear fields if no input
                clearFields();
                return;
            }
            String sql = "select * from employee_information where emp_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,empIdInput);
            rs=pst.executeQuery();
            if(rs.next()){
                txt_empid.setText(rs.getString("emp_id"));
                txt_fullname.setText(rs.getString("fullname"));
                txt_department.setText(rs.getString("department"));
            } else {
                // Clear fields if no employee found
                clearFields();
                return;
            }
            rs.close();
            pst.close();
            String sqlQuery = "SELECT LAST_INSERT_ID() AS emp_id, COUNT(CASE WHEN date IS NOT NULL THEN 1 END) AS present_days FROM attendance where emp_id = ?";
            try (PreparedStatement pst2 = conn.prepareStatement(sqlQuery)){
                pst2.setString(1, empIdInput);
                rs = pst2.executeQuery();
                if(rs.next()){
                     int presentDays = rs.getInt("present_days");
                     int daysperMonth = 22;
                     int absentDays = daysperMonth - presentDays;
                     txt_worked.setText(Integer.toString(presentDays));
                     txt_absent.setText(Integer.toString(absentDays));
                     int total = 1000 * presentDays;
                     txt_total.setText(Integer.toString(total));
                     double ps = calculateSSS(salary) + calculatePagibig(salary);
                     double netpay = (total - ps);
                     txt_netpay.setText(Double.toString(netpay));
                 }
            } catch(Exception e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
        // Close resources (PreparedStatement and ResultSet) and handle exceptions
        try {
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_txt_empidKeyReleased

    private void clearFields() {
    // Clear all fields when no employee is found or no input
        txt_empid.setText("");
        txt_fullname.setText("");
        txt_department.setText("");
        txt_worked.setText("");
        txt_absent.setText("");
        txt_total.setText("");
        txt_netpay.setText("");
    }
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
            java.util.logging.Logger.getLogger(payslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payslip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txt_absent;
    private javax.swing.JTextField txt_department;
    private javax.swing.JTextField txt_empid;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JTextField txt_less;
    private javax.swing.JTextField txt_monthly;
    private javax.swing.JTextField txt_netpay;
    private javax.swing.JTextField txt_pagibig;
    private javax.swing.JTextField txt_salary;
    private javax.swing.JTextField txt_sss;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_worked;
    // End of variables declaration//GEN-END:variables
}
