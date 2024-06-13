/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import MainController.DatabaseUtils;



/**
 *
 * @author tuandinh
 */
public class UserDao {
    
    public User getUserByID(String username){
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        User ee = new User();
        try {
            String sSQl = "select * from User where username = ?";
            conn = DatabaseUtils.getConnection();
            sttm = conn.prepareStatement(sSQl);
            sttm.setString(1, username);
            rs = sttm.executeQuery();
            while(rs.next()){
                ee.setUsername(rs.getString(1));
                ee.setPass(rs.getString(2));
                ee.setRole(rs.getBoolean(3));
                
                return ee;
            }
        } catch (Exception e) {
            System.out.println("Error:" +e.toString());
        }finally{
            try {
                conn.close();
                rs.close();
                sttm.close();
                
            } catch (Exception e) {
                
            }
        }
        return  null;
    }
    
    public boolean  checLogin(String username,String pass){
        User user = getUserByID(username);
        if(user != null){
            if(user.getPass().equals(pass)){
                
            }
        }
        return false;
    }
}
