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
public class Role {

    private int idRole;
    private int personID;
    private String fullName;
    private String alternateName;

    public Role(String fullName) {
        this.fullName = fullName;
    }

    public Role(int personID, String fullName, String alternateName) {
        this(fullName);
        this.personID = personID;
        this.alternateName = alternateName;
    }

    public Role(int idRole, int personID, String fullName, String alternateName) {
        this(personID, fullName, alternateName);
        this.idRole = idRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public int getPersonID() {
        return personID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

}
