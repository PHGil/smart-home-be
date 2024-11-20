package org.switch2023.adapter.rest.controller;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.switch2023.adapter.rest.to.RoomTO;
import org.switch2023.domain.exception.NotFoundException;

import java.util.List;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
public interface RoomRouter {

    @GET
    @Operation(summary = "Find all rooms", description = "Returns all rooms.")
    @APIResponses({@APIResponse(responseCode = "200", description = "List of all rooms",
            content = @Content(schema = @Schema(allOf = RoomTO.class)))})
    List<RoomTO> findRooms();

    @GET
    @Operation(summary = "Find room by ID", description = "Returns a room by its identifier.")
    @APIResponses({@APIResponse(responseCode = "200", description = "Get room by ID",
            content = @Content(schema = @Schema(allOf = RoomTO.class))), @APIResponse(responseCode = "404",
            description = "The filter criteria couldn't be applied.",
            content = @Content(schema = @Schema(implementation = NotFoundException.class)))})
    @Path("/{id}")
    RoomTO findRoomById(@PathParam("id") Long id) throws NotFoundException;
}
