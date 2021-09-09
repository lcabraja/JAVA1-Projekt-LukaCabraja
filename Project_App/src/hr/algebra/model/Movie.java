/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lcabraja
 */
public class Movie {

    private int IDMovie;
    private String Title;
    private String OriginalTitle;
    private String HTMLDescription;
    private int Length;
    private String Genre;
    private String PosterFilePath;
    private String TrailerLink;
    private String Link;
    private String GUID;
    private Date StartsPlaying;
    private List<Actor> Actors;
    private List<Director> Directors;

    public Movie() {
        Actors = new ArrayList<>();
        Directors = new ArrayList<>();
    }

    public Movie(String Title, String OriginalTitle, String HTMLDescription, int Length, String Genre, String PosterFilePath, String TrailerLink, String Link, String GUID, Date StartsPlaying) {
        this();
        this.Title = Title;
        this.OriginalTitle = OriginalTitle;
        this.HTMLDescription = HTMLDescription;
        this.Length = Length;
        this.Genre = Genre;
        this.PosterFilePath = PosterFilePath;
        this.TrailerLink = TrailerLink;
        this.Link = Link;
        this.GUID = GUID;
        this.StartsPlaying = StartsPlaying;
    }

    public Movie(int IDMovie, String Title, String OriginalTitle, String HTMLDescription, int Length, String Genre, String PosterFilePath, String TrailerLink, String Link, String GUID, Date StartsPlaying) {
        this(Title, OriginalTitle, HTMLDescription, Length, Genre, PosterFilePath, TrailerLink, Link, GUID, StartsPlaying);
        this.IDMovie = IDMovie;
    }

    public List<Actor> getActors() {
        return Actors;
    }

    public void setActors(List<Actor> Actors) {
        this.Actors = Actors;
    }

    public List<Director> getDirectors() {
        return Directors;
    }

    public void setDirectors(List<Director> Directors) {
        this.Directors = Directors;
    }

    public int getIDMovie() {
        return IDMovie;
    }

    public String getTitle() {
        return Title;
    }

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public String getHTMLDescription() {
        return HTMLDescription;
    }

    public int getLength() {
        return Length;
    }

    public String getGenre() {
        return Genre;
    }

    public String getPosterFilePath() {
        return PosterFilePath;
    }

    public String getTrailerLink() {
        return TrailerLink;
    }

    public String getLink() {
        return Link;
    }

    public String getGUID() {
        return GUID;
    }

    public Date getStartsPlaying() {
        return StartsPlaying;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setOriginalTitle(String OriginalTitle) {
        this.OriginalTitle = OriginalTitle;
    }

    public void setHTMLDescription(String HTMLDescription) {
        this.HTMLDescription = HTMLDescription;
    }

    public void setLength(int Length) {
        this.Length = Length;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setPosterFilePath(String PosterFilePath) {
        this.PosterFilePath = PosterFilePath;
    }

    public void setTrailerLink(String TrailerLink) {
        this.TrailerLink = TrailerLink;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public void setStartsPlaying(Date StartsPlaying) {
        this.StartsPlaying = StartsPlaying;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.IDMovie;
        hash = 67 * hash + Objects.hashCode(this.Title);
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
        if (this.IDMovie != other.IDMovie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" + "IDMovie=" + IDMovie + ", Title=" + Title + ", OriginalTitle=" + OriginalTitle + ", DatePublished=" + ", HTMLDescription=" + HTMLDescription + ", Length=" + Length + ", Genre=" + Genre + ", PosterFilePath=" + PosterFilePath + ", TrailerLink=" + TrailerLink + ", Link=" + Link + ", GUID=" + GUID + ", StartsPlaying=" + StartsPlaying + '}';
    }
}
