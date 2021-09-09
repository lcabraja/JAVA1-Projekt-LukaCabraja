/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

/**
 *
 * @author lcabraja
 */
public class User {

    private int IDUser;
    private final String Username;
    private final String PasswordHash;
    private String Role;
    private int AccessLevel;

    public User(String Username, String PasswordHash) {
        this.Username = Username;
        this.PasswordHash = PasswordHash;
    }

    public User(int IDUser, String Username, String PasswordHash, String Role, int AccessLevel) {
        this(Username, PasswordHash);
        this.IDUser = IDUser;
        this.Role = Role;
        this.AccessLevel = AccessLevel;
    }

    public int getIDUser() {
        return IDUser;
    }

    public String getUsername() {
        return Username;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public String getRole() {
        return Role;
    }

    public int getAccessLevel() {
        return AccessLevel;
    }

}
