/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.sql.Date;
import microsoft.sql.DateTimeOffset;

/**
 *
 * @author lcabraja
 */
public class Movie {

    private int IDMovie;
    private String Title;
    private String OriginalTitle;
    private DateTimeOffset DatePublished;
    private String HTMLDescription;
    private int Length;
    private String Genre;
    private String PosterFilePath;
    private String TrailerLink;
    private String Link;
    private String GUID;
    private Date StartsPlaying;

    public Movie() {
    }

    public Movie(String Title, String OriginalTitle, DateTimeOffset DatePublished, String HTMLDescription, int Length, String Genre, String PosterFilePath, String TrailerLink, String Link, String GUID, Date StartsPlaying) {
        this.Title = Title;
        this.OriginalTitle = OriginalTitle;
        this.DatePublished = DatePublished;
        this.HTMLDescription = HTMLDescription;
        this.Length = Length;
        this.Genre = Genre;
        this.PosterFilePath = PosterFilePath;
        this.TrailerLink = TrailerLink;
        this.Link = Link;
        this.GUID = GUID;
        this.StartsPlaying = StartsPlaying;
    }

    public Movie(int IDMovie, String Title, String OriginalTitle, DateTimeOffset DatePublished, String HTMLDescription, int Length, String Genre, String PosterFilePath, String TrailerLink, String Link, String GUID, Date StartsPlaying) {
        this(Title, OriginalTitle, DatePublished, HTMLDescription, Length, Genre, PosterFilePath, TrailerLink, Link, GUID, StartsPlaying);
        this.IDMovie = IDMovie;
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

    public DateTimeOffset getDatePublished() {
        return DatePublished;
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

    public void setDatePublished(DateTimeOffset DatePublished) {
        this.DatePublished = DatePublished;
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

}
