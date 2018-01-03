package it.service;


import com.mongodb.Block;
import it.SongsService;
import org.bson.Document;
import org.codehaus.jettison.json.JSONArray;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


@Path("songs")
@ApplicationScoped
public class SongsServiceWeb {

    @Inject
    @Named("modelTest")
    private SongsService songsService;


    @GET
    @Produces("application/json")
    public JSONArray getSongs(@Context HttpServletRequest request) {
        final List<Document> songs = songsService.getSongs();
        List<String> names = new ArrayList<>();
        songs.forEach((Consumer<? super Document>) document -> {
            names.add(document.get("artist").toString());
        });
        return new JSONArray(names);
    }
}
