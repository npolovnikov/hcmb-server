package com.pologames.hcmb.admin.controler;

import com.pologames.hcmb.admin.dto.Filter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/player")
public interface PlayerController {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("playerList")
    Response getPlayerList(Filter filter);

//    Удалить, после тестов
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("status")
    String getStatus();
}
