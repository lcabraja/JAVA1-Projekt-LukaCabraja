/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import hr.algebra.model.Movie;
import hr.algebra.model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lcabraja
 */
public interface Repository {
    int createActor(Actor actor) throws Exception;
    void createActors(List<Actor> actors) throws Exception;    
    void updateActor(int id, Actor data) throws Exception;
    void deleteActor(int id) throws Exception;
    Optional<Actor> selectActor(int id) throws Exception;
    List<Actor> selectActors() throws Exception;
    
    int createDirector(Director director) throws Exception;
    void createDirectors(List<Director> directors) throws Exception;    
    void updateDirector(int id, Director data) throws Exception;
    void deleteDirector(int id) throws Exception;
    Optional<Director> selectDirector(int id) throws Exception;
    List<Director> selectDirectors() throws Exception;
    
    int createMovie(Movie movie) throws Exception;
    void createMovies(List<Movie> movies) throws Exception;    
    void updateMovie(int id, Movie data) throws Exception;
    void deleteMovie(int id) throws Exception;
    Optional<Movie> selectMovie(int id) throws Exception;
    List<Movie> selectMovies() throws Exception;
    
    Optional<User> selectUser(String username) throws Exception;
    
    void createMovieActor(int MovieID, int ActorID) throws Exception;
    void createMovieActors(int MovieID, List<Actor> actors) throws Exception;    
    void deleteMovieActor(int MovieID, int ActorID) throws Exception;
    List<Actor> selectMovieActors(int MovieID) throws Exception;
    
    void createMovieDirector(int MovieID, int DirectorID) throws Exception;
    void createMovieDirectors(int MovieID, List<Director> directors) throws Exception;    
    void deleteMovieDirector(int MovieID, int DirectorID) throws Exception;
    List<Director> selectMovieDirectors(int MovieID) throws Exception;
}
