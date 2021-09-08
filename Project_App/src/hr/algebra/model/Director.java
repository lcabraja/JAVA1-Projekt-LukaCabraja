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
public class Director {
    private int IDDirector;
    private int PersonID;
    private String FullName;
    private String AlternateName;

    public Director(int PersonID, String FullName, String AlternateName) {
        this.PersonID = PersonID;
        this.FullName = FullName;
        this.AlternateName = AlternateName;
    }

    public Director(int IDDirector, int PersonID, String FullName, String AlternateName) {
        this(PersonID, FullName, AlternateName);
        this.IDDirector = IDDirector;
    }

    public int getIDDirector() {
        return IDDirector;
    }

    public int getPersonID() {
        return PersonID;
    }

    public String getFullName() {
        return FullName;
    }

    public String getAlternateName() {
        return AlternateName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public void setAlternateName(String AlternateName) {
        this.AlternateName = AlternateName;
    }
}
