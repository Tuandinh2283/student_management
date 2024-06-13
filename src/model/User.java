/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author tuandinh
 */
public class User {
    private String Username;
    private String pass;
    private Boolean Role;

    public User(Boolean Role) {
        this.Role = Role;
    }

    public Boolean getRole() {
        return Role;
    }

    public void setRole(Boolean Role) {
        this.Role = Role;
    }

    public User() {
    }

    public User(String Username, String pass) {
        this.Username = Username;
        this.pass = pass;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
