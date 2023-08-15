package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.*;
import java.io.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HPWorld
 */
public class databaseConnection {
    final static String JDBCDRIVER ="com.mysql.cj.jdbc.Driver";
    final static String DbUrl="jdbc:mysql://localhost:3306/student";
    final static String User="root";
    final static String Password="Pass@123";
    
    public static Connection connection(){
        
        try{
            Class.forName(JDBCDRIVER);
            Connection conn = DriverManager.getConnection(DbUrl,User,Password);
            return conn;
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}
