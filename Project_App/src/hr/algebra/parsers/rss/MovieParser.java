/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.parsers.rss;

import hr.algebra.factory.ParserFactory;
import hr.algebra.factory.UrlConnectionFactory;
import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import hr.algebra.model.Movie;
import hr.algebra.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author lcabraja
 */
public class MovieParser {

    private static final String RSS_URL = "https://www.blitz-cinestar.hr/rss.aspx?najava=1";
    private static final String TRAILER_PREFIX = "https://slike.blitz-cinestar.hr/Trejleri/";
    public static final String TIMESTAMP_PATTERN = "dd.mm.yyyy";
    private static final String EXT = ".jpg";
    private static final String DIR = "data";

    private MovieParser() {
    }

    public static List<Movie> parse() throws IOException, XMLStreamException {
        List<Movie> movies = new ArrayList<>();
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL, 10000, "GET");
        try (InputStream is = con.getInputStream()) {
            XMLEventReader reader = ParserFactory.createStaxParser(is);

            Optional<TagType> tagType = Optional.empty();
            Movie movie = null;
            StartElement startElement;
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        tagType = TagType.from(qName);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (tagType.isPresent()) {
                            Characters characters = event.asCharacters();
                            String data = characters.getData().trim();
                            switch (tagType.get()) {
                                case ITEM:
                                    movie = new Movie();
                                    movies.add(movie);
                                    break;
                                case TITLE:
                                    if (movie != null && !data.isEmpty()) {
                                        movie.setTitle(data);
                                    }
                                    break;
                                case DESCRIPTION:
                                    if (movie != null && !data.isEmpty()) {
                                        movie.setHTMLDescription(data);
                                    }
                                    break;
                                case ORIGINAL_TITLE:
                                    if (movie != null && !data.isEmpty()) {
                                        movie.setOriginalTitle(data);
                                    }
                                    break;
                                case DIRECTOR:
                                    if (movie != null && !data.isEmpty()) {
                                        List<String> people = parseCsv(data);
                                        movie.setDirectors(objectifyDirectors(people));
                                    }
                                    break;
                                case ACTORS:
                                    if (movie != null && !data.isEmpty()) {
                                        List<String> people = parseCsv(data);
                                        movie.setActors(objectifyActors(people));
                                    }
                                    break;
                                case LENGTH:
                                    if (movie != null && !data.isEmpty()) {
                                        movie.setLength(Integer.valueOf(data));
                                    }
                                    break;
                                case GENRE:
                                    if (movie != null && !data.isEmpty()) {
                                        movie.setGenre(data);
                                    }
                                    break;
                                case POSTER:
                                    if (movie != null && !data.isEmpty()) {
                                        handlePicture(movie, data);
                                    }
                                    break;
                                case LINK:
                                    if (movie != null && !data.isEmpty()) {
                                        movie.setLink(data);
                                    }
                                    break;
                                case GUID:
                                    if (movie != null && !data.isEmpty()) {
                                        movie.setGUID(data);
                                    }
                                    break;
                                case TRAILER:
                                    if (movie != null && !data.isEmpty()) {
                                        movie.setTrailerLink(TRAILER_PREFIX + data.replace(" ", "%20"));
                                    }
                                    break;
                                case STARTS_PLAYING:
                                    if (movie != null && !data.isEmpty()) {
                                        String[] dmy = data.split("\\.");
                                        Date date = Date.valueOf(LocalDateTime.of(Integer.valueOf(dmy[2]), Integer.valueOf(dmy[1]), Integer.valueOf(dmy[0]), 0, 0).toLocalDate());
                                        movie.setStartsPlaying(date);
                                    }
                                    break;
                            }
                        }
                        break;
                }
            }
        }
        return movies;

    }

    private static List<String> parseCsv(String data) {
        List<String> people = new ArrayList<>();
        String[] peopleArray = data.split(",");
        for (String person : peopleArray) {
            people.add(person.trim());
        }
        return people;
    }

    // todo genericify
    private static List<Actor> objectifyActors(List<String> people) {
        List<Actor> actors = new ArrayList<>();
        Actor actor;
        for (String name : people) {
            actor = new Actor(name);
            actors.add(actor);
        }
        return actors;
    }

    private static List<Director> objectifyDirectors(List<String> people) {
        List<Director> directors = new ArrayList<>();
        Director director;
        for (String name : people) {
            director = new Director(name);
            directors.add(director);
        }
        return directors;
    }

    private static void handlePicture(Movie movie, String pictureUrl) {
        try {
            String ext = pictureUrl.substring(pictureUrl.lastIndexOf("."));
            if (ext.length() > 4) {
                ext = EXT;
            }
            String pictureName = UUID.randomUUID() + ext;
            String localPicturePath = DIR + File.separator + pictureName;

            FileUtils.copyFromUrl(pictureUrl, localPicturePath);
            movie.setPosterFilePath(localPicturePath);
        } catch (IOException ex) {
            Logger.getLogger(MovieParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private enum TagType {

        ITEM("item"),
        TITLE("title"),
        DESCRIPTION("description"),
        ORIGINAL_TITLE("orignaziv"),
        DIRECTOR("redatelj"),
        ACTORS("glumci"),
        LENGTH("trajanje"),
        GENRE("zanr"),
        POSTER("plakat"),
        LINK("link"),
        GUID("guid"),
        TRAILER("trailer"),
        STARTS_PLAYING("pocetak");
        private final String name;

        private TagType(String name) {
            this.name = name;
        }

        private static Optional<TagType> from(String name) {
            for (TagType value : values()) {
                if (value.name.equals(name)) {
                    return Optional.of(value);
                }
            }
            return Optional.empty();
        }
    }
}
