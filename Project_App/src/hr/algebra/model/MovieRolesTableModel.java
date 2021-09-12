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
public class MovieRolesTableModel extends AbstractTableModel {

    private final String[] COLUMN_NAMES = {"ID Movie", "Title", "ID Role", "Full Name"};
    private final RoleTypes ROLE_TYPE;
    private Movie movie;

    public MovieRolesTableModel(Movie movie, RoleTypes roleType) {
        this.movie = movie;
        COLUMN_NAMES[2] = "ID " + roleType;
        ROLE_TYPE = roleType;
    }

    public void setMovieRoles(Movie movie) {
        this.movie = movie;
        fireTableDataChanged();
    }

    private List<Role> getRoleAccordingToClassType() {
        switch (ROLE_TYPE) {
            case Actor:
                return movie.getActors();
            case Director:
                return movie.getDirectors();
            default:
                throw new RuntimeException("Cannot find requested Role Type");
        }
    }

    @Override
    public int getRowCount() {
        return getRoleAccordingToClassType().size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return movie.getIDMovie();
            case 1:
                return movie.getTitle();
            case 2:
                return getRoleAccordingToClassType().get(rowIndex).getIdRole();
            case 3:
                return getRoleAccordingToClassType().get(rowIndex).getFullName();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
