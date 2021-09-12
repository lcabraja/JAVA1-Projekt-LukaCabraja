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
public class MovieShortTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"ID Movie", "Title", "Original Title", "Genre"};

    private List<Movie> movies;

    public MovieShortTableModel(List<Movie> movies) {
        this.movies = movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return movies.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return movies.get(rowIndex).getIDMovie();
            case 1:
                return movies.get(rowIndex).getTitle();
            case 2:
                return movies.get(rowIndex).getOriginalTitle();
            case 3:
                return movies.get(rowIndex).getGenre();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
