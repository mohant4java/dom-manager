package com.dmc;

import com.dmc.model.Flat;
import com.dmc.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("flat")
public class FlatResource {

    @Autowired
    private FlatService flatService;


    @GET
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<Flat> getFlats() throws InterruptedException {
        Thread.sleep(1000);
        return flatService.getFlats();
    }

    @GET
    @Path("/{flatName}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Flat getFlatByName (@PathParam("flatName") String flatName){
        return flatService.getFlatByName(flatName);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public Response saveFlat(Flat flat){
        flatService.addFlat(flat);
        return Response.ok().build();
    }


}
