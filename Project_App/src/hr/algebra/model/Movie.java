/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lcabraja
 */
public class Movie {

    private int idMovie;
    private String title;
    private String originalTitle;
    private String htmlDescription;
    private int length;
    private String genre;
    private String posterFilePath;
    private String trailerLink;
    private String link;
    private String guid;
    private Date startsPlaying;
    private List<Role> actors;
    private List<Role> directors;

    public Movie() {
        actors = new ArrayList<>();
        directors = new ArrayList<>();
    }

    public Movie(String title, String originalTitle, String htmlDescription, int length, String genre, String posterFilePath, String trailerLink, String link, String guid, Date startsPlaying) {
        this();
        this.title = title;
        this.originalTitle = originalTitle;
        this.htmlDescription = htmlDescription;
        this.length = length;
        this.genre = genre;
        this.posterFilePath = posterFilePath;
        this.trailerLink = trailerLink;
        this.link = link;
        this.guid = guid;
        this.startsPlaying = startsPlaying;
    }

    public Movie(int IDMovie, String title, String originalTitle, String htmlDescription, int length, String genre, String posterFilePath, String trailerLink, String link, String guid, Date startsPlaying) {
        this(title, originalTitle, htmlDescription, length, genre, posterFilePath, trailerLink, link, guid, startsPlaying);
        this.idMovie = IDMovie;
    }

    public List<Role> getActors() {
        return actors;
    }

    public void setActors(List<Role> actors) {
        this.actors = actors;
    }

    public List<Role> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Role> directors) {
        this.directors = directors;
    }

    public int getIDMovie() {
        return idMovie;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getHTMLDescription() {
        return htmlDescription;
    }

    public int getLength() {
        return length;
    }

    public String getGenre() {
        return genre;
    }

    public String getPosterFilePath() {
        return posterFilePath;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public String getLink() {
        return link;
    }

    public String getGUID() {
        return guid;
    }

    public Date getStartsPlaying() {
        return startsPlaying;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setHTMLDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPosterFilePath(String posterFilePath) {
        this.posterFilePath = posterFilePath;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setGUID(String guid) {
        this.guid = guid;
    }

    public void setStartsPlaying(Date startsPlaying) {
        this.startsPlaying = startsPlaying;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idMovie;
        hash = 67 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (this.idMovie != other.idMovie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" + "idMovie=" + idMovie + ", title=" + title + ", originalTitle=" + originalTitle + ", htmlDescription=" + htmlDescription + ", length=" + length + ", genre=" + genre + ", posterFilePath=" + posterFilePath + ", trailerLink=" + trailerLink + ", link=" + link + ", guid=" + guid + ", startsPlaying=" + startsPlaying + ", actors=" + actors + ", directors=" + directors + '}';
    }   
}
