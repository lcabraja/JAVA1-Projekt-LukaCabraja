/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.model.Role;
import hr.algebra.model.Movie;
import hr.algebra.model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lcabraja
 */
public interface Repository {
    int createActor(Role actor) throws Exception;
    void createActors(List<Role> actors) throws Exception;    
    void updateActor(int id, Role data) throws Exception;
    void deleteActor(int id) throws Exception;
    Optional<Role> selectActor(int id) throws Exception;
    List<Role> selectActors() throws Exception;
    
    int createDirector(Role director) throws Exception;
    void createDirectors(List<Role> directors) throws Exception;    
    void updateDirector(int id, Role data) throws Exception;
    void deleteDirector(int id) throws Exception;
    Optional<Role> selectDirector(int id) throws Exception;
    List<Role> selectDirectors() throws Exception;
    
    int createMovie(Movie movie) throws Exception;
    void createMovies(List<Movie> movies) throws Exception;    
    void updateMovie(int id, Movie data) throws Exception;
    void deleteMovie(int id) throws Exception;
    Optional<Movie> selectMovie(int id) throws Exception;
    List<Movie> selectMovies() throws Exception;
    
    int createUser(User newUser) throws Exception;
    Optional<User> selectUser(String username) throws Exception;
    
    void createMovieActor(int MovieID, int ActorID) throws Exception;
    void createMovieActors(int MovieID, List<Role> actors) throws Exception;    
    void deleteMovieActor(int MovieID, int ActorID) throws Exception;
    List<Role> selectMovieActors(int MovieID) throws Exception;
    
    void createMovieDirector(int MovieID, int DirectorID) throws Exception;
    void createMovieDirectors(int MovieID, List<Role> directors) throws Exception;    
    void deleteMovieDirector(int MovieID, int DirectorID) throws Exception;
    List<Role> selectMovieDirectors(int MovieID) throws Exception;

    void clearAllData(User user) throws Exception;
}
