package com.gdiama.infrastructure.rest;

import com.gdiama.infrastructure.rest.resources.PoolResource;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.UUID;


@Path("/pool")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public interface LiquidityEndpoint {

    @PUT
    @Path(value = "/{uuid}")
    PoolResource createPool(@PathParam("uuid") UUID uuid, PoolResource poolResource);

    @GET
    PoolResource getPool();

}
