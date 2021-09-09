/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lcabraja
 */
public class MovieTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {"IDMovie", "Title", "OriginalTitle", "DatePublished", "HTMLDescription", "Length", "Genre", "PosterFilePath", "TrailerLink", "Link", "GUID", "StartsPlaying"};

    private List<Movie> movies;

    public MovieTableModel(List<Movie> movies) {
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
        return Movie.class.getDeclaredFields().length - 3; // -1 for the static field, and -2 for the arrays
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
                return movies.get(rowIndex).getDatePublished();
            case 4:
                return movies.get(rowIndex).getHTMLDescription();
            case 5:
                return movies.get(rowIndex).getLength();
            case 6:
                return movies.get(rowIndex).getGenre();
            case 7:
                return movies.get(rowIndex).getPosterFilePath();
            case 8:
                return movies.get(rowIndex).getTrailerLink();
            case 9:
                return movies.get(rowIndex).getLink();
            case 10:
                return movies.get(rowIndex).getGUID();
            case 11:
                return movies.get(rowIndex).getStartsPlaying();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
