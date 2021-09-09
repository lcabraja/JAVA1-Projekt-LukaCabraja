/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import hr.algebra.model.Movie;
import hr.algebra.model.User;
import hr.algebra.utils.FileUtils;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 *
 * @author lcabraja
 */
public class SqlRepository implements Repository {

    private static final String ID_ACTOR = "IDActor";
    private static final String ID_DIRECTOR = "IDDirector";
    private static final String PERSON_ID = "PersonID";
    private static final String FULL_NAME = "FullName";
    private static final String ALTERNATE_NAME = "AlternateName";

    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String ORIGINAL_TITLE = "OriginalTitle";
    private static final String DATE_PUBLISHED = "DatePublished";
    private static final String HTML_DESCRIPTION = "HTMLDescription";
    private static final String LENGTH = "Length";
    private static final String GENRE = "Genre";
    private static final String POSTER_FILE_PATH = "PosterFilePath";
    private static final String TRAILER_LINK = "TrailerLink";
    private static final String LINK = "Link";
    private static final String GUID = "GUID";
    private static final String STARTS_PLAYING = "StartsPlaying";

    private static final String ID_USER = "IDUser";
    private static final String USERNAME = "Username";
    private static final String PASSWORD_HASH = "PasswordHash";
    private static final String ROLE = "Role";
    private static final String ACCESS_LEVEL = "AccessLevel";

    private static final String PROC_CREATE_MOVIE = "{ CALL proc_create_movie  (?,?,?,?,?,?,?,?,?,?,?,?) }";
    private static final String PROC_READ_MOVIE = "{ CALL proc_read_movie  (?) }";
    private static final String PROC_READ_MOVIES = "{ CALL proc_read_movies }";
    private static final String PROC_UPDATE_MOVIE = "{ CALL proc_update_movie  (?,?,?,?,?,?,?,?,?,?,?,?) }";
    private static final String PROC_DELETE_MOVIE = "{ CALL proc_delete_movie (?) }";

    private static final String PROC_CREATE_ACTOR = "{ CALL proc_create_actor  (?,?) }";
    private static final String PROC_READ_ACTOR = "{ CALL proc_read_actor (?) }";
    private static final String PROC_READ_ACTORS = "{ CALL proc_read_actors  (?) }";
    private static final String PROC_UPDATE_ACTOR = "{ CALL proc_update_actor  (?,?) }";
    private static final String PROC_DELETE_ACTOR = "{ CALL proc_delete_actor  (?) }";

    private static final String PROC_CREATE_DIRECTOR = "{ CALL proc_create_director  (?) }";
    private static final String PROC_READ_DIRECTOR = "{ CALL proc_read_director  (?) }";
    private static final String PROC_READ_DIRECTORS = "{ CALL proc_read_directors  (?) }";
    private static final String PROC_UPDATE_DIRECTOR = "{ CALL proc_update_director  (?,?) }";
    private static final String PROC_DELETE_DIRECTOR = "{ CALL proc_delete_director (?) }";

    private static final String PROC_CREATE_USER = "{ CALL proc_create_user  (?,?,?) }";
    private static final String PROC_READ_USER = "{ CALL proc_get_user  (?) }";

    private static final String PROC_CREATE_MOVIE_ACTOR = "{ CALL proc_create_movie_actor  (?,?) }";
    private static final String PROC_READ_MOVIE_ACTOR = "{ CALL proc_read_movie_actor (?) }";
    private static final String PROC_DELETE_MOVIE_ACTOR = "{ CALL proc_delete_movie_actor  (?,?) }";

    private static final String PROC_CREATE_MOVIE_DIRECTOR = "{ CALL proc_create_movie_director  (?,?) }";
    private static final String PROC_READ_MOVIE_DIRECTOR = "{ CALL proc_read_movie_director  (?) }";
    private static final String PROC_DELETE_MOVIE_DIRECTOR = "{ CALL proc_delete_movie_director  (?,?) }";

    private static final String PROC_CLEAR_ALL_DATA = "{ CALL proc_clear_all_data }";

    @Override
    public int createActor(Actor actor) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_ACTOR)) {

            stmt.setString(1, actor.getFullName());
            stmt.registerOutParameter(2, Types.INTEGER);
            stmt.executeUpdate();
            return stmt.getInt(2);
        }
    }

    @Override
    public void createActors(List<Actor> actors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_ACTOR)) {

            for (Actor actor : actors) {
                stmt.setString(1, actor.getFullName());
                stmt.registerOutParameter(2, Types.INTEGER);

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void updateActor(int id, Actor data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_UPDATE_ACTOR)) {

            stmt.setInt(1, data.getIDActor());
            stmt.setString(2, data.getFullName());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteActor(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_DELETE_ACTOR)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Actor> selectActor(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_READ_ACTOR)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Actor(
                            rs.getInt(ID_ACTOR),
                            rs.getInt(PERSON_ID),
                            rs.getString(FULL_NAME),
                            rs.getString(ALTERNATE_NAME)));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Actor> selectActors() throws Exception {
        List<Actor> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_READ_ACTORS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                actors.add(new Actor(
                        rs.getInt(ID_ACTOR),
                        rs.getInt(PERSON_ID),
                        rs.getString(FULL_NAME),
                        rs.getString(ALTERNATE_NAME)));
            }
        }
        return actors;
    }

    @Override
    public int createDirector(Director director) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_DIRECTOR)) {

            stmt.setString(1, director.getFullName());
            stmt.registerOutParameter(2, Types.INTEGER);
            stmt.executeUpdate();
            return stmt.getInt(2);
        }
    }

    @Override
    public void createDirectors(List<Director> directors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_DIRECTOR)) {

            for (Director director : directors) {
                stmt.setString(1, director.getFullName());
                stmt.registerOutParameter(2, Types.INTEGER);

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void updateDirector(int id, Director data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_UPDATE_DIRECTOR)) {

            stmt.setInt(1, data.getIDDirector());
            stmt.setString(2, data.getFullName());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteDirector(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_DELETE_DIRECTOR)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Director> selectDirector(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_READ_DIRECTOR)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Director(
                            rs.getInt(ID_DIRECTOR),
                            rs.getInt(PERSON_ID),
                            rs.getString(FULL_NAME),
                            rs.getString(ALTERNATE_NAME)));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Director> selectDirectors() throws Exception {
        List<Director> directors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_READ_DIRECTORS);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                directors.add(new Director(
                        rs.getInt(ID_DIRECTOR),
                        rs.getInt(PERSON_ID),
                        rs.getString(FULL_NAME),
                        rs.getString(ALTERNATE_NAME)));
            }
        }
        return directors;
    }

    @Override
    public int createMovie(Movie movie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_MOVIE)) {

            createActors(movie.getActors());
            createDirectors(movie.getDirectors());

            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getOriginalTitle());
            stmt.setString(3, movie.getDatePublished().toString());
            stmt.setString(4, movie.getHTMLDescription());
            stmt.setInt(5, movie.getLength());
            stmt.setString(6, movie.getGenre());
            stmt.setString(7, movie.getPosterFilePath());
            stmt.setString(8, movie.getTrailerLink());
            stmt.setString(9, movie.getLink());
            stmt.setString(10, movie.getGUID());
            stmt.setDate(11, movie.getStartsPlaying());
            stmt.registerOutParameter(12, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(12);
        }
    }

    @Override
    public void createMovies(List<Movie> movies) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_MOVIE)) {

            for (Movie movie : movies) {

                createActors(movie.getActors());
                createDirectors(movie.getDirectors());

                stmt.setString(1, movie.getTitle());
                stmt.setString(2, movie.getOriginalTitle());
                stmt.setString(3, movie.getDatePublished().toString());
                stmt.setString(4, movie.getHTMLDescription());
                stmt.setInt(5, movie.getLength());
                stmt.setString(6, movie.getGenre());
                stmt.setString(7, movie.getPosterFilePath());
                stmt.setString(8, movie.getTrailerLink());
                stmt.setString(9, movie.getLink());
                stmt.setString(10, movie.getGUID());
                stmt.setDate(11, movie.getStartsPlaying());
                stmt.registerOutParameter(12, Types.INTEGER);

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void updateMovie(int id, Movie data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_UPDATE_MOVIE)) {

            for (Actor actor : data.getActors()) {
                updateActor(actor.getIDActor(), actor);
            }
            for (Director director : data.getDirectors()) {
                updateDirector(director.getIDDirector(), director);
            }

            stmt.setInt(1, id);
            stmt.setString(2, data.getTitle());
            stmt.setString(3, data.getOriginalTitle());
            stmt.setString(4, data.getDatePublished().toString());
            stmt.setString(5, data.getHTMLDescription());
            stmt.setInt(6, data.getLength());
            stmt.setString(7, data.getGenre());
            stmt.setString(8, data.getPosterFilePath());
            stmt.setString(9, data.getTrailerLink());
            stmt.setString(10, data.getLink());
            stmt.setString(11, data.getGUID());
            stmt.setDate(12, data.getStartsPlaying());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteMovie(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        Optional<Movie> potentialMovie = selectMovie(id);
        if (potentialMovie.isPresent()) {
            File poster = new File(potentialMovie.get().getPosterFilePath());
            poster.delete();
            try (Connection con = dataSource.getConnection();
                    CallableStatement stmt = con.prepareCall(PROC_DELETE_MOVIE)) {
                stmt.setInt(1, id);

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public Optional<Movie> selectMovie(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_READ_MOVIE)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Movie newMovie = new Movie(
                            rs.getInt(ID_MOVIE),
                            rs.getString(TITLE),
                            rs.getString(ORIGINAL_TITLE),
                            DateTimeOffsetParser.parse(rs.getString(DATE_PUBLISHED)),
                            rs.getString(HTML_DESCRIPTION),
                            rs.getInt(LENGTH),
                            rs.getString(GENRE),
                            rs.getString(POSTER_FILE_PATH),
                            rs.getString(TRAILER_LINK),
                            rs.getString(LINK),
                            rs.getString(GUID),
                            rs.getDate(STARTS_PLAYING));

                    List<Actor> selectMovieActors = selectMovieActors(newMovie.getIDMovie());
                    newMovie.setActors(selectMovieActors);
                    List<Director> selectMovieDirectors = selectMovieDirectors(newMovie.getIDMovie());
                    newMovie.setDirectors(selectMovieDirectors);
                    return Optional.of(newMovie);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Movie> selectMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_READ_MOVIES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Movie newMovie = new Movie(
                        rs.getInt(ID_MOVIE),
                        rs.getString(TITLE),
                        rs.getString(ORIGINAL_TITLE),
                        DateTimeOffsetParser.parse(rs.getString(DATE_PUBLISHED)),
                        rs.getString(HTML_DESCRIPTION),
                        rs.getInt(LENGTH),
                        rs.getString(GENRE),
                        rs.getString(POSTER_FILE_PATH),
                        rs.getString(TRAILER_LINK),
                        rs.getString(LINK),
                        rs.getString(GUID),
                        rs.getDate(STARTS_PLAYING));

                List<Actor> selectMovieActors = selectMovieActors(newMovie.getIDMovie());
                newMovie.setActors(selectMovieActors);
                List<Director> selectMovieDirectors = selectMovieDirectors(newMovie.getIDMovie());
                newMovie.setDirectors(selectMovieDirectors);
                movies.add(newMovie);
            }
        }
        return movies;
    }

    @Override
    public int createUser(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_USER)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPasswordHash());
            stmt.registerOutParameter(3, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(3);
        }
    }

    @Override
    public Optional<User> selectUser(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_READ_USER)) {

            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new User(
                            rs.getInt(ID_USER),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD_HASH),
                            rs.getString(ROLE),
                            rs.getInt(ACCESS_LEVEL))
                    );
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void createMovieActor(int ActorID, int MovieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_MOVIE_ACTOR)) {

            stmt.setInt(1, MovieID);
            stmt.setInt(2, ActorID);

            stmt.executeUpdate();
        }
    }

    @Override
    public void createMovieActors(int MovieID, List<Actor> actors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_MOVIE_ACTOR)) {

            for (Actor actor : actors) {
                stmt.setInt(1, MovieID);
                stmt.setInt(2, actor.getIDActor());

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void deleteMovieActor(int MovieID, int ActorID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_DELETE_MOVIE_ACTOR)) {

            stmt.setInt(1, MovieID);
            stmt.setInt(2, ActorID);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Actor> selectMovieActors(int MovieID) throws Exception {
        List<Actor> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_READ_MOVIE_ACTOR);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                actors.add(new Actor(
                        rs.getInt(ID_ACTOR),
                        rs.getInt(PERSON_ID),
                        rs.getString(FULL_NAME),
                        rs.getString(ALTERNATE_NAME)));
            }
        }
        return actors;
    }

    @Override
    public void createMovieDirector(int MovieID, int DirectorID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_MOVIE_DIRECTOR)) {

            stmt.setInt(1, MovieID);
            stmt.setInt(2, DirectorID);

            stmt.executeUpdate();
        }
    }

    @Override
    public void createMovieDirectors(int MovieID, List<Director> directors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_CREATE_MOVIE_DIRECTOR)) {

            for (Director director : directors) {
                stmt.setInt(1, MovieID);
                stmt.setInt(2, director.getIDDirector());

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void deleteMovieDirector(int MovieID, int DirectorID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_DELETE_MOVIE_DIRECTOR)) {

            stmt.setInt(1, MovieID);
            stmt.setInt(2, DirectorID);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Director> selectMovieDirectors(int MovieID) throws Exception {
        List<Director> directors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(PROC_READ_MOVIE_DIRECTOR);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                directors.add(new Director(
                        rs.getInt(ID_DIRECTOR),
                        rs.getInt(PERSON_ID),
                        rs.getString(FULL_NAME),
                        rs.getString(ALTERNATE_NAME)));
            }
        }
        return directors;
    }

    @Override
    public void clearAllData(User user) throws Exception {
        if (user.getAccessLevel() == 100) {
            FileUtils.recursivelyDeleteDirectory(new File("assets"), true);

            DataSource dataSource = DataSourceSingleton.getInstance();
            try (Connection con = dataSource.getConnection();
                    CallableStatement stmt = con.prepareCall(PROC_CLEAR_ALL_DATA)) {
                stmt.executeUpdate();
            }
        }
    }
}
