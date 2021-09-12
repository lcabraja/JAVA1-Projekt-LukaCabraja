/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lcabraja
 */
public class RoleTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"ID Role", "Person ID", "Alternate Name", "Full Name"};
    private final RoleTypes ROLE_TYPE;

    private List<Role> roles;

    public RoleTableModel(List<Role> roles, RoleTypes roleType) {
        this.roles = roles;
        ROLE_TYPE = roleType;
        COLUMN_NAMES[1] = "ID " + ROLE_TYPE.name();
    }

    public void setMovies(List<Role> roles) {
        this.roles = roles;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return roles.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return roles.get(rowIndex).getIdRole();
            case 1:
                return roles.get(rowIndex).getPersonID();
            case 2:
                return roles.get(rowIndex).getAlternateName();
            case 3:
                return roles.get(rowIndex).getFullName();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
