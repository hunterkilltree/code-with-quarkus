package org.hunterkilltree.app.model;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.hunterkilltree.app.respository.FilmRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Path("/local")
public class FilmResource {

    @Inject
    FilmRepository filmRepository;

    @GET
    @Path("/films/{filmId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFilms(short filmId) {
        Optional<Film> film = filmRepository.getFilm(filmId);
        return film.isPresent() ? film.get().getTitle() : "No matching film";
    }

    @GET
    @Path("/films/search/{page}/{minLength}")
    @Produces(MediaType.TEXT_PLAIN)
    public String paged(int page, short minLength) {
        return filmRepository.paged(page, minLength)
                .map(f -> String.format("%s (%d min)", f.getTitle(), f.getLength()))
                .collect(Collectors.joining("\n"));
    }

}
