/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idscpayrollsystem_v01;
import java.sql.*; //imports all classes & interfaces, allowing us to use JDBC or Java Database Connectivity(Java API)
                   // the '*' symbol presents all
import javax.swing.*; //set of GUI or Graphical User Interface components for building desktop apps in Java
import javax.swing.JOptionPane; //provide simple way to display standard dialog boxes for showing messages & warning messages, asking for input etc
/**
 *
 * @author lyren
 */
public class dbconn {
    public static Connection java_db(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/idsc_db","root","");
            return conn;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
        
        //Connection conn = null;
        //try { //try: define block of code that may throw exceptions, followed by catch and optional finally
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/idsc_db","root",""); //DriverManager.getConnection: used to establish a connection to a database - part of JDBC
            //return conn;
        //}catch (Exception e) { //catch: used to catch and handle specific type of exception
            //JOptionPane.showMessageDialog(null,e);
            //return null;
        //} //finally: code that will be executed whether an exception occurs or not
    }
}
