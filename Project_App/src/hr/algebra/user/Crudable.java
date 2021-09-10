/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.user;

/**
 *
 * @author lcabraja
 */
public interface Crudable {

    public void clearAction();

    public void createAction();

    public void updateAction();

    public void deleteAction();
}
